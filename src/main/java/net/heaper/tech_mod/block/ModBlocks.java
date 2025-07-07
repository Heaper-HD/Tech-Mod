package net.heaper.tech_mod.block;

import net.heaper.tech_mod.Tech_mod;
import net.heaper.tech_mod.component.ModComponents;
import net.heaper.tech_mod.compound.CompoundVariant;
import net.heaper.tech_mod.compound.Compounds;
import net.heaper.tech_mod.element.ElementVariant;
import net.heaper.tech_mod.element.Elements;
import net.heaper.tech_mod.element.PurityLevel;
import net.heaper.tech_mod.util.ItemComponentHelper;
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
    private static Block register(String name, Function<AbstractBlock.Settings, Block> blockFactory, AbstractBlock.Settings settings, boolean shouldRegisterItem) {
        //Creates the block key
        RegistryKey<Block> blockKey = keyOfBlock(name);

        //Creates the block instance
        Block block = blockFactory.apply(settings.registryKey(blockKey));

        //In case block item shouldn't be registered (Ex: minecraft:moving_piston, minecraft:end_gateway)
        if (shouldRegisterItem) {
            //Creates the block item key, needs to be a different type of registry key but the ID ban be the same
            RegistryKey<Item> itemKey = keyOfItem(name);

            BlockItem blockItem = new BlockItem(block, new Item.Settings().registryKey(itemKey));
            Registry.register(Registries.ITEM, itemKey, blockItem);
        }

        return Registry.register(Registries.BLOCK, blockKey, block);
    }

    private static Block register(String name, Function<AbstractBlock.Settings, Block> blockFactory, AbstractBlock.Settings settings, boolean shouldRegisterItem, @Nullable Consumer<Item.Settings> itemSettingsModifier) {
        //Creates the block key
        RegistryKey<Block> blockKey = keyOfBlock(name);

        //Creates the block instance
        Block block = blockFactory.apply(settings.registryKey(blockKey));

        //In case block item shouldn't be registered (Ex: minecraft:moving_piston, minecraft:end_gateway)
        if (shouldRegisterItem) {
            //Creates the block item key, needs to be a different type of registry key but the ID ban be the same
            RegistryKey<Item> itemKey = keyOfItem(name);
            Item.Settings itemSettings = new Item.Settings().registryKey(itemKey);
            if (shouldRegisterItem) {
                itemSettingsModifier.accept(itemSettings);
            }

            BlockItem blockItem = new BlockItem(block, itemSettings);
            Registry.register(Registries.ITEM, itemKey, blockItem);
        }

        return Registry.register(Registries.BLOCK, blockKey, block);
    }

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
                itemSettings.component(ModComponents.ELEMENTS_COMPONENT, List.of(new ElementVariant(Elements.URANIUM, PurityLevel.IMPURE)));
                itemSettings.component(ModComponents.COMPOUNDS_COMPONENT, List.of(new CompoundVariant(Compounds.SILICON_DIOXIDE, PurityLevel.IMPURE)));
            });


    public static Block DEEPSLATE_URANIUM_ORE = register(
            "deepslate_uranium_ore",
            Block::new,
            AbstractBlock.Settings.create().strength(4.5f, 3f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE),
            true, itemSettings -> {
                itemSettings.component(ModComponents.ELEMENTS_COMPONENT, List.of(new ElementVariant(Elements.URANIUM, PurityLevel.IMPURE)));
                itemSettings.component(ModComponents.COMPOUNDS_COMPONENT, List.of(
                        new CompoundVariant(Compounds.SILICON_DIOXIDE, PurityLevel.IMPURE),
                        new CompoundVariant(Compounds.CALCIUM_CARBONATE, PurityLevel.IMPURE)));
            });

    public static Block RAW_URANIUM_BLOCK = register(
            "raw_uranium_block",
            Block::new,
            AbstractBlock.Settings.create().strength(5f, 6f).requiresTool().sounds(BlockSoundGroup.STONE),
            true
    );

    public static Block URANIUM_BLOCK = register(
            "uranium_block",
            Block::new,
            AbstractBlock.Settings.create().strength(4.5f, 6f).requiresTool().sounds(BlockSoundGroup.IRON),
            true
    );

    public static void Initialize() {

    }
}
