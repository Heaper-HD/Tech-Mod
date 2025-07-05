package net.heaper.tech_mod.client.tooltip;

import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.heaper.tech_mod.block.ModBlocks;
import net.heaper.tech_mod.item.ModItems;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModCompositionTooltips {
    public static final Map<Item, String> TOOLTIP_MAP = new HashMap<>();

    public static void registerTooltips() {
        TOOLTIP_MAP.put(Blocks.COBBLESTONE.asItem(), "SiO₂*");
        TOOLTIP_MAP.put(Blocks.STONE.asItem(), "SiO₂*");
        TOOLTIP_MAP.put(Blocks.COBBLED_DEEPSLATE.asItem(), "CaCO₃* + SiO₂*");
        TOOLTIP_MAP.put(Blocks.DEEPSLATE.asItem(), "CaCO₃* + SiO₂*");

        TOOLTIP_MAP.put(ModBlocks.URANIUM_ORE.asItem(), "U* + SiO₂*");
        TOOLTIP_MAP.put(ModBlocks.DEEPSLATE_URANIUM_ORE.asItem(), "U* + CaCO₃* + SiO₂*");
        TOOLTIP_MAP.put(ModItems.RAW_URANIUM, "U* + X");
        TOOLTIP_MAP.put(ModItems.DIRTY_URANIUM_POWDER, "U*");
        TOOLTIP_MAP.put(ModItems.URANIUM_POWDER, "U");
        TOOLTIP_MAP.put(ModItems.PURIFIED_URANIUM_POWDER, "U⁰");
        TOOLTIP_MAP.put(ModItems.URANIUM_PELLET, "UO₂");
        TOOLTIP_MAP.put(ModItems.SMALL_URANIUM_PELLET, "UO₂");

        TOOLTIP_MAP.put(Blocks.COAL_ORE.asItem(), "C* + SiO₂*");
        TOOLTIP_MAP.put(Blocks.DEEPSLATE_COAL_ORE.asItem(), "C* + CaCO₃* + SiO₂*");
        TOOLTIP_MAP.put(Items.COAL, "C*");

        TOOLTIP_MAP.put(Blocks.COPPER_ORE.asItem(), "Cu* + SiO₂*");
        TOOLTIP_MAP.put(Blocks.DEEPSLATE_COPPER_ORE.asItem(), "Cu* + CaCO₃* + SiO₂*");
        TOOLTIP_MAP.put(Items.RAW_COPPER, "Cu* + X");
        TOOLTIP_MAP.put(Items.COPPER_INGOT, "Cu");

        TOOLTIP_MAP.put(Blocks.IRON_ORE.asItem(), "Fe* + SiO₂*");
        TOOLTIP_MAP.put(Blocks.DEEPSLATE_IRON_ORE.asItem(), "Fe* + CaCO₃* + SiO₂*");
        TOOLTIP_MAP.put(Items.RAW_IRON, "Fe* + X");
        TOOLTIP_MAP.put(Items.IRON_INGOT, "Fe");

        TOOLTIP_MAP.put(Blocks.LAPIS_ORE.asItem(), "Na₃Ca(Al₃Si₃O₁₂)S* + SiO₂*");
        TOOLTIP_MAP.put(Blocks.DEEPSLATE_LAPIS_ORE.asItem(), "Na₃Ca(Al₃Si₃O₁₂)S* + CaCO₃* + SiO₂*");
        TOOLTIP_MAP.put(Items.LAPIS_LAZULI, "Na₃Ca(Al₃Si₃O₁₂)S*");

        TOOLTIP_MAP.put(Blocks.REDSTONE_ORE.asItem(), "HgSiO₃PS* + SiO₂*");
        TOOLTIP_MAP.put(Blocks.DEEPSLATE_REDSTONE_ORE.asItem(), "HgSiO₃PS* + CaCO₃* + SiO₂*");
        TOOLTIP_MAP.put(Items.REDSTONE, "HgSiO₃PS*");

        TOOLTIP_MAP.put(Blocks.GOLD_ORE.asItem(), "Au* + SiO₂*");
        TOOLTIP_MAP.put(Blocks.DEEPSLATE_GOLD_ORE.asItem(), "Au* + CaCO₃* + SiO₂*");
        TOOLTIP_MAP.put(Items.RAW_GOLD, "Au* + X");
        TOOLTIP_MAP.put(Items.GOLD_INGOT, "Au");

        TOOLTIP_MAP.put(Blocks.DIAMOND_ORE.asItem(), "C* + SiO₂*");
        TOOLTIP_MAP.put(Blocks.DEEPSLATE_DIAMOND_ORE.asItem(), "C* + CaCO₃* + SiO₂*");
        TOOLTIP_MAP.put(Items.DIAMOND, "C⁰");

        TOOLTIP_MAP.put(Blocks.EMERALD_ORE.asItem(), "(Be₃Al₂Si₆O₁₈ + Cr³⁺)* + SiO₂*");
        TOOLTIP_MAP.put(Blocks.DEEPSLATE_EMERALD_ORE.asItem(), "(Be₃Al₂Si₆O₁₈ + Cr³⁺)* + SiO₂*");
        TOOLTIP_MAP.put(Items.EMERALD, "(Be₃Al₂Si₆O₁₈ + Cr³⁺)*");
    }

    public static void Initialize() {
        registerTooltips();
        ItemTooltipCallback.EVENT.register(ModCompositionTooltips::onTooltip);
    }

    private static void onTooltip(ItemStack stack, Item.TooltipContext context, TooltipType tooltipType, List<Text> texts) {
        String key = TOOLTIP_MAP.get(stack.getItem());
        if (key != null) {
            texts.add(Text.literal(key).formatted(Formatting.GRAY));
        }
    }
}
