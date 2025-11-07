package com.protons.testmod.entity.client;

import com.protons.testmod.TestMod;
import com.protons.testmod.entity.custom.RangeaEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class RangeaRenderer extends MobEntityRenderer<RangeaEntity, RangeaModel<RangeaEntity>> {
    private static final Identifier TEXTURE = new Identifier(TestMod.MOD_ID, "textures/entity/rangea.png");
    public RangeaRenderer(EntityRendererFactory.Context context) {
        super(context, new RangeaModel<>(context.getPart(ModModelLayers.RANGEA)), 0.5f);
    }

    @Override
    public Identifier getTexture(RangeaEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(RangeaEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        if (mobEntity.isBaby()) {
            matrixStack.scale(0.5f,0.5f,0.5f);
        } else {
            matrixStack.scale(1f,1f,1f);
        }
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}