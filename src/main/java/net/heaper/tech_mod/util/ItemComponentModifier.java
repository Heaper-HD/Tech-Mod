package net.heaper.tech_mod.util;

import net.fabricmc.fabric.api.item.v1.DefaultItemComponentEvents;
import net.heaper.tech_mod.block.ModBlocks;
import net.heaper.tech_mod.component.ModComponents;
import net.heaper.tech_mod.compound.CompoundVariant;
import net.heaper.tech_mod.compound.Compounds;
import net.heaper.tech_mod.element.ElementVariant;
import net.heaper.tech_mod.element.Elements;
import net.heaper.tech_mod.element.PurityLevel;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;

import java.util.List;

public class ItemComponentModifier {
    public static void Initialize() {
        DefaultItemComponentEvents.MODIFY.register(context -> {
            context.modify(Items.CLAY_BALL, builder -> {
                builder.add(ModComponents.COMPOUNDS_COMPONENT, List.of(new CompoundVariant(Compounds.KAOLINITE, PurityLevel.IMPURE)));
            });
            context.modify(Blocks.STONE.asItem(), builder -> {
                builder.add(ModComponents.COMPOUNDS_COMPONENT, List.of(new CompoundVariant(Compounds.SILICON_DIOXIDE, PurityLevel.IMPURE)));
            });
            context.modify(Blocks.COBBLESTONE.asItem(), builder -> {
                builder.add(ModComponents.COMPOUNDS_COMPONENT, List.of(new CompoundVariant(Compounds.SILICON_DIOXIDE, PurityLevel.IMPURE)));
            });
            context.modify(Blocks.DEEPSLATE.asItem(), builder -> {
                builder.add(ModComponents.COMPOUNDS_COMPONENT, List.of(
                        new CompoundVariant(Compounds.CALCIUM_CARBONATE, PurityLevel.IMPURE),
                        new CompoundVariant(Compounds.SILICON_DIOXIDE, PurityLevel.IMPURE)));
            });
            context.modify(Blocks.COBBLED_DEEPSLATE.asItem(), builder -> {
                builder.add(ModComponents.COMPOUNDS_COMPONENT, List.of(
                        new CompoundVariant(Compounds.CALCIUM_CARBONATE, PurityLevel.IMPURE),
                        new CompoundVariant(Compounds.SILICON_DIOXIDE, PurityLevel.IMPURE)));
            });
            context.modify(Items.COPPER_INGOT, builder -> {
                builder.add(ModComponents.ELEMENTS_COMPONENT, List.of(new ElementVariant(Elements.COPPER, PurityLevel.NORMAL)));
            });
            context.modify(Items.IRON_INGOT, builder -> {
                builder.add(ModComponents.ELEMENTS_COMPONENT, List.of(new ElementVariant(Elements.IRON, PurityLevel.NORMAL)));
            });
            context.modify(Items.GOLD_INGOT, builder -> {
                builder.add(ModComponents.ELEMENTS_COMPONENT, List.of(new ElementVariant(Elements.GOLD, PurityLevel.NORMAL)));
            });
        });
    }
}
