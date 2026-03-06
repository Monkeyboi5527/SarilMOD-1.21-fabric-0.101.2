package net.saril.sarilmod.world.tree;

import net.minecraft.block.SaplingGenerator;
import net.saril.sarilmod.SarilMod;
import net.saril.sarilmod.world.ModConfiguredFeatures;

import java.util.Optional;

public class ModSaplingGenerators {
    public static final SaplingGenerator STELLAR = new SaplingGenerator(SarilMod.MOD_ID + ":stellar",
            Optional.empty(), Optional.of(ModConfiguredFeatures.STELLAR_KEY), Optional.empty());
}
