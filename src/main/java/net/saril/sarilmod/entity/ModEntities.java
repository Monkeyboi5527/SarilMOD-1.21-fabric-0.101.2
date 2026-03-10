package net.saril.sarilmod.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.saril.sarilmod.SarilMod;
import net.saril.sarilmod.entity.custom.MantisEntity;

public class ModEntities {

    public static final EntityType<MantisEntity> MANTIS = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(SarilMod.MOD_ID, "mantis"),
            EntityType.Builder.create(MantisEntity::new, SpawnGroup.CREATURE)
                    .dimensions(1f, 2.5f).build());


    public static void registerModEntities() {
        SarilMod.LOGGER.info("Registering ModEntities for: " + SarilMod.MOD_ID);
    }
}
