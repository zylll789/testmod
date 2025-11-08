package com.protons.testmod.block.entity;

import com.protons.testmod.block.ModBlocks;
import com.protons.testmod.block.PrimordialPetriDish;
import com.protons.testmod.item.ModItems;
import com.protons.testmod.state.property.ModProperties;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.LootableContainerBlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableTextContent;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class PrimordialPetriDishBlockEntity extends LootableContainerBlockEntity {

    private PrimordialPetriDish primordialPetriDish;
    private DefaultedList<ItemStack> inv = DefaultedList.ofSize(5, ItemStack.EMPTY);

    private int tickCount = 0; // 用于计时
    private static final int TICKS_TO_COMBINE = 200; // 10 秒（20 ticks/second）

    public PrimordialPetriDishBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntities.PRIMORDIAL_PETRI_DISH_ENTITY, blockPos, blockState);
        this.primordialPetriDish = (PrimordialPetriDish) blockState.getBlock();
    }

    @Override
    protected Text getContainerName() {
        return MutableText.of(new TranslatableTextContent("block.testmod.primordial_petri_dish", "dish", TranslatableTextContent.EMPTY_ARGUMENTS));
    }

    @Override
    public DefaultedList<ItemStack> getHeldStacks() {
        return this.inv;
    }

    @Override
    protected void setHeldStacks(DefaultedList<ItemStack> inventory) {
        this.inv = inventory;
    }

    @Override
    protected ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return null;
    }

    @Override
    public int size() {
        return 5;
    }

    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.writeNbt(nbt, registryLookup);
        nbt.putInt("tick",tickCount);
        Inventories.writeNbt(nbt, inv, registryLookup);
    }

    @Override
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.readNbt(nbt, registryLookup);
        tickCount = nbt.getInt("tick");
        Inventories.readNbt(nbt, inv, registryLookup);
    }

    public void tick(World world, BlockPos pos, BlockState state) {
        if (state.get(ModProperties.IS_CRAFTING)) {
            tickCount++;
        }
        if (inv.get(0).getItem() == ModBlocks.BARITE_CLUSTER.asItem() &&
                inv.get(1).getItem() == ModItems.SULFUR &&
                inv.get(2).getItem() == Items.GOLD_NUGGET &&
                inv.get(3).getItem() == Items.IRON_NUGGET &&
                inv.get(4).getCount() < ModItems.CHARNIA_SPAWN_EGG.getMaxCount()) {
            inv.get(0).decrement(1);
            inv.get(1).decrement(1);
            inv.get(2).decrement(1);
            inv.get(3).decrement(1);
            world.setBlockState(pos, state.with(ModProperties.HAS_BASE, false).with(ModProperties.IS_CRAFTING, true));
        }
        if (tickCount >= TICKS_TO_COMBINE) {
            if (inv.get(4).isEmpty()) {
                inv.set(4, new ItemStack(ModItems.CHARNIA_SPAWN_EGG, 1));
            } else {
                inv.get(4).increment(1);
            }
            tickCount = 0; // 重置计时
            world.setBlockState(pos, state.with(ModProperties.IS_CRAFTING, false));
        }
    }

}
