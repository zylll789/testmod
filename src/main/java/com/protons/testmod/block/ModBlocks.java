package com.protons.testmod.block;

import com.protons.testmod.TestMod;
import com.protons.testmod.fluid.ModFluids;
import com.protons.testmod.state.property.ModProperties;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block STROMATOLITE_BLOCK = registerBlocksWithBlockItems("stromatolite_block", new StromatoliteBlock(AbstractBlock.Settings.copy(Blocks.STONE).nonOpaque().requiresTool()));
    public static final Block STROMATOLITE_BLOCK_CONNECT = registerBlocksWithBlockItems("stromatolite_block_connect", new StromatoliteBlockConnect(AbstractBlock.Settings.copy(Blocks.STONE).nonOpaque().requiresTool()));
    public static final Block RHYOLITE_BLOCK = registerBlocksWithBlockItems("rhyolite_block", new Block(AbstractBlock.Settings.copy(Blocks.STONE).requiresTool()));
    public static final Block GRANULITE_BLOCK = registerBlocksWithBlockItems("granulite_block", new Block(AbstractBlock.Settings.copy(Blocks.STONE).requiresTool()));
    public static final Block SLATE_BLOCK = registerBlocksWithBlockItems("slate_block", new Block(AbstractBlock.Settings.copy(Blocks.STONE).requiresTool()));
    public static final Block SLATE_BLOCK_FOSSIL = registerBlocksWithBlockItems("slate_block_fossil", new SlateBlockFossil(AbstractBlock.Settings.copy(Blocks.STONE).requiresTool()));
    public static final Block MARBLE_BLOCK = registerBlocksWithBlockItems("marble_block", new Block(AbstractBlock.Settings.copy(Blocks.STONE).requiresTool()));
    public static final Block MARBLE_BLOCK_FOSSIL = registerBlocksWithBlockItems("marble_block_fossil", new MarbleBlockFossil(AbstractBlock.Settings.copy(Blocks.STONE).requiresTool()));
    public static final Block DOLOMITE_BLOCK = registerBlocksWithBlockItems("dolomite_block", new Block(AbstractBlock.Settings.copy(Blocks.STONE).requiresTool()));
    public static final Block DOLOMITE_BLOCK_FOSSIL = registerBlocksWithBlockItems("dolomite_block_fossil", new DolomiteBlockFossil(AbstractBlock.Settings.copy(Blocks.STONE).requiresTool()));
    public static final Block LIMESTONE_BLOCK = registerBlocksWithBlockItems("limestone_block", new Block(AbstractBlock.Settings.copy(Blocks.STONE).requiresTool()));
    public static final Block LIMESTONE_BLOCK_FOSSIL = registerBlocksWithBlockItems("limestone_block_fossil", new LimestoneBlockFossil(AbstractBlock.Settings.copy(Blocks.STONE).requiresTool()));
    public static final Block SHALE_BLOCK = registerBlocksWithBlockItems("shale_block", new Block(AbstractBlock.Settings.copy(Blocks.STONE).requiresTool()));
    public static final Block SHALE_BLOCK_FOSSIL = registerBlocksWithBlockItems("shale_block_fossil", new ShaleBlockFossil(AbstractBlock.Settings.copy(Blocks.STONE).requiresTool()));
    public static final Block PHYLLITE_BLOCK = registerBlocksWithBlockItems("phyllite_block", new Block(AbstractBlock.Settings.copy(Blocks.STONE).requiresTool()));
    public static final Block PHYLLITE_BLOCK_FOSSIL = registerBlocksWithBlockItems("phyllite_block_fossil", new PhylliteBlockFossil(AbstractBlock.Settings.copy(Blocks.STONE).requiresTool()));
    public static final Block SILT_BLOCK = registerBlocksWithBlockItems("silt_block", new SiltBlock(AbstractBlock.Settings.copy(Blocks.CLAY)));
    public static final Block OXYGEN_DEFICIENT_WATER = registerBlocks("oxygen_deficient_water", new FluidBlock(ModFluids.PRIMORDIAL_SOUP_STILL, AbstractBlock.Settings.copy(Blocks.WATER)));

    //已修改或新增
    public static final Block PRIMORDIAL_CRUST_ROCK_BLOCK = registerBlocksWithBlockItems("primordial_crust_rock_block", new Block(AbstractBlock.Settings.copy(Blocks.STONE).requiresTool()));
    public static final Block KOMATIITE_BLOCK = registerBlocksWithBlockItems("komatiite_block", new Block(AbstractBlock.Settings.copy(Blocks.STONE).requiresTool()));
    public static final Block SERPENTINITE_BLOCK = registerBlocksWithBlockItems("serpentinite_block", new Block(AbstractBlock.Settings.copy(Blocks.STONE).requiresTool()));
    public static final Block GREEN_SCHIST_BLOCK = registerBlocksWithBlockItems("green_schist_block", new Block(AbstractBlock.Settings.copy(Blocks.STONE).requiresTool()));
    public static final Block TONALITE_BLOCK = registerBlocksWithBlockItems("tonalite_block", new Block(AbstractBlock.Settings.copy(Blocks.GRANITE).requiresTool()));
    public static final Block TRONDHJEMITE_BLOCK = registerBlocksWithBlockItems("trondhjemite_block", new Block(AbstractBlock.Settings.copy(Blocks.GRANITE).requiresTool()));
    public static final Block GRANODIORITE_BLOCK = registerBlocksWithBlockItems("granodiorite_block", new Block(AbstractBlock.Settings.copy(Blocks.GRANITE).requiresTool()));
    public static final Block GNEISS_BLOCK = registerBlocksWithBlockItems("gneiss_block", new Block(AbstractBlock.Settings.copy(Blocks.GRANITE).requiresTool()));
    public static final Block BANDED_IRON_FORMATION_BLOCK = registerBlocksWithBlockItems("banded_iron_formation_block", new BandedIronFormationBlock(AbstractBlock.Settings.copy(Blocks.IRON_ORE).requiresTool()));
    public static final Block QUARTZ_REEF_BLOCK = registerBlocksWithBlockItems("quartz_reef_block", new Block(AbstractBlock.Settings.copy(Blocks.DEEPSLATE).requiresTool()));
    public static final Block QUARTZ_REEF_GOLD_ORE_BLOCK = registerBlocksWithBlockItems("quartz_reef_gold_ore_block", new Block(AbstractBlock.Settings.copy(Blocks.DEEPSLATE_GOLD_ORE).requiresTool()));
    public static final Block SINTER_BLOCK = registerBlocksWithBlockItems("sinter_block", new Block(AbstractBlock.Settings.copy(Blocks.STONE).requiresTool()));
    public static final Block SINTER_SULFUR_DEPOSIT_BLOCK = registerBlocksWithBlockItems("sinter_sulfur_deposit_block", new SinterSulfurDepositBlock(AbstractBlock.Settings.create()
            .ticksRandomly()
            .strength(1.5F)
            .requiresTool()
            .pistonBehavior(PistonBehavior.DESTROY)
    ));
    public static final Block SULFUR_CLUSTER = registerBlocksWithBlockItems("sulfur_cluster", new SulfurClusterBlock(7.0F, 3.0F, AbstractBlock.Settings.create()
            .solid()
            .nonOpaque()
            .strength(1.5F)
            .luminance(state -> 5)
            .pistonBehavior(PistonBehavior.DESTROY)
            .requiresTool()
    ));
    public static final Block LARGE_SULFUR_BUD = registerBlocksWithBlockItems("large_sulfur_bud", new SulfurClusterBlock(5.0F, 3.0F, AbstractBlock.Settings.copyShallow(SULFUR_CLUSTER).luminance(state -> 4)));
    public static final Block MEDIUM_SULFUR_BUD = registerBlocksWithBlockItems("medium_sulfur_bud", new SulfurClusterBlock(4.0F, 3.0F, AbstractBlock.Settings.copyShallow(SULFUR_CLUSTER).luminance(state -> 2)));
    public static final Block SMALL_SULFUR_BUD = registerBlocksWithBlockItems("small_sulfur_bud", new SulfurClusterBlock(3.0F, 4.0F, AbstractBlock.Settings.copyShallow(SULFUR_CLUSTER).luminance(state -> 1)));

    public static final Block HYDROTHERMAL_VENT_BLOCK = registerBlocksWithBlockItems("hydrothermal_vent_block", new HydrothermalVentBlock(AbstractBlock.Settings.copy(Blocks.STONE).requiresTool()));
    public static final Block HYDROTHERMAL_VENT_BLOCK_LARGE = registerBlocksWithBlockItems("hydrothermal_vent_block_large", new HydrothermalVentBlockLarge(AbstractBlock.Settings.copy(Blocks.STONE).requiresTool()));
    public static final Block HYDROTHERMAL_VENT_BLOCK_MIDDLE = registerBlocksWithBlockItems("hydrothermal_vent_block_middle", new HydrothermalVentBlockMiddle(AbstractBlock.Settings.copy(Blocks.STONE).requiresTool()));
    public static final Block HYDROTHERMAL_VENT_BLOCK_SMALL = registerBlocksWithBlockItems("hydrothermal_vent_block_small", new HydrothermalVentBlockSmall(AbstractBlock.Settings.copy(Blocks.STONE).requiresTool()));
    public static final Block METEORITE_BLOCK = registerBlocksWithBlockItems("meteorite_block", new Block(AbstractBlock.Settings.copy(Blocks.DEEPSLATE).requiresTool()));
    public static final Block IRON_METEORITE_BLOCK = registerBlocksWithBlockItems("iron_meteorite_block", new Block(AbstractBlock.Settings.copy(Blocks.DEEPSLATE_IRON_ORE).requiresTool()));
    public static final Block RUBBLE_PILE = registerBlocksWithBlockItems("rubble_pile", new RubblePile(AbstractBlock.Settings.copy(Blocks.STONE).requiresTool()));
    public static final Block SINTER_BARITE_DEPOSIT_BLOCK = registerBlocksWithBlockItems("sinter_barite_deposit_block", new SinterBariteDepositBlock(AbstractBlock.Settings.create()
            .ticksRandomly()
            .strength(1.5F)
            .requiresTool()
            .pistonBehavior(PistonBehavior.DESTROY)
    ));
    public static final Block BARITE_CLUSTER = registerBlocksWithBlockItems("barite_cluster", new BariteClusterBlock(7.0F, 3.0F, AbstractBlock.Settings.copyShallow(Blocks.AMETHYST_CLUSTER)
            .solid()
            .nonOpaque()
            .strength(1.5F)
            .luminance(state -> 5)
            .pistonBehavior(PistonBehavior.DESTROY)
            .requiresTool()
    ));
    public static final Block LARGE_BARITE_BUD = registerBlocksWithBlockItems("large_barite_bud", new BariteClusterBlock(5.0F, 3.0F, AbstractBlock.Settings.copyShallow(BARITE_CLUSTER).luminance(state -> 4)));
    public static final Block MEDIUM_BARITE_BUD = registerBlocksWithBlockItems("medium_barite_bud", new BariteClusterBlock(4.0F, 3.0F, AbstractBlock.Settings.copyShallow(BARITE_CLUSTER).luminance(state -> 2)));
    public static final Block SMALL_BARITE_BUD = registerBlocksWithBlockItems("small_barite_bud", new BariteClusterBlock(3.0F, 4.0F, AbstractBlock.Settings.copyShallow(BARITE_CLUSTER).luminance(state -> 1)));
    public static final Block VOLCANIC_ASH = registerBlocksWithBlockItems(
            "volcanic_ash",
            new VolcanicAshBlock(
                    AbstractBlock.Settings.create()
                    .replaceable()
                    .notSolid()
                    .ticksRandomly()
                    .strength(0.1F)
                    .requiresTool()
                    .blockVision((state, world, pos) -> (Integer)state.get(VolcanicAshBlock.LAYERS) >= 8)
                    .pistonBehavior(PistonBehavior.DESTROY)
    ));
    public static final Block VOLCANIC_ASH_BLOCK = registerBlocksWithBlockItems("volcanic_ash_block", new Block(AbstractBlock.Settings.create().requiresTool().strength(0.2F)));
    public static final Block CRUDE_CRAFTING_TABLE = registerBlocksWithBlockItems("crude_crafting_table", new CrudeCraftingTableBlock(AbstractBlock.Settings.create().requiresTool().strength(2F)));
    public static final Block PRIMORDIAL_PETRI_DISH = registerBlocksWithBlockItems("primordial_petri_dish", new PrimordialPetriDish(AbstractBlock.Settings.create().requiresTool().nonOpaque().strength(1.5F)));

    public static final Block CHEMOAUTOTROPH_MAT = registerBlocksWithBlockItems("chemoautotroph_mat", new ChemoautotrophMatBlock(
            AbstractBlock.Settings.create()
                    .solid()
                    .luminance(state -> state.get(ModProperties.LIGHT))
                    //.nonOpaque()
                    .noCollision()
                    .strength(0.2F)
                    .requiresTool()
                    .sounds(BlockSoundGroup.SCULK_VEIN)
                    .pistonBehavior(PistonBehavior.DESTROY)
    ));

    private static Block registerBlocksWithBlockItems(String name, Block block) {
        registerBlockItems(name, block);
        return registerBlocks(name, block);
    }

    private static Block registerBlocks(String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(TestMod.MOD_ID, name), block);
    }

    private static Item registerBlockItems(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(TestMod.MOD_ID, name), new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {

    }
}
