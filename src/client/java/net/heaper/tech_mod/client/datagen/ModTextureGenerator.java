package net.heaper.tech_mod.client.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.heaper.tech_mod.block.ModBlocks;
import net.heaper.tech_mod.client.datagen.texture.TextureDataProviders;
import net.heaper.tech_mod.client.datagen.texture.base.Base;
import net.heaper.tech_mod.client.datagen.texture.template.TemplateConfig;
import net.heaper.tech_mod.client.datagen.texture.template.Templates;
import net.heaper.tech_mod.client.datagen.texture.template.TextureDefinition;
import net.heaper.tech_mod.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

import java.awt.*;
import java.util.Map;

public class ModTextureGenerator {
    public ModTextureGenerator(FabricDataGenerator.Pack pack) {
        Initialize(pack);
    }

    public static void Initialize(FabricDataGenerator.Pack pack) {
        Map<Item, TemplateConfig> itemTextures = Map.of(
                ModItems.RAW_ARENTINIUM, new TemplateConfig(Templates.RAW_COPPER, new Color(228, 145, 255, 89), 0.525f),
                ModItems.ARENTINIUM_INGOT, new TemplateConfig(Templates.IRON_INGOT, new Color(228, 145, 255, 89))
        );

        Map<Block, TemplateConfig> blockTextures = Map.of(
                ModBlocks.RAW_ARENTINIUM_BLOCK, new TemplateConfig(Templates.RAW_IRON_BLOCK, new Color(228, 145, 255, 89)),
                ModBlocks.URANIUM_BLOCK, new TemplateConfig(Templates.NETHERITE_BLOCK, new Color(89, 89, 89, 255))
        );

        Map<Block, TextureDefinition> overlayedBlockTextures = Map.of(
                ModBlocks.ARENTINIUM_ORE, new TextureDefinition(
                        new TemplateConfig(
                                Templates.COPPER_ORE, new Color(228, 145, 255, 89),
                                0.525f), Base.STONE)
        );

        pack.addProvider(new TextureDataProviders.ItemProvider(itemTextures));
        pack.addProvider(new TextureDataProviders.BlockSimpleProvider(blockTextures));
        pack.addProvider(new TextureDataProviders.BlockOverlayedProvider(overlayedBlockTextures));
    }
}
