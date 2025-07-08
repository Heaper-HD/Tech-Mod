package net.heaper.tech_mod.client;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.heaper.tech_mod.Tech_mod;
import net.heaper.tech_mod.client.datagen.*;
import net.heaper.tech_mod.world.ModConfiguredFeatures;
import net.heaper.tech_mod.world.ModPlacedFeatures;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

import java.io.DataOutput;
import java.io.IOException;

public class Tech_modDataGenerator implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        Tech_mod.LOGGER.info("Initializing Mod Item Tag Provider");
        pack.addProvider(ModItemTagProvider::new);

        Tech_mod.LOGGER.info("Initializing Mod Block Tag Provider");
        pack.addProvider(ModBlockTagProvider::new);

        Tech_mod.LOGGER.info("Initializing Mod English Language Provider");
        pack.addProvider(ModEnglishLangProvider::new);

        Tech_mod.LOGGER.info("Initializing Mod Advancement Provider");
        pack.addProvider(ModAdvancementProvider::new);

        Tech_mod.LOGGER.info("Initializing Mod Recipe Provider");
        pack.addProvider(ModRecipeProvider::new);

        Tech_mod.LOGGER.info("Initializing Mod Loot Table Provider");
        pack.addProvider(ModBlockLootTableProvider::new);

        Tech_mod.LOGGER.info("Initializing Mod Model Provider");
        pack.addProvider(ModModelProvider::new);

        Tech_mod.LOGGER.info("Initializing Mod Registry Data Generator");
        pack.addProvider(ModRegistryDataGenerator::new);

        Tech_mod.LOGGER.info("Initializing texture generator");
        new ModTextureGenerator(pack);
    }

    @Override
    public void buildRegistry(RegistryBuilder registryBuilder) {
        registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap);
        registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, ModPlacedFeatures::bootstrap);
    }
}
