package net.saril.sarilmod.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

public record MatterStabilizerRecipe(Ingredient inputItem, ItemStack output) implements Recipe<MatterStabilizerRecipeInput> {
    @Override
    public DefaultedList<Ingredient> getIngredients() {
        DefaultedList<Ingredient> list = DefaultedList.of();
        list.add(this.inputItem);
        return list;
    }

    @Override
    public boolean matches(MatterStabilizerRecipeInput input, World world) {
        if (world.isClient) {
            return false;
        }

        return inputItem.test(input.getStackInSlot(0));
    }

    @Override
    public ItemStack craft(MatterStabilizerRecipeInput input, RegistryWrapper.WrapperLookup lookup) {
        return output.copy();
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getResult(RegistryWrapper.WrapperLookup registriesLookup) {
        return output;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.MATTER_STABILIZER_SERIALIZER;
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.MATTER_STABILIZER_TYPE;
    }

    public static class Serializer implements RecipeSerializer<MatterStabilizerRecipe> {
        public static final MapCodec<MatterStabilizerRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
                Ingredient.DISALLOW_EMPTY_CODEC.fieldOf("ingredient").forGetter(MatterStabilizerRecipe::inputItem),
                ItemStack.CODEC.fieldOf("result").forGetter(MatterStabilizerRecipe::output)
        ).apply(inst, MatterStabilizerRecipe::new));

        public static final PacketCodec<RegistryByteBuf, MatterStabilizerRecipe> STREAM_CODEC =
                PacketCodec.tuple(
                        Ingredient.PACKET_CODEC, MatterStabilizerRecipe::inputItem,
                        ItemStack.PACKET_CODEC, MatterStabilizerRecipe::output,
                        MatterStabilizerRecipe::new);

        @Override
        public MapCodec<MatterStabilizerRecipe> codec() {
            return CODEC;
        }

        @Override
        public PacketCodec<RegistryByteBuf, MatterStabilizerRecipe> packetCodec() {
            return STREAM_CODEC;
        }
    }
}
