package net.heaper.tech_mod.client.datagen;

import net.minecraft.util.Identifier;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.heaper.tech_mod.block.ModBlocks;
import net.heaper.tech_mod.item.ModItems;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup registryLookup, RecipeExporter exporter) {
        return new RecipeGenerator(registryLookup, exporter) {
            @Override
            public void generate() {
                RegistryWrapper.Impl<Item> itemLookup = registries.getOrThrow(RegistryKeys.ITEM);

                //Ingot like recipes
                createShaped(RecipeCategory.MISC, ModItems.URANIUM_PELLET)
                        .pattern("###")
                        .pattern("###")
                        .pattern("###")
                        .input('#', ModItems.SMALL_URANIUM_PELLET)
                        .group("uranium_pellet")
                        .criterion(hasItem(ModItems.SMALL_URANIUM_PELLET), conditionsFromItem(ModItems.SMALL_URANIUM_PELLET))
                        .offerTo(exporter, String.valueOf(Identifier.of(getRecipeName(ModItems.URANIUM_PELLET)+"_from_nuggets")));

                //Blocks recipes
                createShaped(RecipeCategory.MISC, ModBlocks.RAW_URANIUM_BLOCK)
                        .pattern("###")
                        .pattern("###")
                        .pattern("###")
                        .input('#', ModItems.RAW_URANIUM)
                        .group("raw_uranium_block")
                        .criterion(hasItem(ModItems.RAW_URANIUM), conditionsFromItem(ModItems.RAW_URANIUM))
                        .offerTo(exporter);
                createShaped(RecipeCategory.MISC, ModBlocks.URANIUM_BLOCK)
                        .pattern("###")
                        .pattern("###")
                        .pattern("###")
                        .input('#', ModItems.URANIUM_PELLET)
                        .group("uranium_block")
                        .criterion(hasItem(ModItems.URANIUM_PELLET), conditionsFromItem(ModItems.URANIUM_PELLET))
                        .offerTo(exporter);

                //Ingot to nuggets like recipes
                createShapeless(RecipeCategory.MISC, ModItems.SMALL_URANIUM_PELLET, 9)
                        .input(ModItems.URANIUM_PELLET)
                        .criterion(hasItem(ModItems.URANIUM_PELLET), conditionsFromItem(ModItems.URANIUM_PELLET))
                        .group("small_uranium_pellet")
                        .offerTo(exporter, String.valueOf(Identifier.of(getRecipeName(ModItems.SMALL_URANIUM_PELLET)+"_from_ingot")));

                //Block to ingots like recipes
                createShapeless(RecipeCategory.MISC, ModItems.URANIUM_PELLET, 9)
                        .input(ModBlocks.URANIUM_BLOCK)
                        .criterion(hasItem(ModBlocks.URANIUM_BLOCK), conditionsFromItem(ModBlocks.URANIUM_BLOCK))
                        .group("uranium_pellet")
                        .offerTo(exporter, String.valueOf(Identifier.of(getRecipeName(ModItems.URANIUM_PELLET)+"_from_block")));

                //Raw block to raw item recipes
                createShapeless(RecipeCategory.MISC, ModItems.RAW_URANIUM, 9)
                        .input(ModBlocks.RAW_URANIUM_BLOCK)
                        .criterion(hasItem(ModBlocks.URANIUM_BLOCK), conditionsFromItem(ModBlocks.URANIUM_BLOCK))
                        .group("raw_uranium")
                        .offerTo(exporter);

                //Smelting recipes
                offerSmelting(
                        List.of(ModItems.RAW_URANIUM, ModBlocks.URANIUM_ORE, ModBlocks.DEEPSLATE_URANIUM_ORE),
                        RecipeCategory.MISC,
                        ModItems.URANIUM_PELLET,
                        1f,
                        200,
                        "uranium_pellet"
                );

                //Blasting recipes
                offerBlasting(
                        List.of(ModItems.RAW_URANIUM, ModBlocks.URANIUM_ORE, ModBlocks.DEEPSLATE_URANIUM_ORE),
                        RecipeCategory.MISC,
                        ModItems.URANIUM_PELLET,
                        1f,
                        100,
                        "uranium_pellet"
                );
            }
        };
    }

    @Override
    public String getName() {
        return "TechModRecipeProvider";
    }

    private Identifier recipeId(ItemConvertible output, String suffix) {
        Identifier baseId = Registries.ITEM.getId(output.asItem());
        return Identifier.of("tech_mod:" + baseId.getPath() + (suffix != null && !suffix.isEmpty() ? "_" + suffix : ""));
    }
}
