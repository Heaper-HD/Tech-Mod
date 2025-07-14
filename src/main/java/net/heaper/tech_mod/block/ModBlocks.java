package net.heaper.tech_mod.block;

import net.heaper.tech_mod.Tech_mod;
import net.heaper.tech_mod.component.ModDataComponentsType;
import net.heaper.tech_mod.compound.CompoundComponent;
import net.heaper.tech_mod.compound.Compounds;
import net.heaper.tech_mod.element.ElementComponent;
import net.heaper.tech_mod.element.Elements;
import net.heaper.tech_mod.element.PurityLevel;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class ModBlocks {
    private static RegistryKey<Block> keyOfBlock(String name) {
        return RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Tech_mod.MOD_ID, name));
    }

    private static RegistryKey<Item> keyOfItem(String name) {
        return RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Tech_mod.MOD_ID, name));
    }

    public static Block URANIUM_ORE = register(
            "uranium_ore",
            Block::new,
            AbstractBlock.Settings.create().strength(3.0f, 3f).requiresTool().sounds(BlockSoundGroup.STONE),
            true, itemSettings -> {
                itemSettings.component(ModDataComponentsType.ELEMENTS_COMPONENT, List.of(new ElementComponent(Elements.URANIUM, PurityLevel.IMPURE)));
                itemSettings.component(ModDataComponentsType.COMPOUNDS_COMPONENT, List.of(new CompoundComponent(Compounds.SILICON_MONOXIDE, PurityLevel.NORMAL)));
            });


    public static Block DEEPSLATE_URANIUM_ORE = register(
            "deepslate_uranium_ore",
            Block::new,
            AbstractBlock.Settings.create().strength(4.5f, 3f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE),
            true, itemSettings -> {
                itemSettings.component(ModDataComponentsType.ELEMENTS_COMPONENT, List.of(new ElementComponent(Elements.URANIUM, PurityLevel.IMPURE)));
                itemSettings.component(ModDataComponentsType.COMPOUNDS_COMPONENT, List.of(
                        new CompoundComponent(Compounds.SILICON_MONOXIDE, PurityLevel.IMPURE),
                        new CompoundComponent(Compounds.CALCIUM_CARBONATE, PurityLevel.IMPURE)));
            });

    public static Block RAW_URANIUM_BLOCK = register(
            "raw_uranium_block",
            Block::new,
            AbstractBlock.Settings.create().strength(5f, 6f).requiresTool().sounds(BlockSoundGroup.STONE),
            true, itemSettings -> {
                itemSettings.component(ModDataComponentsType.ELEMENTS_COMPONENT, List.of(
                        new ElementComponent(Elements.URANIUM, PurityLevel.IMPURE),
                        new ElementComponent(Elements.X_ELEMENT, PurityLevel.IMPURE)));
            });

    public static Block URANIUM_BLOCK = register(
            "uranium_block",
            Block::new,
            AbstractBlock.Settings.create().strength(4.5f, 6f).requiresTool().sounds(BlockSoundGroup.IRON),
            true, itemSettings -> {
                itemSettings.component(ModDataComponentsType.ELEMENTS_COMPONENT, List.of(
                        new ElementComponent(Elements.URANIUM, PurityLevel.IMPURE)));
            });

    public static Block ARENTINIUM_ORE = register(
            "arentinium_ore",
            Block::new,
            AbstractBlock.Settings.create().strength(5f, 6f).requiresTool().sounds(BlockSoundGroup.STONE),
            true, itemSettings -> {
                itemSettings.component(ModDataComponentsType.ELEMENTS_COMPONENT, List.of(new ElementComponent(Elements.ARENTINIUM, PurityLevel.IMPURE)));
                itemSettings.component(ModDataComponentsType.COMPOUNDS_COMPONENT, List.of(new CompoundComponent(Compounds.SILICON_MONOXIDE, PurityLevel.NORMAL)));
            });

    public static Block RAW_ARENTINIUM_BLOCK = register(
            "raw_arentinium_block",
            Block::new,
            AbstractBlock.Settings.create().strength(5f, 6f).requiresTool().sounds(BlockSoundGroup.STONE),
            true, itemSettings -> {
                itemSettings.component(ModDataComponentsType.ELEMENTS_COMPONENT, List.of(
                        new ElementComponent(Elements.ARENTINIUM, PurityLevel.IMPURE),
                        new ElementComponent(Elements.X_ELEMENT, PurityLevel.IMPURE)));
            });

    public static Block PULVERIZER = register(
            "pulverizer",
            PulverizerBlock::new,
            AbstractBlock.Settings.create(),
            true
    );


    public static void Initialize() {}

    private static Block register(String name, Function<AbstractBlock.Settings, Block> blockFactory, AbstractBlock.Settings settings, boolean shouldRegisterItem) {
        RegistryKey<Block> blockKey = keyOfBlock(name);

        Block block = blockFactory.apply(settings.registryKey(blockKey));

        if (shouldRegisterItem) {
            RegistryKey<Item> itemKey = keyOfItem(name);

            BlockItem blockItem = new BlockItem(block, new Item.Settings().registryKey(itemKey));
            Registry.register(Registries.ITEM, itemKey, blockItem);
        }

        return Registry.register(Registries.BLOCK, blockKey, block);
    }

    private static Block register(String name, Function<AbstractBlock.Settings, Block> blockFactory, AbstractBlock.Settings settings, boolean shouldRegisterItem, @Nullable Consumer<Item.Settings> itemSettingsModifier) {
        RegistryKey<Block> blockKey = keyOfBlock(name);

        Block block = blockFactory.apply(settings.registryKey(blockKey));

        if (shouldRegisterItem) {
            RegistryKey<Item> itemKey = keyOfItem(name);
            Item.Settings itemSettings = new Item.Settings().registryKey(itemKey);
            itemSettingsModifier.accept(itemSettings);

            BlockItem blockItem = new BlockItem(block, itemSettings);
            Registry.register(Registries.ITEM, itemKey, blockItem);
        }

        return Registry.register(Registries.BLOCK, blockKey, block);
    }
}
