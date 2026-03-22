package net.saril.sarilmod.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.saril.sarilmod.SarilMod;
import net.saril.sarilmod.block.ModBlocks;
import net.saril.sarilmod.block.entity.custom.MatterStabilizerBlockEntity;

public class ModBlockEntities {
    public static final BlockEntityType<MatterStabilizerBlockEntity> MATTER_STABILIZER_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(SarilMod.MOD_ID, "matter_stabilizer_be"),
                    FabricBlockEntityTypeBuilder.create(MatterStabilizerBlockEntity::new, ModBlocks.MATTER_STABILIZER).build(null));

    public static void registerBlockEntities() {
        SarilMod.LOGGER.info("Registering BlockEntities");
    }
}
