package net.saril.sarilmod.potion;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.saril.sarilmod.SarilMod;
import net.saril.sarilmod.effect.ModEffects;

public class ModPotions {

    public static RegistryEntry<Potion> SLIMEY_POTION = registerPotion("slimey_potion",
            new Potion(new StatusEffectInstance(ModEffects.SLIMEY, 1200, 0)));

    private static RegistryEntry<Potion> registerPotion(String name, Potion potion) {
        return Registry.registerReference(Registries.POTION, Identifier.of(SarilMod.MOD_ID, name), potion);
    }

    public static void registerPotions() {
        SarilMod.LOGGER.info("Registering ModPotions for: " + SarilMod.MOD_ID);
    }
}
