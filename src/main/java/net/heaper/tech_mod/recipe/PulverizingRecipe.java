    package net.heaper.tech_mod.recipe;

    import net.heaper.tech_mod.block.ModBlocks;
    import net.heaper.tech_mod.recipe.book.ModRecipeBookCategories;
    import net.heaper.tech_mod.recipe.book.PulverizingRecipeCategory;
    import net.minecraft.item.Item;
    import net.minecraft.item.ItemStack;
    import net.minecraft.recipe.Ingredient;
    import net.minecraft.recipe.IngredientPlacement;
    import net.minecraft.recipe.RecipeSerializer;
    import net.minecraft.recipe.RecipeType;
    import net.minecraft.recipe.book.RecipeBookCategory;
    import org.jetbrains.annotations.Nullable;

    public class PulverizingRecipe extends AbstractPulverizingRecipe {
        public PulverizingRecipe(String group, PulverizingRecipeCategory category, Ingredient ingredient, ItemStack result, float experience, int pulverizationTime) {
            super(group, category, ingredient, result, experience, pulverizationTime);
        }

        @Override
        public Item getPulverizatorItem() {
            return ModBlocks.PULVERIZER.asItem();
        }

        @Override
        public RecipeSerializer<PulverizingRecipe> getSerializer() {
            return ModRecipeSerializers.PULVERIZING;
        }

        @Override
        public RecipeType<PulverizingRecipe> getType() {
            return ModRecipeType.PULVERIZING;
        }

        @Override
        public @Nullable IngredientPlacement getIngredientPlacement() {
            return IngredientPlacement.forSingleSlot(this.ingredient());
        }

        @Override
        public RecipeBookCategory getRecipeBookCategory() {
            return switch (this.getCategory()) {
                case ORES -> ModRecipeBookCategories.PULVERIZER_ORES;
                case POWDER -> ModRecipeBookCategories.PULVERIZER_DUSTS;
                case MISC -> ModRecipeBookCategories.PULVERIZER_MISC;
            };
        }
    }
