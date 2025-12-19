package com.protons.testmod.world.gen.chunk;

import com.protons.testmod.TestMod;
import com.protons.testmod.block.ModBlocks;
import com.protons.testmod.fluid.ModFluids;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.chunk.ChunkGeneratorSettings;
import net.minecraft.world.gen.chunk.GenerationShapeConfig;
import net.minecraft.world.gen.surfacebuilder.VanillaSurfaceRules;

import java.util.List;

public class ModDimensionNoises {

    public static final RegistryKey<ChunkGeneratorSettings> ARCHEAN_EON = RegistryKey.of(RegistryKeys.CHUNK_GENERATOR_SETTINGS, new Identifier(TestMod.MOD_ID,"archean_eon"));

    public static void bootstrap(Registerable<ChunkGeneratorSettings> chunkGenerationSettingsRegisterable) {
        chunkGenerationSettingsRegisterable.register(ARCHEAN_EON, createSurfaceSettings(chunkGenerationSettingsRegisterable, false, false));

    }

    private static ChunkGeneratorSettings createSurfaceSettings(Registerable<?> registerable, boolean amplified, boolean largeBiomes) {
        ChunkGeneratorSettings overworld = registerable.getRegistryLookup(RegistryKeys.CHUNK_GENERATOR_SETTINGS).getOrThrow(ChunkGeneratorSettings.OVERWORLD).value();
        return new ChunkGeneratorSettings(
                GenerationShapeConfig.create(-64, 384, 1, 2),
                ModBlocks.PRIMORDIAL_CRUST_ROCK_BLOCK.getDefaultState(),
                ModFluids.PRIMORDIAL_SOUP_STILL.getDefaultState().getBlockState(),
                overworld.noiseRouter(),
                VanillaSurfaceRules.createOverworldSurfaceRule(),
                List.of(),
                63,
                true,
                true,
                true,
                false
        );
    }

}
