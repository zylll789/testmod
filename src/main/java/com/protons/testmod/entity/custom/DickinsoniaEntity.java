package com.protons.testmod.entity.custom;

import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.WanderAroundGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.WaterCreatureEntity;
import net.minecraft.world.World;

import java.util.Objects;

public class DickinsoniaEntity extends WaterCreatureEntity {
    public final AnimationState moveAnimationState = new AnimationState();
    public final AnimationState fallAnimationState = new AnimationState();
    public final AnimationState hurtAnimationState = new AnimationState();
    public final AnimationState defaultAnimationState = new AnimationState();

    protected AnimationState currentState;

    public AnimationState getAnimationState(){
        return this.currentState;
    }

    public void setAnimationState(AnimationState state){
        this.currentState = state;
    }

    private int moveAnimationTimeOut = 0;
    private int fallAnimationTimeOut = 0;
    private int hurtAnimationTimeOut = 0;
    private void setUpAnimationState() {

        if (this.getAnimationState() == moveAnimationState){
            if (this.moveAnimationTimeOut <= 0) {
                this.moveAnimationTimeOut = 40;
                this.moveAnimationState.start(this.age);
            } else {
                --this.moveAnimationTimeOut;
            }
        } else {
            this.moveAnimationTimeOut = 0;
        }

        if (this.getAnimationState() == fallAnimationState){
            if (this.fallAnimationTimeOut <= 0) {
                this.fallAnimationTimeOut = 40;
                this.fallAnimationState.start(this.age);
            } else {
                --this.fallAnimationTimeOut;
            }
        } else {
            this.fallAnimationTimeOut = 0;
        }

        if (this.getAnimationState() == hurtAnimationState){
           if (this.hurtAnimationTimeOut <= 0) {
               this.hurtAnimationTimeOut = 40;
               this.hurtAnimationState.start(this.age);
           } else {
               --this.hurtAnimationTimeOut;
           }
        } else {
            this.hurtAnimationTimeOut = 0;
        }


    }
    public DickinsoniaEntity(EntityType<? extends WaterCreatureEntity> entityType, World world) {
        super(entityType, world);
        this.setAnimationState(defaultAnimationState);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new WanderAroundGoal(this, 0.2f));
        // this.goalSelector.add(1, new SwimAroundGoal(this, 0.3f, 1));
        this.goalSelector.add(2, new LookAroundGoal(this));
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

    public static DefaultAttributeContainer.Builder createDickinsoniaAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 10)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.2f)
                .add(EntityAttributes.GENERIC_ARMOR, 0)
                .add(EntityAttributes.GENERIC_GRAVITY, 0.6f)
                .add(EntityAttributes.GENERIC_SCALE, 0.5f);
                // .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 1.0f);
    }

}
