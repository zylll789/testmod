package com.protons.testmod.block;

import com.mojang.serialization.MapCodec;
import com.protons.testmod.fluid.ModFluids;
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
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;

public class HydrothermalVentBlockMiddle extends HorizontalFacingBlock implements ModWaterLoggable {
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    private FluidState fluidState = Fluids.EMPTY.getDefaultState();

    public static final MapCodec<StromatoliteBlock> CODEC = Block.createCodec(StromatoliteBlock::new);

    @Override
    protected MapCodec<? extends HorizontalFacingBlock> getCodec() {
        return CODEC;
    }

    public HydrothermalVentBlockMiddle(Settings settings) {
        super(settings);
        setDefaultState(getDefaultState()
                .with(Properties.HORIZONTAL_FACING, Direction.NORTH)
                .with(WATERLOGGED, false));
    }

    // 让方块认识这个属性，否则设置该属性将会抛出异常。
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(Properties.HORIZONTAL_FACING, WATERLOGGED);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext ctx) {
        Direction dir = state.get(FACING);
        return switch (dir) {
            case NORTH -> VoxelShapes.cuboid(0.125, 0, 0.125, 0.875, 1, 0.875);
            case SOUTH -> VoxelShapes.cuboid(0.125, 0, 0.125, 0.875, 1, 0.875);
            case EAST -> VoxelShapes.cuboid(0.125, 0, 0.125, 0.875, 1, 0.875);
            case WEST -> VoxelShapes.cuboid(0.125, 0, 0.125, 0.875, 1, 0.875);
            default -> VoxelShapes.fullCube();
        };
    }

    @Override
    protected boolean canPathfindThrough(BlockState state, NavigationType type) {
        return false;
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        this.setFluidState(ctx.getWorld().getFluidState(ctx.getBlockPos()));
        return this.getDefaultState()
                .with(Properties.HORIZONTAL_FACING, ctx.getHorizontalPlayerFacing().getOpposite())
                .with(WATERLOGGED, ctx.getWorld().getFluidState(ctx.getBlockPos()).getFluid() == Fluids.WATER || ctx.getWorld().getFluidState(ctx.getBlockPos()).getFluid() == ModFluids.OXYGEN_DEFICIENT_WATER_STILL)
                ;
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? fluidState : super.getFluidState(state);
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (state.get(WATERLOGGED)) {
            world.scheduleFluidTick(pos, world.getFluidState(pos).getFluid(), world.getFluidState(pos).getFluid().getTickRate(world));
        }
        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    @Override
    public void setFluidState(FluidState fluidState){
        this.fluidState = fluidState;
    }
}
