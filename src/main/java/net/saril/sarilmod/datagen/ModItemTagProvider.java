package net.saril.sarilmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.saril.sarilmod.item.ModItems;
import net.saril.sarilmod.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {


    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ModTags.Items.TRANSFORMABLE_ITEMS)
            .add(ModItems.SOLAR_MATTER)
            .add(ModItems.UNSTABLE_SOLAR_MATTER)
            .add(Items.STICK)
            .add(Items.MACE)
            .add(Items.APPLE);

        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.SOLAR_MATTER_SWORD);
        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.SOLAR_MATTER_PICKAXE);
        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(ModItems.SOLAR_MATTER_SHOVEL);
        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.SOLAR_MATTER_AXE);
        getOrCreateTagBuilder(ItemTags.HOES)
                .add(ModItems.SOLAR_MATTER_HOE);

        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.SOLAR_MATTER_HELMET)
                .add(ModItems.SOLAR_MATTER_CHESTPLATE)
                .add(ModItems.SOLAR_MATTER_LEGGINGS)
                .add(ModItems.SOLAR_MATTER_BOOTS);

        getOrCreateTagBuilder(ItemTags.TRIM_MATERIALS)
                .add(ModItems.SOLAR_MATTER);

        getOrCreateTagBuilder(ItemTags.TRIM_TEMPLATES)
                .add(ModItems.SKL_SMITHING_TEMPLATE);

        getOrCreateTagBuilder(ModTags.Items.SOLAR_MATTER_REPAIR)
                .add(ModItems.SOLAR_MATTER);

    }
}
