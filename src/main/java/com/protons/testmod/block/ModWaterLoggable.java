package com.protons.testmod.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Waterloggable;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

public interface ModWaterLoggable extends Waterloggable {

    void setFluidState(FluidState fluidState);

    @Override
    default boolean canFillWithFluid(@Nullable PlayerEntity player, BlockView world, BlockPos pos, BlockState state, Fluid fluid) {
        return fluid.getDefaultState().isIn(FluidTags.WATER);//(fluid == Fluids.WATER) || (fluid == ModFluids.OXYGEN_DEFICIENT_WATER_STILL);
    }

    @Override
    default boolean tryFillWithFluid(WorldAccess world, BlockPos pos, BlockState state, FluidState fluidState) {
        if (!(Boolean)state.get(Properties.WATERLOGGED) && fluidState.isIn(FluidTags.WATER)) {
            this.setFluidState(fluidState);
            if (!world.isClient()) {
                world.setBlockState(pos, state.with(Properties.WATERLOGGED, true), Block.NOTIFY_ALL);
                world.scheduleFluidTick(pos, fluidState.getFluid(), fluidState.getFluid().getTickRate(world));
            }
            return true;
        }
        return false;
    }

    @Override
    default ItemStack tryDrainFluid(@Nullable PlayerEntity player, WorldAccess world, BlockPos pos, BlockState state) {
        if (state.get(Properties.WATERLOGGED)) {
            Item item = world.getFluidState(pos).getFluid().getBucketItem();
            world.setBlockState(pos, state.with(Properties.WATERLOGGED, Boolean.FALSE), Block.NOTIFY_ALL);
            this.setFluidState(Fluids.EMPTY.getDefaultState());
            if (!state.canPlaceAt(world, pos)) {
                world.breakBlock(pos, true);
            }
            return new ItemStack(item);
        }
        return ItemStack.EMPTY;
    }

}
