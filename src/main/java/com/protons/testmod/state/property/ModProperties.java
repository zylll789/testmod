package com.protons.testmod.state.property;

import com.protons.testmod.fluid.FluidTypes;
import net.minecraft.state.property.EnumProperty;

public class ModProperties {

    public static final EnumProperty<FluidTypes> LOGGED_WATER = EnumProperty.of("logged_water", FluidTypes.class);

}
