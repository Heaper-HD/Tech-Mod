package net.heaper.tech_mod.client.datagen.texture;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.heaper.tech_mod.client.datagen.texture.template.TextureDefinition;
import net.minecraft.block.Block;

import java.util.Map;

public class BlockOverlayedTextureDataProviderFactory implements FabricDataGenerator.Pack.Factory<BlockOverlayedTextureProvider>{
    private final Map<Block, TextureDefinition> textures;

    public BlockOverlayedTextureDataProviderFactory(Map<Block, TextureDefinition> textures) {
        this.textures = textures;
    }

    @Override
    public BlockOverlayedTextureProvider create(FabricDataOutput output) {
        return new BlockOverlayedTextureProvider(output, textures);
    }
}
