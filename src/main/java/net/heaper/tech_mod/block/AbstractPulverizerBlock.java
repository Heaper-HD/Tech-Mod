package net.heaper.tech_mod.block;

import com.mojang.serialization.MapCodec;
import net.heaper.tech_mod.block.entity.AbstractPulverizerBlockEntity;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractPulverizerBlock extends BlockWithEntity {
    public static final EnumProperty<Direction> FACING = HorizontalFacingBlock.FACING;
    public static final BooleanProperty ENABLED = Properties.ENABLED;

    protected AbstractPulverizerBlock(AbstractBlock.Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH).with(ENABLED, false));
    }

    @Override
    protected abstract MapCodec<? extends AbstractPulverizerBlock> getCodec();

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (!world.isClient) {
            this.openScreen(world, pos, player);
        }

        return ActionResult.SUCCESS;
    }

    protected abstract void openScreen(World world, BlockPos blockPos, PlayerEntity playerEntity);

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    protected void onStateReplaced(BlockState state, ServerWorld world, BlockPos pos, boolean moved) {
        super.onStateReplaced(state, world, pos, moved);
        ItemScatterer.onStateReplaced(state, world, pos);
    }

    @Override
    protected boolean hasComparatorOutput(BlockState state) {
        return true;
    }

    @Override
    protected int getComparatorOutput(BlockState state, World world, BlockPos pos) {
        return ScreenHandler.calculateComparatorOutput(world.getBlockEntity(pos));
    }

    @Override
    protected BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    protected BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, ENABLED);
    }

    @Nullable
    protected static <T extends BlockEntity> BlockEntityTicker<T> validateTicker(
            World world, BlockEntityType<T> givenType, BlockEntityType<? extends AbstractPulverizerBlockEntity> expectedType
    ) {
        return world instanceof ServerWorld serverWorld
                ? validateTicker(givenType, expectedType, (worldx, pos, state, blockEntity) -> AbstractPulverizerBlockEntity.tick(serverWorld, pos, state, blockEntity))
                : null;
    }
}
