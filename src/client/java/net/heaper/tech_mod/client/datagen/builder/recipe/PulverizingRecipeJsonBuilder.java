package net.heaper.tech_mod.client.datagen.builder.recipe;

import net.heaper.tech_mod.component.ModDataComponentsType;
import net.heaper.tech_mod.recipe.AbstractPulverizingRecipe;
import net.heaper.tech_mod.recipe.PulverizingRecipe;
import net.heaper.tech_mod.recipe.book.PulverizingRecipeCategory;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementCriterion;
import net.minecraft.advancement.AdvancementRequirements;
import net.minecraft.advancement.AdvancementRewards;
import net.minecraft.advancement.criterion.RecipeUnlockedCriterion;
import net.minecraft.data.recipe.CraftingRecipeJsonBuilder;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryKey;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class PulverizingRecipeJsonBuilder implements CraftingRecipeJsonBuilder {
    private final RecipeCategory category;
    private final PulverizingRecipeCategory pulverizingCategory;
    private final Item output;
    private final Ingredient input;
    private final float experience;
    private final int pulverizingTime;
    private final Map<String, AdvancementCriterion<?>> criteria = new LinkedHashMap<>();
    @Nullable
    private String group;
    private final AbstractPulverizingRecipe.RecipeFactory<?> recipeFactory;

    public PulverizingRecipeJsonBuilder(RecipeCategory category, PulverizingRecipeCategory pulverizingCategory, ItemConvertible output, Ingredient input, float experience, int pulverizingTime, AbstractPulverizingRecipe.RecipeFactory<?> recipeFactory) {
        this.category = category;
        this.pulverizingCategory = pulverizingCategory;
        this.output = output.asItem();
        this.input = input;
        this.experience = experience;
        this.pulverizingTime = pulverizingTime;
        this.recipeFactory = recipeFactory;
    }

    public static PulverizingRecipeJsonBuilder createPulverizingRecipe(Ingredient input, RecipeCategory category, ItemConvertible output, float experience, int pulverizingTime) {
        return new PulverizingRecipeJsonBuilder(category, getPulverizingRecipeCategory(output), output, input, experience, pulverizingTime, PulverizingRecipe::new);
    }

    public PulverizingRecipeJsonBuilder criterion(String string, AdvancementCriterion<?> advancementCriterion) {
        this.criteria.put(string, advancementCriterion);
        return this;
    }

    public PulverizingRecipeJsonBuilder group(@Nullable String string) {
        this.group = string;
        return this;
    }

    @Override
    public Item getOutputItem() {
        return this.output;
    }

    @Override
    public void offerTo(RecipeExporter exporter, RegistryKey<Recipe<?>> recipeKey) {
        this.validate(recipeKey);
        Advancement.Builder builder = exporter.getAdvancementBuilder().criterion("has_the_recipe", RecipeUnlockedCriterion.create(recipeKey)).rewards(AdvancementRewards.Builder.recipe(recipeKey)).criteriaMerger(AdvancementRequirements.CriterionMerger.OR);
        this.criteria.forEach(builder::criterion);
        Object abstractPulverizingRecipe = this.recipeFactory.create(
                Objects.requireNonNullElse(this.group, ""),
                this.pulverizingCategory,
                this.input,
                new ItemStack(this.output),
                this.experience,
                this.pulverizingTime
        );
        exporter.accept(recipeKey, (Recipe<?>) abstractPulverizingRecipe, builder.build(recipeKey.getValue().withPrefixedPath("recipes/" + this.category.getName() + "/")));
    }

    private static PulverizingRecipeCategory getPulverizingRecipeCategory(ItemConvertible output) {
        if (output.asItem().getComponents().contains(ModDataComponentsType.POWDER)) {
            return PulverizingRecipeCategory.POWDER;
        }
        if (output.asItem() instanceof BlockItem) {
            return PulverizingRecipeCategory.ORES;
        }
        return PulverizingRecipeCategory.MISC;
    }

    private void validate(RegistryKey<Recipe<?>> recipeKey) {
        if (this.criteria.isEmpty()) {
            throw new IllegalStateException("No way of obtaining recipe " + String.valueOf(recipeKey.getValue()));
        }
    }
}
