package net.saril.sarilmod.entity.client;

import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.entity.AnimationState;
import net.saril.sarilmod.entity.custom.MantisVariant;

public class MantisRenderState extends LivingEntityRenderState {
    public final AnimationState idleAnimationState = new AnimationState();
    public MantisVariant variant;
}
