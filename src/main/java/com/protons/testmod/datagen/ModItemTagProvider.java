package com.protons.testmod.datagen;

import com.protons.testmod.item.ModItems;
import com.protons.testmod.registry.tag.ModItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
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
        getOrCreateTagBuilder(ModItemTags.MOD_CRUDE_STONE_TOOL_MATERIALS)
                .add(ModItems.BAR_SHAPED_CRUSHED_STONE);

        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.CRUDE_STONE_HANDLED_STONE_PICKAXE);
    }
}
