package net.heaper.tech_mod.client.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.heaper.tech_mod.block.ModBlocks;
import net.heaper.tech_mod.client.datagen.texture.BlockOverlayedTextureDataProviderFactory;
import net.heaper.tech_mod.client.datagen.texture.BlockTextureDataProviderFactory;
import net.heaper.tech_mod.client.datagen.texture.base.Bases;
import net.heaper.tech_mod.client.datagen.texture.template.TemplateEntry;
import net.heaper.tech_mod.client.datagen.texture.template.Templates;
import net.heaper.tech_mod.client.datagen.texture.ItemTextureDataProviderFactory;
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
        Map<Item, TemplateEntry> itemTextures = Map.of(
                ModItems.RAW_ARENTINIUM, new TemplateEntry(Templates.RAW_IRON, new Color(228, 145, 255, 89)),
                ModItems.ARENTINIUM_INGOT, new TemplateEntry(Templates.IRON_INGOT, new Color(228, 145, 255, 89))
        );

        Map<Block, TemplateEntry> blockTextures = Map.of(
                ModBlocks.RAW_ARENTINIUM_BLOCK, new TemplateEntry(Templates.RAW_IRON_BLOCK, new Color(228, 145, 255, 89)),
                ModBlocks.URANIUM_BLOCK, new TemplateEntry(Templates.NETHERITE_BLOCK, new Color(89, 89, 89, 255))
        );

        Map<Block, TextureDefinition> overlayedBlockTextures = Map.of(
                ModBlocks.ARENTINIUM_ORE, new TextureDefinition(new TemplateEntry(Templates.IRON_ORE, new Color(228, 145, 255, 89)), Bases.STONE)
        );

        pack.addProvider(new ItemTextureDataProviderFactory(itemTextures));
        pack.addProvider(new BlockTextureDataProviderFactory(blockTextures));
        pack.addProvider(new BlockOverlayedTextureDataProviderFactory(overlayedBlockTextures));
    }
}
