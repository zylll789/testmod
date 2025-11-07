package com.protons.testmod.fluid;

import com.protons.testmod.TestMod;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModFluids {
    public static final FlowableFluid OXYGEN_DEFICIENT_WATER_STILL = registerFluids("oxygen_deficient_water_still", new OxygenDeficientWater.Still());
    public static final FlowableFluid OXYGEN_DEFICIENT_WATER_FLOWING = registerFluids("oxygen_deficient_water_flowing", new OxygenDeficientWater.Flowing());

    private static FlowableFluid registerFluids(String name, ModFluid modfluid) {
        return Registry.register(Registries.FLUID, new Identifier(TestMod.MOD_ID, name), modfluid);
    }

    public static void registerModFluids() {

    }
}
