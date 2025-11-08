package com.protons.testmod.item.tool.pickaxe;

import net.minecraft.client.item.TooltipType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableTextContent;

import java.util.List;

public class StoneHandledStonePickaxe extends PickaxeItem {
    public StoneHandledStonePickaxe(ToolMaterial material, Item.Settings settings) {
        super(material, settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(MutableText.of(new TranslatableTextContent("item.testmod.stone_handled_stone_pickaxe.tooltip", "A PICKAXE", TranslatableTextContent.EMPTY_ARGUMENTS)));
    }
}
