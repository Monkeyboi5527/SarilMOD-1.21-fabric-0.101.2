package net.saril.sarilmod.compat;

import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.client.registry.screen.ScreenRegistry;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.saril.sarilmod.block.ModBlocks;
import net.saril.sarilmod.recipe.MatterStabilizerRecipe;
import net.saril.sarilmod.recipe.ModRecipes;
import net.saril.sarilmod.screen.custom.MatterStabilizerScreen;

import java.awt.*;

public class SarilModREIClient implements REIClientPlugin {
    @Override
    public void registerCategories(CategoryRegistry registry) {
        registry.add(new MatterStabilizerCategory());

        registry.addWorkstations(MatterStabilizerCategory.MATTER_STABILIZER, EntryStacks.of(ModBlocks.MATTER_STABILIZER));
    }

    @Override
    public void registerDisplays(DisplayRegistry registry) {
        registry.registerRecipeFiller(MatterStabilizerRecipe.class, ModRecipes.MATTER_STABILIZER_TYPE,
                MatterStabilizerDisplay::new);
    }

    @Override
    public void registerScreens(ScreenRegistry registry) {
        registry.registerClickArea(screen -> new Rectangle(((screen.width - 176) / 2) + 78,
                        ((screen.height - 166) / 2) + 30, 20, 25), MatterStabilizerScreen.class,
                MatterStabilizerCategory.MATTER_STABILIZER);
    }
}