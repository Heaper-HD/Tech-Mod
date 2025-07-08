package net.heaper.tech_mod.client.datagen.texture;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.item.Item;

import java.awt.*;
import java.util.Map;

public class TextureDataProviderFactory implements FabricDataGenerator.Pack.Factory<TextureDataProvider>{
    private final Map<Item, Color> textures;

    public TextureDataProviderFactory(Map<Item, Color> textures) {
        this.textures = textures;
    }

    @Override
    public TextureDataProvider create(FabricDataOutput output) {
        return new TextureDataProvider(output, textures);
    }
}
