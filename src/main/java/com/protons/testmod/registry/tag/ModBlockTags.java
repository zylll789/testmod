package com.protons.testmod.registry.tag;

import com.protons.testmod.TestMod;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public final class ModBlockTags {

    public static final TagKey<Block> VOLCANIC_ASH_LAYER_CANNOT_SURVIVE_ON = of("volcanic_ash_layer_cannot_survive_on");
    public static final TagKey<Block> VOLCANIC_ASH_LAYER_CAN_SURVIVE_ON = of("volcanic_ash_layer_can_survive_on");

    private static TagKey<Block> of(String id) {
        return TagKey.of(RegistryKeys.BLOCK, new Identifier(TestMod.MOD_ID,id));
    }

}
