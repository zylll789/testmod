package com.protons.testmod.datagen;

import com.protons.testmod.block.ModBlocks;
import com.protons.testmod.item.ModItems;
import com.protons.testmod.registry.tag.ModItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ItemTags.STONE_CRAFTING_MATERIALS)
                .add(ModBlocks.PRIMORDIAL_CRUST_ROCK_BLOCK.asItem());

        getOrCreateTagBuilder(ModItemTags.MOD_CRUDE_STONE_TOOL_MATERIALS)
                .add(ModItems.BAR_SHAPED_CRUSHED_STONE);

        getOrCreateTagBuilder(ModItemTags.MOD_STONE_TOOL_MATERIALS)
                .add(ModBlocks.PRIMORDIAL_CRUST_ROCK_BLOCK.asItem());

        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.CRUDE_STONE_HANDLED_STONE_PICKAXE)
                .add(ModItems.STONE_HANDLED_STONE_PICKAXE);

        getOrCreateTagBuilder(ModItemTags.CHEMOAUTOTROPH_MAT_LIT)
                .add(ModItems.SULFUR)
                .add(Items.IRON_NUGGET);
    }
}
