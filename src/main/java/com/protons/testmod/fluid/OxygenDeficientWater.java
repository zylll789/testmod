package com.protons.testmod.fluid;

import com.protons.testmod.block.ModBlocks;
import com.protons.testmod.item.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.world.World;

public class OxygenDeficientWater extends ModFluid{

    @Override
    protected boolean isInfinite(World world) {
        return true;
    }

    @Override
    public Fluid getFlowing() {
        return ModFluids.OXYGEN_DEFICIENT_WATER_FLOWING;
    }

    @Override
    public Fluid getStill() {
        return ModFluids.OXYGEN_DEFICIENT_WATER_STILL;
    }

    @Override
    public int getLevel(FluidState state) {
        return state.getLevel();
    }

    @Override
    public Item getBucketItem() {
        return ModItems.OXYGEN_DEFICIENT_WATER_BUCKET;
    }

    @Override
    protected BlockState toBlockState(FluidState state) {
        return ModBlocks.OXYGEN_DEFICIENT_WATER.getDefaultState().with(Properties.LEVEL_15, getBlockStateLevel(state));
    }

    @Override
    public boolean isStill(FluidState state) {
        return false;
    }

    public static class Flowing extends OxygenDeficientWater {
        @Override
        protected void appendProperties(StateManager.Builder<Fluid, FluidState> builder) {
            super.appendProperties(builder);
            builder.add(LEVEL);
        }

        @Override
        public int getLevel(FluidState fluidState) {
            return fluidState.get(LEVEL);
        }

        @Override
        public boolean isStill(FluidState fluidState) {
            return false;
        }
    }

    public static class Still extends OxygenDeficientWater {
        @Override
        public int getLevel(FluidState fluidState) {
            return 8;
        }

        @Override
        public boolean isStill(FluidState fluidState) {
            return true;
        }
    }
}
