package net.heaper.tech_mod.recipe;

import net.heaper.tech_mod.Tech_mod;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public interface ModRecipeSerializers<T extends Recipe<?>>{
    RecipeSerializer<PulverizingRecipe> PULVERIZING = register("pulverizing", new AbstractPulverizingRecipe.Serializer<>(PulverizingRecipe::new, 200));

    static <S extends RecipeSerializer<T>, T extends Recipe<?>> S register(String id, S serializer) {
        return Registry.register(Registries.RECIPE_SERIALIZER, Identifier.of(Tech_mod.MOD_ID, id), serializer);
    }

    public static void Initialize() {

    }
}
