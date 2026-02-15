package net.saril.sarilmod.util;

import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.util.Identifier;
import net.saril.sarilmod.SarilMod;
import net.saril.sarilmod.component.ModDataComponentTypes;
import net.saril.sarilmod.item.ModItems;

public class ModModelPredicates {
    public static void registerModelPredicates() {
        ModelPredicateProviderRegistry.register(ModItems.CHISEL, Identifier.of(SarilMod.MOD_ID, "used"),
                (stack, world, entity, seed) -> stack.get(ModDataComponentTypes.COORDINATES) != null ? 1f : 0f);
    }

}
