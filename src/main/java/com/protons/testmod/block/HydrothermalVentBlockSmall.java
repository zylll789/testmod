package com.protons.testmod.block;

import com.mojang.serialization.MapCodec;
import com.protons.testmod.fluid.FluidTypes;
import com.protons.testmod.fluid.ModFluids;
import com.protons.testmod.state.property.ModProperties;
import net.minecraft.block.*;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

import java.util.List;

public class HydrothermalVentBlockSmall extends HorizontalFacingBlock implements ModWaterLoggable, HydrothermalVentAble {
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;

    public static final EnumProperty<FluidTypes> LOGGED_WATER = ModProperties.LOGGED_WATER;

    public static final MapCodec<StromatoliteBlock> CODEC = Block.createCodec(StromatoliteBlock::new);

    @Override
    protected MapCodec<? extends HorizontalFacingBlock> getCodec() {
        return CODEC;
    }

    public HydrothermalVentBlockSmall(Settings settings) {
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
            case NORTH -> VoxelShapes.cuboid(0.1875, 0, 0.1875, 0.8125, 1, 0.8125);
            case SOUTH -> VoxelShapes.cuboid(0.1875, 0, 0.1875, 0.8125, 1, 0.8125);
            case EAST -> VoxelShapes.cuboid(0.1875, 0, 0.1875, 0.8125, 1, 0.8125);
            case WEST -> VoxelShapes.cuboid(0.1875, 0, 0.1875, 0.8125, 1, 0.8125);
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

    @Override
    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        if (!world.isClient) world.scheduleBlockTick(pos, this, 4);
    }

    @Override
    protected void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        Box box = Box.of(Vec3d.ofCenter(pos), 2.0, 3.0, 2.0);
        List<LivingEntity> entities = world.getEntitiesByClass(LivingEntity.class, box, entity -> true);
        if (!hasBlockAbove(world,pos)){
            if (random.nextInt(2) == 1) {
                world.spawnParticles(
                        ParticleTypes.CAMPFIRE_COSY_SMOKE,
                        (double)pos.getX() + 0.5,
                        (double)pos.getY() + 1,
                        (double)pos.getZ() + 0.5,
                        0,
                        0,0.05,0,
                        1
                );
            }
        }
        for (LivingEntity entity : entities) {
            this.hurtEntity(world, pos, state, entity);
        }
        world.scheduleBlockTick(pos, this, 4);
    }

}
