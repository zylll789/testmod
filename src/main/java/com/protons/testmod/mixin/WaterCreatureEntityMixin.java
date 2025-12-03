package com.protons.testmod.mixin;


import com.protons.testmod.block.ModBlocks;
import com.protons.testmod.entity.OxygenDeficient;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.mob.WaterCreatureEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WaterCreatureEntity.class)
public class WaterCreatureEntityMixin extends PathAwareEntity {

    public WaterCreatureEntityMixin(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(at = @At("TAIL"), method = "tickWaterBreathingAir(I)V")
    private void tickWaterBreathingAir(int air, CallbackInfo info) {
        WaterCreatureEntity entity = (WaterCreatureEntity)(Object) this;
        BlockState blockState = entity.getBlockStateAtPos();
        if (blockState.isOf(ModBlocks.PRIMORDIAL_SOUP) && !(entity instanceof OxygenDeficient)) {
            this.setAir(air - 1);
            if (this.getAir() == -20) {
                this.setAir(0);
                this.damage(this.getDamageSources().dryOut(), 2.0F);
            }
        }
    }
}
