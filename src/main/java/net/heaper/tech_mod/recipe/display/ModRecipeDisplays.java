package net.heaper.tech_mod.recipe.display;

import net.heaper.tech_mod.Tech_mod;
import net.minecraft.recipe.display.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRecipeDisplays {
    private ModRecipeDisplays() {}

    public static final RecipeDisplay.Serializer<PulverizerRecipeDisplay> PULVERIZATOR =
            PulverizerRecipeDisplay.SERIALIZER;

    public static void register() {
        Registry.register(
                Registries.RECIPE_DISPLAY,
                Identifier.of(Tech_mod.MOD_ID, "pulverizator"),
                PULVERIZATOR
        );
    }
}
