package net.heaper.tech_mod.item;

import net.fabricmc.fabric.api.item.v1.DefaultItemComponentEvents;
import net.heaper.tech_mod.component.ModComponents;
import net.heaper.tech_mod.compound.CompoundComponent;
import net.heaper.tech_mod.compound.Compounds;
import net.heaper.tech_mod.element.ElementComponent;
import net.heaper.tech_mod.element.Elements;
import net.heaper.tech_mod.element.PurityLevel;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;

import java.util.List;

public class ItemComponentModifier {
    public static void Initialize() {
        DefaultItemComponentEvents.MODIFY.register(context -> {
            //Blocks
            context.modify(Blocks.TERRACOTTA.asItem(), builder -> {
                builder.add(ModComponents.COMPOUNDS_COMPONENT, List.of(
                        new CompoundComponent(Compounds.KAOLINITE, PurityLevel.NORMAL)));
            });
            context.modify(Blocks.WHITE_TERRACOTTA.asItem(), builder -> {
                builder.add(ModComponents.COMPOUNDS_COMPONENT, List.of(
                        new CompoundComponent(Compounds.KAOLINITE, PurityLevel.NORMAL)));
            });
            context.modify(Blocks.LIGHT_GRAY_TERRACOTTA.asItem(), builder -> {
                builder.add(ModComponents.COMPOUNDS_COMPONENT, List.of(
                        new CompoundComponent(Compounds.KAOLINITE, PurityLevel.NORMAL)));
            });
            context.modify(Blocks.GRAY_TERRACOTTA.asItem(), builder -> {
                builder.add(ModComponents.COMPOUNDS_COMPONENT, List.of(
                        new CompoundComponent(Compounds.KAOLINITE, PurityLevel.NORMAL)));
            });
            context.modify(Blocks.BLACK_TERRACOTTA.asItem(), builder -> {
                builder.add(ModComponents.COMPOUNDS_COMPONENT, List.of(
                        new CompoundComponent(Compounds.KAOLINITE, PurityLevel.NORMAL)));
            });
            context.modify(Blocks.BROWN_TERRACOTTA.asItem(), builder -> {
                builder.add(ModComponents.COMPOUNDS_COMPONENT, List.of(
                        new CompoundComponent(Compounds.KAOLINITE, PurityLevel.NORMAL)));
            });
            context.modify(Blocks.RED_TERRACOTTA.asItem(), builder -> {
                builder.add(ModComponents.COMPOUNDS_COMPONENT, List.of(
                        new CompoundComponent(Compounds.KAOLINITE, PurityLevel.NORMAL)));
            });
            context.modify(Blocks.ORANGE_TERRACOTTA.asItem(), builder -> {
                builder.add(ModComponents.COMPOUNDS_COMPONENT, List.of(
                        new CompoundComponent(Compounds.KAOLINITE, PurityLevel.NORMAL)));
            });
            context.modify(Blocks.YELLOW_TERRACOTTA.asItem(), builder -> {
                builder.add(ModComponents.COMPOUNDS_COMPONENT, List.of(
                        new CompoundComponent(Compounds.KAOLINITE, PurityLevel.NORMAL)));
            });
            context.modify(Blocks.LIME_TERRACOTTA.asItem(), builder -> {
                builder.add(ModComponents.COMPOUNDS_COMPONENT, List.of(
                        new CompoundComponent(Compounds.KAOLINITE, PurityLevel.NORMAL)));
            });
            context.modify(Blocks.GREEN_TERRACOTTA.asItem(), builder -> {
                builder.add(ModComponents.COMPOUNDS_COMPONENT, List.of(
                        new CompoundComponent(Compounds.KAOLINITE, PurityLevel.NORMAL)));
            });
            context.modify(Blocks.CYAN_TERRACOTTA.asItem(), builder -> {
                builder.add(ModComponents.COMPOUNDS_COMPONENT, List.of(
                        new CompoundComponent(Compounds.KAOLINITE, PurityLevel.NORMAL)));
            });
            context.modify(Blocks.LIGHT_BLUE_TERRACOTTA.asItem(), builder -> {
                builder.add(ModComponents.COMPOUNDS_COMPONENT, List.of(
                        new CompoundComponent(Compounds.KAOLINITE, PurityLevel.NORMAL)));
            });
            context.modify(Blocks.BLUE_TERRACOTTA.asItem(), builder -> {
                builder.add(ModComponents.COMPOUNDS_COMPONENT, List.of(
                        new CompoundComponent(Compounds.KAOLINITE, PurityLevel.NORMAL)));
            });
            context.modify(Blocks.PURPLE_TERRACOTTA.asItem(), builder -> {
                builder.add(ModComponents.COMPOUNDS_COMPONENT, List.of(
                        new CompoundComponent(Compounds.KAOLINITE, PurityLevel.NORMAL)));
            });
            context.modify(Blocks.MAGENTA_TERRACOTTA.asItem(), builder -> {
                builder.add(ModComponents.COMPOUNDS_COMPONENT, List.of(
                        new CompoundComponent(Compounds.KAOLINITE, PurityLevel.NORMAL)));
            });
            context.modify(Blocks.PINK_TERRACOTTA.asItem(), builder -> {
                builder.add(ModComponents.COMPOUNDS_COMPONENT, List.of(
                        new CompoundComponent(Compounds.KAOLINITE, PurityLevel.NORMAL)));
            });
            context.modify(Blocks.STONE.asItem(), builder -> {
                builder.add(ModComponents.COMPOUNDS_COMPONENT, List.of(new CompoundComponent(Compounds.SILICON_DIOXIDE, PurityLevel.IMPURE)));
            });
            context.modify(Blocks.COBBLESTONE.asItem(), builder -> {
                builder.add(ModComponents.COMPOUNDS_COMPONENT, List.of(new CompoundComponent(Compounds.SILICON_DIOXIDE, PurityLevel.IMPURE)));
            });
            context.modify(Blocks.DEEPSLATE.asItem(), builder -> {
                builder.add(ModComponents.COMPOUNDS_COMPONENT, List.of(
                        new CompoundComponent(Compounds.CALCIUM_CARBONATE, PurityLevel.IMPURE),
                        new CompoundComponent(Compounds.SILICON_DIOXIDE, PurityLevel.IMPURE)));
            });
            context.modify(Blocks.COBBLED_DEEPSLATE.asItem(), builder -> {
                builder.add(ModComponents.COMPOUNDS_COMPONENT, List.of(
                        new CompoundComponent(Compounds.CALCIUM_CARBONATE, PurityLevel.IMPURE),
                        new CompoundComponent(Compounds.SILICON_DIOXIDE, PurityLevel.IMPURE)));
            });
            context.modify(Blocks.NETHERRACK.asItem(), builder -> {
                builder.add(ModComponents.COMPOUNDS_COMPONENT, List.of(
                        new CompoundComponent(Compounds.CALCIUM_CARBONATE, PurityLevel.IMPURE),
                        new CompoundComponent(Compounds.FAYALITE, PurityLevel.IMPURE),
                        new CompoundComponent(Compounds.SULFUR_DIOXIDE, PurityLevel.IMPURE)));
            });
            context.modify(Blocks.GRANITE.asItem(), builder -> {
                builder.add(ModComponents.COMPOUNDS_COMPONENT, List.of(
                        new CompoundComponent(Compounds.SILICON_DIOXIDE, PurityLevel.IMPURE),
                        new CompoundComponent(Compounds.ORTHOCLASE, PurityLevel.IMPURE),
                        new CompoundComponent(Compounds.AMPHIBOLE, PurityLevel.IMPURE)));
            });
            context.modify(Blocks.DIORITE.asItem(), builder -> {
                builder.add(ModComponents.COMPOUNDS_COMPONENT, List.of(
                        new CompoundComponent(Compounds.ALBITE, PurityLevel.IMPURE),
                        new CompoundComponent(Compounds.DIOPSIDE, PurityLevel.IMPURE),
                        new CompoundComponent(Compounds.ANNITE, PurityLevel.IMPURE)));
            });
            context.modify(Blocks.ANDESITE.asItem(), builder -> {
                builder.add(ModComponents.COMPOUNDS_COMPONENT, List.of(
                        new CompoundComponent(Compounds.ALBITE, PurityLevel.IMPURE),
                        new CompoundComponent(Compounds.DIOPSIDE, PurityLevel.IMPURE),
                        new CompoundComponent(Compounds.FERROSILITE, PurityLevel.IMPURE)));
            });
            context.modify(Blocks.TUFF.asItem(), builder -> {
                builder.add(ModComponents.COMPOUNDS_COMPONENT, List.of(
                        new CompoundComponent(Compounds.SILICON_DIOXIDE, PurityLevel.IMPURE),
                        new CompoundComponent(Compounds.ORTHOCLASE, PurityLevel.IMPURE),
                        new CompoundComponent(Compounds.KAOLINITE, PurityLevel.IMPURE)));
            });
            context.modify(Blocks.BRICKS.asItem(), builder -> {
                builder.add(ModComponents.COMPOUNDS_COMPONENT, List.of(
                        new CompoundComponent(Compounds.KAOLINITE, PurityLevel.IMPURE)));
            });
            context.modify(Blocks.SAND.asItem(), builder -> {
                builder.add(ModComponents.COMPOUNDS_COMPONENT, List.of(
                        new CompoundComponent(Compounds.SILICON_MONOXIDE, PurityLevel.IMPURE)));
            });
            context.modify(Blocks.SANDSTONE.asItem(), builder -> {
                builder.add(ModComponents.COMPOUNDS_COMPONENT, List.of(
                        new CompoundComponent(Compounds.SILICON_MONOXIDE, PurityLevel.IMPURE),
                        new CompoundComponent(Compounds.CALCIUM_CARBONATE, PurityLevel.IMPURE)));
            });
            context.modify(Blocks.RED_SAND.asItem(), builder -> {
                builder.add(ModComponents.COMPOUNDS_COMPONENT, List.of(
                        new CompoundComponent(Compounds.SILICON_MONOXIDE, PurityLevel.IMPURE),
                        new CompoundComponent(Compounds.HEMATITE, PurityLevel.IMPURE)));
            });
            context.modify(Blocks.RED_SANDSTONE.asItem(), builder -> {
                builder.add(ModComponents.COMPOUNDS_COMPONENT, List.of(
                        new CompoundComponent(Compounds.SILICON_MONOXIDE, PurityLevel.IMPURE),
                        new CompoundComponent(Compounds.HEMATITE, PurityLevel.IMPURE)));
            });
            context.modify(Blocks.BASALT.asItem(), builder -> {
                builder.add(ModComponents.COMPOUNDS_COMPONENT, List.of(
                        new CompoundComponent(Compounds.ALBITE, PurityLevel.IMPURE),
                        new CompoundComponent(Compounds.FERROSILITE, PurityLevel.IMPURE),
                        new CompoundComponent(Compounds.FORSTERITE, PurityLevel.IMPURE)));
            });
            context.modify(Blocks.BLACKSTONE.asItem(), builder -> {
                builder.add(ModComponents.COMPOUNDS_COMPONENT, List.of(
                        new CompoundComponent(Compounds.ALBITE, PurityLevel.IMPURE),
                        new CompoundComponent(Compounds.DIOPSIDE, PurityLevel.IMPURE),
                        new CompoundComponent(Compounds.HEMATITE, PurityLevel.IMPURE),
                        new CompoundComponent(Compounds.SULFUR_DIOXIDE, PurityLevel.IMPURE)));
            });
            context.modify(Blocks.OBSIDIAN.asItem(), builder -> {
                builder.add(ModComponents.COMPOUNDS_COMPONENT, List.of(
                        new CompoundComponent(Compounds.SILICON_DIOXIDE, PurityLevel.IMPURE),
                        new CompoundComponent(Compounds.ALUMINUM_OXIDE, PurityLevel.IMPURE),
                        new CompoundComponent(Compounds.HEMATITE, PurityLevel.IMPURE)));
            });
            context.modify(Blocks.COAL_BLOCK.asItem(), builder -> {
                builder.add(ModComponents.ELEMENTS_COMPONENT, List.of(
                        new ElementComponent(Elements.CARBON, PurityLevel.NORMAL)));
            });
            context.modify(Blocks.IRON_BLOCK.asItem(), builder -> {
                builder.add(ModComponents.ELEMENTS_COMPONENT, List.of(
                        new ElementComponent(Elements.IRON, PurityLevel.NORMAL)));
            });
            context.modify(Blocks.GOLD_BLOCK.asItem(), builder -> {
                builder.add(ModComponents.ELEMENTS_COMPONENT, List.of(
                        new ElementComponent(Elements.GOLD, PurityLevel.NORMAL)));
            });
            context.modify(Blocks.REDSTONE_BLOCK.asItem(), builder -> {
                builder.add(ModComponents.COMPOUNDS_COMPONENT, List.of(
                        new CompoundComponent(Compounds.REDSTONE, PurityLevel.NORMAL)));
            });
            context.modify(Blocks.EMERALD_BLOCK.asItem(), builder -> {
                builder.add(ModComponents.COMPOUNDS_COMPONENT, List.of(
                        new CompoundComponent(Compounds.EMERALD, PurityLevel.NORMAL)));
            });
            context.modify(Blocks.LAPIS_BLOCK.asItem(), builder -> {
                builder.add(ModComponents.COMPOUNDS_COMPONENT, List.of(
                        new CompoundComponent(Compounds.LAPIS, PurityLevel.NORMAL)));
            });
            context.modify(Blocks.DIAMOND_BLOCK.asItem(), builder -> {
                builder.add(ModComponents.COMPOUNDS_COMPONENT, List.of(
                        new CompoundComponent(Compounds.DIAMOND, PurityLevel.NORMAL)));
            });
            context.modify(Blocks.ANCIENT_DEBRIS.asItem(), builder -> {
                builder.add(ModComponents.COMPOUNDS_COMPONENT, List.of(
                        new CompoundComponent(Compounds.ANCIENT_MATERIAL, PurityLevel.IMPURE)));
            });
            context.modify(Blocks.NETHERITE_BLOCK.asItem(), builder -> {
                builder.add(ModComponents.COMPOUNDS_COMPONENT, List.of(
                        new CompoundComponent(Compounds.NETHERITE, PurityLevel.NORMAL)));
            });
            context.modify(Blocks.COPPER_BLOCK.asItem(), builder -> {
                builder.add(ModComponents.ELEMENTS_COMPONENT, List.of(
                        new ElementComponent(Elements.COPPER, PurityLevel.NORMAL)));
            });
            context.modify(Blocks.QUARTZ_BLOCK.asItem(), builder -> {
                builder.add(ModComponents.COMPOUNDS_COMPONENT, List.of(
                        new CompoundComponent(Compounds.SILICON_DIOXIDE, PurityLevel.NORMAL)));
            });
            context.modify(Blocks.COAL_ORE.asItem(), builder -> {
                builder.add(ModComponents.ELEMENTS_COMPONENT, List.of(
                        new ElementComponent(Elements.CARBON, PurityLevel.IMPURE)));
                builder.add(ModComponents.COMPOUNDS_COMPONENT, List.of(
                        new CompoundComponent(Compounds.SILICON_DIOXIDE, PurityLevel.IMPURE)));
            });
            context.modify(Blocks.DEEPSLATE_COAL_ORE.asItem(), builder -> {
                builder.add(ModComponents.ELEMENTS_COMPONENT, List.of(
                        new ElementComponent(Elements.CARBON, PurityLevel.IMPURE)));
                builder.add(ModComponents.COMPOUNDS_COMPONENT, List.of(
                        new CompoundComponent(Compounds.CALCIUM_CARBONATE, PurityLevel.IMPURE),
                        new CompoundComponent(Compounds.SILICON_DIOXIDE, PurityLevel.IMPURE)));
            });
            context.modify(Blocks.IRON_ORE.asItem(), builder -> {
                builder.add(ModComponents.ELEMENTS_COMPONENT, List.of(
                        new ElementComponent(Elements.IRON, PurityLevel.IMPURE)));
                builder.add(ModComponents.COMPOUNDS_COMPONENT, List.of(
                        new CompoundComponent(Compounds.SILICON_DIOXIDE, PurityLevel.IMPURE)));
            });
            context.modify(Blocks.DEEPSLATE_IRON_ORE.asItem(), builder -> {
                builder.add(ModComponents.ELEMENTS_COMPONENT, List.of(
                        new ElementComponent(Elements.IRON, PurityLevel.IMPURE)));
                builder.add(ModComponents.COMPOUNDS_COMPONENT, List.of(
                        new CompoundComponent(Compounds.CALCIUM_CARBONATE, PurityLevel.IMPURE),
                        new CompoundComponent(Compounds.SILICON_DIOXIDE, PurityLevel.IMPURE)));
            });
            context.modify(Blocks.COPPER_ORE.asItem(), builder -> {
                builder.add(ModComponents.ELEMENTS_COMPONENT, List.of(
                        new ElementComponent(Elements.COPPER, PurityLevel.IMPURE)));
                builder.add(ModComponents.COMPOUNDS_COMPONENT, List.of(
                        new CompoundComponent(Compounds.SILICON_DIOXIDE, PurityLevel.IMPURE)));
            });
            context.modify(Blocks.DEEPSLATE_COPPER_ORE.asItem(), builder -> {
                builder.add(ModComponents.ELEMENTS_COMPONENT, List.of(
                        new ElementComponent(Elements.COPPER, PurityLevel.IMPURE)));
                builder.add(ModComponents.COMPOUNDS_COMPONENT, List.of(
                        new CompoundComponent(Compounds.CALCIUM_CARBONATE, PurityLevel.IMPURE),
                        new CompoundComponent(Compounds.SILICON_DIOXIDE, PurityLevel.IMPURE)));
            });
            context.modify(Blocks.GOLD_ORE.asItem(), builder -> {
                builder.add(ModComponents.ELEMENTS_COMPONENT, List.of(
                        new ElementComponent(Elements.GOLD, PurityLevel.IMPURE)));
                builder.add(ModComponents.COMPOUNDS_COMPONENT, List.of(
                        new CompoundComponent(Compounds.SILICON_DIOXIDE, PurityLevel.IMPURE)));
            });
            context.modify(Blocks.DEEPSLATE_GOLD_ORE.asItem(), builder -> {
                builder.add(ModComponents.ELEMENTS_COMPONENT, List.of(
                        new ElementComponent(Elements.GOLD, PurityLevel.IMPURE)));
                builder.add(ModComponents.COMPOUNDS_COMPONENT, List.of(
                        new CompoundComponent(Compounds.CALCIUM_CARBONATE, PurityLevel.IMPURE),
                        new CompoundComponent(Compounds.SILICON_DIOXIDE, PurityLevel.IMPURE)));
            });
            context.modify(Blocks.REDSTONE_ORE.asItem(), builder -> {
                builder.add(ModComponents.COMPOUNDS_COMPONENT, List.of(
                        new CompoundComponent(Compounds.REDSTONE, PurityLevel.IMPURE),
                        new CompoundComponent(Compounds.SILICON_DIOXIDE, PurityLevel.IMPURE)));
            });
            context.modify(Blocks.DEEPSLATE_REDSTONE_ORE.asItem(), builder -> {
                builder.add(ModComponents.COMPOUNDS_COMPONENT, List.of(
                        new CompoundComponent(Compounds.REDSTONE, PurityLevel.IMPURE),
                        new CompoundComponent(Compounds.CALCIUM_CARBONATE, PurityLevel.IMPURE),
                        new CompoundComponent(Compounds.SILICON_DIOXIDE, PurityLevel.IMPURE)));
            });
            context.modify(Blocks.EMERALD_ORE.asItem(), builder -> {
                builder.add(ModComponents.COMPOUNDS_COMPONENT, List.of(
                        new CompoundComponent(Compounds.EMERALD, PurityLevel.IMPURE),
                        new CompoundComponent(Compounds.SILICON_DIOXIDE, PurityLevel.IMPURE)));
            });
            context.modify(Blocks.DEEPSLATE_EMERALD_ORE.asItem(), builder -> {
                builder.add(ModComponents.COMPOUNDS_COMPONENT, List.of(
                        new CompoundComponent(Compounds.EMERALD, PurityLevel.IMPURE),
                        new CompoundComponent(Compounds.CALCIUM_CARBONATE, PurityLevel.IMPURE),
                        new CompoundComponent(Compounds.SILICON_DIOXIDE, PurityLevel.IMPURE)));
            });
            context.modify(Blocks.LAPIS_ORE.asItem(), builder -> {
                builder.add(ModComponents.COMPOUNDS_COMPONENT, List.of(
                        new CompoundComponent(Compounds.LAPIS, PurityLevel.IMPURE),
                        new CompoundComponent(Compounds.SILICON_DIOXIDE, PurityLevel.IMPURE)));
            });
            context.modify(Blocks.DEEPSLATE_LAPIS_ORE.asItem(), builder -> {
                builder.add(ModComponents.COMPOUNDS_COMPONENT, List.of(
                        new CompoundComponent(Compounds.LAPIS, PurityLevel.IMPURE),
                        new CompoundComponent(Compounds.CALCIUM_CARBONATE, PurityLevel.IMPURE),
                        new CompoundComponent(Compounds.SILICON_DIOXIDE, PurityLevel.IMPURE)));
            });
            context.modify(Blocks.DIAMOND_ORE.asItem(), builder -> {
                builder.add(ModComponents.COMPOUNDS_COMPONENT, List.of(
                        new CompoundComponent(Compounds.DIAMOND, PurityLevel.IMPURE),
                        new CompoundComponent(Compounds.SILICON_DIOXIDE, PurityLevel.IMPURE)));
            });
            context.modify(Blocks.DEEPSLATE_DIAMOND_ORE.asItem(), builder -> {
                builder.add(ModComponents.COMPOUNDS_COMPONENT, List.of(
                        new CompoundComponent(Compounds.DIAMOND, PurityLevel.IMPURE),
                        new CompoundComponent(Compounds.CALCIUM_CARBONATE, PurityLevel.IMPURE),
                        new CompoundComponent(Compounds.SILICON_DIOXIDE, PurityLevel.IMPURE)));
            });
            context.modify(Blocks.NETHER_GOLD_ORE.asItem(), builder -> {
                builder.add(ModComponents.ELEMENTS_COMPONENT, List.of(
                        new ElementComponent(Elements.GOLD, PurityLevel.IMPURE)));
                builder.add(ModComponents.COMPOUNDS_COMPONENT, List.of(
                        new CompoundComponent(Compounds.CALCIUM_CARBONATE, PurityLevel.IMPURE),
                        new CompoundComponent(Compounds.CALCIUM_CARBONATE, PurityLevel.IMPURE),
                        new CompoundComponent(Compounds.FAYALITE, PurityLevel.IMPURE),
                        new CompoundComponent(Compounds.SULFUR_DIOXIDE, PurityLevel.IMPURE)));
            });
            context.modify(Blocks.RAW_IRON_BLOCK.asItem(), builder -> {
                builder.add(ModComponents.ELEMENTS_COMPONENT, List.of(
                        new ElementComponent(Elements.IRON, PurityLevel.IMPURE),
                        new ElementComponent(Elements.X_ELEMENT, PurityLevel.NORMAL)));
            });
            context.modify(Blocks.RAW_COPPER_BLOCK.asItem(), builder -> {
                builder.add(ModComponents.ELEMENTS_COMPONENT, List.of(
                        new ElementComponent(Elements.COPPER, PurityLevel.IMPURE),
                        new ElementComponent(Elements.X_ELEMENT, PurityLevel.NORMAL)));
            });
            context.modify(Blocks.RAW_GOLD_BLOCK.asItem(), builder -> {
                builder.add(ModComponents.ELEMENTS_COMPONENT, List.of(
                        new ElementComponent(Elements.GOLD, PurityLevel.IMPURE),
                        new ElementComponent(Elements.X_ELEMENT, PurityLevel.NORMAL)));
            });
            context.modify(Blocks.GLOWSTONE.asItem(), builder -> {
                builder.add(ModComponents.COMPOUNDS_COMPONENT, List.of(
                        new CompoundComponent(Compounds.GLOWSTONE, PurityLevel.IMPURE)));
            });
            context.modify(Blocks.AMETHYST_BLOCK.asItem(), builder -> {
                builder.add(ModComponents.COMPOUNDS_COMPONENT, List.of(
                        new CompoundComponent(Compounds.SILICON_DIOXIDE, PurityLevel.NORMAL)));
                builder.add(ModComponents.ELEMENTS_COMPONENT, List.of(
                        new ElementComponent(Elements.IRON, PurityLevel.NORMAL)));
            });


            //Items
            context.modify(Items.CLAY_BALL, builder -> {
                builder.add(ModComponents.COMPOUNDS_COMPONENT, List.of(new CompoundComponent(Compounds.KAOLINITE, PurityLevel.IMPURE)));
            });
            context.modify(Items.BRICK, builder -> {
                builder.add(ModComponents.COMPOUNDS_COMPONENT, List.of(new CompoundComponent(Compounds.KAOLINITE, PurityLevel.IMPURE)));
            });
            context.modify(Items.COAL, builder -> {
                builder.add(ModComponents.ELEMENTS_COMPONENT, List.of(new ElementComponent(Elements.CARBON, PurityLevel.NORMAL)));
            });
            context.modify(Items.CHARCOAL, builder -> {
                builder.add(ModComponents.ELEMENTS_COMPONENT, List.of(new ElementComponent(Elements.CARBON, PurityLevel.NORMAL)));
            });
            context.modify(Items.RAW_COPPER, builder -> {
                builder.add(ModComponents.ELEMENTS_COMPONENT, List.of(
                        new ElementComponent(Elements.COPPER, PurityLevel.IMPURE),
                        new ElementComponent(Elements.X_ELEMENT, PurityLevel.NORMAL)));
            });
            context.modify(Items.COPPER_INGOT, builder -> {
                builder.add(ModComponents.ELEMENTS_COMPONENT, List.of(new ElementComponent(Elements.COPPER, PurityLevel.NORMAL)));
            });
            context.modify(Items.RAW_IRON, builder -> {
                builder.add(ModComponents.ELEMENTS_COMPONENT, List.of(
                        new ElementComponent(Elements.IRON, PurityLevel.IMPURE),
                        new ElementComponent(Elements.X_ELEMENT, PurityLevel.NORMAL)));
            });
            context.modify(Items.IRON_INGOT, builder -> {
                builder.add(ModComponents.ELEMENTS_COMPONENT, List.of(new ElementComponent(Elements.IRON, PurityLevel.NORMAL)));
            });
            context.modify(Items.IRON_NUGGET, builder -> {
                builder.add(ModComponents.ELEMENTS_COMPONENT, List.of(new ElementComponent(Elements.IRON, PurityLevel.NORMAL)));
            });
            context.modify(Items.RAW_GOLD, builder -> {
                builder.add(ModComponents.ELEMENTS_COMPONENT, List.of(
                        new ElementComponent(Elements.GOLD, PurityLevel.IMPURE),
                        new ElementComponent(Elements.X_ELEMENT, PurityLevel.NORMAL)));
            });
            context.modify(Items.GOLD_INGOT, builder -> {
                builder.add(ModComponents.ELEMENTS_COMPONENT, List.of(new ElementComponent(Elements.GOLD, PurityLevel.NORMAL)));
            });
            context.modify(Items.GOLD_NUGGET, builder -> {
                builder.add(ModComponents.ELEMENTS_COMPONENT, List.of(new ElementComponent(Elements.GOLD, PurityLevel.NORMAL)));
            });
            context.modify(Items.LAPIS_LAZULI, builder -> {
                builder.add(ModComponents.COMPOUNDS_COMPONENT, List.of(new CompoundComponent(Compounds.LAPIS, PurityLevel.NORMAL)));
            });
            context.modify(Items.EMERALD, builder -> {
                builder.add(ModComponents.COMPOUNDS_COMPONENT, List.of(new CompoundComponent(Compounds.EMERALD, PurityLevel.NORMAL)));
            });
            context.modify(Items.DIAMOND, builder -> {
                builder.add(ModComponents.COMPOUNDS_COMPONENT, List.of(new CompoundComponent(Compounds.DIAMOND, PurityLevel.NORMAL)));
            });
            context.modify(Items.QUARTZ, builder -> {
                builder.add(ModComponents.COMPOUNDS_COMPONENT, List.of(new CompoundComponent(Compounds.SILICON_DIOXIDE, PurityLevel.NORMAL)));
            });
            context.modify(Items.AMETHYST_SHARD, builder -> {
                builder.add(ModComponents.COMPOUNDS_COMPONENT, List.of(
                        new CompoundComponent(Compounds.SILICON_DIOXIDE, PurityLevel.NORMAL)));
                builder.add(ModComponents.ELEMENTS_COMPONENT, List.of(
                        new ElementComponent(Elements.IRON, PurityLevel.NORMAL)));
            });
            context.modify(Items.ANCIENT_DEBRIS, builder -> {
                builder.add(ModComponents.COMPOUNDS_COMPONENT, List.of(new CompoundComponent(Compounds.ANCIENT_MATERIAL, PurityLevel.IMPURE)));
            });
            context.modify(Items.NETHERITE_INGOT, builder -> {
                builder.add(ModComponents.COMPOUNDS_COMPONENT, List.of(new CompoundComponent(Compounds.NETHERITE, PurityLevel.NORMAL)));
            });
        });
    }
}
