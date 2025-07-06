package net.heaper.tech_mod;

import net.fabricmc.api.ModInitializer;
import net.heaper.tech_mod.block.ModBlocks;
import net.heaper.tech_mod.command.ModCommandsDispatcher;
import net.heaper.tech_mod.groups.ModItemGroups;
import net.heaper.tech_mod.item.ModItems;
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

        //Log message that mod items are being registered
        LOGGER.info("Registering Items.");
        ModItems.Initialize();

        //Log message that mod blocks are being registered
        LOGGER.info("Registering Blocks");
        ModBlocks.Initialize();

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
    }
}
