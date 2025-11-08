package com.protons.testmod.block;

import com.mojang.serialization.MapCodec;
import com.protons.testmod.fluid.ModFluid;
import com.protons.testmod.fluid.ModFluids;
import net.minecraft.block.*;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;

public class StromatoliteBlock extends HorizontalFacingBlock implements ModWaterLoggable {
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    private FluidState fluidState;
    private Fluid fluidType = Fluids.EMPTY;

    public static final MapCodec<StromatoliteBlock> CODEC = Block.createCodec(StromatoliteBlock::new);

    @Override
    protected MapCodec<? extends HorizontalFacingBlock> getCodec() {
        return CODEC;
    }

    public StromatoliteBlock(Settings settings) {
        super(settings);
        this.fluidState = Fluids.EMPTY.getDefaultState();
        this.fluidType = Fluids.EMPTY;
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
        this.setFluidState(ctx.getWorld().getFluidState(ctx.getBlockPos()));
        return this.getDefaultState()
                .with(Properties.HORIZONTAL_FACING, ctx.getHorizontalPlayerFacing().getOpposite())
                .with(WATERLOGGED, ctx.getWorld().getFluidState(ctx.getBlockPos()).isIn(FluidTags.WATER))
                ;
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        if (this.fluidType==Fluids.EMPTY){
            System.out.println("111");
        } else if(this.fluidType== Fluids.WATER){
            System.out.println("222");
        } else {
            System.out.println("333");
        }
        return state.get(WATERLOGGED) ? (this.fluidType==Fluids.EMPTY) ? Fluids.EMPTY.getDefaultState() : (this.fluidType== Fluids.WATER ? Fluids.WATER.getStill(false) : ((ModFluid)this.fluidType).getSerFluid().getStill(false)) : super.getFluidState(state);
    }

    @Override
    public void setFluidState(FluidState fluidState) {
        this.fluidType = fluidState.getFluid(); // 只保存类型
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (state.get(WATERLOGGED)) {
            world.scheduleFluidTick(pos, this.fluidType, this.fluidType.getTickRate(world));
        }
        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

}
