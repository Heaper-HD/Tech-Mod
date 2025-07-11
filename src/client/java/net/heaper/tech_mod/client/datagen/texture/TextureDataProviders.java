package net.heaper.tech_mod.client.datagen.texture;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.heaper.tech_mod.Tech_mod;
import net.heaper.tech_mod.client.datagen.texture.base.Base;
import net.heaper.tech_mod.client.datagen.texture.template.TextureDefinition;
import net.minecraft.block.Block;
import net.heaper.tech_mod.client.datagen.texture.template.TemplateConfig;
import net.minecraft.data.DataOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.DataWriter;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class TextureDataProviders {

    private static final Path PROJECT_ROOT = Paths.get(System.getProperty("user.dir")).getParent().getParent();

    public static class ItemProvider implements FabricDataGenerator.Pack.Factory<DataProvider> {
        private final Map<Item, TemplateConfig> targets;

        public ItemProvider(Map<Item, TemplateConfig> targets) {
            this.targets = targets;
        }

        @Override
        public DataProvider create(FabricDataOutput output) {
            return new ItemTextureGenerator(output, targets);
        }
    }

    public static class BlockSimpleProvider implements FabricDataGenerator.Pack.Factory<DataProvider> {
        private final Map<Block, TemplateConfig> targets;

        public BlockSimpleProvider(Map<Block, TemplateConfig> targets) {
            this.targets = targets;
        }

        @Override
        public DataProvider create(FabricDataOutput output) {
            return new BlockSimpleTextureGenerator(output, targets);
        }
    }

    public static class BlockOverlayedProvider implements FabricDataGenerator.Pack.Factory<DataProvider> {
        private final Map<Block, TextureDefinition> targets;

        public BlockOverlayedProvider(Map<Block, TextureDefinition> targets) {
            this.targets = targets;
        }

        @Override
        public DataProvider create(FabricDataOutput output) {
            return new BlockOverlayedTextureGenerator(output, targets);
        }
    }

    public static class ItemTextureGenerator implements DataProvider {
        private final DataOutput.PathResolver resolver;
        private final Map<Item, TemplateConfig> targets;

        public ItemTextureGenerator(DataOutput output, Map<Item, TemplateConfig> targets) {
            this.resolver = output.getResolver(DataOutput.OutputType.RESOURCE_PACK, "textures/item");
            this.targets = targets;
        }

        @Override
        public CompletableFuture<?> run(DataWriter writer) {
            return CompletableFuture.runAsync(() -> targets.forEach((item, templateConfig) -> {
                Identifier id = Registries.ITEM.getId(item);
                try {
                    BufferedImage baseImage = readTemplate("item", templateConfig.getTemplate().getTemplateFile());
                    BufferedImage result = TextureRecolorUtil.recolor(baseImage, templateConfig.getOverlayColor());

                    if (templateConfig.getTemplate().getRustFile() != null) {
                        BufferedImage rust = readTemplate("item", templateConfig.getTemplate().getRustFile());
                        rust = TextureRecolorUtil.darken(rust, templateConfig.getRustIntensity());
                        result = TextureLayeringUtil.blendLayer(result, rust);
                    }

                    writeTexture(writer, resolver.resolveJson(id).resolveSibling(id.getPath() + ".png"), result);
                    logSuccess("item", id, templateConfig.getTemplate().getTemplateFile());
                } catch (IOException e) {
                    throw new RuntimeException("Failed to write item texture for: " + id, e);
                }
            }));
        }

        @Override
        public String getName() {
            return "Recolored Item Textures";
        }
    }

    public static class BlockSimpleTextureGenerator implements DataProvider {
        private final DataOutput.PathResolver resolver;
        private final Map<Block, TemplateConfig> targets;

        public BlockSimpleTextureGenerator(DataOutput output, Map<Block, TemplateConfig> targets) {
            this.resolver = output.getResolver(DataOutput.OutputType.RESOURCE_PACK, "textures/block");
            this.targets = targets;
        }

        @Override
        public CompletableFuture<?> run(DataWriter writer) {
            return CompletableFuture.runAsync(() -> targets.forEach((block, config) -> {
                Identifier id = Registries.BLOCK.getId(block);
                try {
                    BufferedImage baseImage = readTemplate("block", config.getTemplate().getTemplateFile());
                    BufferedImage result = TextureRecolorUtil.recolor(baseImage, config.getOverlayColor());

                    writeTexture(writer, resolver.resolveJson(id).resolveSibling(id.getPath() + ".png"), result);
                    logSuccess("block", id, config.getTemplate().getTemplateFile());
                } catch (IOException e) {
                    throw new RuntimeException("Failed to write block texture for " + id, e);
                }
            }));
        }

        @Override
        public String getName() {
            return "Recolored Block Texture";
        }
    }

    public static class BlockOverlayedTextureGenerator implements DataProvider {
        private final DataOutput.PathResolver resolver;
        private final Map<Block, TextureDefinition> targets;

        public BlockOverlayedTextureGenerator(DataOutput output, Map<Block, TextureDefinition> targets) {
            this.resolver = output.getResolver(DataOutput.OutputType.RESOURCE_PACK, "textures/block");
            this.targets = targets;
        }

        @Override
        public CompletableFuture<?> run(DataWriter writer) {
            return CompletableFuture.runAsync(() -> targets.forEach((block, textureDefinition) -> {
                Identifier id = Registries.BLOCK.getId(block);
                TemplateConfig config = textureDefinition.getTemplateEntry();
                Base base = textureDefinition.getBase();
                try {
                    BufferedImage baseImage = readTemplate("base", base.getTextureFile());
                    BufferedImage overlay = TextureRecolorUtil.recolor(readTemplate("block", config.getTemplate().getTemplateFile()), config.getOverlayColor());

                    BufferedImage result = TextureLayeringUtil.staticLayer(baseImage, overlay);

                    if (config.getTemplate().getShadowFile() != null) {
                        result = TextureLayeringUtil.blendLayer(result, readTemplate("block", config.getTemplate().getShadowFile()));
                    }

                    if (config.getTemplate().getRustFile() != null) {
                        BufferedImage rust = readTemplate("block", config.getTemplate().getRustFile());
                        rust = TextureRecolorUtil.darken(rust, config.getRustIntensity());
                        result = TextureLayeringUtil.blendLayer(result, rust);
                    }

                    writeTexture(writer, resolver.resolveJson(id).resolveSibling(id.getPath() + ".png"), result);
                    logSuccess("overlayed block", id, config.getTemplate().getTemplateFile());
                } catch (IOException e) {
                    throw new RuntimeException("Failed to generate textures for: " + id, e);
                }
            }));
        }

        @Override
        public String getName() {
            return "Overlayed Block Textures";
        }
    }

    private static BufferedImage readTemplate(String type, String fileName) throws IOException {
        Path path = Path.of(PROJECT_ROOT.toString(), "src", "main", "resources", "assets", Tech_mod.MOD_ID, "templates", type, fileName);
        if (!Files.exists(path)) throw new IOException("Template not found: " + path);
        return ImageIO.read(path.toFile());
    }

    private static void writeTexture(DataWriter writer, Path targetPath, BufferedImage image) throws IOException {
        Files.createDirectories(targetPath.getParent());
        ImageWriter.writeImage(targetPath, image, writer);
    }

    public static void logSuccess(String type, Identifier id, String file) {
        Tech_mod.LOGGER.info("[Textures] Wrote {} texture for: {} using template: {}", type, id, file);
    }
}
