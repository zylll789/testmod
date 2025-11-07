package com.protons.testmod.entity.custom;

import net.minecraft.entity.AnimationState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.WaterCreatureEntity;
import net.minecraft.world.World;

import java.util.Objects;

public class RangeaEntity extends WaterCreatureEntity {
    public final AnimationState idleAnimationState = new AnimationState();
    public final AnimationState hurtAnimationState = new AnimationState();
    public final AnimationState defaultAnimationState = new AnimationState();

    protected AnimationState currentState;

    public AnimationState getAnimationState(){
        return this.currentState;
    }

    public void setAnimationState(AnimationState state){
        this.currentState = state;
    }

    private int idleAnimationTimeOut = 0;
    private int hurtAnimationTimeOut = 0;
    private void setUpAnimationState() {

        if (this.getAnimationState() == idleAnimationState){
            if (this.idleAnimationTimeOut <= 0) {
                this.idleAnimationTimeOut = 160;
                this.idleAnimationState.start(this.age);
            } else {
                --this.idleAnimationTimeOut;
            }
        } else {
            this.idleAnimationTimeOut = 0;
        }

        if (this.getAnimationState() == hurtAnimationState){
            if (this.hurtAnimationTimeOut <= 0) {
                this.hurtAnimationTimeOut = 160;
                this.hurtAnimationState.start(this.age);
            } else {
                --this.hurtAnimationTimeOut;
            }
        } else {
            this.hurtAnimationTimeOut = 0;
        }


    }
    public RangeaEntity(EntityType<? extends WaterCreatureEntity> entityType, World world) {
        super(entityType, world);
        this.setAnimationState(defaultAnimationState);
    }

    @Override
    protected void initGoals() {

    }

    @Override
    public void tick() {
        super.tick();
        if (this.getWorld().isClient()) {
            setUpAnimationState();
        }
        if (this.touchingWater) {
            Objects.requireNonNull(this.getAttributeInstance(EntityAttributes.GENERIC_GRAVITY)).setBaseValue(0.1f);
        } else {
            Objects.requireNonNull(this.getAttributeInstance(EntityAttributes.GENERIC_GRAVITY)).setBaseValue(0.6f);
        }
    }

    public static DefaultAttributeContainer.Builder createRangeaAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 10)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0f)
                .add(EntityAttributes.GENERIC_ARMOR, 0)
                .add(EntityAttributes.GENERIC_GRAVITY, 0.6f)
                .add(EntityAttributes.GENERIC_SCALE, 0.5f)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 1.0f);
    }

    @Override
    public boolean isPushable() {
        return false;
    }

    protected void pushAway(Entity entity) {
    }
}
