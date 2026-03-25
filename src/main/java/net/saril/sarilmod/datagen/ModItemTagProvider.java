package net.saril.sarilmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.saril.sarilmod.block.ModBlocks;
import net.saril.sarilmod.item.ModItems;
import net.saril.sarilmod.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {


    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        valueLookupBuilder(ModTags.Items.TRANSFORMABLE_ITEMS)
            .add(ModItems.SOLAR_MATTER)
            .add(ModItems.UNSTABLE_SOLAR_MATTER)
            .add(Items.STICK)
            .add(Items.MACE)
            .add(Items.APPLE);

        valueLookupBuilder(ItemTags.SWORDS)
                .add(ModItems.SOLAR_MATTER_SWORD);
        valueLookupBuilder(ItemTags.PICKAXES)
                .add(ModItems.SOLAR_MATTER_PICKAXE);
        valueLookupBuilder(ItemTags.SHOVELS)
                .add(ModItems.SOLAR_MATTER_SHOVEL);
        valueLookupBuilder(ItemTags.AXES)
                .add(ModItems.SOLAR_MATTER_AXE);
        valueLookupBuilder(ItemTags.HOES)
                .add(ModItems.SOLAR_MATTER_HOE);

        valueLookupBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.SOLAR_MATTER_HELMET)
                .add(ModItems.SOLAR_MATTER_CHESTPLATE)
                .add(ModItems.SOLAR_MATTER_LEGGINGS)
                .add(ModItems.SOLAR_MATTER_BOOTS);

        valueLookupBuilder(ItemTags.TRIM_MATERIALS)
                .add(ModItems.SOLAR_MATTER);


        valueLookupBuilder(ItemTags.LOGS)
                .add(ModBlocks.STELLAR_LOG.asItem())
                .add(ModBlocks.STELLAR_WOOD.asItem())
                .add(ModBlocks.STRIPPED_STELLAR_LOG.asItem())
                .add(ModBlocks.STRIPPED_STELLAR_WOOD.asItem());


        valueLookupBuilder(ItemTags.PLANKS)
                .add(ModBlocks.STELLAR_PLANKS.asItem());

        valueLookupBuilder(ModTags.Items.SOLAR_MATTER_REPAIR)
                .add(ModItems.SOLAR_MATTER);

    }
}
