package com.protons.testmod.block;

import com.mojang.serialization.MapCodec;
import com.protons.testmod.block.entity.PrimordialPetriDishBlockEntity;
import com.protons.testmod.fluid.ModFluids;
import com.protons.testmod.item.ModItems;
import com.protons.testmod.state.property.ModProperties;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

public class PrimordialPetriDish extends BlockWithEntity implements ModWaterLoggable {
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    private FluidState fluidState = Fluids.EMPTY.getDefaultState();

    public static final MapCodec<PrimordialPetriDish> CODEC = Block.createCodec(PrimordialPetriDish::new);

    public static final BooleanProperty HAS_BASE = ModProperties.HAS_BASE;
    public static final BooleanProperty IS_CRAFTING = ModProperties.IS_CRAFTING;

    private PrimordialPetriDishBlockEntity blockEntity;


    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
    }

    public PrimordialPetriDish(Settings settings) {
        super(settings);
        setDefaultState(getDefaultState()
                .with(Properties.HORIZONTAL_FACING, Direction.NORTH)
                .with(WATERLOGGED, false)
                .with(HAS_BASE,false)
                .with(IS_CRAFTING, false)
        );
    }

    // 让方块认识这个属性，否则设置该属性将会抛出异常。
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(Properties.HORIZONTAL_FACING, WATERLOGGED, HAS_BASE, IS_CRAFTING);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext ctx) {
        Direction dir = state.get(Properties.HORIZONTAL_FACING);
        return switch (dir) {
            case NORTH -> VoxelShapes.cuboid(0.125, 0, 0.125, 0.875, 0.3125, 0.875);
            case SOUTH -> VoxelShapes.cuboid(0.125, 0, 0.125, 0.875, 0.3125, 0.875);
            case EAST -> VoxelShapes.cuboid(0.125, 0, 0.125, 0.875, 0.3125, 0.875);
            case WEST -> VoxelShapes.cuboid(0.125, 0, 0.125, 0.875, 0.3125, 0.875);
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
                .with(HAS_BASE,false)
                .with(IS_CRAFTING, false);
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
/*
    public boolean canStartWork(){
        return this.getDefaultState().get(LOGGED_WATER)==FluidTypes.OXYGEN_DEFICIENT_WATER;
    }*/

    @Override
    protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (world.isClient){
            return ItemActionResult.SUCCESS;
        }
        PrimordialPetriDishBlockEntity blockEntity =(PrimordialPetriDishBlockEntity) world.getBlockEntity(pos);
        DefaultedList<ItemStack> itemStacks = blockEntity.getHeldStacks();
        if (player.getMainHandStack().isEmpty()){
            ItemScatterer.spawn(world, pos, itemStacks);
            world.setBlockState(pos, state.with(HAS_BASE,false));
            return ItemActionResult.SUCCESS;
        }
        if (!state.get(HAS_BASE) && stack.getItem() == ModBlocks.BARITE_CLUSTER.asItem()){
            world.setBlockState(pos,state.with(HAS_BASE,true));
            //
            itemStacks.set(0,player.getMainHandStack().split(1));
            return ItemActionResult.CONSUME;
        }
        if (state.get(HAS_BASE)){
            if (stack.getItem() == ModItems.SULFUR && itemStacks.get(1).isEmpty()){
                itemStacks.set(1,player.getMainHandStack().split(1));
                return ItemActionResult.CONSUME;
            }
            if (stack.getItem() == Items.GOLD_NUGGET && itemStacks.get(2).isEmpty()){
                itemStacks.set(2,player.getMainHandStack().split(1));
                return ItemActionResult.CONSUME;
            }
            if (stack.getItem() == Items.IRON_NUGGET && itemStacks.get(3).isEmpty()){
                itemStacks.set(3,player.getMainHandStack().split(1));
                return ItemActionResult.CONSUME;
            }
        }
        return super.onUseWithItem(stack, state, world, pos, player, hand, hit);
    }

    @Override
    public void afterBreak(World world, PlayerEntity player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack tool) {
        DefaultedList<ItemStack> itemStacks = ((PrimordialPetriDishBlockEntity) blockEntity).getHeldStacks();
        if (!itemStacks.isEmpty()){
            ItemScatterer.spawn(world,pos,itemStacks);
        }
        super.afterBreak(world, player, pos, state, blockEntity, tool);
    }


    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        this.blockEntity = new PrimordialPetriDishBlockEntity(pos, state);
        return this.blockEntity;
    }

    public PrimordialPetriDishBlockEntity getEntity(){
        return this.blockEntity;
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return world.isClient ? null : (world1, pos, state1, blockEntity) -> {
            if (blockEntity instanceof PrimordialPetriDishBlockEntity) {
                ((PrimordialPetriDishBlockEntity) blockEntity).tick(world1, pos, state1);
            }
        };
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (state.get(IS_CRAFTING)){
                System.out.println("Crafting is true, adding particles");
                for (int i = 0; i < 5; i++) {
                    double x = pos.getX() + 0.5;
                    double y = pos.getY() + 0.5;
                    double z = pos.getZ() + 0.5;
                    world.addParticle(net.minecraft.particle.ParticleTypes.SMOKE, x, y, z, 0.0, 0.0, 0.0);
                }

        }
    }

    @Override
    public void setFluidState(FluidState fluidState){
        this.fluidState = fluidState;
    }
}

