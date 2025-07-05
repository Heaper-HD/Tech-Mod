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
        //Minecraft base composts
        final String clayCompost = "Al₂Si₂O₅(OH)₄";
        final String stoneCompost = "SiO₂";
        final String deepslateCompost = "CaCO₃ + SiO₂";
        final String netherrackCompost = "CaCO₃ + MgFeSiO₄ + SiO₂ + SO₃";
        final String graniteCompost = "SiO₂ + KAlSi₃O₈ + (Fe,Mg)AlSi₃O₁₀(OH)₂";
        final String andesiteCompost = "NaAlSi₃O₈ + CaMgSi₂O₆ + (Fe,Mg)SiO₃";
        final String dioriteCompost = "NaAlSi₃O₈ + CaMgSi₂O₆ + (Fe,Mg)AlSi₃O₁₀(OH)₂";
        final String tuffCompost = "SiO₂ + KAlSi₃O₈ + Al₂Si₂O₅(OH)₄ + X";
        final String basaltCompost = "(Ca,Na)(Al,Si)₄O₈ + (Mg,Fe)SiO₃ + (Mg,Fe)₂SiO₄";
        final String blackstoneCompost = "(Ca,Na)(Al,Si)₄O₈ + (Ca,Fe,Mg)(Si,Al)₂O₆ + Fe₂O₃ + SO₃";
        final String obsidianCompost = "SiO₂ + Al₂O₃ + Fe₂O₃";
        final String coalCompound = "C";
        final String copperCompound = "Cu";
        final String ironCompound = "Fe";
        final String lapisCompound = "Na₃Ca(Al₃Si₃O₁₂)S";
        final String redstoneCompound = "HgSiO₃PS";
        final String goldCompost = "Au";
        final String diamondCompost = "C";
        final String emeraldCompost = "(Be₃Al₂Si₆O₁₈ + Cr³⁺)";
        final String amethystCompost = "SiO₂ + Fe³⁺";
        final String quartzCompost = "SiO₂";
        final String glowstoneCompost = "SiO₂ + CaO + WO₃ + S + Eu³⁺";
        final String netheriteCompost = "(WC·FeV)ZrSiO₄C";

        //Mod composts
        final String uraniumCompound = "U";

        //Non ore blocks composition tooltip
        TOOLTIP_MAP.put(Blocks.CLAY.asItem(), clayCompost);
        TOOLTIP_MAP.put(Items.CLAY_BALL, clayCompost);
        TOOLTIP_MAP.put(Blocks.BRICKS.asItem(), clayCompost);
        TOOLTIP_MAP.put(Items.BRICK, clayCompost);
        TOOLTIP_MAP.put(Blocks.SAND.asItem(), stoneCompost);
        TOOLTIP_MAP.put(Blocks.SANDSTONE.asItem(), stoneCompost + " + CaCO₃");
        TOOLTIP_MAP.put(Blocks.RED_SAND.asItem(), stoneCompost + " + Fe₂O₃");
        TOOLTIP_MAP.put(Blocks.RED_SANDSTONE.asItem(), stoneCompost + " + Fe₂O₃");
        TOOLTIP_MAP.put(Blocks.COBBLESTONE.asItem(), stoneCompost + '*');
        TOOLTIP_MAP.put(Blocks.STONE.asItem(), stoneCompost + '*');
        TOOLTIP_MAP.put(Blocks.COBBLED_DEEPSLATE.asItem(), '(' + deepslateCompost + ')' + '*');
        TOOLTIP_MAP.put(Blocks.DEEPSLATE.asItem(), '(' + deepslateCompost + ')' + '*');
        TOOLTIP_MAP.put(Blocks.NETHERRACK.asItem(), '(' + netherrackCompost + ')' + '*');
        TOOLTIP_MAP.put(Blocks.GRANITE.asItem(), '(' + graniteCompost + ')' + '*');
        TOOLTIP_MAP.put(Blocks.ANDESITE.asItem(), '(' + andesiteCompost + ')' + '*');
        TOOLTIP_MAP.put(Blocks.DIORITE.asItem(), '(' + dioriteCompost + ')' + '*');
        TOOLTIP_MAP.put(Blocks.TUFF.asItem(), '(' + tuffCompost + ')' + '*');
        TOOLTIP_MAP.put(Blocks.BASALT.asItem(), '(' + basaltCompost + ')' + '*');
        TOOLTIP_MAP.put(Blocks.BLACKSTONE.asItem(), '(' + blackstoneCompost + ')' + '*');
        TOOLTIP_MAP.put(Blocks.OBSIDIAN.asItem(), '(' + obsidianCompost + ')' + '*');

        //Terracota clay like composition tooltip
        TOOLTIP_MAP.put(Blocks.TERRACOTTA.asItem(), clayCompost + '*');
        TOOLTIP_MAP.put(Blocks.WHITE_TERRACOTTA.asItem(), clayCompost + '*');
        TOOLTIP_MAP.put(Blocks.LIGHT_GRAY_TERRACOTTA.asItem(), clayCompost + '*');
        TOOLTIP_MAP.put(Blocks.GRAY_TERRACOTTA.asItem(), clayCompost + '*');
        TOOLTIP_MAP.put(Blocks.BLACK_TERRACOTTA.asItem(), clayCompost + '*');
        TOOLTIP_MAP.put(Blocks.BROWN_TERRACOTTA.asItem(), clayCompost + '*');
        TOOLTIP_MAP.put(Blocks.RED_TERRACOTTA.asItem(), clayCompost + '*');
        TOOLTIP_MAP.put(Blocks.ORANGE_TERRACOTTA.asItem(), clayCompost + '*');
        TOOLTIP_MAP.put(Blocks.YELLOW_TERRACOTTA.asItem(), clayCompost + '*');
        TOOLTIP_MAP.put(Blocks.LIME_TERRACOTTA.asItem(), clayCompost + '*');
        TOOLTIP_MAP.put(Blocks.GREEN_TERRACOTTA.asItem(), clayCompost + '*');
        TOOLTIP_MAP.put(Blocks.CYAN_TERRACOTTA.asItem(), clayCompost + '*');
        TOOLTIP_MAP.put(Blocks.LIGHT_BLUE_TERRACOTTA.asItem(), clayCompost + '*');
        TOOLTIP_MAP.put(Blocks.BLUE_TERRACOTTA.asItem(), clayCompost + '*');
        TOOLTIP_MAP.put(Blocks.PURPLE_TERRACOTTA.asItem(), clayCompost + '*');
        TOOLTIP_MAP.put(Blocks.MAGENTA_TERRACOTTA.asItem(), clayCompost + '*');
        TOOLTIP_MAP.put(Blocks.PINK_TERRACOTTA.asItem(), clayCompost + '*');

        //Uranium related composition tooltips
        TOOLTIP_MAP.put(ModBlocks.URANIUM_ORE.asItem(), uraniumCompound + "* + " + stoneCompost + '*');
        TOOLTIP_MAP.put(ModBlocks.DEEPSLATE_URANIUM_ORE.asItem(), uraniumCompound + "* + " + deepslateCompost + '*');
        TOOLTIP_MAP.put(ModItems.RAW_URANIUM, uraniumCompound + "* + X");
        TOOLTIP_MAP.put(ModBlocks.RAW_URANIUM_BLOCK.asItem(), uraniumCompound + "* + X");
        TOOLTIP_MAP.put(ModItems.DIRTY_URANIUM_POWDER, uraniumCompound + '*');
        TOOLTIP_MAP.put(ModItems.URANIUM_POWDER, uraniumCompound);
        TOOLTIP_MAP.put(ModItems.PURIFIED_URANIUM_POWDER, uraniumCompound + '⁰');
        TOOLTIP_MAP.put(ModItems.URANIUM_PELLET, uraniumCompound + "O₂");
        TOOLTIP_MAP.put(ModItems.SMALL_URANIUM_PELLET, uraniumCompound + "O₂");

        //Coal related composition tooltips
        TOOLTIP_MAP.put(Blocks.COAL_ORE.asItem(), coalCompound + "* + " + stoneCompost + '*');
        TOOLTIP_MAP.put(Blocks.DEEPSLATE_COAL_ORE.asItem(), coalCompound + "* + " + deepslateCompost + '*');
        TOOLTIP_MAP.put(Items.COAL, coalCompound + '*');
        TOOLTIP_MAP.put(Items.CHARCOAL, coalCompound + '*');
        TOOLTIP_MAP.put(Blocks.COAL_BLOCK.asItem(), coalCompound + '*');

        //Copper related composition tooltips
        TOOLTIP_MAP.put(Blocks.COPPER_ORE.asItem(), copperCompound + "* + " + stoneCompost + '*');
        TOOLTIP_MAP.put(Blocks.DEEPSLATE_COPPER_ORE.asItem(), copperCompound + "* + " + deepslateCompost + '*');
        TOOLTIP_MAP.put(Items.RAW_COPPER, copperCompound + "* + X");
        TOOLTIP_MAP.put(Blocks.RAW_COPPER_BLOCK.asItem(), copperCompound + "* + X");
        TOOLTIP_MAP.put(Items.COPPER_INGOT, copperCompound);
        TOOLTIP_MAP.put(Blocks.COPPER_BLOCK.asItem(), copperCompound);
        TOOLTIP_MAP.put(Blocks.EXPOSED_COPPER.asItem(), copperCompound);
        TOOLTIP_MAP.put(Blocks.WEATHERED_COPPER.asItem(), copperCompound);
        TOOLTIP_MAP.put(Blocks.OXIDIZED_COPPER.asItem(), copperCompound);

        //Iron related composition tooltips
        TOOLTIP_MAP.put(Blocks.IRON_ORE.asItem(), ironCompound + "* + " + stoneCompost + '*');
        TOOLTIP_MAP.put(Blocks.DEEPSLATE_IRON_ORE.asItem(), ironCompound + "* + " + deepslateCompost + '*');
        TOOLTIP_MAP.put(Items.RAW_IRON, ironCompound + "* + X");
        TOOLTIP_MAP.put(Blocks.RAW_IRON_BLOCK.asItem(), ironCompound + "* + X");
        TOOLTIP_MAP.put(Items.IRON_INGOT, ironCompound);
        TOOLTIP_MAP.put(Items.IRON_NUGGET, ironCompound);
        TOOLTIP_MAP.put(Blocks.IRON_BLOCK.asItem(), ironCompound);

        //Lapis related composition tooltips
        TOOLTIP_MAP.put(Blocks.LAPIS_ORE.asItem(), lapisCompound + "* + " + stoneCompost + '*');
        TOOLTIP_MAP.put(Blocks.DEEPSLATE_LAPIS_ORE.asItem(), lapisCompound + "* + " + deepslateCompost + '*');
        TOOLTIP_MAP.put(Items.LAPIS_LAZULI, lapisCompound + '*');
        TOOLTIP_MAP.put(Blocks.LAPIS_BLOCK.asItem(), lapisCompound + '*');

        //Redstone related composition tooltips
        TOOLTIP_MAP.put(Blocks.REDSTONE_ORE.asItem(), redstoneCompound + "* + " + stoneCompost + '*');
        TOOLTIP_MAP.put(Blocks.DEEPSLATE_REDSTONE_ORE.asItem(), redstoneCompound + "* + " + deepslateCompost + '*');
        TOOLTIP_MAP.put(Items.REDSTONE, redstoneCompound + '*');
        TOOLTIP_MAP.put(Blocks.REDSTONE_BLOCK.asItem(), redstoneCompound + '*');

        //Gold related composition tooltips
        TOOLTIP_MAP.put(Blocks.GOLD_ORE.asItem(), goldCompost + "* + " + stoneCompost + '*');
        TOOLTIP_MAP.put(Blocks.DEEPSLATE_GOLD_ORE.asItem(), goldCompost + "* + " + deepslateCompost + '*');
        TOOLTIP_MAP.put(Blocks.NETHER_GOLD_ORE.asItem(), goldCompost + "* + " + netherrackCompost + '*');
        TOOLTIP_MAP.put(Items.RAW_GOLD, goldCompost + "* + X");
        TOOLTIP_MAP.put(Blocks.RAW_GOLD_BLOCK.asItem(), goldCompost + "* + X");
        TOOLTIP_MAP.put(Items.GOLD_INGOT, goldCompost);
        TOOLTIP_MAP.put(Items.GOLD_NUGGET, goldCompost);
        TOOLTIP_MAP.put(Blocks.GOLD_BLOCK.asItem(), goldCompost);

        //Diamond related composition tooltips
        TOOLTIP_MAP.put(Blocks.DIAMOND_ORE.asItem(), diamondCompost + "* + " + stoneCompost + '*');
        TOOLTIP_MAP.put(Blocks.DEEPSLATE_DIAMOND_ORE.asItem(), diamondCompost + "* + " + deepslateCompost + '*');
        TOOLTIP_MAP.put(ModItems.DIAMOND_CRYSTAL, diamondCompost + "* + X");
        TOOLTIP_MAP.put(Items.DIAMOND, diamondCompost + '⁰');
        TOOLTIP_MAP.put(Blocks.DIAMOND_BLOCK.asItem(), diamondCompost + '⁰');

        //Emerald related composition tooltips
        TOOLTIP_MAP.put(Blocks.EMERALD_ORE.asItem(), emeraldCompost + "* + " + quartzCompost + '*');
        TOOLTIP_MAP.put(Blocks.DEEPSLATE_EMERALD_ORE.asItem(), emeraldCompost + "* + " + deepslateCompost + "*");
        TOOLTIP_MAP.put(ModItems.EMERALD_CRYSTAL, emeraldCompost + "* + X");
        TOOLTIP_MAP.put(Items.EMERALD, emeraldCompost + '⁰');
        TOOLTIP_MAP.put(Blocks.EMERALD_BLOCK.asItem(), emeraldCompost + '⁰');

        //Amethyst related composition tooltips
        TOOLTIP_MAP.put(Items.AMETHYST_SHARD, amethystCompost + '⁰');
        TOOLTIP_MAP.put(Blocks.AMETHYST_BLOCK.asItem(), amethystCompost + '⁰');

        //Quartz related composition tooltips
        TOOLTIP_MAP.put(Blocks.NETHER_QUARTZ_ORE.asItem(), quartzCompost + "* + " + netherrackCompost + '*');
        TOOLTIP_MAP.put(Items.QUARTZ, quartzCompost);
        TOOLTIP_MAP.put(Blocks.QUARTZ_BLOCK.asItem(), quartzCompost);

        //Glowstone related composition tooltips
        TOOLTIP_MAP.put(Blocks.GLOWSTONE.asItem(), glowstoneCompost);
        TOOLTIP_MAP.put(Items.GLOWSTONE, glowstoneCompost);

        //Netherite/Ancient debris related composition tooltips
        TOOLTIP_MAP.put(Blocks.ANCIENT_DEBRIS.asItem(), netheriteCompost + '*');
        TOOLTIP_MAP.put(Items.NETHERITE_SCRAP, netheriteCompost);
        TOOLTIP_MAP.put(Items.NETHERITE_INGOT, netheriteCompost + goldCompost);
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
