package net.heaper.tech_mod.client.gui.screen.recipebook;

import net.heaper.tech_mod.Tech_mod;
import net.heaper.tech_mod.recipe.display.PulverizerRecipeDisplay;
import net.heaper.tech_mod.screen.AbstractPulverizerScreenHandler;
import net.minecraft.client.gui.screen.ButtonTextures;
import net.minecraft.client.gui.screen.recipebook.GhostRecipe;
import net.minecraft.client.gui.screen.recipebook.RecipeBookWidget;
import net.minecraft.client.gui.screen.recipebook.RecipeResultCollection;
import net.minecraft.recipe.RecipeFinder;
import net.minecraft.recipe.display.RecipeDisplay;
import net.minecraft.screen.slot.Slot;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.context.ContextParameterMap;

import java.util.List;

public class AbstractPulverizerBookWidget extends RecipeBookWidget<AbstractPulverizerScreenHandler> {
    private static final ButtonTextures TEXTURES = new ButtonTextures(
            Identifier.of(Tech_mod.MOD_ID, "recipe_book/pulverizer_filter_enabled"),
            Identifier.of(Tech_mod.MOD_ID, "recipe_book/pulverizer_filter_disabled"),
            Identifier.of(Tech_mod.MOD_ID, "recipe_book/pulverizer_filter_enabled_highlighted"),
            Identifier.of(Tech_mod.MOD_ID, "recipe_book/pulverizer_filter_disabled_highlighted")
    );
    private final net.minecraft.text.Text toggleCraftableButtonText;

    public AbstractPulverizerBookWidget(AbstractPulverizerScreenHandler screenHandler, Text toggleCraftableButtonText, List<RecipeBookWidget.Tab> tabs) {
        super(screenHandler, tabs);
        this.toggleCraftableButtonText = toggleCraftableButtonText;
    }

    @Override
    protected void setBookButtonTexture() {
        this.toggleCraftableButton.setTextures(TEXTURES);
    }

    @Override
    protected boolean isValid(Slot slot) {
        return switch (slot.id) {
            case 0, 1 -> true;
            default -> false;
        };
    }

    @Override
    protected void showGhostRecipe(GhostRecipe ghostRecipe, RecipeDisplay display, ContextParameterMap context) {
        ghostRecipe.addResults(this.craftingScreenHandler.getOutputSlot(), context, display.result());
        if (display instanceof PulverizerRecipeDisplay pulverizerRecipeDisplay) {
            ghostRecipe.addInputs((Slot)this.craftingScreenHandler.slots.get(0), context, pulverizerRecipeDisplay.ingredient());
        }
    }

    @Override
    public net.minecraft.text.Text getToggleCraftableButtonText() {
        return this.toggleCraftableButtonText;
    }

    @Override
    protected void populateRecipes(RecipeResultCollection recipeResultCollection, RecipeFinder recipeFinder) {
        recipeResultCollection.populateRecipes(recipeFinder, display -> display instanceof PulverizerRecipeDisplay);
    }
}
