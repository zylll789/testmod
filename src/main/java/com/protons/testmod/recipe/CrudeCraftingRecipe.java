package com.protons.testmod.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.inventory.RecipeInputInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.recipe.*;
import net.minecraft.recipe.book.CraftingRecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

public class CrudeCraftingRecipe implements CraftingRecipe {

    final RawShapedRecipe raw;
    final ItemStack result;
    final String group;
    final CraftingRecipeCategory category;
    final boolean showNotification;

    public CrudeCraftingRecipe(String group, CraftingRecipeCategory category, RawShapedRecipe raw, ItemStack result, boolean showNotification) {
        this.group = group;
        this.category = category;
        this.raw = raw;
        this.result = result;
        this.showNotification = showNotification;
    }
    public CrudeCraftingRecipe(String group, CraftingRecipeCategory category, RawShapedRecipe raw, ItemStack result) {
        this(group, category, raw, result, true);
    }

    @Override
    public String getGroup() {
        return this.group;
    }

    @Override
    public CraftingRecipeCategory getCategory() {
        return this.category;
    }

    @Override
    public ItemStack getResult(RegistryWrapper.WrapperLookup registriesLookup) {
        return this.result;
    }

    @Override
    public DefaultedList<Ingredient> getIngredients() {
        return this.raw.ingredients();
    }

    @Override
    public boolean showNotification() {
        return this.showNotification;
    }

    @Override
    public boolean matches(RecipeInputInventory recipeInputInventory, World world) {
        return this.raw.matches(recipeInputInventory);
    }

    @Override
    public ItemStack craft(RecipeInputInventory recipeInputInventory, RegistryWrapper.WrapperLookup wrapperLookup) {
        return this.getResult(wrapperLookup).copy();
    }

    @Override
    public boolean fits(int width, int height) {
        return width >= this.raw.width() && height >= this.raw.height();
    }

    @Override
    public RecipeSerializer<CrudeCraftingRecipe> getSerializer() {
        return ModRecipeSerializers.CRUDE_CRAFTING;
    }

    @Override
    public RecipeType<CrudeCraftingRecipe> getType() {
        return ModRecipeType.CRUDE_CRAFTING;
    }

    public int getWidth() {
        return this.raw.width();
    }

    public int getHeight() {
        return this.raw.height();
    }

    @Override
    public boolean isEmpty() {
        DefaultedList<Ingredient> defaultedList = this.getIngredients();
        return defaultedList.isEmpty()
                || defaultedList.stream().filter(ingredient -> !ingredient.isEmpty()).anyMatch(ingredient -> ingredient.getMatchingStacks().length == 0);
    }

    public static class Serializer implements RecipeSerializer<CrudeCraftingRecipe> {
        public static final MapCodec<CrudeCraftingRecipe> CODEC = RecordCodecBuilder.mapCodec(
                instance -> instance.group(
                                Codec.STRING.optionalFieldOf("group", "").forGetter(recipe -> recipe.group),
                                CraftingRecipeCategory.CODEC.fieldOf("category").orElse(CraftingRecipeCategory.MISC).forGetter(recipe -> recipe.category),
                                RawShapedRecipe.CODEC.forGetter(recipe -> recipe.raw),
                                ItemStack.VALIDATED_CODEC.fieldOf("result").forGetter(recipe -> recipe.result),
                                Codec.BOOL.optionalFieldOf("show_notification", Boolean.valueOf(true)).forGetter(recipe -> recipe.showNotification)
                        )
                        .apply(instance, CrudeCraftingRecipe::new)
        );
        public static final PacketCodec<RegistryByteBuf, CrudeCraftingRecipe> PACKET_CODEC = PacketCodec.ofStatic(
                CrudeCraftingRecipe.Serializer::write, CrudeCraftingRecipe.Serializer::read
        );

        @Override
        public MapCodec<CrudeCraftingRecipe> codec() {
            return CODEC;
        }

        @Override
        public PacketCodec<RegistryByteBuf, CrudeCraftingRecipe> packetCodec() {
            return PACKET_CODEC;
        }

        private static CrudeCraftingRecipe read(RegistryByteBuf buf) {
            String string = buf.readString();
            CraftingRecipeCategory craftingRecipeCategory = buf.readEnumConstant(CraftingRecipeCategory.class);
            RawShapedRecipe rawShapedRecipe = RawShapedRecipe.PACKET_CODEC.decode(buf);
            ItemStack itemStack = ItemStack.PACKET_CODEC.decode(buf);
            boolean bl = buf.readBoolean();
            return new CrudeCraftingRecipe(string, craftingRecipeCategory, rawShapedRecipe, itemStack, bl);
        }

        private static void write(RegistryByteBuf buf, CrudeCraftingRecipe recipe) {
            buf.writeString(recipe.group);
            buf.writeEnumConstant(recipe.category);
            RawShapedRecipe.PACKET_CODEC.encode(buf, recipe.raw);
            ItemStack.PACKET_CODEC.encode(buf, recipe.result);
            buf.writeBoolean(recipe.showNotification);
        }
    }

}
