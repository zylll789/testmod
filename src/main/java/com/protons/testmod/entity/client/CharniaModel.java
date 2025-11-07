package com.protons.testmod.entity.client;

import com.protons.testmod.entity.animation.CharniaAnimation;
import com.protons.testmod.entity.custom.CharniaEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;

public class CharniaModel<T extends CharniaEntity> extends SinglePartEntityModel<T> {
    private final ModelPart root;
    private final ModelPart charnia;
    private final ModelPart base;
    private final ModelPart stem;
    private final ModelPart leaf;
    private final ModelPart leaf1;
    private final ModelPart leaf2;
    private final ModelPart leaf3;
    private final ModelPart leaf4;
    private final ModelPart leaf5;
    private final ModelPart leaf6;
    private final ModelPart leaf7;
    private final ModelPart leaf8;
    public CharniaModel(ModelPart root) {
        this.root = root.getChild("root");
        this.charnia = this.root.getChild("charnia");
        this.base = this.charnia.getChild("base");
        this.stem = this.charnia.getChild("stem");
        this.leaf = this.stem.getChild("leaf");
        this.leaf1 = this.leaf.getChild("leaf1");
        this.leaf2 = this.leaf1.getChild("leaf2");
        this.leaf3 = this.leaf2.getChild("leaf3");
        this.leaf4 = this.leaf3.getChild("leaf4");
        this.leaf5 = this.leaf4.getChild("leaf5");
        this.leaf6 = this.leaf5.getChild("leaf6");
        this.leaf7 = this.leaf6.getChild("leaf7");
        this.leaf8 = this.leaf7.getChild("leaf8");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData root = modelPartData.addChild("root", ModelPartBuilder.create(), ModelTransform.pivot(-4.0F, 24.0F, 2.0F));

        ModelPartData charnia = root.addChild("charnia", ModelPartBuilder.create(), ModelTransform.pivot(4.0F, -32.0F, -2.0F));

        ModelPartData base = charnia.addChild("base", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -2.0F, -6.0F, 8.0F, 2.0F, 8.0F, new Dilation(0.0F))
                .uv(17, 34).cuboid(8.0F, -2.0F, -4.0F, 1.0F, 2.0F, 4.0F, new Dilation(0.0F))
                .uv(29, 44).cuboid(2.0F, -2.0F, -7.0F, 4.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(40, 44).cuboid(2.0F, -2.0F, 2.0F, 4.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(0, 39).cuboid(-1.0F, -2.0F, -4.0F, 1.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-4.0F, 32.0F, 2.0F));

        ModelPartData stem = charnia.addChild("stem", ModelPartBuilder.create().uv(33, 13).cuboid(-3.0F, -3.0F, -3.0F, 6.0F, 2.0F, 6.0F, new Dilation(0.0F))
                .uv(33, 33).cuboid(-2.0F, -8.0F, -2.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.0F))
                .uv(11, 41).cuboid(-1.0F, -12.0F, -1.5F, 2.0F, 4.0F, 2.0F, new Dilation(0.0F))
                .uv(20, 41).cuboid(-1.0F, -12.0F, -0.5F, 2.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 32.0F, 0.0F));

        ModelPartData leaf = stem.addChild("leaf", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData leaf1 = leaf.addChild("leaf1", ModelPartBuilder.create().uv(33, 22).cuboid(-5.0F, -11.0F, -1.0F, 10.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData leaf2 = leaf1.addChild("leaf2", ModelPartBuilder.create().uv(33, 0).cuboid(-6.0F, -15.0F, -1.0F, 12.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData leaf3 = leaf2.addChild("leaf3", ModelPartBuilder.create().uv(0, 27).cuboid(-7.0F, -19.0F, -1.0F, 14.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData leaf4 = leaf3.addChild("leaf4", ModelPartBuilder.create().uv(0, 11).cuboid(-7.0F, -25.0F, -1.0F, 14.0F, 6.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData leaf5 = leaf4.addChild("leaf5", ModelPartBuilder.create().uv(0, 20).cuboid(-7.0F, -29.0F, -1.0F, 14.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData leaf6 = leaf5.addChild("leaf6", ModelPartBuilder.create().uv(33, 7).cuboid(-6.0F, -32.0F, -1.0F, 12.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData leaf7 = leaf6.addChild("leaf7", ModelPartBuilder.create().uv(33, 28).cuboid(-5.0F, -34.0F, -1.0F, 10.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData leaf8 = leaf7.addChild("leaf8", ModelPartBuilder.create().uv(0, 34).cuboid(-3.0F, -36.0F, -1.0F, 6.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
        return TexturedModelData.of(modelData, 64, 64);
    }
    @Override
    public ModelPart getPart() {
        return this.root;
    }
    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        root.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }
    @Override
    public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        if(entity.getRecentDamageSource() != null && entity.isSubmergedInWater()){
            if ((entity.getLastAttackedTime() - entity.hurtTime < 0) && entity.getRecentDamageSource().getAttacker() instanceof PlayerEntity) {
                entity.setAnimationState(entity.hurtAnimationState);
                this.updateAnimation(entity.hurtAnimationState, CharniaAnimation.HURT, entity.age, 1f);
                return;
            }
        }
        if (!entity.isSubmergedInWater()) {
            entity.setAnimationState(entity.onlandAnimationState);
            this.updateAnimation(entity.onlandAnimationState, CharniaAnimation.ONLAND, entity.age, 1f);
        } else {
            entity.setAnimationState(entity.idleAnimationState);
            this.updateAnimation(entity.idleAnimationState, CharniaAnimation.IDLE, entity.age, 1f);
        }
    }
}
