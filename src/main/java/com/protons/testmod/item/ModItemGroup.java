package com.protons.testmod.item;

import com.protons.testmod.TestMod;
import com.protons.testmod.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup ARCHEAN_EON = Registry.register(Registries.ITEM_GROUP, new Identifier(TestMod.MOD_ID, "archean_eon_group"),
            FabricItemGroup.builder().displayName(Text.translatable("itemGroup.archean_eon_group")).icon(()-> new ItemStack(ModBlocks.STROMATOLITE_BLOCK)).entries((displayContext, entries) -> {
                entries.add(ModBlocks.STROMATOLITE_BLOCK);
                entries.add(ModBlocks.STROMATOLITE_BLOCK_CONNECT);
                entries.add(ModItems.STROMATOLITE_FRAGMENTS);
                entries.add(ModBlocks.RHYOLITE_BLOCK);
                entries.add(ModBlocks.GRANULITE_BLOCK);
                entries.add(ModBlocks.SILT_BLOCK);
                entries.add(ModItems.OXYGEN_DEFICIENT_WATER_BUCKET);
                //已修改或新增
                entries.add(ModBlocks.PRIMORDIAL_CRUST_ROCK_BLOCK);
                entries.add(ModBlocks.KOMATIITE_BLOCK);
                entries.add(ModBlocks.SERPENTINITE_BLOCK);
                entries.add(ModBlocks.GREEN_SCHIST_BLOCK);
                entries.add(ModBlocks.TONALITE_BLOCK);
                entries.add(ModBlocks.TRONDHJEMITE_BLOCK);
                entries.add(ModBlocks.GRANODIORITE_BLOCK);
                entries.add(ModBlocks.GNEISS_BLOCK);
                entries.add(ModBlocks.BANDED_IRON_FORMATION_BLOCK);
                entries.add(ModBlocks.QUARTZ_REEF_BLOCK);
                entries.add(ModBlocks.QUARTZ_REEF_GOLD_ORE_BLOCK);
                entries.add(ModBlocks.SINTER_BLOCK);
                entries.add(ModBlocks.SINTER_SULFUR_DEPOSIT_BLOCK);
                entries.add(ModBlocks.SULFUR_CLUSTER);
                entries.add(ModBlocks.LARGE_SULFUR_BUD);
                entries.add(ModBlocks.MEDIUM_SULFUR_BUD);
                entries.add(ModBlocks.SMALL_SULFUR_BUD);
                entries.add(ModBlocks.SINTER_BARITE_DEPOSIT_BLOCK);
                entries.add(ModBlocks.BARITE_CLUSTER);
                entries.add(ModBlocks.LARGE_BARITE_BUD);
                entries.add(ModBlocks.MEDIUM_BARITE_BUD);
                entries.add(ModBlocks.SMALL_BARITE_BUD);
                entries.add(ModBlocks.HYDROTHERMAL_VENT_BLOCK);
                entries.add(ModBlocks.HYDROTHERMAL_VENT_BLOCK_LARGE);
                entries.add(ModBlocks.HYDROTHERMAL_VENT_BLOCK_MIDDLE);
                entries.add(ModBlocks.HYDROTHERMAL_VENT_BLOCK_SMALL);
                entries.add(ModItems.SULFUR);
                entries.add(ModBlocks.METEORITE_BLOCK);
                entries.add(ModBlocks.RUBBLE_PILE);
                entries.add(ModItems.BAR_SHAPED_CRUSHED_STONE);
                entries.add(ModBlocks.VOLCANIC_ASH_BLOCK);
                entries.add(ModBlocks.VOLCANIC_ASH);
                entries.add(ModItems.CRUDE_STONE_HANDLED_STONE_PICKAXE);
                entries.add(ModItems.STONE_HANDLED_STONE_PICKAXE);
                entries.add(ModItems.STONE_STICK);
                entries.add(ModBlocks.CRUDE_CRAFTING_TABLE);
                entries.add(ModBlocks.PRIMORDIAL_PETRI_DISH);
            }).build());

    public static final ItemGroup PROTEROZOIC_EON = Registry.register(Registries.ITEM_GROUP, new Identifier(TestMod.MOD_ID, "proterozoic_eon_group"),
            FabricItemGroup.builder().displayName(Text.translatable("itemGroup.proterozoic_eon_group")).icon(()-> new ItemStack(ModBlocks.LIMESTONE_BLOCK)).entries((displayContext, entries) -> {
                entries.add(ModBlocks.SLATE_BLOCK);
                entries.add(ModBlocks.SLATE_BLOCK_FOSSIL);
                entries.add(ModBlocks.MARBLE_BLOCK);
                entries.add(ModBlocks.MARBLE_BLOCK_FOSSIL);
                entries.add(ModBlocks.DOLOMITE_BLOCK);
                entries.add(ModBlocks.DOLOMITE_BLOCK_FOSSIL);
                entries.add(ModBlocks.LIMESTONE_BLOCK);
                entries.add(ModBlocks.LIMESTONE_BLOCK_FOSSIL);
                entries.add(ModBlocks.SHALE_BLOCK);
                entries.add(ModBlocks.SHALE_BLOCK_FOSSIL);
                entries.add(ModBlocks.PHYLLITE_BLOCK);
                entries.add(ModBlocks.PHYLLITE_BLOCK_FOSSIL);
                entries.add(ModItems.DICKINSONIA_SPAWN_EGG);
                entries.add(ModItems.CHARNIA_SPAWN_EGG);
                entries.add(ModItems.RANGEA_SPAWN_EGG);
            }).build());

    public static void registerModItemGroup() {

    }
}