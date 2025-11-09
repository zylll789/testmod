package com.protons.testmod.fluid;

import com.protons.testmod.TestMod;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModFluids {
    public static final FlowableFluid PRIMORDIAL_SOUP_STILL = registerFluids("primordial_soup_still", new PrimordialSoup.Still());
    public static final FlowableFluid PRIMORDIAL_SOUP_FLOWING = registerFluids("primordial_soup_flowing", new PrimordialSoup.Flowing());

    private static FlowableFluid registerFluids(String name, ModFluid modfluid) {
        return Registry.register(Registries.FLUID, new Identifier(TestMod.MOD_ID, name), modfluid);
    }

    public static void registerModFluids() {

    }
}
