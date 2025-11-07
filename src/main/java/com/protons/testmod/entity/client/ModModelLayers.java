package com.protons.testmod.entity.client;

import com.protons.testmod.TestMod;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModModelLayers {
    public static final EntityModelLayer DICKINSONIA = new EntityModelLayer(
            new Identifier(TestMod.MOD_ID, "dickinsonia"), "main");

    public static final EntityModelLayer CHARNIA = new EntityModelLayer(
            new Identifier(TestMod.MOD_ID, "charnia"), "main");

    public static final EntityModelLayer RANGEA = new EntityModelLayer(
            new Identifier(TestMod.MOD_ID, "rangea"), "main");
}
