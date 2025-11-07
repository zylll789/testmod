// Made with Blockbench 4.11.2
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports

package com.protons.testmod.entity.client;

import com.protons.testmod.entity.animation.DickinsoniaAnimation;
import com.protons.testmod.entity.custom.DickinsoniaEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class DickinsoniaModel<T extends DickinsoniaEntity> extends SinglePartEntityModel<T> {
	private final ModelPart root;
	private final ModelPart Dickinsonia;
	private final ModelPart left;
	private final ModelPart lup;
	private final ModelPart lmid;
	private final ModelPart ldown;
	private final ModelPart right;
	private final ModelPart rup;
	private final ModelPart rmid;
	private final ModelPart rdown;
	private final ModelPart mid_up;
	private final ModelPart mid_down;
	public DickinsoniaModel(ModelPart root) {
		this.root = root.getChild("root");
		this.Dickinsonia = this.root.getChild("dickinsonia");
		this.left = Dickinsonia.getChild("left");
		this.lup = left.getChild("lup");
		this.lmid = left.getChild("lmid");
		this.ldown = left.getChild("ldown");
		this.right = Dickinsonia.getChild("right");
		this.rup = right.getChild("rup");
		this.rmid = right.getChild("rmid");
		this.rdown = right.getChild("rdown");
		this.mid_up = Dickinsonia.getChild("mid_up");
		this.mid_down = Dickinsonia.getChild("mid_down");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData root = modelPartData.addChild("root", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData Dickinsonia = root.addChild("dickinsonia", ModelPartBuilder.create(), ModelTransform.of(0.0F, 24.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		ModelPartData left = Dickinsonia.addChild("left", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 17.0F));

		ModelPartData lup = left.addChild("lup", ModelPartBuilder.create().uv(36, 27).cuboid(-2.0F, -1.0F, 9.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
				.uv(22, 34).cuboid(-4.0F, -1.0F, 8.0F, 4.0F, 1.0F, 1.0F, new Dilation(0.0F))
				.uv(27, 24).cuboid(-5.0F, -1.0F, 7.0F, 5.0F, 1.0F, 1.0F, new Dilation(0.0F))
				.uv(27, 20).cuboid(-6.0F, -1.0F, 5.0F, 6.0F, 1.0F, 2.0F, new Dilation(0.0F))
				.uv(25, 8).cuboid(-7.0F, -1.0F, 3.0F, 7.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, -17.0F));

		ModelPartData lmid = left.addChild("lmid", ModelPartBuilder.create().uv(0, 13).cuboid(-8.0F, -1.0F, -2.0F, 8.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, -17.0F));

		ModelPartData ldown = left.addChild("ldown", ModelPartBuilder.create().uv(25, 0).cuboid(-7.0F, -1.0F, -4.0F, 7.0F, 1.0F, 2.0F, new Dilation(0.0F))
				.uv(27, 12).cuboid(-6.0F, -1.0F, -6.0F, 6.0F, 1.0F, 2.0F, new Dilation(0.0F))
				.uv(13, 31).cuboid(-5.0F, -1.0F, -7.0F, 5.0F, 1.0F, 1.0F, new Dilation(0.0F))
				.uv(0, 34).cuboid(-4.0F, -1.0F, -8.0F, 4.0F, 1.0F, 1.0F, new Dilation(0.0F))
				.uv(14, 37).cuboid(-2.0F, -1.0F, -9.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, -17.0F));

		ModelPartData right = Dickinsonia.addChild("right", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 17.0F));

		ModelPartData rup = right.addChild("rup", ModelPartBuilder.create().uv(7, 37).cuboid(0.0F, -1.0F, 9.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
				.uv(11, 34).cuboid(0.0F, -1.0F, 8.0F, 4.0F, 1.0F, 1.0F, new Dilation(0.0F))
				.uv(26, 31).cuboid(0.0F, -1.0F, 7.0F, 5.0F, 1.0F, 1.0F, new Dilation(0.0F))
				.uv(27, 16).cuboid(0.0F, -1.0F, 5.0F, 6.0F, 1.0F, 2.0F, new Dilation(0.0F))
				.uv(25, 4).cuboid(0.0F, -1.0F, 3.0F, 7.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, -17.0F));

		ModelPartData rmid = right.addChild("rmid", ModelPartBuilder.create().uv(0, 20).cuboid(0.0F, -1.0F, -2.0F, 8.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, -17.0F));

		ModelPartData rdown = right.addChild("rdown", ModelPartBuilder.create().uv(0, 27).cuboid(0.0F, -1.0F, -4.0F, 7.0F, 1.0F, 2.0F, new Dilation(0.0F))
				.uv(19, 27).cuboid(0.0F, -1.0F, -6.0F, 6.0F, 1.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 31).cuboid(0.0F, -1.0F, -7.0F, 5.0F, 1.0F, 1.0F, new Dilation(0.0F))
				.uv(33, 34).cuboid(0.0F, -1.0F, -8.0F, 4.0F, 1.0F, 1.0F, new Dilation(0.0F))
				.uv(0, 37).cuboid(0.0F, -1.0F, -9.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, -17.0F));

		ModelPartData mid_up = Dickinsonia.addChild("mid_up", ModelPartBuilder.create().uv(0, 0).cuboid(-0.5F, -1.5F, -4.0F, 1.0F, 1.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData mid_down = Dickinsonia.addChild("mid_down", ModelPartBuilder.create().uv(0, 0).cuboid(-0.5F, -1.5F, 2.0F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
		return TexturedModelData.of(modelData, 64, 64);
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		this.root.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}
	@Override
	public ModelPart getPart() {
		return this.root;
	}


	@Override
	public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);

		// this.animateMovement(DickinsoniaAnimation.MOVE, limbAngle, limbDistance, limbAngle, limbDistance);
		// this.updateAnimation(entity.fallAnimationState, DickinsoniaAnimation.FALL, entity.age, 1f);
		if (entity.getLastAttackedTime() - entity.hurtTime < 0) {
			entity.setAnimationState(entity.hurtAnimationState);
			this.updateAnimation(entity.hurtAnimationState, DickinsoniaAnimation.HURT, entity.age, 1f);
		} else if (!entity.isOnGround()) {
			entity.setAnimationState(entity.fallAnimationState);
			this.updateAnimation(entity.fallAnimationState, DickinsoniaAnimation.FALL, entity.age, 1f);
		} else if (entity.getVelocity().horizontalLengthSquared() > 0) {
			entity.setAnimationState(entity.moveAnimationState);
			this.updateAnimation(entity.moveAnimationState, DickinsoniaAnimation.MOVE, entity.age, 1f);
		} else {
			entity.setAnimationState(entity.defaultAnimationState);
		}
		// System.out.println(1);

	}
}