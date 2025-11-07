package com.protons.testmod.entity;

import com.protons.testmod.TestMod;
import com.protons.testmod.entity.custom.CharniaEntity;
import com.protons.testmod.entity.custom.DickinsoniaEntity;
import com.protons.testmod.entity.custom.RangeaEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<DickinsoniaEntity> DICKINSONIA = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(TestMod.MOD_ID, "dickinsonia"), EntityType.Builder.create(DickinsoniaEntity::new, SpawnGroup.WATER_CREATURE)
                    .dimensions(1f,1f).build());
    public static final EntityType<CharniaEntity> CHARNIA = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(TestMod.MOD_ID, "charnia"), EntityType.Builder.create(CharniaEntity::new, SpawnGroup.WATER_CREATURE)
                    .dimensions(1f,1f).build());
    public static final EntityType<RangeaEntity> RANGEA = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(TestMod.MOD_ID, "rangea"), EntityType.Builder.create(RangeaEntity::new, SpawnGroup.WATER_CREATURE)
                    .dimensions(1f,1f).build());

    public static void registerModEntities() {
        FabricDefaultAttributeRegistry.register(DICKINSONIA, DickinsoniaEntity.createDickinsoniaAttributes());
        FabricDefaultAttributeRegistry.register(CHARNIA, CharniaEntity.createCharniaAttributes());
        FabricDefaultAttributeRegistry.register(RANGEA, RangeaEntity.createRangeaAttributes());
    }
}
