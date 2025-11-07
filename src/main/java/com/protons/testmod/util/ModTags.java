package com.protons.testmod.util;

import com.protons.testmod.TestMod;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks {
        // 示例用法： public static final TagKey<Block> SAMPLE_LIST = createTag("sample_list");
        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, new Identifier(TestMod.MOD_ID, name));
        }
    }
    public static class Items {

    }
}
