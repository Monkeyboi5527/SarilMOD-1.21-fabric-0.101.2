package net.saril.sarilmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeGenerator;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import net.saril.sarilmod.SarilMod;
import net.saril.sarilmod.block.ModBlocks;
import net.saril.sarilmod.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {


    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            @Override
            public void generate() {
                List<ItemConvertible> SOLAR_SMELTABLE = List.of(
                        ModItems.UNSTABLE_SOLAR_MATTER,
                        ModBlocks.UNSTABLE_SOLAR_MATTER_ORE,
                        ModBlocks.DEEPSLATE_UNSTABLE_SOLAR_MATTER_ORE);

                offerSmelting( SOLAR_SMELTABLE, RecipeCategory.MISC,
                        ModItems.UNSTABLE_SOLAR_MATTER, 0.5f, 600, "solar_matter_from_smelting");

                offerBlasting( SOLAR_SMELTABLE, RecipeCategory.MISC,
                        ModItems.UNSTABLE_SOLAR_MATTER, 0.5f, 300, "solar_matter_from_blasting");


                offerReversibleCompactingRecipes(
                        RecipeCategory.BUILDING_BLOCKS,
                        ModItems.SOLAR_MATTER,
                        RecipeCategory.DECORATIONS,
                        ModBlocks.SOLAR_MATTER_BLOCK
                );

                offerReversibleCompactingRecipes(
                        RecipeCategory.BUILDING_BLOCKS,
                        ModItems.UNSTABLE_SOLAR_MATTER,
                        RecipeCategory.DECORATIONS,
                        ModBlocks.UNSTABLE_SOLAR_MATTER_BLOCK
                );


                createShaped(RecipeCategory.MISC, ModItems.CHISEL)
                        .pattern(" # ")
                        .pattern(" # ")
                        .pattern(" I ")
                        .input('#', Items.STICK)
                        .input('I', Items.IRON_INGOT)
                        .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                        .offerTo(exporter);

                offerSmithingTrimRecipe( ModItems.SKL_SMITHING_TEMPLATE,
                        RegistryKey.of(RegistryKeys.RECIPE, Identifier.ofVanilla(getItemPath(ModItems.SKL_SMITHING_TEMPLATE) + "-smithing_trim")));



            }
        };


    }



    @Override
    public String getName() {
        return "Sarilmod ";
    }
}
