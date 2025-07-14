package net.heaper.tech_mod.client.recipebook;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.heaper.tech_mod.recipe.book.ModRecipeBookCategories;
import net.minecraft.recipe.book.RecipeBookCategory;
import net.minecraft.recipe.book.RecipeBookGroup;

import java.util.List;

@Environment(EnvType.CLIENT)
public enum ModRecipeBookType implements RecipeBookGroup {
    PULVERIZER(ModRecipeBookCategories.PULVERIZER_ORES, ModRecipeBookCategories.PULVERIZER_DUSTS, ModRecipeBookCategories.PULVERIZER_MISC);

    private final List<RecipeBookCategory> categories;

    private ModRecipeBookType(final RecipeBookCategory... categories) {
        this.categories = List.of(categories);
    }

    public List<RecipeBookCategory> getCategories() {
        return this.categories;
    }
}
