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

public class PrimordialSoup extends ModFluid{

    public FluidTypes getFluidType(){
        return FluidTypes.PRIMORDIAL_SOUP;
    }

    @Override
    protected boolean isInfinite(World world) {
        return true;
    }

    @Override
    public Fluid getFlowing() {
        return ModFluids.PRIMORDIAL_SOUP_FLOWING;
    }

    @Override
    public Fluid getStill() {
        return ModFluids.PRIMORDIAL_SOUP_STILL;
    }

    @Override
    public int getLevel(FluidState state) {
        return state.getLevel();
    }

    @Override
    public Item getBucketItem() {
        return ModItems.PRIMORDIAL_SOUP_BUCKET;
    }

    @Override
    protected BlockState toBlockState(FluidState state) {
        return ModBlocks.OXYGEN_DEFICIENT_WATER.getDefaultState().with(Properties.LEVEL_15, getBlockStateLevel(state));
    }

    @Override
    public boolean isStill(FluidState state) {
        return false;
    }

    public static class Flowing extends PrimordialSoup {
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

    public static class Still extends PrimordialSoup {
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
