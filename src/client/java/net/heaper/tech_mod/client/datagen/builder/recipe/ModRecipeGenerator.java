package net.heaper.tech_mod.client.datagen.builder.recipe;

import net.heaper.tech_mod.Tech_mod;
import net.heaper.tech_mod.recipe.AbstractPulverizingRecipe;
import net.heaper.tech_mod.recipe.ModRecipeSerializers;
import net.heaper.tech_mod.recipe.PulverizingRecipe;
import net.minecraft.advancement.AdvancementCriterion;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ModRecipeGenerator extends RecipeGenerator {
    protected final RegistryWrapper.WrapperLookup registries;
    private final RegistryEntryLookup<Item> itemLookup;
    protected final RecipeExporter exporter;

    protected ModRecipeGenerator(RegistryWrapper.WrapperLookup registries, RecipeExporter exporter) {
        super(registries, exporter);
        this.registries = registries;
        this.itemLookup = registries.getOrThrow(RegistryKeys.ITEM);
        this.exporter = exporter;
    }

    @Override
    public void generate() {

    }

    public void offerPulverizing(List<ItemConvertible> inputs, RecipeCategory category, ItemConvertible output, float experience, int pulverizingTime, String group) {
        this.offerMultipleOptions(ModRecipeSerializers.PULVERIZING, PulverizingRecipe::new, inputs, category, output, experience, pulverizingTime, group, "_from_pulverizing");
    }

    public final <T extends AbstractPulverizingRecipe> void offerMultipleOptions(
            RecipeSerializer<T> serializer,
            AbstractPulverizingRecipe.RecipeFactory<T> recipeFactory,
            List<ItemConvertible> input, RecipeCategory category,
            ItemConvertible output, float experience, int pulverizingTime,
            String group,
            String suffix
    ) {
        for (ItemConvertible itemConvertible : input) {
            String path = ModRecipeGenerator.getItemPath(output) + suffix + "_" + ModRecipeGenerator.getItemPath(itemConvertible);
            String id = String.valueOf(Identifier.of(Tech_mod.MOD_ID, path));
            PulverizingRecipeJsonBuilder.create(Ingredient.ofItems(itemConvertible), category, output, experience, pulverizingTime, serializer, recipeFactory)
                    .group(group)
                    .criterion(ModRecipeGenerator.hasItem(itemConvertible), (AdvancementCriterion) this.conditionsFromItem(itemConvertible))
                    .offerTo(this.exporter, id);
        }
    }
    public AdvancementCriterion<InventoryChangedCriterion.Conditions> conditionsFromItem(ItemConvertible item) {
        return ModRecipeGenerator.conditionsFromPredicates(ItemPredicate.Builder.create().items(this.itemLookup, item));
    }

    public static AdvancementCriterion<InventoryChangedCriterion.Conditions> conditionsFromPredicates(ItemPredicate.Builder... predicates) {
        return ModRecipeGenerator.conditionsFromItemPredicates((ItemPredicate[]) Arrays.stream(predicates).map(ItemPredicate.Builder::build).toArray(ItemPredicate[]::new));
    }

    public static AdvancementCriterion<InventoryChangedCriterion.Conditions> conditionsFromItemPredicates(ItemPredicate... predicates) {
        return Criteria.INVENTORY_CHANGED.create(new InventoryChangedCriterion.Conditions(Optional.empty(), InventoryChangedCriterion.Conditions.Slots.ANY, List.of(predicates)));
    }

    public static String hasItem(ItemConvertible item) {
        return "has_" + ModRecipeGenerator.getItemPath(item);
    }

    public static String getItemPath(ItemConvertible item) {
        return Registries.ITEM.getId(item.asItem()).getPath();
    }
}
