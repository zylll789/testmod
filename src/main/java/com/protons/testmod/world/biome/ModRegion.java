package com.protons.testmod.world.biome;

import com.mojang.datafixers.util.Pair;
import com.protons.testmod.TestMod;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;
import terrablender.api.Region;
import terrablender.api.RegionType;

import java.util.function.Consumer;

public class ModRegion extends Region {
    public ModRegion() {
        super(new Identifier(TestMod.MOD_ID, "overworld"), RegionType.OVERWORLD, 5);
    }

    @Override
    public void addBiomes(Registry<Biome> reg,
                          Consumer<Pair<MultiNoiseUtil.NoiseHypercube, RegistryKey<Biome>>> mapper) {
        /* 50% 概率替换掉原版平原 */
        this.addModifiedVanillaOverworldBiomes(mapper, builder ->
                builder.replaceBiome(BiomeKeys.PLAINS, ModBiomeKeys.PRIMORDIAL_LOWLANDS));
    }
}
