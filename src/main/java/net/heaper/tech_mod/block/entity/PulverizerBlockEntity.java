package net.heaper.tech_mod.block.entity;

import net.heaper.tech_mod.Tech_mod;
import net.heaper.tech_mod.recipe.ModRecipeType;
import net.heaper.tech_mod.screen.PulverizerScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;

public class PulverizerBlockEntity extends AbstractPulverizerBlockEntity{
    public PulverizerBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityType.PULVERIZER, pos, state, ModRecipeType.PULVERIZING);
    }

    @Override
    protected Text getContainerName() {
        return Text.translatable(Tech_mod.MOD_ID + "container.pulverizer");
    }

    @Override
    protected ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return new PulverizerScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }
}
