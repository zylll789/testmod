package com.protons.testmod.datagen;

import com.protons.testmod.block.ModBlocks;
import com.protons.testmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.TableBonusLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTablesProvider extends FabricBlockLootTableProvider {
    public ModLootTablesProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.STROMATOLITE_BLOCK);
        addDrop(ModBlocks.STROMATOLITE_BLOCK_CONNECT);
        addDrop(ModBlocks.RHYOLITE_BLOCK);
        addDrop(ModBlocks.GRANULITE_BLOCK);
        addDrop(ModBlocks.SLATE_BLOCK);
        addDrop(ModBlocks.SLATE_BLOCK_FOSSIL);
        addDrop(ModBlocks.MARBLE_BLOCK);
        addDrop(ModBlocks.MARBLE_BLOCK_FOSSIL);
        addDrop(ModBlocks.DOLOMITE_BLOCK);
        addDrop(ModBlocks.DOLOMITE_BLOCK_FOSSIL);
        addDrop(ModBlocks.LIMESTONE_BLOCK);
        addDrop(ModBlocks.LIMESTONE_BLOCK_FOSSIL);
        addDrop(ModBlocks.SHALE_BLOCK);
        addDrop(ModBlocks.SHALE_BLOCK_FOSSIL);
        addDrop(ModBlocks.PHYLLITE_BLOCK);
        addDrop(ModBlocks.PHYLLITE_BLOCK_FOSSIL);
        addDrop(ModBlocks.SILT_BLOCK);
        //已修改或新增
        addDrop(ModBlocks.PRIMORDIAL_CRUST_ROCK_BLOCK);
        addDrop(ModBlocks.KOMATIITE_BLOCK);
        addDrop(ModBlocks.SERPENTINITE_BLOCK);
        addDrop(ModBlocks.GREEN_SCHIST_BLOCK);
        addDrop(ModBlocks.TONALITE_BLOCK);
        addDrop(ModBlocks.TRONDHJEMITE_BLOCK);
        addDrop(ModBlocks.GRANODIORITE_BLOCK);
        addDrop(ModBlocks.GNEISS_BLOCK);
        addDrop(ModBlocks.BANDED_IRON_FORMATION_BLOCK, OreDropsWithOneLoot(ModBlocks.BANDED_IRON_FORMATION_BLOCK, Items.RAW_IRON, 1.0F, 3.0F, Items.FLINT, 1.0F, 2.0F, new float[]{0F, 0.2F, 0.5F, 1F}));
        addDrop(ModBlocks.QUARTZ_REEF_BLOCK);
        addDrop(ModBlocks.QUARTZ_REEF_GOLD_ORE_BLOCK, OreDrops(ModBlocks.QUARTZ_REEF_GOLD_ORE_BLOCK, Items.RAW_GOLD, 2.0F, 3.0F));
        addDrop(ModBlocks.SINTER_BLOCK);
        addDrop(ModBlocks.SINTER_SULFUR_DEPOSIT_BLOCK, BlockDropsWithOneLoot(ModBlocks.SINTER_SULFUR_DEPOSIT_BLOCK, ModBlocks.SINTER_BLOCK.asItem(), ModItems.SULFUR, 1.0F, 2.0F, new float[]{0F, 0.2F, 0.5F, 1F}));
        addDrop(ModBlocks.SINTER_BARITE_DEPOSIT_BLOCK, BlockDrops(ModBlocks.SINTER_BARITE_DEPOSIT_BLOCK, ModBlocks.SINTER_BLOCK.asItem()));
        addDrop(ModBlocks.HYDROTHERMAL_VENT_BLOCK);
        addDrop(ModBlocks.HYDROTHERMAL_VENT_BLOCK_LARGE);
        addDrop(ModBlocks.HYDROTHERMAL_VENT_BLOCK_MIDDLE);
        addDrop(ModBlocks.HYDROTHERMAL_VENT_BLOCK_SMALL);
        addDrop(ModBlocks.METEORITE_BLOCK);
        addDrop(ModBlocks.RUBBLE_PILE, OreDrops(ModBlocks.RUBBLE_PILE, ModItems.BAR_SHAPED_CRUSHED_STONE, 0.0F, 2.0F));
        addDrop(ModBlocks.SULFUR_CLUSTER, ConstantOreDrops(ModBlocks.SULFUR_CLUSTER, ModItems.SULFUR, 4.0F));
        addDrop(ModBlocks.LARGE_SULFUR_BUD, ConstantOreDrops(ModBlocks.LARGE_SULFUR_BUD, ModItems.SULFUR, 3.0F));
        addDrop(ModBlocks.MEDIUM_SULFUR_BUD, ConstantOreDrops(ModBlocks.MEDIUM_SULFUR_BUD, ModItems.SULFUR, 2.0F));
        addDrop(ModBlocks.SMALL_SULFUR_BUD, ConstantOreDrops(ModBlocks.SMALL_SULFUR_BUD, ModItems.SULFUR, 1.0F));
        addDrop(ModBlocks.BARITE_CLUSTER);
        addDrop(ModBlocks.LARGE_BARITE_BUD, dropsWithSilkTouch(ModBlocks.LARGE_BARITE_BUD));
        addDrop(ModBlocks.MEDIUM_BARITE_BUD, dropsWithSilkTouch(ModBlocks.MEDIUM_BARITE_BUD));
        addDrop(ModBlocks.SMALL_BARITE_BUD, dropsWithSilkTouch(ModBlocks.SMALL_BARITE_BUD));
        addDrop(ModBlocks.CRUDE_CRAFTING_TABLE);
    }
    // 参考 net.minecraft.data.server.loottable.BlockLootTableGenerator
    public LootTable.Builder OreDrops(Block drop, Item item, float min, float max) {
        return dropsWithSilkTouch(
            drop,
            (LootPoolEntry.Builder<?>)this.applyExplosionDecay(
                drop,
                ItemEntry.builder(item)
                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(min, max)))
                    .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))
            )
        );
    }
    public LootTable.Builder ConstantOreDrops(Block drop, Item item, float num) {
        return dropsWithSilkTouch(
            drop,
            (LootPoolEntry.Builder<?>)this.applyExplosionDecay(
                drop,
                ItemEntry.builder(item)
                    .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(num)))
            )
        );
    }
    public LootTable.Builder OreDropsWithOneLoot(Block drop, Item item, float min, float max, Item loot_item, float min_loot, float max_loot, float[] chance) {
        return dropsWithSilkTouch(
            drop,
            (LootPoolEntry.Builder<?>)this.applyExplosionDecay(
                drop,
                ItemEntry.builder(item)
                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(min, max)))
                    .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))
            )
        ).pool(
            LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(1.0F))
                .conditionally(WITHOUT_SILK_TOUCH)
                .with(
                    ((LootPoolEntry.Builder<?>)this.applyExplosionDecay(
                        drop, ItemEntry.builder(loot_item).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(min_loot, max_loot)))
                    ))
                    .conditionally(TableBonusLootCondition.builder(Enchantments.FORTUNE, chance))
                )
        );
    }
    public LootTable.Builder BlockDrops(Block drop, Item fixedDropItem) {
        return dropsWithSilkTouch(
            drop,
            (LootPoolEntry.Builder<?>)this.applyExplosionDecay(
                drop,
                ItemEntry.builder(fixedDropItem)
                    .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0F)))
            )
        );
    }
    public LootTable.Builder BlockDropsWithOneLoot(Block drop, Item fixedDropItem, Item variableDropItem, float min, float max, float[] chance) {
        return dropsWithSilkTouch(
            drop,
            (LootPoolEntry.Builder<?>)this.applyExplosionDecay(drop,
                ItemEntry.builder(fixedDropItem)
                    .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0F)))
            )
        ).pool(
            LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(1.0F))
                .conditionally(WITHOUT_SILK_TOUCH)
                .with(
                    ((LootPoolEntry.Builder<?>)this.applyExplosionDecay(
                        drop, ItemEntry.builder(variableDropItem).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(min, max)))
                    ))
                        .conditionally(TableBonusLootCondition.builder(Enchantments.FORTUNE, chance))
                )
        );
    }
}
