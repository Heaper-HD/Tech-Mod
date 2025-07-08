package net.heaper.tech_mod.client.datagen.texture;

import net.heaper.tech_mod.Tech_mod;
import net.minecraft.data.DataOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.DataWriter;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class TextureDataProvider implements DataProvider {
    private final DataOutput.PathResolver texturePathResolver;
    private final Map<Item, Color> textureTargets;

    public TextureDataProvider(DataOutput output, Map<Item, Color> textureTargets) {
        this.texturePathResolver = output.getResolver(DataOutput.OutputType.RESOURCE_PACK, "textures/item");
        this.textureTargets = textureTargets;
    }

    @Override
    public CompletableFuture<?> run(DataWriter writer) {
        return CompletableFuture.runAsync(() -> {
            Path projectRoot = Paths.get(System.getProperty("user.dir")).getParent().getParent();
            Path baseImagePath = Path.of(projectRoot.toString() + "/src/main/resources/template/raw_iron_like_template.png");
            Tech_mod.LOGGER.info("Trying to read texture from: " + baseImagePath.toString());

            for (Map.Entry<Item, Color> entry : textureTargets.entrySet()) {
                Identifier id = Identifier.of(entry.getKey().toString());
                Color overlay = entry.getValue();
                try {
                    BufferedImage baseIamge = ImageIO.read(baseImagePath.toFile());
                    BufferedImage result = TextureRecolorUtil.recolor(baseIamge, overlay);

                    Path targetPath = texturePathResolver.resolveJson(id).resolveSibling(id.getPath() + ".png");
                    Files.createDirectories(targetPath.getParent());
                    ImageIO.write(result, "png", targetPath.toFile());

                    Tech_mod.LOGGER.info("Wrote texture for:" + id + " to " + targetPath);
                } catch (IOException e) {
                    throw new RuntimeException("Failed to write texture for: " + id, e);
                }
            }
        });
    }

    @Override
    public String getName() {
        return "Recolored Items Textures";
    }
}
