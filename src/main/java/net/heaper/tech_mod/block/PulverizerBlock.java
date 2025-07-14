package net.heaper.tech_mod.block;

import com.mojang.serialization.MapCodec;
import net.heaper.tech_mod.block.entity.ModBlockEntityType;
import net.heaper.tech_mod.block.entity.PulverizerBlockEntity;
import net.heaper.tech_mod.stat.ModStats;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class PulverizerBlock extends AbstractPulverizerBlock{
    public static final MapCodec<PulverizerBlock> CODEC = createCodec(PulverizerBlock::new);

    @Override
    protected MapCodec<PulverizerBlock> getCodec() {
        return CODEC;
    }

    public PulverizerBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new PulverizerBlockEntity(pos, state);
    }

    @Override
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return validateTicker(world, type, ModBlockEntityType.PULVERIZER);
    }

    @Override
    protected void openScreen(World world, BlockPos blockPos, PlayerEntity playerEntity) {
        BlockEntity blockEntity = world.getBlockEntity(blockPos);
        if (blockEntity instanceof PulverizerBlockEntity) {
            playerEntity.openHandledScreen((NamedScreenHandlerFactory) blockEntity);
            playerEntity.incrementStat(ModStats.INTERACTED_WITH_PULVERIZER);
        }
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if ((boolean) state.get(ENABLED)) {
            double cx = pos.getX() + 0.5;
            double cy = pos.getY() + 0.5;
            double cz = pos.getZ() + 0.5;

            Direction face = state.get(FACING);

            double ox = cx + face.getOffsetX() * 0.48;
            double oy = cy + (random.nextDouble() * 0.4 - 0.2);
            double oz = cz + face.getOffsetZ() * 0.48;

            if (face.getAxis() == Direction.Axis.X) {
                oz += random.nextDouble() * 0.4 - 0.2;
            } else {
                ox += random.nextDouble() * 0.4 - 0.2;
            }
            if (random.nextDouble() < 0.1) {
                world.playSoundClient(cx, cy, cz,
                        SoundEvents.BLOCK_FURNACE_FIRE_CRACKLE,
                        SoundCategory.BLOCKS, 1.0F, 1.0F, false);
            }

            world.addParticleClient(ParticleTypes.ASH, ox, oy, oz, 0.0, 0.0, 0.0);
        }
    }
}
