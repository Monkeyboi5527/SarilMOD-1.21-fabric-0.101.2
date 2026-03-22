package net.saril.sarilmod.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.recipe.*;
import net.minecraft.recipe.book.RecipeBookCategories;
import net.minecraft.recipe.book.RecipeBookCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

public record MatterStabilizerRecipe(Ingredient inputItem, ItemStack output) implements Recipe<MatterStabilizerRecipeInput> {

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
    public RecipeSerializer< ? extends Recipe<MatterStabilizerRecipeInput>> getSerializer() {
        return ModRecipes.MATTER_STABILIZER_SERIALIZER;
    }

    @Override
    public RecipeType<? extends Recipe<MatterStabilizerRecipeInput>> getType() {
        return ModRecipes.MATTER_STABILIZER_TYPE;
    }

    @Override
    public IngredientPlacement getIngredientPlacement() {
        return IngredientPlacement.forSingleSlot(inputItem);
    }

    @Override
    public RecipeBookCategory getRecipeBookCategory() {
        return RecipeBookCategories.CRAFTING_MISC;
    }

    public static class Serializer implements RecipeSerializer<MatterStabilizerRecipe> {
        public static final MapCodec<MatterStabilizerRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
                Ingredient.CODEC.fieldOf("ingredient").forGetter(MatterStabilizerRecipe::inputItem),
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
