package com.protons.testmod.datagen;

import com.protons.testmod.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipesProvider extends FabricRecipeProvider {
    private static final List<ItemConvertible> MOD_IRON_ORE_LIST = List.of(ModBlocks.BANDED_IRON_FORMATION_BLOCK);
    private static final List<ItemConvertible> MOD_GOLD_ORE_LIST = List.of(ModBlocks.QUARTZ_REEF_GOLD_ORE_BLOCK);
    public ModRecipesProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        // 可逆压缩
        // offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.SAMPLE_ITEM, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SAMPLE_BLOCK);

        offerSmelting(exporter, MOD_IRON_ORE_LIST, RecipeCategory.MISC, Items.IRON_INGOT, 0.7f, 200, "iron_ingot");
        offerBlasting(exporter, MOD_IRON_ORE_LIST, RecipeCategory.MISC, Items.IRON_INGOT, 0.7f, 100, "iron_ingot");
        offerSmelting(exporter, MOD_GOLD_ORE_LIST, RecipeCategory.MISC, Items.GOLD_INGOT, 1.5f, 200, "gold_ingot");
        offerBlasting(exporter, MOD_GOLD_ORE_LIST, RecipeCategory.MISC, Items.GOLD_INGOT, 1.5f, 100, "gold_ingot");
    }
}
