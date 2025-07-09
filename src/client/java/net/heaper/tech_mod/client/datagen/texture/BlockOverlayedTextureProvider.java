package net.heaper.tech_mod.client.datagen.texture;


import com.google.common.hash.HashCode;
import net.heaper.tech_mod.Tech_mod;
import net.heaper.tech_mod.client.datagen.texture.base.Base;
import net.heaper.tech_mod.client.datagen.texture.template.TemplateEntry;
import net.heaper.tech_mod.client.datagen.texture.template.TextureDefinition;
import net.minecraft.block.Block;
import net.minecraft.data.DataOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.DataWriter;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class BlockOverlayedTextureProvider implements DataProvider {
    private final DataOutput.PathResolver texturePathResolver;
    private final Map<Block, TextureDefinition> textureTargets;

    public BlockOverlayedTextureProvider(DataOutput output, Map<Block, TextureDefinition> textureTargets) {
        this.texturePathResolver = output.getResolver(DataOutput.OutputType.RESOURCE_PACK, "textures/block");
        this.textureTargets = textureTargets;
    }

    @Override
    public CompletableFuture<?> run(DataWriter writer) {
        return CompletableFuture.runAsync(() -> {
            Path projectRoot = Paths.get(System.getProperty("user.dir")).getParent().getParent();

            for (Map.Entry<Block, TextureDefinition> entry : textureTargets.entrySet()) {
                Block block = entry.getKey();
                Identifier id = Registries.BLOCK.getId(block);
                TextureDefinition textureDefinition = entry.getValue();
                TemplateEntry template = textureDefinition.getTemplateEntry();
                Base base = textureDefinition.getBase();
                try {
                    Path overlayPath = Path.of(projectRoot + "/src/main/resources/assets/" + Tech_mod.MOD_ID + "/templates/block/" + template.getTemplate().getTemplateFile());
                    Path basePath = Path.of(projectRoot + "/src/main/resources/assets/" + Tech_mod.MOD_ID + "/templates/base/" + base.getOverlayFile());

                    if (!Files.exists(overlayPath)) throw new IOException("Overlay not found" + overlayPath);
                    if (!Files.exists(basePath)) throw new IOException("Base not found" + basePath);

                    BufferedImage overlayImage = ImageIO.read(overlayPath.toFile());
                    BufferedImage baseImage = ImageIO.read(basePath.toFile());
                    BufferedImage recolored = TextureRecolorUtil.recolor(overlayImage, template.getOverlayColor());

                    BufferedImage shadow = null;
                    if (template.getTemplate().getShadowFile() != null) {
                        Path shadowPath = Path.of(projectRoot + "/src/main/resources/assets/" + Tech_mod.MOD_ID + "/templates/block/" + template.getTemplate().getShadowFile());
                        shadow = ImageIO.read(shadowPath.toFile());

                        if (!Files.exists(shadowPath)) throw new IOException("Shadow not found: " + shadowPath);
                    }

                    BufferedImage result = TextureLayeringUtil.layer(baseImage, recolored, shadow);

                    Path targetPath = texturePathResolver.resolveJson(id).resolveSibling(id.getPath() + ".png");
                    Files.createDirectories(targetPath.getParent());

                    ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
                    ImageIO.write(result, "png", byteStream);
                    byte[] data = byteStream.toByteArray();
                    HashCode hash = com.google.common.hash.Hashing.sha256().hashBytes(data);

                    writer.write(targetPath, data, hash);
                    Tech_mod.LOGGER.info("Wrote overlayed block texture for: {} using base: {} and template: {} to: {}", id, base.getName(), template.getTemplate().getTemplateFile(), targetPath);
                } catch (IOException e) {
                    throw new RuntimeException("Failed to generate textures for " + id, e);
                }
            }
        });
    }

    @Override
    public String getName() {
        return "Overlayed Block texture";
    }
}
