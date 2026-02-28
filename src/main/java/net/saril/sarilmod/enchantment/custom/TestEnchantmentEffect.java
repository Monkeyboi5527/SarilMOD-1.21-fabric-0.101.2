package net.saril.sarilmod.enchantment.custom;

import com.mojang.authlib.GameProfile;
import com.mojang.serialization.MapCodec;
import net.minecraft.enchantment.EnchantmentEffectContext;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.dragon.EnderDragonFight;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Optional;

public record TestEnchantmentEffect() implements EnchantmentEntityEffect{
    public static final MapCodec<TestEnchantmentEffect> CODEC = MapCodec.unit(TestEnchantmentEffect::new);

    @Override
    public void apply(ServerWorld world, int level, EnchantmentEffectContext context, Entity user, Vec3d pos) {

        World.ExplosionSourceType sourceType = World.ExplosionSourceType.TNT;
        PlayerEntity player = new PlayerEntity(world,user.getBlockPos(),2f,new GameProfile(user.getUuid(), "skibidi")) {
            @Override
            public boolean isSpectator() {
                return false;
            }

            @Override
            public boolean isCreative() {
                return false;
            }
        };
        if(world.isClient) {
            world.createExplosion(user, user.getX(), user.getY(), user.getZ(), 3f, sourceType);
        }
        if (level == 1){
            world.createExplosion(user, user.getX(), user.getY(), user.getZ(), 3f, sourceType);
        }
        if (level == 2){
            world.createExplosion(user, user.getX(), user.getY(), user.getZ(), 3f, sourceType);
            world.createExplosion(user, user.getX(), user.getY(), user.getZ(), 3f, sourceType);
        }
        if (level == 3){
            world.createExplosion(user, user.getX(), user.getY(), user.getZ(), 30f, sourceType);

        }
        if (level == 4){
            world.setEnderDragonFight(new EnderDragonFight(world, 10L,
                    new EnderDragonFight.Data(true,true,true,true,
                            Optional.ofNullable(user.getUuid()), Optional.of(user.getBlockPos()), Optional.of(new ArrayList<>()))));
            // This doesn't work either
            player.sendMessage(Text.literal("This lowkey was supposed to spawn the EnderDragon or something but couldn't get it to work"));


        }
    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> getCodec() {
        return CODEC;
    }

}
