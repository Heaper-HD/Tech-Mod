package net.heaper.tech_mod.recipe;

import net.heaper.tech_mod.Tech_mod;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public interface ModRecipeType<T extends Recipe<?>> {
    RecipeType<PulverizingRecipe> PULVERIZING = register("pulverizing");

    static <T extends Recipe<?>> RecipeType<T> register(String id) {
        return Registry.register(Registries.RECIPE_TYPE, Identifier.of(Tech_mod.MOD_ID, id), new RecipeType<T>() {
            public String toString() {
                return id;
            }
        });
    }

    public static void Initialize() {

    }
}
