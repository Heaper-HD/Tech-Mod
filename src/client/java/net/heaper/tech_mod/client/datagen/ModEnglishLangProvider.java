package net.heaper.tech_mod.client.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.heaper.tech_mod.item.ModItems;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModEnglishLangProvider extends FabricLanguageProvider {
    public ModEnglishLangProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "en_us", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add(ModItems.RAW_URANIUM, "Raw Uranium");
        translationBuilder.add(ModItems.URANIUM_PELLET, "Uranium Pellet");
        translationBuilder.add(ModItems.SMALL_URANIUM_PELLET, "Small Uranium Pellet");
        translationBuilder.add(ModItems.DIRTY_URANIUM_POWDER, "Dirty Uranium Powder");
        translationBuilder.add(ModItems.URANIUM_POWDER, "Uranium Powder");
        translationBuilder.add(ModItems.PURIFIED_URANIUM_POWDER, "Purified Uranium Powder");

        translationBuilder.add("item.tech_mod.uranium_ore", "Uranium Ore");
        translationBuilder.add("item.tech_mod.deepslate_uranium_ore", "Deepslate Uranium Ore");
        translationBuilder.add("item.tech_mod.raw_uranium_block", "Block of Raw Uranium");
        translationBuilder.add("item.tech_mod.uranium_block", "Uranium Block");

        translationBuilder.add("itemGroup.tech_mod.items", "Items");
        translationBuilder.add("itemGroup.tech_mod.blocks", "Blocks");
    }
}
