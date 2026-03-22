package net.saril.sarilmod.compat;

import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.Display;
import me.shedaniel.rei.api.common.display.DisplaySerializer;
import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.minecraft.recipe.RecipeEntry;
import net.saril.sarilmod.recipe.MatterStabilizerRecipe;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MatterStabilizerDisplay extends BasicDisplay {
    public MatterStabilizerDisplay(RecipeEntry<MatterStabilizerRecipe> recipe) {
        super(List.of(EntryIngredients.ofIngredient(recipe.value().getIngredients().get(0))),
        List.of(EntryIngredient.of(EntryStacks.of(recipe.value().output()))));
    }

    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return MatterStabilizerCategory.MATTER_STABILIZER;
    }

    @Override
    public @Nullable DisplaySerializer<? extends Display> getSerializer() {
        return null;
    }


}
