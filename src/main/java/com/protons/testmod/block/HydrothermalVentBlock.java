package com.protons.testmod.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.entity.LivingEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

import java.util.List;

public class HydrothermalVentBlock extends Block implements HydrothermalVentAble {

    public static final MapCodec<StromatoliteBlock> CODEC = Block.createCodec(StromatoliteBlock::new);

    public HydrothermalVentBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends HorizontalFacingBlock> getCodec() {
        return CODEC;
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
