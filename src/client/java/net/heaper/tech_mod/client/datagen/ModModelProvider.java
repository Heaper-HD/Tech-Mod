package net.heaper.tech_mod.client.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.heaper.tech_mod.block.ModBlocks;
import net.heaper.tech_mod.item.ModItems;
import net.minecraft.client.data.*;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        //Uranium block related models
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.URANIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_URANIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_URANIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.URANIUM_BLOCK);

        //Arentinium block related models
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ARENTINIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_ARENTINIUM_BLOCK);

        //Machines block related models
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        //Uranium item related models
        itemModelGenerator.register(ModItems.RAW_URANIUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.URANIUM_PELLET, Models.GENERATED);
        itemModelGenerator.register(ModItems.SMALL_URANIUM_PELLET, Models.GENERATED);
        itemModelGenerator.register(ModItems.DIRTY_URANIUM_POWDER, Models.GENERATED);
        itemModelGenerator.register(ModItems.URANIUM_POWDER, Models.GENERATED);
        itemModelGenerator.register(ModItems.PURIFIED_URANIUM_POWDER, Models.GENERATED);

        //Arentinium item related models
        itemModelGenerator.register(ModItems.RAW_ARENTINIUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.ARENTINIUM_INGOT, Models.GENERATED);

        //Coal item related models

        //Copper item related models

        //Iron item related models

        //Gold item related models

        //Diamond item related models
        itemModelGenerator.register(ModItems.DIAMOND_CRYSTAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.EMERALD_CRYSTAL, Models.GENERATED);

        //Emerald item related models
    }

    @Override
    public String getName() {
        return "Tech Mod Model Provider";
    }
}
