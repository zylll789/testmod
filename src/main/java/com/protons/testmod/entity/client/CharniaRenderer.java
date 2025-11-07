package com.protons.testmod.entity.client;

import com.protons.testmod.TestMod;
import com.protons.testmod.entity.custom.CharniaEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class CharniaRenderer extends MobEntityRenderer<CharniaEntity, CharniaModel<CharniaEntity>> {
    private static final Identifier TEXTURE = new Identifier(TestMod.MOD_ID, "textures/entity/charnia.png");
    public CharniaRenderer(EntityRendererFactory.Context context) {
        super(context, new CharniaModel<>(context.getPart(ModModelLayers.CHARNIA)), 0.5f);
    }

    @Override
    public Identifier getTexture(CharniaEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(CharniaEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        if (mobEntity.isBaby()) {
            matrixStack.scale(0.5f,0.5f,0.5f);
        } else {
            matrixStack.scale(1f,1f,1f);
        }
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
