package com.protons.testmod.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.fluid.Fluids;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;

public class SinterSulfurDepositBlock extends SulfurBlock {
	public static final MapCodec<SinterSulfurDepositBlock> CODEC = createCodec(SinterSulfurDepositBlock::new);
	public static final int GROW_CHANCE = 5;
	private static final Direction[] DIRECTIONS = Direction.values();

	@Override
	public MapCodec<SinterSulfurDepositBlock> getCodec() {
		return CODEC;
	}

	public SinterSulfurDepositBlock(Settings settings) {
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
				block = ModBlocks.SMALL_SULFUR_BUD;
			} else if (blockState.isOf(ModBlocks.SMALL_SULFUR_BUD) && blockState.get(SulfurClusterBlock.FACING) == direction) {
				block = ModBlocks.MEDIUM_SULFUR_BUD;
			} else if (blockState.isOf(ModBlocks.MEDIUM_SULFUR_BUD) && blockState.get(SulfurClusterBlock.FACING) == direction) {
				block = ModBlocks.LARGE_SULFUR_BUD;
			} else if (blockState.isOf(ModBlocks.LARGE_SULFUR_BUD) && blockState.get(SulfurClusterBlock.FACING) == direction) {
				block = ModBlocks.SULFUR_CLUSTER;
			}

			if (block != null) {
				BlockState blockState2 = block.getDefaultState()
					.with(SulfurClusterBlock.FACING, direction)
					.with(SulfurClusterBlock.WATERLOGGED, Boolean.valueOf(blockState.getFluidState().getFluid() == Fluids.WATER));
				world.setBlockState(blockPos, blockState2);
			}
		}
	}

	public static boolean canGrowIn(BlockState state) {
		return state.isAir() || state.isOf(Blocks.WATER) && state.getFluidState().getLevel() == 8;
	}
}
