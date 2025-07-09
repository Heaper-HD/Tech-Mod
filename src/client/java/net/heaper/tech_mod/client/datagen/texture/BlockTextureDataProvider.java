package net.heaper.tech_mod.client.datagen.texture;

import com.google.common.hash.HashCode;
import net.heaper.tech_mod.Tech_mod;
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

public class BlockTextureDataProvider implements DataProvider {
    private final DataOutput.PathResolver texturePathResolver;
    private final Map<Block, TemplateEntry> textureTargets;

    public BlockTextureDataProvider(DataOutput output, Map<Block, TemplateEntry> textureTargets) {
        this.texturePathResolver = output.getResolver(DataOutput.OutputType.RESOURCE_PACK, "textures/block");
        this.textureTargets = textureTargets;
    }

    @Override
    public CompletableFuture<?> run(DataWriter writer) {
        return CompletableFuture.runAsync(() -> {
            Path projectRoot = Paths.get(System.getProperty("user.dir")).getParent().getParent();

            for (Map.Entry<Block, TemplateEntry> entry : textureTargets.entrySet()) {
                Identifier id = Registries.BLOCK.getId(entry.getKey());
                TemplateEntry template = entry.getValue();
                try {
                    Path baseImagePath = Path.of(projectRoot.toString() + "/src/main/resources/assets/" + Tech_mod.MOD_ID + "/templates/block/" + template.getTemplate().getTemplateFile());
                    if (!Files.exists(baseImagePath)) throw new IOException("Template image not found: " + baseImagePath);
                    Tech_mod.LOGGER.info("Reading item texture for: {} from: {}", id, baseImagePath);

                    BufferedImage baseIamge = ImageIO.read(baseImagePath.toFile());
                    BufferedImage result = TextureRecolorUtil.recolor(baseIamge, template.overlayColor);

                    Path targetPath = texturePathResolver.resolveJson(id).resolveSibling(id.getPath() + ".png");
                    Files.createDirectories(targetPath.getParent());

                    ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
                    ImageIO.write(result, "png", byteStream);
                    byte[] data = byteStream.toByteArray();
                    HashCode hash = com.google.common.hash.Hashing.sha256().hashBytes(data);
                    writer.write(targetPath, data, hash);

                    Tech_mod.LOGGER.info("Wrote block texture for: {} to: {}", id, targetPath);
                } catch (IOException e) {
                    throw new RuntimeException("Failed to write block texture for: " + id, e);
                }
            }
        });
    }

    @Override
    public String getName() {
        return "Recolored Block Textures";
    }
}
