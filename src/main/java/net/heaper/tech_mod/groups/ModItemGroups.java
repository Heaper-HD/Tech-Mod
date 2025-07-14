package net.heaper.tech_mod.groups;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.heaper.tech_mod.Tech_mod;
import net.heaper.tech_mod.block.ModBlocks;
import net.heaper.tech_mod.item.ModItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.URANIUM_PELLET))
            .displayName(Text.translatable("itemGroup.tech_mod.items"))
            .entries((context, entries) -> {
                //Uranium related modded items
                entries.add(ModItems.RAW_URANIUM);
                entries.add(ModItems.URANIUM_PELLET);
                entries.add(ModItems.SMALL_URANIUM_PELLET);
                entries.add(ModItems.DIRTY_URANIUM_POWDER);
                entries.add(ModItems.URANIUM_POWDER);
                entries.add(ModItems.PURIFIED_URANIUM_POWDER);

                //Arentinium related mod items
                entries.add(ModItems.RAW_ARENTINIUM);
                entries.add(ModItems.ARENTINIUM_INGOT);

                //Vanilla related modded items
                entries.add(ModItems.DIAMOND_CRYSTAL);
                entries.add(ModItems.EMERALD_CRYSTAL);
            })
            .build();

    public static final ItemGroup BLOCK_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModBlocks.URANIUM_ORE))
            .displayName(Text.translatable("itemGroup.tech_mod.blocks"))
            .entries((context, entries) -> {
                //Uranium related modded blocks
                entries.add(ModBlocks.URANIUM_ORE);
                entries.add(ModBlocks.DEEPSLATE_URANIUM_ORE);
                entries.add(ModBlocks.RAW_URANIUM_BLOCK);
                entries.add(ModBlocks.URANIUM_BLOCK);

                //Arentinium related modded blocks
                entries.add(ModBlocks.ARENTINIUM_ORE);
                entries.add(ModBlocks.RAW_ARENTINIUM_BLOCK);

            })
            .build();

    public static final ItemGroup MACHINES_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModBlocks.PULVERIZER))
            .displayName(Text.translatable("itemGroup.tech_mod.machines"))
            .entries((context, entries) -> {
               entries.add(ModBlocks.PULVERIZER);
            })
            .build();

    public static void Initialize() {
        Registry.register(Registries.ITEM_GROUP, Identifier.of(Tech_mod.MOD_ID, "items_group"), ITEM_GROUP);
        Registry.register(Registries.ITEM_GROUP, Identifier.of(Tech_mod.MOD_ID, "blocks_group"), BLOCK_GROUP);
        Registry.register(Registries.ITEM_GROUP, Identifier.of(Tech_mod.MOD_ID, "machines_group"), MACHINES_GROUP);
    }
}
