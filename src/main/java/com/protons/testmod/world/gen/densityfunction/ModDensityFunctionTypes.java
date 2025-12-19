package com.protons.testmod.world.gen.densityfunction;

import com.mojang.serialization.MapCodec;
import com.protons.testmod.TestMod;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.dynamic.CodecHolder;
import net.minecraft.world.gen.densityfunction.DensityFunction;

public class ModDensityFunctionTypes {
    public static final MapCodec<? extends DensityFunction> CUSTOM_WORLEY_NOISE = registerDensityFunctionTypes("custom_worley_noise", CustomWorleyNoise.CODEC_HOLDER);

    private static MapCodec<? extends DensityFunction> registerDensityFunctionTypes(String name, CodecHolder<? extends DensityFunction> codecHolder) {
        return Registry.register(Registries.DENSITY_FUNCTION_TYPE, new Identifier(TestMod.MOD_ID, name), codecHolder.codec());
    }

    public static void registerModDensityFunctionTypes() {

    }
}
