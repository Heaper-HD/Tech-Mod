package net.heaper.tech_mod.client.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.heaper.tech_mod.block.ModBlocks;
import net.heaper.tech_mod.item.ModItems;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.URANIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_URANIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_URANIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.URANIUM_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.RAW_URANIUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.URANIUM_PELLET, Models.GENERATED);
        itemModelGenerator.register(ModItems.SMALL_URANIUM_PELLET, Models.GENERATED);
        itemModelGenerator.register(ModItems.DIRTY_URANIUM_POWDER, Models.GENERATED);
        itemModelGenerator.register(ModItems.URANIUM_POWDER, Models.GENERATED);
        itemModelGenerator.register(ModItems.PURIFIED_URANIUM_POWDER, Models.GENERATED);
    }

    @Override
    public String getName() {
        return "Tech Mod Model Provider";
    }
}
