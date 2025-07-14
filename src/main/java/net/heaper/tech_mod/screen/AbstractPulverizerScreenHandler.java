package net.heaper.tech_mod.screen;

import net.heaper.tech_mod.recipe.AbstractPulverizingRecipe;
import net.heaper.tech_mod.screen.slot.PulverizerOutputSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.*;
import net.minecraft.recipe.book.RecipeBookType;
import net.minecraft.recipe.input.SingleStackRecipeInput;
import net.minecraft.registry.RegistryKey;
import net.minecraft.screen.AbstractRecipeScreenHandler;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.Slot;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import java.util.List;

public abstract class AbstractPulverizerScreenHandler extends AbstractRecipeScreenHandler {
    final Inventory inventory;
    private final PropertyDelegate propertyDelegate;
    protected final World world;
    private final RecipeType<? extends AbstractPulverizingRecipe> recipeType;
    private final RecipePropertySet recipePropertySet;
    private final RecipeBookType category;

    protected AbstractPulverizerScreenHandler(
            ScreenHandlerType<?> type,
            RecipeType<? extends AbstractPulverizingRecipe> recipeType,
            RegistryKey<RecipePropertySet> recipePropertySetKey,
            RecipeBookType category,
            int syncId,
            PlayerInventory playerInventory
    ) {
        this(type, recipeType, recipePropertySetKey, category, syncId, playerInventory, new SimpleInventory(3), new ArrayPropertyDelegate(4));
    }

    protected AbstractPulverizerScreenHandler(
            ScreenHandlerType<?> type,
            RecipeType<? extends AbstractPulverizingRecipe> recipeType,
            RegistryKey<RecipePropertySet> recipePropertySetKey,
            RecipeBookType category,
            int syncId,
            PlayerInventory playerInventory,
            Inventory inventory,
            PropertyDelegate propertyDelegate
    ) {
        super(type, syncId);
        this.recipeType = recipeType;
        this.category = category;
        checkSize(inventory, 2);
        checkDataCount(propertyDelegate, 4);
        this.inventory = inventory;
        this.propertyDelegate = propertyDelegate;
        this.world = playerInventory.player.getWorld();
        this.recipePropertySet = this.world.getRecipeManager().getPropertySet(recipePropertySetKey);
        this.addSlot(new Slot(inventory, 0, 56, 35));
        this.addSlot(new PulverizerOutputSlot(playerInventory.player, inventory, 1, 116, 35));
        this.addPlayerSlots(playerInventory, 8, 84);
        this.addProperties(propertyDelegate);
    }

    @Override
    public void populateRecipeFinder(RecipeFinder finder) {
        if (this.inventory instanceof RecipeInputProvider) {
            ((RecipeInputProvider) this.inventory).provideRecipeInputs(finder);
        }
    }

    public Slot getOutputSlot() {
        return this.slots.get(1);
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }

    public float getPulverizeProgress() {
        int i = this.propertyDelegate.get(2);
        int j = this.propertyDelegate.get(3);
        return j != 0 && i != 0 ? MathHelper.clamp((float) i / j, 0.0F, 1.0F) : 0.0F;
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int index) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if (!slot.hasStack()) return ItemStack.EMPTY;

        ItemStack original = slot.getStack();
        newStack = original.copy();

        // machine slots
        final int INPUT = 0;
        final int OUTPUT = 1;

        // player inventory ranges (handler indices)
        final int INV_FIRST   = 2;                // 2 ‑ 28  (27 slots)
        final int INV_LAST    = INV_FIRST + 27;   // 29 (exclusive)
        final int HOTBAR_FIRST= INV_LAST;         // 29
        final int HOTBAR_LAST = HOTBAR_FIRST + 9; // 38 (exclusive)

        /* ---------- machine output clicked ---------- */
        if (index == OUTPUT) {
            if (!this.insertItem(original, INV_FIRST, HOTBAR_LAST, true))
                return ItemStack.EMPTY;

            slot.onQuickTransfer(original, newStack);
        }
        /* ---------- machine input clicked ---------- */
        else if (index == INPUT) {
            if (!this.insertItem(original, INV_FIRST, HOTBAR_LAST, false))
                return ItemStack.EMPTY;
        }
        /* ---------- player inventory / hot‑bar clicked ---------- */
        else {
            boolean moved = false;

            // 1) try move into machine input if valid
            if (this.getSlot(INPUT).canInsert(original)) {
                moved = this.insertItem(original, INPUT, INPUT + 1, false);
            }

            // 2) if not moved, move between main‑inv and hot‑bar (with fallback):
            if (!moved) {
                if (index < HOTBAR_FIRST) {
                    // came from main‑inv -> try hot‑bar first, then full inventory if needed
                    moved = this.insertItem(original, HOTBAR_FIRST, HOTBAR_LAST, false)
                            || this.insertItem(original, INV_FIRST, INV_LAST, false);
                } else {
                    // came from hot‑bar -> try main‑inv first, then full inventory
                    moved = this.insertItem(original, INV_FIRST, INV_LAST, false)
                            || this.insertItem(original, HOTBAR_FIRST, HOTBAR_LAST, false);
                }
            }

            if (!moved) return ItemStack.EMPTY;
        }

        // finalise
        if (original.isEmpty()) {
            slot.setStackNoCallbacks(ItemStack.EMPTY);
        } else {
            slot.markDirty();
        }
        return newStack;
    }

    public boolean isPulverizing() {
        return this.propertyDelegate.get(0) > 0;
    }

    @Override
    public RecipeBookType getCategory() {
        return this.category;
    }

    @SuppressWarnings("unchecked")
    @Override
    public AbstractRecipeScreenHandler.PostFillAction fillInputSlots(
            boolean craftAll, boolean creative, RecipeEntry<?> recipe, ServerWorld world, PlayerInventory inventory
    ) {
        final List<Slot> list = List.of(this.getSlot(0), this.getSlot(1));
        return InputSlotFiller.fill(new InputSlotFiller.Handler<AbstractPulverizingRecipe>() {
            @Override
            public void populateRecipeFinder(RecipeFinder finder) {
                AbstractPulverizerScreenHandler.this.populateRecipeFinder(finder);
            }

            @Override
            public void clear() {
                list.forEach(slot -> slot.setStackNoCallbacks(ItemStack.EMPTY));
            }

            @Override
            public boolean matches(RecipeEntry<AbstractPulverizingRecipe> entry) {
                return entry.value().matches(new SingleStackRecipeInput(AbstractPulverizerScreenHandler.this.inventory.getStack(0)), world);
            }
        }, 1, 1, List.of(this.getSlot(0)), list, inventory, (RecipeEntry<AbstractPulverizingRecipe>) recipe, craftAll, creative);
    }
}
