package com.protons.testmod.recipe;

import com.protons.testmod.TestMod;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public interface ModRecipeType <T extends Recipe<?>>{

    RecipeType<CrudeCraftingRecipe> CRUDE_CRAFTING = register("crude_crafting");

    static <T extends Recipe<?>> RecipeType<T> register(String id) {
        return Registry.register(Registries.RECIPE_TYPE, new Identifier(TestMod.MOD_ID, id), new RecipeType<T>() {
            public String toString() {
                return id;
            }
        });
    }

    public static void register(){

    }

}
