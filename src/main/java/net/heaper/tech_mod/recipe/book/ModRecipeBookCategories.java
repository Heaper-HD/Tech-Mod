package net.heaper.tech_mod.recipe.book;

import net.heaper.tech_mod.Tech_mod;
import net.minecraft.recipe.book.RecipeBookCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRecipeBookCategories {
    public static final RecipeBookCategory PULVERIZER_ORES = register("pulverizer_ores");
    public static final RecipeBookCategory PULVERIZER_DUSTS = register("pulverizer_dusts");
    public static final RecipeBookCategory PULVERIZER_MISC = register("pulverizer_misc");

    public static void Initialize() {

    }

    private static RecipeBookCategory register(String id) {
        return Registry.register(Registries.RECIPE_BOOK_CATEGORY, Identifier.of(Tech_mod.MOD_ID, id), new RecipeBookCategory());
    }

    private ModRecipeBookCategories() {}
}
