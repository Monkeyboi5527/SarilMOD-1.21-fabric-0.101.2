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
        valueLookupBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.SOLAR_MATTER_BLOCK)
                .add(ModBlocks.UNSTABLE_SOLAR_MATTER_BLOCK)
                .add(ModBlocks.UNSTABLE_SOLAR_MATTER_ORE)
                .add(ModBlocks.DEEPSLATE_UNSTABLE_SOLAR_MATTER_ORE)
                .add(ModBlocks.MAGIC_BLOCK);


        valueLookupBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.SOLAR_MATTER_BLOCK)
                .add(ModBlocks.UNSTABLE_SOLAR_MATTER_BLOCK)
                .add(ModBlocks.UNSTABLE_SOLAR_MATTER_ORE)
                .add(ModBlocks.DEEPSLATE_UNSTABLE_SOLAR_MATTER_ORE);

        valueLookupBuilder(BlockTags.FENCE_GATES).add(ModBlocks.SOLAR_MATTER_FENCE);
        valueLookupBuilder(BlockTags.FENCES).add(ModBlocks.SOLAR_MATTER_FENCE_GATE);
        valueLookupBuilder(BlockTags.WALLS).add(ModBlocks.SOLAR_MATTER_WALL);

        valueLookupBuilder(ModTags.Blocks.NEEDS_SOLAR_MATTER_TOOl)
                .add(ModBlocks.MAGIC_BLOCK)
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL);

        valueLookupBuilder(BlockTags.LOGS)
                .add(ModBlocks.STELLAR_LOG)
                .add(ModBlocks.STELLAR_WOOD)
                .add(ModBlocks.STRIPPED_STELLAR_LOG)
                .add(ModBlocks.STRIPPED_STELLAR_WOOD);
    }
}
