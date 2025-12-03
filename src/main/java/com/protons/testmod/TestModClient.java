package com.protons.testmod;

import com.protons.testmod.block.ModBlocks;
import com.protons.testmod.entity.ModEntities;
import com.protons.testmod.entity.client.*;
import com.protons.testmod.fluid.ModFluids;
import com.protons.testmod.screen.ModScreens;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;

public class TestModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        ModScreens.registerModScreens();

        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.DICKINSONIA, DickinsoniaModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.DICKINSONIA, DickinsoniaRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.CHARNIA, CharniaModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.CHARNIA, CharniaRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.RANGEA, RangeaModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.RANGEA, RangeaRenderer::new);

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHEMOAUTOTROPH_MAT, RenderLayer.getCutout());

        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.PRIMORDIAL_SOUP_STILL, ModFluids.PRIMORDIAL_SOUP_FLOWING, new SimpleFluidRenderHandler(
                new Identifier("minecraft:block/water_still"),
                new Identifier("minecraft:block/water_flow"),
                0x4F493C
        ));
        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.ACIDIC_HOT_SPRING_STILL, ModFluids.ACIDIC_HOT_SPRING_FLOWING, new SimpleFluidRenderHandler(
                new Identifier("minecraft:block/water_still"),
                new Identifier("minecraft:block/water_flow"),
                0xB89815
        ));

        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), ModFluids.PRIMORDIAL_SOUP_STILL, ModFluids.PRIMORDIAL_SOUP_FLOWING);
        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), ModFluids.ACIDIC_HOT_SPRING_STILL, ModFluids.ACIDIC_HOT_SPRING_FLOWING);

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BARITE_CLUSTER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LARGE_BARITE_BUD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MEDIUM_BARITE_BUD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SMALL_BARITE_BUD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SULFUR_CLUSTER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LARGE_SULFUR_BUD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MEDIUM_SULFUR_BUD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SMALL_SULFUR_BUD, RenderLayer.getCutout());
    }
}
