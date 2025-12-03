package com.protons.testmod.fluid;

import com.protons.testmod.block.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.world.World;

public class AcidicHotSpring extends ModFluid{
    @Override
    public FluidTypes getFluidType() {
        return FluidTypes.ACIDIC_HOT_SPRING;
    }

    @Override
    protected boolean isInfinite(World world) {
        return true;
    }

    @Override
    public Fluid getFlowing() {
        return ModFluids.ACIDIC_HOT_SPRING_FLOWING;
    }

    @Override
    public Fluid getStill() {
        return ModFluids.ACIDIC_HOT_SPRING_STILL;
    }

    @Override
    public Item getBucketItem() {
        return null;
    }

    @Override
    protected BlockState toBlockState(FluidState state) {
        return ModBlocks.ACIDIC_HOT_SPRING.getDefaultState().with(Properties.LEVEL_15, getBlockStateLevel(state));
    }

    @Override
    public boolean isStill(FluidState state) {
        return false;
    }

    @Override
    public int getLevel(FluidState state) {
        return state.getLevel();
    }

    public static class Flowing extends AcidicHotSpring {
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

    public static class Still extends AcidicHotSpring {
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
