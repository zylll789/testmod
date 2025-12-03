package com.protons.testmod.world.biome;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;

public class ModBiomeCreator {

    public static Biome create(Registerable<Biome> ctx) {
        SpawnSettings.Builder spawn = new SpawnSettings.Builder();
        DefaultBiomeFeatures.addFarmAnimals(spawn);
        DefaultBiomeFeatures.addBatsAndMonsters(spawn);

        GenerationSettings.LookupBackedBuilder gen =
                new GenerationSettings.LookupBackedBuilder(
                        ctx.getRegistryLookup(RegistryKeys.PLACED_FEATURE),
                        ctx.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));
        DefaultBiomeFeatures.addLandCarvers(gen);
        DefaultBiomeFeatures.addAmethystGeodes(gen);
        DefaultBiomeFeatures.addDefaultOres(gen);
        DefaultBiomeFeatures.addDefaultMushrooms(gen);
        DefaultBiomeFeatures.addForestFlowers(gen);
        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.TREES_PLAINS);

        return new Biome.Builder()
                .temperature(0.8F).downfall(0.4F)
                .effects(new BiomeEffects.Builder()
                        .skyColor(0x66EBFF)
                        .fogColor(0xC0FFFF)
                        .waterColor(0x3F76E4)
                        .waterFogColor(0x050533)
                        .grassColor(0x7CFF7C)
                        .foliageColor(0x59FF59)
                        .build())
                .spawnSettings(spawn.build())
                .generationSettings(gen.build())
                .build();
    }

    public static void bootstrap(Registerable<Biome> ctx) {
        ctx.register(ModBiomeKeys.PRIMORDIAL_LOWLANDS, create(ctx));
    }

}
