package com.protons.testmod.registry.tag;

import com.protons.testmod.TestMod;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModItemTags {
    public static final TagKey<Item> MOD_CRUDE_STONE_TOOL_MATERIALS = of("mod_crude_stone_tool_materials");

    private static TagKey<Item> of(String id) {
        return TagKey.of(RegistryKeys.ITEM, new Identifier(TestMod.MOD_ID,id));
    }
}
