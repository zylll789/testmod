package com.protons.testmod.world.biome;

import com.protons.testmod.TestMod;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;

public class ModBiomeKeys {

    public static final RegistryKey<Biome> PRIMORDIAL_LOWLANDS = register("primordial_lowlands");

    private static RegistryKey<Biome> register(String name) {
        return RegistryKey.of(RegistryKeys.BIOME, new Identifier(TestMod.MOD_ID, name));
    }

}
