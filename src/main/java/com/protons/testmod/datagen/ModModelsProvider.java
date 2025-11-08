package com.protons.testmod.datagen;

import com.google.common.collect.ImmutableMap;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.protons.testmod.TestMod;
import com.protons.testmod.block.ModBlocks;
import com.protons.testmod.custom.ModModels;
import com.protons.testmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.*;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;

import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;

public class ModModelsProvider extends FabricModelProvider {
    public ModModelsProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GRANULITE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.LIMESTONE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MARBLE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SILT_BLOCK);
        // blockStateModelGenerator.registerCubeWithCustomTextures();
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.MARBLE_BLOCK_FOSSIL);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.STROMATOLITE_BLOCK);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.STROMATOLITE_BLOCK_CONNECT);
        //已修改或新增
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PRIMORDIAL_CRUST_ROCK_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.KOMATIITE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SERPENTINITE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GREEN_SCHIST_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TONALITE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TRONDHJEMITE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GRANODIORITE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GNEISS_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.QUARTZ_REEF_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.QUARTZ_REEF_GOLD_ORE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SINTER_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SINTER_SULFUR_DEPOSIT_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SINTER_BARITE_DEPOSIT_BLOCK);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.HYDROTHERMAL_VENT_BLOCK_LARGE);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.HYDROTHERMAL_VENT_BLOCK_MIDDLE);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.HYDROTHERMAL_VENT_BLOCK_SMALL);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.METEORITE_BLOCK);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.RUBBLE_PILE);
        blockStateModelGenerator.registerAmethyst(ModBlocks.BARITE_CLUSTER);
        blockStateModelGenerator.registerAmethyst(ModBlocks.LARGE_BARITE_BUD);
        blockStateModelGenerator.registerAmethyst(ModBlocks.MEDIUM_BARITE_BUD);
        blockStateModelGenerator.registerAmethyst(ModBlocks.SMALL_BARITE_BUD);
        blockStateModelGenerator.registerAmethyst(ModBlocks.SULFUR_CLUSTER);
        blockStateModelGenerator.registerAmethyst(ModBlocks.LARGE_SULFUR_BUD);
        blockStateModelGenerator.registerAmethyst(ModBlocks.MEDIUM_SULFUR_BUD);
        blockStateModelGenerator.registerAmethyst(ModBlocks.SMALL_SULFUR_BUD);
        this.registerSnowLikeBlocks(ModBlocks.VOLCANIC_ASH, ModBlocks.VOLCANIC_ASH_BLOCK, blockStateModelGenerator);
        //blockStateModelGenerator.registerCubeWithCustomTextures(Blocks.CRAFTING_TABLE, Blocks.OAK_PLANKS, TextureMap::sideFrontTopBottom);
        this.registerCraftingTableLikeBlocks(ModBlocks.CRUDE_CRAFTING_TABLE, blockStateModelGenerator);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.PRIMORDIAL_PETRI_DISH);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.DICKINSONIA_SPAWN_EGG, ModModels.TEMPLATE_SPAWN_EGG);
        itemModelGenerator.register(ModItems.CHARNIA_SPAWN_EGG, ModModels.TEMPLATE_SPAWN_EGG);
        itemModelGenerator.register(ModItems.RANGEA_SPAWN_EGG, ModModels.TEMPLATE_SPAWN_EGG);
        itemModelGenerator.register(ModItems.OXYGEN_DEFICIENT_WATER_BUCKET, ModModels.GENERATED);
        // itemModelGenerator.register(ModItems.SAMPLE_ITEM, Models.GENERATED);
        //已修改或新增
        itemModelGenerator.register(ModItems.SULFUR, ModModels.GENERATED);
        itemModelGenerator.register(ModItems.BAR_SHAPED_CRUSHED_STONE, ModModels.GENERATED);
        itemModelGenerator.register(ModItems.STONE_STICK, ModModels.GENERATED);
        itemModelGenerator.register(ModItems.CRYSTAL_OF_LIFE, ModModels.GENERATED);

        itemModelGenerator.register(ModItems.CRUDE_STONE_HANDLED_STONE_PICKAXE,ModModels.HANDHELD);
        itemModelGenerator.register(ModItems.STONE_HANDLED_STONE_PICKAXE, ModModels.HANDHELD);
    }

    private void registerSnowLikeBlocks(Block layer, Block block, BlockStateModelGenerator blockStateModelGenerator) {
        TextureMap textureMap = TextureMap.all(layer);
        Identifier identifier = Models.CUBE_ALL.upload(block, textureMap, blockStateModelGenerator.modelCollector);
        for (int height = 1; height < 8; height++) {
            Identifier modelId = ModelIds.getBlockSubModelId(layer, "_height" + height * 2);
            TextureMap textureMap1 = new TextureMap()
                    .put(TextureKey.PARTICLE, new Identifier(TestMod.MOD_ID,"block/volcanic_ash"))
                    .put(TextureKey.TEXTURE, new Identifier(TestMod.MOD_ID,"block/volcanic_ash"));

            Model model = new Model(Optional.of(new Identifier("block/thin_block")), Optional.empty(), TextureKey.TEXTURE, TextureKey.PARTICLE);
            int finalHeight = height;
            model.upload(modelId, textureMap1, blockStateModelGenerator.modelCollector, (id, textures) -> {
                JsonObject json = new JsonObject();
                json.addProperty("parent", "block/thin_block");
                JsonObject texturesJson = new JsonObject();
                textures.forEach((key, value) -> texturesJson.addProperty(key.getName(), value.toString()));
                json.add("textures", texturesJson);

                JsonObject element = new JsonObject();
                JsonArray elementArray = new JsonArray();
                JsonArray fromArray = new JsonArray();
                fromArray.add(0);
                fromArray.add(0);
                fromArray.add(0);
                element.add("from", fromArray);

                JsonArray toArray = new JsonArray();
                toArray.add(16);
                toArray.add(finalHeight * 2);
                toArray.add(16);
                element.add("to", toArray);
                JsonObject faces = new JsonObject();
                faces.add("down", createFaceJson("#texture", new int[]{0, 0, 16, 16}, "down"));
                faces.add("up", createFaceJson("#texture", new int[]{0, 0, 16, 16}, null));
                faces.add("north", createFaceJson("#texture", new int[]{0,(16-finalHeight*2),16,16}, "north"));
                faces.add("south", createFaceJson("#texture", new int[]{0,(16-finalHeight*2),16,16}, "south"));
                faces.add("east", createFaceJson("#texture", new int[]{0,(16-finalHeight*2),16,16}, "east"));
                faces.add("west", createFaceJson("#texture", new int[]{0,(16-finalHeight*2),16,16}, "west"));
                element.add("faces", faces);
                elementArray.add(element);
                json.add("elements", elementArray);

                return json;
            });
        }

        blockStateModelGenerator.blockStateCollector
            .accept(
                VariantsBlockStateSupplier.create(layer)
                    .coordinate(
                        BlockStateVariantMap.create(Properties.LAYERS)
                            .register(
                                height -> BlockStateVariant.create()
                                    .put(VariantSettings.MODEL, height < 8
                                            ? ModelIds.getBlockSubModelId(layer, "_height" + height * 2) : identifier)
                            )
                    )
            );
        this.registerParentedItemModel(layer, ModelIds.getBlockSubModelId(layer, "_height2"),blockStateModelGenerator);
        blockStateModelGenerator.blockStateCollector.accept(createSingletonBlockState(block, identifier));
    }

    public void registerParentedItemModel(Block block, Identifier parentModelId, BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.modelCollector.accept(ModelIds.getItemModelId(block.asItem()), new SimpleModelSupplier(parentModelId));
    }

    public static VariantsBlockStateSupplier createSingletonBlockState(Block block, Identifier modelId) {
        return VariantsBlockStateSupplier.create(block, BlockStateVariant.create().put(VariantSettings.MODEL, modelId));
    }

    private JsonObject createFaceJson(String texture, int[] uv, String cullface) {
        JsonObject face = new JsonObject();
        face.addProperty("texture", texture);
        JsonArray uvArray = new JsonArray();
        for (int value : uv) {
            uvArray.add(value); // 直接添加数值
        }
        face.add("uv", uvArray);
        if (cullface != null) {
            face.addProperty("cullface", cullface);
        }
        return face;
    }

    public final void registerCubeWithOwnCustomTextures(Block block, Function<Block, TextureMap> texturesFactory, BlockStateModelGenerator blockStateModelGenerator) {
        // 使用提供的工厂函数生成纹理映射
        TextureMap textureMap = texturesFactory.apply(block);
        // 使用 Models.CUBE 模型上传方块和其纹理映射，然后将生成的模型ID注册为该方块的单一方块状态
        blockStateModelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createSingletonBlockState(block, Models.CUBE.upload(block, textureMap, blockStateModelGenerator.modelCollector)));
    }

    public static TextureMap sideFrontTopBottomWithParticle(Block block) {
        return TextureMap.sideFrontTopBottom(block)
                .inherit(TextureKey.FRONT, TextureKey.PARTICLE)
        ;
    }

    private void registerCraftingTableLikeBlocks(Block block, BlockStateModelGenerator blockStateModelGenerator) {
        TextureMap textureMap = new TextureMap()
                .put(TextureKey.PARTICLE, TextureMap.getSubId(block, "_front"))
                .put(TextureKey.DOWN, TextureMap.getSubId(block, "_bottom"))
                .put(TextureKey.UP, TextureMap.getSubId(block, "_top"))
                .put(TextureKey.NORTH, TextureMap.getSubId(block, "_front"))
                .put(TextureKey.SOUTH, TextureMap.getSubId(block, "_front"))
                .put(TextureKey.EAST, TextureMap.getSubId(block, "_side"))
                .put(TextureKey.WEST, TextureMap.getSubId(block, "_side"));
        blockStateModelGenerator.blockStateCollector.accept(createSingletonBlockState(block, Models.CUBE.upload(block, textureMap, blockStateModelGenerator.modelCollector)));
    }
}
