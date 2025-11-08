package com.protons.testmod.item;

import com.protons.testmod.TestMod;
import com.protons.testmod.entity.ModEntities;
import com.protons.testmod.fluid.ModFluids;
import com.protons.testmod.item.tool.pickaxe.CrudeStoneHandledStonePickaxe;
import com.protons.testmod.item.tool.pickaxe.StoneHandledStonePickaxe;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item STROMATOLITE_FRAGMENTS = registerItems("stromatolite_fragments", new Item(new Item.Settings()));
    public static final Item DICKINSONIA_SPAWN_EGG = registerItems("dickinsonia_spawn_egg", new SpawnEggItem(ModEntities.DICKINSONIA, 0xF0E68C, 0xBDB76B, new Item.Settings()));
    public static final Item CHARNIA_SPAWN_EGG = registerItems("charnia_spawn_egg", new SpawnEggItem(ModEntities.CHARNIA, 0xB6703E, 0xB64315, new Item.Settings()));
    public static final Item RANGEA_SPAWN_EGG = registerItems("rangea_spawn_egg", new SpawnEggItem(ModEntities.RANGEA, 0x71767F, 0x434850, new Item.Settings()));
    public static final Item OXYGEN_DEFICIENT_WATER_BUCKET = registerItems("oxygen_deficient_water_bucket", new ModBuckets(ModFluids.OXYGEN_DEFICIENT_WATER_STILL, new Item.Settings().recipeRemainder(Items.BUCKET).maxCount(1)));
    //已修改或新增
    public static final Item SULFUR = registerItems("sulfur", new Item(new Item.Settings()));
    public static final Item BAR_SHAPED_CRUSHED_STONE = registerItems("bar_shaped_crushed_stone", new Item(new Item.Settings()));
    public static final Item STONE_STICK = registerItems("stone_stick", new Item(new Item.Settings()));

    public static final Item CRUDE_STONE_HANDLED_STONE_PICKAXE = registerItems("crude_stone_handled_stone_pickaxe",new CrudeStoneHandledStonePickaxe(ModToolMaterials.MOD_CRUDE_STONE, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.MOD_CRUDE_STONE, 0.8F, -3F))));
    public static final Item STONE_HANDLED_STONE_PICKAXE = registerItems("stone_handled_stone_pickaxe", new StoneHandledStonePickaxe(ModToolMaterials.MOD_STONE, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.MOD_STONE, 1.0F, -2.8F))));
    public static final Item CRYSTAL_OF_LIFE = registerItems("crystal_of_life", new Item(new Item.Settings()));

    private static void addItemsToIngredients(FabricItemGroupEntries fabricItemGroupEntries) {
        fabricItemGroupEntries.add(STROMATOLITE_FRAGMENTS);
    }

    private static void addItemsToSpawnEgg(FabricItemGroupEntries fabricItemGroupEntries) {
        fabricItemGroupEntries.add(DICKINSONIA_SPAWN_EGG);
    }

    private static void addItemsToTools(FabricItemGroupEntries fabricItemGroupEntries) {
        fabricItemGroupEntries.add(OXYGEN_DEFICIENT_WATER_BUCKET);
    }

    private static Item registerItems(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(TestMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredients);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(ModItems::addItemsToSpawnEgg);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(ModItems::addItemsToTools);
    }
}
