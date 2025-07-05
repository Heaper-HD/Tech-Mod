package net.heaper.tech_mod.client.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.heaper.tech_mod.block.ModBlocks;
import net.heaper.tech_mod.item.ModItems;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.entry.RegistryEntry;

import java.util.concurrent.CompletableFuture;

public class ModBlockLootTableProvider extends FabricBlockLootTableProvider {

    public ModBlockLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        RegistryWrapper<Enchantment> enchantmentRegistry = registries.getOrThrow(RegistryKeys.ENCHANTMENT);

        RegistryEntry<Enchantment> fortune = enchantmentRegistry
                .getOptional(Enchantments.FORTUNE)
                .orElseThrow();

        addDrop(ModBlocks.URANIUM_BLOCK);
        addDrop(ModBlocks.RAW_URANIUM_BLOCK);

        //Silk touch/Fortune affected loot table drops
        addDrop(ModBlocks.URANIUM_ORE, dropsWithSilkTouch(ModBlocks.URANIUM_ORE,
                this.applyExplosionDecay(ModBlocks.URANIUM_ORE,
                        ItemEntry.builder(ModItems.RAW_URANIUM)
                                .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1)))
                                .apply(ApplyBonusLootFunction.oreDrops(fortune))
                ))
        );
        addDrop(ModBlocks.DEEPSLATE_URANIUM_ORE, dropsWithSilkTouch(ModBlocks.DEEPSLATE_URANIUM_ORE,
                this.applyExplosionDecay(ModBlocks.DEEPSLATE_URANIUM_ORE,
                        ItemEntry.builder(ModItems.RAW_URANIUM)
                                .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1)))
                                .apply(ApplyBonusLootFunction.oreDrops(fortune))
                ))
        );

        //Replaces vanilla loot tables
        addDrop(Blocks.DIAMOND_ORE, dropsWithSilkTouch(Blocks.DIAMOND_ORE,
                this.applyExplosionDecay(Blocks.DIAMOND_ORE,
                        ItemEntry.builder(ModItems.DIAMOND_CRYSTAL)  // Your modded drop
                                .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1))) // base count 1
                                .apply(ApplyBonusLootFunction.oreDrops(fortune))  // fortune effect
                )
        ));

        addDrop(Blocks.DEEPSLATE_DIAMOND_ORE, dropsWithSilkTouch(Blocks.DEEPSLATE_DIAMOND_ORE,
                this.applyExplosionDecay(Blocks.DEEPSLATE_DIAMOND_ORE,
                        ItemEntry.builder(ModItems.DIAMOND_CRYSTAL)
                                .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1)))
                                .apply(ApplyBonusLootFunction.oreDrops(fortune))
                )
        ));

        addDrop(Blocks.EMERALD_ORE, dropsWithSilkTouch(Blocks.EMERALD_ORE,
                this.applyExplosionDecay(Blocks.EMERALD_ORE,
                        ItemEntry.builder(ModItems.EMERALD_CRYSTAL)  // Your modded drop
                                .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1))) // base count 1
                                .apply(ApplyBonusLootFunction.oreDrops(fortune))  // fortune effect
                )
        ));

        addDrop(Blocks.DEEPSLATE_EMERALD_ORE, dropsWithSilkTouch(Blocks.DEEPSLATE_EMERALD_ORE,
                this.applyExplosionDecay(Blocks.DEEPSLATE_EMERALD_ORE,
                        ItemEntry.builder(ModItems.EMERALD_CRYSTAL)
                                .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1)))
                                .apply(ApplyBonusLootFunction.oreDrops(fortune))
                )
        ));
    }
}
