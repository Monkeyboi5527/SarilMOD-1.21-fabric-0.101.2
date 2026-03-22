package net.saril.sarilmod.item;

import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;

import java.util.List;

public class ModFoodComponents {
    public static final FoodComponent BANANA = new FoodComponent.Builder().nutrition(30).saturationModifier(20f).alwaysEdible().build();

    public static final ConsumableComponent BANANA_EFFECT = ConsumableComponents.food().consumeEffect(
            new ApplyEffectsConsumeEffect(List.of(
                    new StatusEffectInstance(StatusEffects.REGENERATION, 400, 25),
                    new StatusEffectInstance(StatusEffects.RESISTANCE, 6000, 25),
                    new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 6000, 25),
                    new StatusEffectInstance(StatusEffects.ABSORPTION, 2400, 25),
                    new StatusEffectInstance(StatusEffects.SPEED, 2400, 5),
                    new StatusEffectInstance(StatusEffects.JUMP_BOOST, 2400, 5),
                    new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 2400, 25)))).build();

}
