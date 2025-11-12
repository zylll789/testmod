package com.protons.testmod.screen;

import com.protons.testmod.TestMod;
import com.protons.testmod.client.gui.screen.ingame.CrudeCraftingScreen;
import com.protons.testmod.screen.handler.CrudeCraftingScreenHandler;
import net.minecraft.client.gui.screen.ingame.CraftingScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreens {

    public static final ScreenHandlerType<CrudeCraftingScreenHandler> CRUDE_CRAFTING = register("crude_crafting", CrudeCraftingScreenHandler::new);

    private static <T extends ScreenHandler> ScreenHandlerType<T> register(String id, ScreenHandlerType.Factory<T> factory) {
        return Registry.register(Registries.SCREEN_HANDLER, new Identifier(TestMod.MOD_ID, id), new ScreenHandlerType<>(factory, FeatureFlags.VANILLA_FEATURES));
    }


    public static void registerModScreens() {
        HandledScreens.register(CRUDE_CRAFTING, CrudeCraftingScreen::new);
    }

}
