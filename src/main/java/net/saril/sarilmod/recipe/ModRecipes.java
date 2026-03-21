package net.saril.sarilmod.recipe;

import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.saril.sarilmod.SarilMod;

public class ModRecipes {
    public static final RecipeSerializer<MatterStabilizerRecipe> MATTER_STABILIZER_SERIALIZER =
            Registry.register(Registries.RECIPE_SERIALIZER, Identifier.of(SarilMod.MOD_ID, "matter_stabilizer"),
                    new MatterStabilizerRecipe.Serializer());
    public static final RecipeType<MatterStabilizerRecipe> MATTER_STABILIZER_TYPE =
            Registry.register(Registries.RECIPE_TYPE, Identifier.of(SarilMod.MOD_ID, "matter_stabilizer"),
                    new RecipeType<MatterStabilizerRecipe>() {
                @Override
                        public String toString() {
                    return "matter_stabilizer";
                }
                    });

    public static void registerRecipes() {
        SarilMod.LOGGER.info("Registering ModRecipes");
    }
}
