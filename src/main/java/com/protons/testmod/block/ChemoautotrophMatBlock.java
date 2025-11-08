package com.protons.testmod.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.fluid.FluidState;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.WorldAccess;

import java.util.Collection;

public class ChemoautotrophMatBlock extends MultifaceGrowthBlock implements ModWaterLoggable {

    public static final MapCodec<ChemoautotrophMatBlock> CODEC = createCodec(ChemoautotrophMatBlock::new);
    private static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;

  //  private final LichenGrower allGrowTypeGrower = new LichenGrower(new ChemoautotrophMatBlock.SculkVeinGrowChecker(LichenGrower.GROW_TYPES));
  //  private final LichenGrower samePositionOnlyGrower = new LichenGrower(new ChemoautotrophMatBlock.SculkVeinGrowChecker(LichenGrower.GrowType.SAME_POSITION));

    public ChemoautotrophMatBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getDefaultState()
                //.with(WATERLOGGED, Boolean.valueOf(false))

        );
    }

    @Override
    public MapCodec<ChemoautotrophMatBlock> getCodec() {
        return CODEC;
    }


    @Override
    public LichenGrower getGrower() {
        return null;//this.allGrowTypeGrower;
    }

    public LichenGrower getSamePositionOnlyGrower() {
        return null;//this.samePositionOnlyGrower;
    }

    public static boolean place(WorldAccess world, BlockPos pos, BlockState state, Collection<Direction> directions) {
        boolean bl = false;
        BlockState blockState = ModBlocks.CHEMOAUTOTROPH_MAT.getDefaultState();

        for (Direction direction : directions) {
            BlockPos blockPos = pos.offset(direction);
            if (canGrowOn(world, direction, blockPos, world.getBlockState(blockPos))) {
                blockState = blockState.with(getProperty(direction), Boolean.valueOf(true));
                bl = true;
            }
        }

        if (!bl) {
            return false;
        } else {
            if (!state.getFluidState().isEmpty()) {
                blockState = blockState.with(WATERLOGGED, Boolean.valueOf(true));
            }

            world.setBlockState(pos, blockState, Block.NOTIFY_ALL);
            return true;
        }
    }


    @Override
    public void setFluidState(FluidState fluidState) {

    }
}
