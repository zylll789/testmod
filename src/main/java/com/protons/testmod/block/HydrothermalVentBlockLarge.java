package com.protons.testmod.block;

import com.mojang.serialization.MapCodec;
import com.protons.testmod.fluid.FluidTypes;
import com.protons.testmod.fluid.ModFluids;
import com.protons.testmod.state.property.ModProperties;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
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

public class HydrothermalVentBlockLarge extends HorizontalFacingBlock implements ModWaterLoggable {
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;

    public static final EnumProperty LOGGED_WATER = ModProperties.LOGGED_WATER;

    public static final MapCodec<StromatoliteBlock> CODEC = Block.createCodec(StromatoliteBlock::new);

    @Override
    protected MapCodec<? extends HorizontalFacingBlock> getCodec() {
        return CODEC;
    }

    public HydrothermalVentBlockLarge(Settings settings) {
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
            case NORTH -> VoxelShapes.cuboid(0.0625, 0, 0.0625, 0.9375, 1, 0.9375);
            case SOUTH -> VoxelShapes.cuboid(0.0625, 0, 0.0625, 0.9375, 1, 0.9375);
            case EAST -> VoxelShapes.cuboid(0.0625, 0, 0.0625, 0.9375, 1, 0.9375);
            case WEST -> VoxelShapes.cuboid(0.0625, 0, 0.0625, 0.9375, 1, 0.9375);
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
                .with(WATERLOGGED, ctx.getWorld().getFluidState(ctx.getBlockPos()).getFluid() == Fluids.WATER || ctx.getWorld().getFluidState(ctx.getBlockPos()).getFluid() == ModFluids.PRIMORDIAL_SOUP_STILL)
                .with(LOGGED_WATER, ctx.getWorld().getFluidState(ctx.getBlockPos()).getFluid() == Fluids.WATER ?
                        FluidTypes.WATER : (ctx.getWorld().getFluidState(ctx.getBlockPos()).getFluid() == ModFluids.PRIMORDIAL_SOUP_STILL ?
                        FluidTypes.PRIMORDIAL_SOUP : FluidTypes.DRY));
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? (state.get(LOGGED_WATER) == FluidTypes.PRIMORDIAL_SOUP ? ModFluids.PRIMORDIAL_SOUP_STILL.getStill(false) : (state.get(LOGGED_WATER) == FluidTypes.WATER ? Fluids.WATER.getStill(false) : super.getFluidState(state))) : super.getFluidState(state);
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (state.get(WATERLOGGED)) {
            if (state.get(LOGGED_WATER) == FluidTypes.PRIMORDIAL_SOUP){
                world.scheduleFluidTick(pos, ModFluids.PRIMORDIAL_SOUP_STILL, ModFluids.PRIMORDIAL_SOUP_STILL.getTickRate(world));
            }
            if (state.get(LOGGED_WATER) == FluidTypes.WATER){
                world.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
            }
        }
        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

}
