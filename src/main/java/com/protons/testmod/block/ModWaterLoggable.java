package com.protons.testmod.block;

import com.protons.testmod.fluid.FluidTypes;
import com.protons.testmod.fluid.ModFluid;
import com.protons.testmod.fluid.ModFluids;
import com.protons.testmod.item.ModItems;
import com.protons.testmod.state.property.ModProperties;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Waterloggable;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

public interface ModWaterLoggable extends Waterloggable {

    @Override
    default boolean canFillWithFluid(@Nullable PlayerEntity player, BlockView world, BlockPos pos, BlockState state, Fluid fluid) {
        return fluid.isIn(FluidTags.WATER);//(fluid == Fluids.WATER) || (fluid == ModFluids.OXYGEN_DEFICIENT_WATER_STILL);
    }

    @Override
    default boolean tryFillWithFluid(WorldAccess world, BlockPos pos, BlockState state, FluidState fluidState) {
        if (!(Boolean)state.get(Properties.WATERLOGGED) && fluidState.getFluid().isIn(FluidTags.WATER)) {
            if (fluidState.getFluid() == Fluids.WATER){
                if (!world.isClient()) {
                    world.setBlockState(pos, state.with(Properties.WATERLOGGED, true)
                            .with(ModProperties.LOGGED_WATER, FluidTypes.WATER), Block.NOTIFY_ALL);
                    world.scheduleFluidTick(pos, fluidState.getFluid(), fluidState.getFluid().getTickRate(world));
                }
                return true;
            } else {
                Fluid fluid = fluidState.getFluid();//TODO
                if (!world.isClient()) {
                    world.setBlockState(pos, state.with(Properties.WATERLOGGED, true)
                            .with(ModProperties.LOGGED_WATER, ((ModFluid)fluid).getFluidType()), Block.NOTIFY_ALL);
                    world.scheduleFluidTick(pos, fluidState.getFluid(), fluidState.getFluid().getTickRate(world));
                }
                return true;
            }
        }
        return false;
    }

    @Override
    default ItemStack tryDrainFluid(@Nullable PlayerEntity player, WorldAccess world, BlockPos pos, BlockState state) {
        if (state.get(Properties.WATERLOGGED)) {
            world.setBlockState(pos, state.with(Properties.WATERLOGGED, Boolean.FALSE)
                    .with(ModProperties.LOGGED_WATER, FluidTypes.DRY), Block.NOTIFY_ALL);
            if (!state.canPlaceAt(world, pos)) {
                world.breakBlock(pos, true);
            }
            if (state.get(ModProperties.LOGGED_WATER) == FluidTypes.WATER) {
                return new ItemStack(Items.WATER_BUCKET);
            }
            if (state.get(ModProperties.LOGGED_WATER) == FluidTypes.OXYGEN_DEFICIENT_WATER) {
                return new ItemStack(ModItems.OXYGEN_DEFICIENT_WATER_BUCKET);
            }
        }
        return ItemStack.EMPTY;
    }

}
