package com.protons.testmod.world.dimension;

import com.protons.testmod.TestMod;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;

import java.util.OptionalLong;

public class ModDimensions {

    public static final RegistryKey<DimensionType> ARCHEAN_EON = RegistryKey.of(RegistryKeys.DIMENSION_TYPE, new Identifier(TestMod.MOD_ID, "archean_eon"));
    public static final Identifier ARCHEAN_EON_ID = new Identifier("archean_eon");
    public static final RegistryKey<World> ARCHEAN_EON_WORLD = RegistryKey.of(RegistryKeys.WORLD, new Identifier(TestMod.MOD_ID, "archean_eon"));

    public static void bootstrap(Registerable<DimensionType> dimensionTypeRegisterable) {
        dimensionTypeRegisterable.register(
                ARCHEAN_EON,
                new DimensionType(
                        OptionalLong.empty(),
                        true,
                        false,
                        false,
                        true,
                        1.0,
                        true,
                        true,
                        -64,
                        384,
                        384,
                        BlockTags.INFINIBURN_OVERWORLD,
                        ARCHEAN_EON_ID,
                        0.0F,
                        new DimensionType.MonsterSettings(true, false, UniformIntProvider.create(0, 7), 0)
                )
        );
    }

}
