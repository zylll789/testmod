package com.protons.testmod.entity.client;

import com.protons.testmod.entity.animation.CharniaAnimation;
import com.protons.testmod.entity.animation.RangeaAnimation;
import com.protons.testmod.entity.custom.RangeaEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;

public class RangeaModel <T extends RangeaEntity> extends SinglePartEntityModel<T> {
    private final ModelPart root;
    private final ModelPart rangea;
    private final ModelPart leaf1;
    private final ModelPart leaf111;
    private final ModelPart leaf121;
    private final ModelPart leaf131;
    private final ModelPart leaf141;
    private final ModelPart leaf151;
    private final ModelPart leaf161;
    private final ModelPart leaf171;
    private final ModelPart leaf181;
    private final ModelPart leaf112;
    private final ModelPart leaf122;
    private final ModelPart leaf132;
    private final ModelPart leaf142;
    private final ModelPart leaf152;
    private final ModelPart leaf162;
    private final ModelPart leaf172;
    private final ModelPart leaf182;
    private final ModelPart leaf2;
    private final ModelPart leaf3;
    private final ModelPart leaf4;
    private final ModelPart leaf5;
    private final ModelPart leaf6;
    private final ModelPart leaf7;
    private final ModelPart leaf8;
    private final ModelPart leaf9;
    private final ModelPart leaf10;
    private final ModelPart leaf11;
    private final ModelPart leaf12;
    private final ModelPart leaf13;
    private final ModelPart leaf14;
    private final ModelPart leaf15;
    private final ModelPart leaf16;
    private final ModelPart leaf17;
    private final ModelPart leaf18;
    private final ModelPart leaf19;
    private final ModelPart leaf20;
    private final ModelPart leaf21;
    private final ModelPart leaf22;
    private final ModelPart leaf23;
    private final ModelPart leaf24;
    private final ModelPart leaf25;
    private final ModelPart leaf26;
    private final ModelPart leaf27;
    private final ModelPart leaf28;
    private final ModelPart leaf29;
    private final ModelPart leaf30;
    private final ModelPart leaf31;
    private final ModelPart leaf32;
    private final ModelPart leaf33;
    private final ModelPart leaf34;
    private final ModelPart leaf35;
    private final ModelPart base;
    public RangeaModel(ModelPart root) {
        this.root = root.getChild("root");
        this.rangea = this.root.getChild("rangea");
        this.leaf1 = this.rangea.getChild("leaf1");
        this.leaf111 = this.leaf1.getChild("leaf111");
        this.leaf121 = this.leaf111.getChild("leaf121");
        this.leaf131 = this.leaf121.getChild("leaf131");
        this.leaf141 = this.leaf131.getChild("leaf141");
        this.leaf151 = this.leaf141.getChild("leaf151");
        this.leaf161 = this.leaf151.getChild("leaf161");
        this.leaf171 = this.leaf161.getChild("leaf171");
        this.leaf181 = this.leaf171.getChild("leaf181");
        this.leaf112 = this.leaf1.getChild("leaf112");
        this.leaf122 = this.leaf112.getChild("leaf122");
        this.leaf132 = this.leaf122.getChild("leaf132");
        this.leaf142 = this.leaf132.getChild("leaf142");
        this.leaf152 = this.leaf142.getChild("leaf152");
        this.leaf162 = this.leaf152.getChild("leaf162");
        this.leaf172 = this.leaf162.getChild("leaf172");
        this.leaf182 = this.leaf172.getChild("leaf182");
        this.leaf2 = this.rangea.getChild("leaf2");
        this.leaf3 = this.leaf2.getChild("leaf3");
        this.leaf4 = this.leaf3.getChild("leaf4");
        this.leaf5 = this.leaf4.getChild("leaf5");
        this.leaf6 = this.leaf5.getChild("leaf6");
        this.leaf7 = this.leaf6.getChild("leaf7");
        this.leaf8 = this.leaf7.getChild("leaf8");
        this.leaf9 = this.leaf8.getChild("leaf9");
        this.leaf10 = this.leaf9.getChild("leaf10");
        this.leaf11 = this.leaf2.getChild("leaf11");
        this.leaf12 = this.leaf11.getChild("leaf12");
        this.leaf13 = this.leaf12.getChild("leaf13");
        this.leaf14 = this.leaf13.getChild("leaf14");
        this.leaf15 = this.leaf14.getChild("leaf15");
        this.leaf16 = this.leaf15.getChild("leaf16");
        this.leaf17 = this.leaf16.getChild("leaf17");
        this.leaf18 = this.leaf17.getChild("leaf18");
        this.leaf19 = this.rangea.getChild("leaf19");
        this.leaf20 = this.leaf19.getChild("leaf20");
        this.leaf21 = this.leaf20.getChild("leaf21");
        this.leaf22 = this.leaf21.getChild("leaf22");
        this.leaf23 = this.leaf22.getChild("leaf23");
        this.leaf24 = this.leaf23.getChild("leaf24");
        this.leaf25 = this.leaf24.getChild("leaf25");
        this.leaf26 = this.leaf25.getChild("leaf26");
        this.leaf27 = this.leaf26.getChild("leaf27");
        this.leaf28 = this.leaf19.getChild("leaf28");
        this.leaf29 = this.leaf28.getChild("leaf29");
        this.leaf30 = this.leaf29.getChild("leaf30");
        this.leaf31 = this.leaf30.getChild("leaf31");
        this.leaf32 = this.leaf31.getChild("leaf32");
        this.leaf33 = this.leaf32.getChild("leaf33");
        this.leaf34 = this.leaf33.getChild("leaf34");
        this.leaf35 = this.leaf34.getChild("leaf35");
        this.base = this.rangea.getChild("base");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData root = modelPartData.addChild("root", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData rangea = root.addChild("rangea", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData leaf1 = rangea.addChild("leaf1", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData leaf111 = leaf1.addChild("leaf111", ModelPartBuilder.create().uv(46, 48).cuboid(-6.0F, -2.0F, -1.0F, 6.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -7.0F, 0.0F));

        ModelPartData leaf121 = leaf111.addChild("leaf121", ModelPartBuilder.create().uv(0, 39).cuboid(-9.0F, -12.0F, -1.0F, 9.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 7.0F, 0.0F));

        ModelPartData leaf131 = leaf121.addChild("leaf131", ModelPartBuilder.create().uv(27, 31).cuboid(-11.0F, -15.0F, -1.0F, 11.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData leaf141 = leaf131.addChild("leaf141", ModelPartBuilder.create().uv(0, 11).cuboid(-12.0F, -8.0F, -1.0F, 12.0F, 7.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -14.0F, 0.0F));

        ModelPartData leaf151 = leaf141.addChild("leaf151", ModelPartBuilder.create().uv(0, 31).cuboid(-11.0F, -13.0F, -1.0F, 11.0F, 5.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData leaf161 = leaf151.addChild("leaf161", ModelPartBuilder.create().uv(23, 43).cuboid(-4.0F, -3.0F, -1.0F, 9.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-5.0F, -13.0F, 0.0F));

        ModelPartData leaf171 = leaf161.addChild("leaf171", ModelPartBuilder.create().uv(33, 6).cuboid(-2.0F, -2.0F, -1.0F, 7.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -3.0F, 0.0F));

        ModelPartData leaf181 = leaf171.addChild("leaf181", ModelPartBuilder.create().uv(50, 37).cuboid(-4.0F, -2.0F, -1.0F, 4.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(5.0F, -2.0F, 0.0F));

        ModelPartData leaf112 = leaf1.addChild("leaf112", ModelPartBuilder.create().uv(23, 49).cuboid(0.0F, -2.0F, -1.0F, 6.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -7.0F, 0.0F));

        ModelPartData leaf122 = leaf112.addChild("leaf122", ModelPartBuilder.create().uv(27, 37).cuboid(0.0F, -12.0F, -1.0F, 9.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 7.0F, 0.0F));

        ModelPartData leaf132 = leaf122.addChild("leaf132", ModelPartBuilder.create().uv(33, 0).cuboid(0.0F, -8.0F, -1.0F, 11.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -7.0F, 0.0F));

        ModelPartData leaf142 = leaf132.addChild("leaf142", ModelPartBuilder.create().uv(0, 21).cuboid(0.0F, -8.0F, -1.0F, 12.0F, 7.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -7.0F, 0.0F));

        ModelPartData leaf152 = leaf142.addChild("leaf152", ModelPartBuilder.create().uv(29, 23).cuboid(0.0F, -8.0F, -1.0F, 11.0F, 5.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -5.0F, 0.0F));

        ModelPartData leaf162 = leaf152.addChild("leaf162", ModelPartBuilder.create().uv(0, 45).cuboid(-5.0F, -3.0F, -1.0F, 9.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(5.0F, -8.0F, 0.0F));

        ModelPartData leaf172 = leaf162.addChild("leaf172", ModelPartBuilder.create().uv(46, 43).cuboid(-5.0F, -2.0F, -1.0F, 7.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -3.0F, 0.0F));

        ModelPartData leaf182 = leaf172.addChild("leaf182", ModelPartBuilder.create().uv(52, 6).cuboid(0.0F, -2.0F, -1.0F, 4.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-5.0F, -2.0F, 0.0F));

        ModelPartData leaf2 = rangea.addChild("leaf2", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 1.0472F, 0.0F));

        ModelPartData leaf3 = leaf2.addChild("leaf3", ModelPartBuilder.create().uv(46, 48).cuboid(-6.0F, -2.0F, -1.0F, 6.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -7.0F, 0.0F));

        ModelPartData leaf4 = leaf3.addChild("leaf4", ModelPartBuilder.create().uv(0, 39).cuboid(-9.0F, -12.0F, -1.0F, 9.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 7.0F, 0.0F));

        ModelPartData leaf5 = leaf4.addChild("leaf5", ModelPartBuilder.create().uv(27, 31).cuboid(-11.0F, -15.0F, -1.0F, 11.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData leaf6 = leaf5.addChild("leaf6", ModelPartBuilder.create().uv(0, 11).cuboid(-12.0F, -8.0F, -1.0F, 12.0F, 7.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -14.0F, 0.0F));

        ModelPartData leaf7 = leaf6.addChild("leaf7", ModelPartBuilder.create().uv(0, 31).cuboid(-11.0F, -13.0F, -1.0F, 11.0F, 5.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData leaf8 = leaf7.addChild("leaf8", ModelPartBuilder.create().uv(23, 43).cuboid(-4.0F, -3.0F, -1.0F, 9.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-5.0F, -13.0F, 0.0F));

        ModelPartData leaf9 = leaf8.addChild("leaf9", ModelPartBuilder.create().uv(33, 6).cuboid(-2.0F, -2.0F, -1.0F, 7.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -3.0F, 0.0F));

        ModelPartData leaf10 = leaf9.addChild("leaf10", ModelPartBuilder.create().uv(50, 37).cuboid(-4.0F, -2.0F, -1.0F, 4.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(5.0F, -2.0F, 0.0F));

        ModelPartData leaf11 = leaf2.addChild("leaf11", ModelPartBuilder.create().uv(23, 49).cuboid(0.0F, -2.0F, -1.0F, 6.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -7.0F, 0.0F));

        ModelPartData leaf12 = leaf11.addChild("leaf12", ModelPartBuilder.create().uv(27, 37).cuboid(0.0F, -12.0F, -1.0F, 9.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 7.0F, 0.0F));

        ModelPartData leaf13 = leaf12.addChild("leaf13", ModelPartBuilder.create().uv(33, 0).cuboid(0.0F, -8.0F, -1.0F, 11.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -7.0F, 0.0F));

        ModelPartData leaf14 = leaf13.addChild("leaf14", ModelPartBuilder.create().uv(0, 21).cuboid(0.0F, -8.0F, -1.0F, 12.0F, 7.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -7.0F, 0.0F));

        ModelPartData leaf15 = leaf14.addChild("leaf15", ModelPartBuilder.create().uv(29, 23).cuboid(0.0F, -8.0F, -1.0F, 11.0F, 5.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -5.0F, 0.0F));

        ModelPartData leaf16 = leaf15.addChild("leaf16", ModelPartBuilder.create().uv(0, 45).cuboid(-5.0F, -3.0F, -1.0F, 9.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(5.0F, -8.0F, 0.0F));

        ModelPartData leaf17 = leaf16.addChild("leaf17", ModelPartBuilder.create().uv(46, 43).cuboid(-5.0F, -2.0F, -1.0F, 7.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -3.0F, 0.0F));

        ModelPartData leaf18 = leaf17.addChild("leaf18", ModelPartBuilder.create().uv(52, 6).cuboid(0.0F, -2.0F, -1.0F, 4.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-5.0F, -2.0F, 0.0F));

        ModelPartData leaf19 = rangea.addChild("leaf19", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 2.0944F, 0.0F));

        ModelPartData leaf20 = leaf19.addChild("leaf20", ModelPartBuilder.create().uv(46, 48).cuboid(-6.0F, -2.0F, -1.0F, 6.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -7.0F, 0.0F));

        ModelPartData leaf21 = leaf20.addChild("leaf21", ModelPartBuilder.create().uv(0, 39).cuboid(-9.0F, -12.0F, -1.0F, 9.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 7.0F, 0.0F));

        ModelPartData leaf22 = leaf21.addChild("leaf22", ModelPartBuilder.create().uv(27, 31).cuboid(-11.0F, -15.0F, -1.0F, 11.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData leaf23 = leaf22.addChild("leaf23", ModelPartBuilder.create().uv(0, 11).cuboid(-12.0F, -8.0F, -1.0F, 12.0F, 7.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -14.0F, 0.0F));

        ModelPartData leaf24 = leaf23.addChild("leaf24", ModelPartBuilder.create().uv(0, 31).cuboid(-11.0F, -13.0F, -1.0F, 11.0F, 5.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData leaf25 = leaf24.addChild("leaf25", ModelPartBuilder.create().uv(23, 43).cuboid(-4.0F, -3.0F, -1.0F, 9.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-5.0F, -13.0F, 0.0F));

        ModelPartData leaf26 = leaf25.addChild("leaf26", ModelPartBuilder.create().uv(33, 6).cuboid(-2.0F, -2.0F, -1.0F, 7.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -3.0F, 0.0F));

        ModelPartData leaf27 = leaf26.addChild("leaf27", ModelPartBuilder.create().uv(50, 37).cuboid(-4.0F, -2.0F, -1.0F, 4.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(5.0F, -2.0F, 0.0F));

        ModelPartData leaf28 = leaf19.addChild("leaf28", ModelPartBuilder.create().uv(23, 49).cuboid(0.0F, -2.0F, -1.0F, 6.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -7.0F, 0.0F));

        ModelPartData leaf29 = leaf28.addChild("leaf29", ModelPartBuilder.create().uv(27, 37).cuboid(0.0F, -12.0F, -1.0F, 9.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 7.0F, 0.0F));

        ModelPartData leaf30 = leaf29.addChild("leaf30", ModelPartBuilder.create().uv(33, 0).cuboid(0.0F, -8.0F, -1.0F, 11.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -7.0F, 0.0F));

        ModelPartData leaf31 = leaf30.addChild("leaf31", ModelPartBuilder.create().uv(0, 21).cuboid(0.0F, -8.0F, -1.0F, 12.0F, 7.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -7.0F, 0.0F));

        ModelPartData leaf32 = leaf31.addChild("leaf32", ModelPartBuilder.create().uv(29, 23).cuboid(0.0F, -8.0F, -1.0F, 11.0F, 5.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -5.0F, 0.0F));

        ModelPartData leaf33 = leaf32.addChild("leaf33", ModelPartBuilder.create().uv(0, 45).cuboid(-5.0F, -3.0F, -1.0F, 9.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(5.0F, -8.0F, 0.0F));

        ModelPartData leaf34 = leaf33.addChild("leaf34", ModelPartBuilder.create().uv(46, 43).cuboid(-5.0F, -2.0F, -1.0F, 7.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -3.0F, 0.0F));

        ModelPartData leaf35 = leaf34.addChild("leaf35", ModelPartBuilder.create().uv(52, 6).cuboid(0.0F, -2.0F, -1.0F, 4.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-5.0F, -2.0F, 0.0F));

        ModelPartData base = rangea.addChild("base", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -2.0F, -4.0F, 8.0F, 2.0F, 8.0F, new Dilation(0.0F))
                .uv(22, 54).cuboid(-2.0F, -2.0F, -5.0F, 4.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(54, 31).cuboid(-2.0F, -2.0F, 4.0F, 4.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(40, 53).cuboid(4.0F, -2.0F, -2.0F, 1.0F, 2.0F, 4.0F, new Dilation(0.0F))
                .uv(51, 53).cuboid(-5.0F, -2.0F, -2.0F, 1.0F, 2.0F, 4.0F, new Dilation(0.0F))
                .uv(29, 11).cuboid(-3.0F, -7.0F, -3.0F, 6.0F, 5.0F, 6.0F, new Dilation(0.0F))
                .uv(54, 11).cuboid(-2.0F, -6.0F, 3.0F, 4.0F, 4.0F, 1.0F, new Dilation(0.0F))
                .uv(0, 51).cuboid(-4.0F, -6.0F, -2.0F, 1.0F, 4.0F, 4.0F, new Dilation(0.0F))
                .uv(11, 51).cuboid(3.0F, -6.0F, -2.0F, 1.0F, 4.0F, 4.0F, new Dilation(0.0F))
                .uv(54, 17).cuboid(-2.0F, -6.0F, -4.0F, 4.0F, 4.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
        return TexturedModelData.of(modelData, 64, 64);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        root.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }
    @Override
    public ModelPart getPart() {
        return this.root;
    }

    @Override
    public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);

        if(entity.getRecentDamageSource() != null && entity.isSubmergedInWater()){
            if ((entity.getLastAttackedTime() - entity.hurtTime < 0) && entity.getRecentDamageSource().getAttacker() instanceof PlayerEntity) {
                entity.setAnimationState(entity.hurtAnimationState);
                this.updateAnimation(entity.hurtAnimationState, RangeaAnimation.HURT, entity.age, 1f);
                return;
            }
        }
        if (entity.isSubmergedInWater()) {
            entity.setAnimationState(entity.idleAnimationState);
            this.updateAnimation(entity.idleAnimationState, RangeaAnimation.IDLE, entity.age, 1f);
        } else {
            entity.setAnimationState(entity.defaultAnimationState);
        }
    }
}
