package com.protons.testmod.custom;

import net.minecraft.data.client.Model;
import net.minecraft.data.client.Models;
import net.minecraft.data.client.TextureKey;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class ModModels extends Models {

    public static final Model TEMPLATE_SPAWN_EGG = item("template_spawn_egg");

    public static final Model THIN_BLOCK = new Model(Optional.of(new Identifier("minecraft", "block/" + "thin_block")), Optional.empty(),
            TextureKey.PARTICLE, TextureKey.NORTH, TextureKey.SOUTH, TextureKey.EAST, TextureKey.WEST, TextureKey.UP, TextureKey.DOWN);


    private static Model item(String parent, TextureKey... requiredTextureKeys) {
        return new Model(Optional.of(new Identifier("minecraft", "item/" + parent)), Optional.empty(), requiredTextureKeys);
    }

}
