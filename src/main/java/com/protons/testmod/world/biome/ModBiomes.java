package com.protons.testmod.world.biome;

import com.protons.testmod.TestMod;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.VerticalSurfaceType;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;

public class ModBiomes {

    public static void register(){

        Regions.register(new ModRegion());
        SurfaceRuleManager.addSurfaceRules(
                SurfaceRuleManager.RuleCategory.OVERWORLD,
                TestMod.MOD_ID,
                MaterialRules.sequence(
                        MaterialRules.condition(
                                MaterialRules.biome(ModBiomeKeys.PRIMORDIAL_LOWLANDS),
                                MaterialRules.condition(
                                        MaterialRules.stoneDepth(0, false, VerticalSurfaceType.FLOOR),
                                        MaterialRules.block(Blocks.QUARTZ_BLOCK.getDefaultState())
                                )
                        ),
                        MaterialRules.condition(
                                MaterialRules.stoneDepth(0, false, VerticalSurfaceType.FLOOR),
                                MaterialRules.block(Blocks.GRASS_BLOCK.getDefaultState())
                        )
                )
        );

    }

}
