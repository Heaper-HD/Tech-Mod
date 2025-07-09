package net.heaper.tech_mod.client.datagen.texture;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.block.Block;

import java.util.Map;

public class BlockTextureDataProviderFactory implements FabricDataGenerator.Pack.Factory<BlockTextureDataProvider>{
    private final Map<net.minecraft.block.Block, TemplateEntry> textures;

    public BlockTextureDataProviderFactory(Map<Block, TemplateEntry> textures) {
        this.textures = textures;
    }

    @Override
    public BlockTextureDataProvider create(FabricDataOutput output) {
        return new BlockTextureDataProvider(output, textures);
    }
}
