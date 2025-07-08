package net.heaper.tech_mod.client.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.heaper.tech_mod.client.datagen.texture.TextureDataProviderFactory;
import net.heaper.tech_mod.item.ModItems;
import net.minecraft.item.Item;

import java.awt.*;
import java.util.Map;

public class ModTextureGenerator {
    public ModTextureGenerator(FabricDataGenerator.Pack pack) {
        Initialize(pack);
    }

    public static void Initialize(FabricDataGenerator.Pack pack) {
        Map<Item, Color> textures = Map.of(
                ModItems.RAW_URANIUM, new Color(177, 191, 58)
        );

        pack.addProvider(new TextureDataProviderFactory(textures));
    }
}
