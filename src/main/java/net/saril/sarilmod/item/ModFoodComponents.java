package net.saril.sarilmod.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static FoodComponent BANANA =
            new FoodComponent.Builder().nutrition(6)
                    .saturationModifier(.45f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 600), 1)
                    .build();
}
