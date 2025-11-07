package com.protons.testmod.datagen;

import com.protons.testmod.block.ModBlocks;
import com.protons.testmod.registry.tag.ModBlockTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.STROMATOLITE_BLOCK)
                .add(ModBlocks.STROMATOLITE_BLOCK_CONNECT)
                .add(ModBlocks.RHYOLITE_BLOCK)
                .add(ModBlocks.GRANULITE_BLOCK)
                .add(ModBlocks.SLATE_BLOCK)
                .add(ModBlocks.SLATE_BLOCK_FOSSIL)
                .add(ModBlocks.MARBLE_BLOCK)
                .add(ModBlocks.MARBLE_BLOCK_FOSSIL)
                .add(ModBlocks.DOLOMITE_BLOCK)
                .add(ModBlocks.DOLOMITE_BLOCK_FOSSIL)
                .add(ModBlocks.LIMESTONE_BLOCK)
                .add(ModBlocks.LIMESTONE_BLOCK_FOSSIL)
                .add(ModBlocks.SHALE_BLOCK)
                .add(ModBlocks.SHALE_BLOCK_FOSSIL)
                .add(ModBlocks.PHYLLITE_BLOCK)
                .add(ModBlocks.PHYLLITE_BLOCK_FOSSIL)
                //已修改或新增
                .add(ModBlocks.PRIMORDIAL_CRUST_ROCK_BLOCK)
                .add(ModBlocks.KOMATIITE_BLOCK)
                .add(ModBlocks.SERPENTINITE_BLOCK)
                .add(ModBlocks.GREEN_SCHIST_BLOCK)
                .add(ModBlocks.TONALITE_BLOCK)
                .add(ModBlocks.TRONDHJEMITE_BLOCK)
                .add(ModBlocks.GRANODIORITE_BLOCK)
                .add(ModBlocks.GNEISS_BLOCK)
                .add(ModBlocks.BANDED_IRON_FORMATION_BLOCK)
                .add(ModBlocks.QUARTZ_REEF_BLOCK)
                .add(ModBlocks.QUARTZ_REEF_GOLD_ORE_BLOCK)
                .add(ModBlocks.SINTER_BLOCK)
                .add(ModBlocks.SINTER_SULFUR_DEPOSIT_BLOCK)
                .add(ModBlocks.SINTER_BARITE_DEPOSIT_BLOCK)
                .add(ModBlocks.HYDROTHERMAL_VENT_BLOCK)
                .add(ModBlocks.HYDROTHERMAL_VENT_BLOCK_LARGE)
                .add(ModBlocks.HYDROTHERMAL_VENT_BLOCK_MIDDLE)
                .add(ModBlocks.HYDROTHERMAL_VENT_BLOCK_SMALL)
                .add(ModBlocks.METEORITE_BLOCK)
                .add(ModBlocks.RUBBLE_PILE)
                .add(ModBlocks.SULFUR_CLUSTER)
                .add(ModBlocks.LARGE_SULFUR_BUD)
                .add(ModBlocks.MEDIUM_SULFUR_BUD)
                .add(ModBlocks.SMALL_SULFUR_BUD)
                .add(ModBlocks.BARITE_CLUSTER)
                .add(ModBlocks.LARGE_BARITE_BUD)
                .add(ModBlocks.MEDIUM_BARITE_BUD)
                .add(ModBlocks.SMALL_BARITE_BUD)
                ;

        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.STROMATOLITE_BLOCK)
                .add(ModBlocks.STROMATOLITE_BLOCK_CONNECT)
                .add(ModBlocks.RHYOLITE_BLOCK)
                .add(ModBlocks.GRANULITE_BLOCK)
                .add(ModBlocks.SLATE_BLOCK)
                .add(ModBlocks.SLATE_BLOCK_FOSSIL)
                .add(ModBlocks.MARBLE_BLOCK)
                .add(ModBlocks.MARBLE_BLOCK_FOSSIL)
                .add(ModBlocks.DOLOMITE_BLOCK)
                .add(ModBlocks.DOLOMITE_BLOCK_FOSSIL)
                .add(ModBlocks.LIMESTONE_BLOCK)
                .add(ModBlocks.LIMESTONE_BLOCK_FOSSIL)
                .add(ModBlocks.SHALE_BLOCK)
                .add(ModBlocks.SHALE_BLOCK_FOSSIL)
                .add(ModBlocks.PHYLLITE_BLOCK)
                .add(ModBlocks.PHYLLITE_BLOCK_FOSSIL)
                //已修改或新增
                .add(ModBlocks.PRIMORDIAL_CRUST_ROCK_BLOCK)
                .add(ModBlocks.KOMATIITE_BLOCK)
                .add(ModBlocks.SERPENTINITE_BLOCK)
                .add(ModBlocks.GREEN_SCHIST_BLOCK)
                .add(ModBlocks.TONALITE_BLOCK)
                .add(ModBlocks.TRONDHJEMITE_BLOCK)
                .add(ModBlocks.GRANODIORITE_BLOCK)
                .add(ModBlocks.GNEISS_BLOCK)
                .add(ModBlocks.BANDED_IRON_FORMATION_BLOCK)
                .add(ModBlocks.QUARTZ_REEF_BLOCK)
                .add(ModBlocks.QUARTZ_REEF_GOLD_ORE_BLOCK)
                .add(ModBlocks.SINTER_BLOCK)
                .add(ModBlocks.SINTER_SULFUR_DEPOSIT_BLOCK)
                .add(ModBlocks.SINTER_BARITE_DEPOSIT_BLOCK)
                .add(ModBlocks.HYDROTHERMAL_VENT_BLOCK)
                .add(ModBlocks.HYDROTHERMAL_VENT_BLOCK_LARGE)
                .add(ModBlocks.HYDROTHERMAL_VENT_BLOCK_MIDDLE)
                .add(ModBlocks.HYDROTHERMAL_VENT_BLOCK_SMALL)
                .add(ModBlocks.METEORITE_BLOCK)
                .add(ModBlocks.RUBBLE_PILE)
                .add(ModBlocks.SULFUR_CLUSTER)
                .add(ModBlocks.LARGE_SULFUR_BUD)
                .add(ModBlocks.MEDIUM_SULFUR_BUD)
                .add(ModBlocks.SMALL_SULFUR_BUD)
                .add(ModBlocks.BARITE_CLUSTER)
                .add(ModBlocks.LARGE_BARITE_BUD)
                .add(ModBlocks.MEDIUM_BARITE_BUD)
                .add(ModBlocks.SMALL_BARITE_BUD)
                ;

        getOrCreateTagBuilder(ModBlockTags.VOLCANIC_ASH_LAYER_CAN_SURVIVE_ON)
                .add(Blocks.MUD)
                .add(Blocks.SOUL_SAND)
                .add(Blocks.HONEY_BLOCK)
                ;

        getOrCreateTagBuilder(ModBlockTags.VOLCANIC_ASH_LAYER_CANNOT_SURVIVE_ON)
                .add(Blocks.BARRIER)
                ;


        // 示例用法(最后一个可以是下界合金级)
        // getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL).add(...)
        // getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL).add(...)
        // getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("fabric", "needs_tool_level_4"))).add(...)
    }
}
