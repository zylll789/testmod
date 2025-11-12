package com.protons.testmod.client.gui.screen.ingame;

import com.protons.testmod.TestMod;
import com.protons.testmod.screen.handler.CrudeCraftingScreenHandler;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.screen.recipebook.RecipeBookProvider;
import net.minecraft.client.gui.screen.recipebook.RecipeBookWidget;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class CrudeCraftingScreen extends HandledScreen<CrudeCraftingScreenHandler>{

    private static final Identifier TEXTURE = new Identifier(TestMod.MOD_ID,"textures/gui/container/crude_crafting_table_ui.png");
    //private final RecipeBookWidget recipeBook = new RecipeBookWidget();
    private boolean narrow;

    public CrudeCraftingScreen(CrudeCraftingScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        int i = this.x;
        int j = (this.height - this.backgroundHeight) / 2;
        context.drawTexture(TEXTURE, i, j, 0, 0, this.backgroundWidth, this.backgroundHeight);
    }


    @Override
    public void handledScreenTick() {
        super.handledScreenTick();
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context, mouseX, mouseY, delta);
        super.render(context, mouseX, mouseY, delta);
        this.drawMouseoverTooltip(context, mouseX, mouseY);
    }

}
