package com.protons.testmod.block;

import net.minecraft.block.AirBlock;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface HydrothermalVentAble {

    default void hurtEntity(World world, BlockPos pos, BlockState state, Entity entity){
        if (entity.collidesWithStateAtPos(pos.up(), state) && entity instanceof LivingEntity) {
            entity.damage(world.getDamageSources().hotFloor(), 1.0F);
        }
    }

    default boolean hasBlockAbove(World world, BlockPos pos){
        BlockState blockState = world.getBlockState(pos.up());
        return !(blockState.getBlock() instanceof AirBlock);
    }

}
