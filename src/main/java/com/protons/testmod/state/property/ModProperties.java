package com.protons.testmod.state.property;

import com.protons.testmod.fluid.FluidTypes;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;

public class ModProperties {

    public static final EnumProperty<FluidTypes> LOGGED_WATER = EnumProperty.of("logged_water", FluidTypes.class);

    public static final BooleanProperty HAS_BASE = BooleanProperty.of("has_base");
    public static final BooleanProperty IS_CRAFTING = BooleanProperty.of("is_crafting");

}
