package com.protons.testmod.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.fluid.Fluids;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;

public class SinterBariteDepositBlock extends BariteBlock {
	public static final MapCodec<SinterBariteDepositBlock> CODEC = createCodec(SinterBariteDepositBlock::new);
	public static final int GROW_CHANCE = 5;
	private static final Direction[] DIRECTIONS = Direction.values();

	@Override
	public MapCodec<SinterBariteDepositBlock> getCodec() {
		return CODEC;
	}

	public SinterBariteDepositBlock(Settings settings) {
		super(settings);
	}

	@Override
	protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
		if (random.nextInt(5) == 0) {
			Direction direction = DIRECTIONS[random.nextInt(DIRECTIONS.length)];
			BlockPos blockPos = pos.offset(direction);
			BlockState blockState = world.getBlockState(blockPos);
			Block block = null;
			if (canGrowIn(blockState)) {
				block = ModBlocks.SMALL_BARITE_BUD;
			} else if (blockState.isOf(ModBlocks.SMALL_BARITE_BUD) && blockState.get(BariteClusterBlock.FACING) == direction) {
				block = ModBlocks.MEDIUM_BARITE_BUD;
			} else if (blockState.isOf(ModBlocks.MEDIUM_BARITE_BUD) && blockState.get(BariteClusterBlock.FACING) == direction) {
				block = ModBlocks.LARGE_BARITE_BUD;
			} else if (blockState.isOf(ModBlocks.LARGE_BARITE_BUD) && blockState.get(BariteClusterBlock.FACING) == direction) {
				block = ModBlocks.BARITE_CLUSTER;
			}

			if (block != null) {
				BlockState blockState2 = block.getDefaultState()
					.with(BariteClusterBlock.FACING, direction)
					.with(BariteClusterBlock.WATERLOGGED, Boolean.valueOf(blockState.getFluidState().getFluid() == Fluids.WATER));
				world.setBlockState(blockPos, blockState2);
			}
		}
	}

	public static boolean canGrowIn(BlockState state) {
		return state.isAir() || state.isOf(Blocks.WATER) && state.getFluidState().getLevel() == 8;
	}
}
