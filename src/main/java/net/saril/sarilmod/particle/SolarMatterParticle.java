package net.saril.sarilmod.particle;

import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.util.math.random.Random;
import org.jetbrains.annotations.Nullable;

public class SolarMatterParticle extends BillboardParticle {
    protected SolarMatterParticle(ClientWorld clientWorld, double x, double y, double z,
                                  SpriteProvider spriteProvider, double xSpeed, double ySpeed, double zSpeed) {
        super(clientWorld, x, y, z, xSpeed, ySpeed, zSpeed, spriteProvider.getFirst());

        this.maxAge = 40;

        this.red = 1.0F;
        this.green = 1.0F;
        this.blue = 1.0F;
    }


    @Override
    protected RenderType getRenderType() {
        return RenderType.BLOCK_ATLAS_TRANSLUCENT;
    }


    public static class Factory implements ParticleFactory<SimpleParticleType>{
        private final SpriteProvider spriteProvider;
        public Factory(SpriteProvider spriteProvider) {
            this.spriteProvider = spriteProvider;
        }

        @Override
        public @Nullable Particle createParticle(SimpleParticleType parameters, ClientWorld world, double x, double y, double z,
                                                 double velocityX, double velocityY, double velocityZ, Random random) {
            return new SolarMatterParticle(world, x, y, z, spriteProvider, velocityX, velocityY, velocityZ);
        }
    }
}
