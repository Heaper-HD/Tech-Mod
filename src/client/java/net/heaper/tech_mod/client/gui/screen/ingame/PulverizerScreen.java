package net.heaper.tech_mod.client.gui.screen.ingame;

import net.heaper.tech_mod.Tech_mod;
import net.heaper.tech_mod.block.ModBlocks;
import net.heaper.tech_mod.item.ModItems;
import net.heaper.tech_mod.recipe.book.ModRecipeBookCategories;
import net.heaper.tech_mod.screen.PulverizerScreenHandler;
import net.minecraft.client.gui.screen.recipebook.RecipeBookWidget;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.List;

public class PulverizerScreen extends AbstractPulverizerScreen<PulverizerScreenHandler>{
    public static final Identifier RUNNING_PROGRESS_TEXTURE = Identifier.of(Tech_mod.MOD_ID, "container/pulverizer/running_progress");
    public static final Identifier TEXTURE = Identifier.of(Tech_mod.MOD_ID, "textures/gui/container/pulverizer.png");
    public static final Text TOGGLE_PULVERIZEABLE_TEXT = Text.translatable(Tech_mod.MOD_ID + "gui.recipebook.toggleRecipes.pulverizeable");
    public static final List<RecipeBookWidget.Tab> TABS = List.of(
            new RecipeBookWidget.Tab(
                    ModItems.URANIUM_POWDER,                    // icon for “Dusts”
                    ModRecipeBookCategories.PULVERIZER_DUSTS),

            new RecipeBookWidget.Tab(
                    ModBlocks.URANIUM_ORE.asItem(),             // icon for “Ores”
                    ModRecipeBookCategories.PULVERIZER_ORES),

            new RecipeBookWidget.Tab(
                    ModBlocks.URANIUM_BLOCK.asItem(),           // icon for “Misc”
                    ModRecipeBookCategories.PULVERIZER_MISC)
    );

    public PulverizerScreen(PulverizerScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title, TOGGLE_PULVERIZEABLE_TEXT, TEXTURE,  RUNNING_PROGRESS_TEXTURE, TABS);
    }
}
