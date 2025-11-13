package com.protons.testmod.recipe;

import com.protons.testmod.TestMod;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRecipeSerializers {

    public static final RecipeSerializer<CrudeCraftingRecipe> CRUDE_CRAFTING = register(new Identifier(TestMod.MOD_ID, "crude_crafting"),
                    new CrudeCraftingRecipe.Serializer());

    static <S extends RecipeSerializer<T>, T extends Recipe<?>> S register(Identifier id, S serializer) {
        return Registry.register(Registries.RECIPE_SERIALIZER, id, serializer);
    }

    public static void register(){

    }

}
