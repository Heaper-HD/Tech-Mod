package net.heaper.tech_mod;

import net.fabricmc.api.ModInitializer;
import net.heaper.tech_mod.block.ModBlocks;
import net.heaper.tech_mod.block.entity.ModBlockEntityType;
import net.heaper.tech_mod.command.ModCommandsDispatcher;
import net.heaper.tech_mod.component.ModDataComponentsType;
import net.heaper.tech_mod.groups.ModItemGroups;
import net.heaper.tech_mod.item.ItemComponentModifier;
import net.heaper.tech_mod.item.ModItems;
import net.heaper.tech_mod.recipe.ModRecipeSerializers;
import net.heaper.tech_mod.recipe.ModRecipeType;
import net.heaper.tech_mod.recipe.book.ModRecipeBookCategories;
import net.heaper.tech_mod.recipe.display.ModRecipeDisplays;
import net.heaper.tech_mod.screen.ModScreenHandlerType;
import net.heaper.tech_mod.stat.ModStats;
import net.heaper.tech_mod.util.ModLootTableModifiers;
import net.heaper.tech_mod.world.gen.ModWorldGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Tech_mod implements ModInitializer {
    public static final String MOD_ID = "tech_mod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        //Log message that the mod is initializing
        LOGGER.info("Tech Mod Initializing.");

        //Log message that mod recipes are being initialized
        LOGGER.info("Registering Modded Recipes");
        ModRecipeType.Initialize();

        //Log message that mod recipe book is being initialized
        LOGGER.info("Registering Modded Recipe Book");
        ModRecipeBookCategories.Initialize();

        //Log message that mod recipe displays is being initialized
        LOGGER.info("Registering Modded Recipe Displays");
        ModRecipeDisplays.register();

        //Log message that mod recipe serializer is being initialized
        LOGGER.info("Registering Modded Recipe Serializer Book");
        ModRecipeSerializers.Initialize();

        //Log message that mod stats are being initialized
        LOGGER.info("Registering Modded Stats");
        ModStats.Initialize();

        //Log message that mod screen handler are being initialized
        LOGGER.info("Registering Modded Screen Handler");
        ModScreenHandlerType.Initialize();

        //Log message that mod items are being registered
        LOGGER.info("Registering Items.");
        ModItems.Initialize();

        //Log message that mod blocks are being registered
        LOGGER.info("Registering Blocks");
        ModBlocks.Initialize();

        //Log message that mod entities blocks are being registered
        LOGGER.info("Registering Entities Blocks");
        ModBlockEntityType.Initialize();

        //Log message that mod group tabs are being registered
        LOGGER.info("Registering CompoundGroup Tabs");
        ModItemGroups.Initialize();

        //Log message for initializing world generation
        LOGGER.info("Initializing Mod World Generation");
        ModWorldGeneration.Initialize();

        //Log message for mod loot table modifier
        LOGGER.info("Initializing Loot Table Modifier");
        ModLootTableModifiers.Initialize();

        //Log message for mod command dispatcher
        LOGGER.info("Initializing Mod Commands");
        ModCommandsDispatcher.Initialize();

        //Log message for mod components initializing
        LOGGER.info("Registering Components");
        ModDataComponentsType.Initialize();

        //Log message for altering vanilla items
        LOGGER.info("Altering Vanilla Items");
        ItemComponentModifier.Initialize();
    }
}
