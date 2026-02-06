package net.saril.sarilmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.saril.sarilmod.block.ModBlocks;
import net.saril.sarilmod.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.SOLAR_MATTER_BLOCK)
                .add(ModBlocks.UNSTABLE_SOLAR_MATTER_BLOCK)
                .add(ModBlocks.UNSTABLE_SOLAR_MATTER_ORE)
                .add(ModBlocks.DEEPSLATE_UNSTABLE_SOLAR_MATTER_ORE)
                .add(ModBlocks.MAGIC_BLOCK);


        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.SOLAR_MATTER_BLOCK)
                .add(ModBlocks.UNSTABLE_SOLAR_MATTER_BLOCK)
                .add(ModBlocks.UNSTABLE_SOLAR_MATTER_ORE)
                .add(ModBlocks.DEEPSLATE_UNSTABLE_SOLAR_MATTER_ORE);

        getOrCreateTagBuilder(BlockTags.FENCE_GATES).add(ModBlocks.SOLAR_MATTER_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCES).add(ModBlocks.SOLAR_MATTER_FENCE_GATE);
        getOrCreateTagBuilder(BlockTags.WALLS).add(ModBlocks.SOLAR_MATTER_WALL);

        getOrCreateTagBuilder(ModTags.Blocks.NEEDS_SOLAR_MATTER_TOOl)
                .add(ModBlocks.MAGIC_BLOCK)
                .add(BlockTags.NEEDS_DIAMOND_TOOL.id());

    }
}
