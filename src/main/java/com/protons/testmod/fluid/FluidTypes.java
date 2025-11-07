package com.protons.testmod.fluid;

import net.minecraft.util.StringIdentifiable;

public enum FluidTypes implements StringIdentifiable {

    DRY("dry"),
    WATER("water"),
    OXYGEN_DEFICIENT_WATER("oxygen_deficient_water");

    private final String name;

    private FluidTypes(final String name) {
        this.name = name;
    }

    @Override
    public String asString() {
        return this.name;
    }

}
