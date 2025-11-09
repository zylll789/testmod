package com.protons.testmod.block;

import com.mojang.serialization.MapCodec;
import com.protons.testmod.fluid.FluidTypes;
import com.protons.testmod.fluid.ModFluids;
import com.protons.testmod.item.ModItems;
import com.protons.testmod.registry.tag.ModItemTags;
import com.protons.testmod.state.property.ModProperties;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

import java.util.Collection;

public class ChemoautotrophMatBlock extends MultifaceGrowthBlock implements ModWaterLoggable {

    public static final MapCodec<ChemoautotrophMatBlock> CODEC = createCodec(ChemoautotrophMatBlock::new);
    private static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    public static final EnumProperty LOGGED_WATER = ModProperties.LOGGED_WATER;
    public static final IntProperty LIGHT = ModProperties.LIGHT;

    private final LichenGrower allGrowTypeGrower = new LichenGrower(new ChemoautotrophMatBlock.ChemoautotrophMatGrowChecker(LichenGrower.GROW_TYPES));
    private final LichenGrower samePositionOnlyGrower = new LichenGrower(new ChemoautotrophMatBlock.ChemoautotrophMatGrowChecker(LichenGrower.GrowType.SAME_POSITION));

    public ChemoautotrophMatBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getDefaultState()
                .with(WATERLOGGED, Boolean.valueOf(false))
                .with(LOGGED_WATER, FluidTypes.DRY)
                .with(LIGHT, 0)
        );
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockState state = super.getPlacementState(ctx);
        if (state == null) return null;
        return state
                .with(LIGHT, 0)
                .with(WATERLOGGED, ctx.getWorld().getFluidState(ctx.getBlockPos()).getFluid() == Fluids.WATER || ctx.getWorld().getFluidState(ctx.getBlockPos()).getFluid() == ModFluids.PRIMORDIAL_SOUP_STILL)
                .with(LOGGED_WATER, ctx.getWorld().getFluidState(ctx.getBlockPos()).getFluid() == Fluids.WATER ?
                        FluidTypes.WATER : (ctx.getWorld().getFluidState(ctx.getBlockPos()).getFluid() == ModFluids.PRIMORDIAL_SOUP_STILL ?
                        FluidTypes.PRIMORDIAL_SOUP : FluidTypes.DRY));
    }


    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (!world.isClient) return;
        if (state.get(ModProperties.LOGGED_WATER) != FluidTypes.PRIMORDIAL_SOUP){
            world.setBlockState(pos, state.with(LIGHT, 0), Block.NOTIFY_ALL);
            return;
        }
        for (BlockPos near : BlockPos.iterate(pos.add(-2,-2,-2), pos.add(2,2,2))){
            if (world.getBlockState(near).isOf(ModBlocks.PRIMORDIAL_PETRI_DISH)){
                if (world.getBlockState(near).get(ModProperties.IS_CRAFTING)){
                    world.setBlockState(pos, state.with(LIGHT, 15), Block.NOTIFY_ALL);
                    return ;
                }
            }
        }
        for (PlayerEntity player : world.getPlayers()){
            if (player.getMainHandStack().isIn(ModItemTags.CHEMOAUTOTROPH_MAT_LIT)){
                BlockPos center = player.getBlockPos();
                int radius = 5;
                if (center.getManhattanDistance(pos) <= radius){
                    world.setBlockState(pos, state.with(LIGHT, 7), Block.NOTIFY_ALL);
                    return ;
                }
            }
        }
        world.setBlockState(pos, state.with(LIGHT, 0), Block.NOTIFY_ALL);
        super.randomDisplayTick(state, world, pos, random);
    }

    @Override
    public MapCodec<ChemoautotrophMatBlock> getCodec() {
        return CODEC;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(WATERLOGGED, LOGGED_WATER, LIGHT);
    }

    @Override
    protected BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public LichenGrower getGrower() {
        return this.allGrowTypeGrower;
    }

    public LichenGrower getSamePositionOnlyGrower() {
        return this.samePositionOnlyGrower;
    }

    public static boolean place(WorldAccess world, BlockPos pos, BlockState state, Collection<Direction> directions) {
        boolean bl = false;
        BlockState blockState = ModBlocks.CHEMOAUTOTROPH_MAT.getDefaultState();

        for (Direction direction : directions) {
            BlockPos blockPos = pos.offset(direction);
            if (canGrowOn(world, direction, blockPos, world.getBlockState(blockPos))) {
                blockState = blockState.with(getProperty(direction), Boolean.valueOf(true));
                bl = true;
            }
        }

        if (!bl) {
            return false;
        } else {
            if (!state.getFluidState().isEmpty()) {
                blockState = blockState.with(WATERLOGGED, Boolean.valueOf(true)).with(LIGHT, 0)
                        .with(LOGGED_WATER, world.getFluidState(pos).getFluid() == Fluids.WATER ?
                        FluidTypes.WATER : world.getFluidState(pos).getFluid()== ModFluids.PRIMORDIAL_SOUP_STILL ?
                                FluidTypes.PRIMORDIAL_SOUP : FluidTypes.DRY);
            }

            world.setBlockState(pos, blockState, Block.NOTIFY_ALL);
            return true;
        }
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
    public FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? (state.get(LOGGED_WATER) == FluidTypes.PRIMORDIAL_SOUP ? ModFluids.PRIMORDIAL_SOUP_STILL.getStill(false) : (state.get(LOGGED_WATER) == FluidTypes.WATER ? Fluids.WATER.getStill(false) : super.getFluidState(state))) : super.getFluidState(state);
    }

    @Override
    protected boolean isTransparent(BlockState state, BlockView world, BlockPos pos) {
        return true;
    }



    class ChemoautotrophMatGrowChecker extends LichenGrower.LichenGrowChecker {
        private final LichenGrower.GrowType[] growTypes;

        public ChemoautotrophMatGrowChecker(final LichenGrower.GrowType... growTypes) {
            super(ChemoautotrophMatBlock.this);
            this.growTypes = growTypes;
        }

        @Override
        public boolean canGrow(BlockView world, BlockPos pos, BlockPos growPos, Direction direction, BlockState state) {
            /*BlockState blockState = world.getBlockState(growPos.offset(direction));
            if (!blockState.isOf(Blocks.SCULK) && !blockState.isOf(Blocks.SCULK_CATALYST) && !blockState.isOf(Blocks.MOVING_PISTON)) {
                if (pos.getManhattanDistance(growPos) == 2) {
                    BlockPos blockPos = pos.offset(direction.getOpposite());
                    if (world.getBlockState(blockPos).isSideSolidFullSquare(world, blockPos, direction)) {
                        return false;
                    }
                }

                FluidState fluidState = state.getFluidState();
                if (!fluidState.isEmpty() && !fluidState.isOf(Fluids.WATER)) {
                    return false;
                } else {
                    return state.isIn(BlockTags.FIRE) ? false : state.isReplaceable() || super.canGrow(world, pos, growPos, direction, state);
                }
            } else {
                return false;
            }*/
            return false;
        }

        @Override
        public LichenGrower.GrowType[] getGrowTypes() {
            return this.growTypes;
        }

        @Override
        public boolean canGrow(BlockState state) {
            return false;//!state.isOf(Blocks.SCULK_VEIN);
        }
    }

}