package net.saril.sarilmod.particle;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.saril.sarilmod.SarilMod;

public class ModParticles {

    public static final SimpleParticleType SOLAR_MATTER_PARTICLE =
            registerParticle("solar_matter_particle", FabricParticleTypes.simple(true));

    private static SimpleParticleType registerParticle(String name ,SimpleParticleType particleType){
        return Registry.register(Registries.PARTICLE_TYPE, Identifier.of(SarilMod.MOD_ID, name), particleType);
    }

    public static void registerParticles() {
        SarilMod.LOGGER.info("Registering Particles for " + SarilMod.MOD_ID);
    }
}
