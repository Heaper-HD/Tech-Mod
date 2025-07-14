package net.heaper.tech_mod.screen;

import net.heaper.tech_mod.recipe.ModRecipePropertySet;
import net.heaper.tech_mod.recipe.ModRecipeType;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.recipe.book.RecipeBookType;
import net.minecraft.screen.PropertyDelegate;

public class PulverizerScreenHandler extends AbstractPulverizerScreenHandler {
    public PulverizerScreenHandler(int syncId, PlayerInventory playerInventory) {
        super(ModScreenHandlerType.PULVERIZER, ModRecipeType.PULVERIZING, ModRecipePropertySet.PULVERIZER_INPUT, RecipeBookType.FURNACE, syncId, playerInventory);
    }

    public PulverizerScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory, PropertyDelegate propertyDelegate) {
        super(
                ModScreenHandlerType.PULVERIZER,
                ModRecipeType.PULVERIZING,
                ModRecipePropertySet.PULVERIZER_INPUT,
                RecipeBookType.FURNACE,
                syncId,
                playerInventory,
                inventory,
                propertyDelegate
        );
    }
}
