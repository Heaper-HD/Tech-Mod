package net.heaper.tech_mod.client.gui.screen.ingame;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.heaper.tech_mod.client.gui.screen.recipebook.AbstractPulverizerBookWidget;
import net.heaper.tech_mod.screen.AbstractPulverizerScreenHandler;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.ScreenPos;
import net.minecraft.client.gui.screen.ingame.RecipeBookScreen;
import net.minecraft.client.gui.screen.recipebook.RecipeBookWidget;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

import java.util.List;

@Environment(EnvType.CLIENT)
public abstract class AbstractPulverizerScreen<T extends AbstractPulverizerScreenHandler> extends RecipeBookScreen<T> {
    private final Identifier background;
    private final Identifier runningProgressTexture;

    public AbstractPulverizerScreen(
            T handler,
            PlayerInventory inventory,
            Text title,
            Text toggleCraftableButton,
            Identifier background,
            Identifier runningProgressTexture,
            List<RecipeBookWidget.Tab> recipeBookTabs
    ) {
        super(handler, new AbstractPulverizerBookWidget(handler, toggleCraftableButton, recipeBookTabs), inventory, title);
        this.background = background;
        this.runningProgressTexture = runningProgressTexture;
    }

    @Override
    public void init() {
        super.init();
        this.titleX = (this.backgroundWidth - this.textRenderer.getWidth(this.title)) / 2;
    }

    @Override
    protected ScreenPos getRecipeBookButtonPos() {
        return new ScreenPos(this.x + 20, this.height/2 - 49);
    }

    @Override
    protected void drawBackground(DrawContext context, float deltaTicks, int mouseX, int mouseY) {
        int i = this.x;
        int j = this.y;
        context.drawTexture(RenderPipelines.GUI_TEXTURED, this.background, i, j, 0.0F, 0.0F, this.backgroundWidth, this.backgroundHeight, 256, 256);

        int prog = MathHelper.ceil(handler.getPulverizeProgress() * 24);
        context.drawGuiTexture(RenderPipelines.GUI_TEXTURED, runningProgressTexture,
                24, 16, 0, 0, i + 79, j + 34, prog, 16);
    }
}
