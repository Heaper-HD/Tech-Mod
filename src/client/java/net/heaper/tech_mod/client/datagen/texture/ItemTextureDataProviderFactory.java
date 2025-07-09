package net.heaper.tech_mod.client.datagen.texture;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.heaper.tech_mod.client.datagen.texture.template.TemplateEntry;
import net.minecraft.item.Item;

import java.util.Map;

public class ItemTextureDataProviderFactory implements FabricDataGenerator.Pack.Factory<ItemTextureDataProvider>{
    private final Map<Item, TemplateEntry> textures;

    public ItemTextureDataProviderFactory(Map<Item, TemplateEntry> textures) {
        this.textures = textures;
    }

    @Override
    public ItemTextureDataProvider create(FabricDataOutput output) {
        return new ItemTextureDataProvider(output, textures);
    }
}
