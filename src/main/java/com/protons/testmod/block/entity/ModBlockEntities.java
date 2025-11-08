package com.protons.testmod.block.entity;

import com.protons.testmod.TestMod;
import com.protons.testmod.block.ModBlocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.datafixer.TypeReferences;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {

    public static final BlockEntityType<PrimordialPetriDishBlockEntity> PRIMORDIAL_PETRI_DISH_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            new Identifier(TestMod.MOD_ID, "primordial_petri_dish_entity"),
            BlockEntityType.Builder.create(PrimordialPetriDishBlockEntity::new, ModBlocks.PRIMORDIAL_PETRI_DISH).build(null)
    );

    public static void registerModBlockEntities() {

    }

}
