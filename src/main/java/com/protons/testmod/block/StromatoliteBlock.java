package com.protons.testmod.block;

import com.mojang.serialization.MapCodec;
import com.protons.testmod.fluid.FluidTypes;
import com.protons.testmod.fluid.ModFluids;
import com.protons.testmod.item.ModItems;
import com.protons.testmod.state.property.ModProperties;
import net.minecraft.block.*;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import org.apache.commons.logging.Log;
import org.jetbrains.annotations.Nullable;

public class StromatoliteBlock extends HorizontalFacingBlock implements ModWaterLoggable {
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;

    public static final EnumProperty LOGGED_WATER = ModProperties.LOGGED_WATER;

    public static final MapCodec<StromatoliteBlock> CODEC = Block.createCodec(StromatoliteBlock::new);

    @Override
    protected MapCodec<? extends HorizontalFacingBlock> getCodec() {
        return CODEC;
    }

    public StromatoliteBlock(Settings settings) {
        super(settings);
        setDefaultState(getDefaultState()
                .with(Properties.HORIZONTAL_FACING, Direction.NORTH)
                .with(WATERLOGGED, false)
                .with(LOGGED_WATER, FluidTypes.DRY));
    }

    // 让方块认识这个属性，否则设置该属性将会抛出异常。
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(Properties.HORIZONTAL_FACING, WATERLOGGED, LOGGED_WATER);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext ctx) {
        Direction dir = state.get(FACING);
        return switch (dir) {
            case NORTH -> VoxelShapes.cuboid(0.25, 0, 0.25, 0.75, 0.75, 0.75);
            case SOUTH -> VoxelShapes.cuboid(0.25, 0, 0.25, 0.75, 0.75, 0.75);
            case EAST -> VoxelShapes.cuboid(0.25, 0, 0.25, 0.75, 0.75, 0.75);
            case WEST -> VoxelShapes.cuboid(0.25, 0, 0.25, 0.75, 0.75, 0.75);
            default -> VoxelShapes.fullCube();
        };
    }

    @Override
    protected boolean canPathfindThrough(BlockState state, NavigationType type) {
        return false;
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState()
                .with(Properties.HORIZONTAL_FACING, ctx.getHorizontalPlayerFacing().getOpposite())
                .with(WATERLOGGED, ctx.getWorld().getFluidState(ctx.getBlockPos()).getFluid() == Fluids.WATER || ctx.getWorld().getFluidState(ctx.getBlockPos()).getFluid() == ModFluids.OXYGEN_DEFICIENT_WATER_STILL)
                .with(LOGGED_WATER, ctx.getWorld().getFluidState(ctx.getBlockPos()).getFluid() == Fluids.WATER ?
                        FluidTypes.WATER : (ctx.getWorld().getFluidState(ctx.getBlockPos()).getFluid() == ModFluids.OXYGEN_DEFICIENT_WATER_STILL ?
                        FluidTypes.OXYGEN_DEFICIENT_WATER : FluidTypes.DRY));
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? (state.get(LOGGED_WATER) == FluidTypes.OXYGEN_DEFICIENT_WATER ? ModFluids.OXYGEN_DEFICIENT_WATER_STILL.getStill(false) : (state.get(LOGGED_WATER) == FluidTypes.WATER ? Fluids.WATER.getStill(false) : super.getFluidState(state))) : super.getFluidState(state);
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (state.get(WATERLOGGED)) {
            if (state.get(LOGGED_WATER) == FluidTypes.OXYGEN_DEFICIENT_WATER){
                world.scheduleFluidTick(pos, ModFluids.OXYGEN_DEFICIENT_WATER_STILL, ModFluids.OXYGEN_DEFICIENT_WATER_STILL.getTickRate(world));
            }
            if (state.get(LOGGED_WATER) == FluidTypes.WATER){
                world.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
            }
        }
        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

}
