package net.saril.sarilmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SweetBerryBushBlock;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.saril.sarilmod.block.ModBlocks;
import net.saril.sarilmod.block.custom.BananaBushBlock;
import net.saril.sarilmod.block.custom.CauliflowerCropBlock;
import net.saril.sarilmod.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        addDrop(ModBlocks.SOLAR_MATTER_BLOCK);
        addDrop(ModBlocks.UNSTABLE_SOLAR_MATTER_BLOCK);
        addDrop(ModBlocks.MAGIC_BLOCK);

        addDrop(ModBlocks.SOLAR_MATTER_STAIRS);
        addDrop(ModBlocks.SOLAR_MATTER_SLAB, slabDrops(ModBlocks.SOLAR_MATTER_SLAB));

        addDrop(ModBlocks.SOLAR_MATTER_BUTTON);
        addDrop(ModBlocks.SOLAR_MATTER_PRESSURE_PLATE);

        addDrop(ModBlocks.SOLAR_MATTER_FENCE);
        addDrop(ModBlocks.SOLAR_MATTER_FENCE_GATE);

        addDrop(ModBlocks.SOLAR_MATTER_WALL);
        addDrop(ModBlocks.SOLAR_MATTER_DOOR, doorDrops(ModBlocks.SOLAR_MATTER_DOOR));

        addDrop(ModBlocks.SOLAR_MATTER_TRAPDOOR);

        addDrop(ModBlocks.UNSTABLE_SOLAR_MATTER_ORE, oreDrops(ModBlocks.UNSTABLE_SOLAR_MATTER_ORE, ModItems.UNSTABLE_SOLAR_MATTER));
        addDrop(ModBlocks.DEEPSLATE_UNSTABLE_SOLAR_MATTER_ORE, multipleOreDrops(ModBlocks.DEEPSLATE_UNSTABLE_SOLAR_MATTER_ORE, ModItems.UNSTABLE_SOLAR_MATTER, 1, 3));
        addDrop(ModBlocks.UNSTABLE_SOLAR_MATTER_NETHER_ORE, multipleOreDrops(ModBlocks.UNSTABLE_SOLAR_MATTER_NETHER_ORE, ModItems.UNSTABLE_SOLAR_MATTER, 2, 4));
        addDrop(ModBlocks.UNSTABLE_SOLAR_MATTER_END_ORE, multipleOreDrops(ModBlocks.UNSTABLE_SOLAR_MATTER_END_ORE, ModItems.UNSTABLE_SOLAR_MATTER, 2, 4));

        BlockStatePropertyLootCondition.Builder builder2 = BlockStatePropertyLootCondition.builder(ModBlocks.CAULIFLOWER_CROP)
                .properties(StatePredicate.Builder.create().exactMatch(CauliflowerCropBlock.AGE, CauliflowerCropBlock.MAX_AGE));
        this.addDrop(ModBlocks.CAULIFLOWER_CROP, this.cropDrops(ModBlocks.CAULIFLOWER_CROP, ModItems.BANANA, ModItems.CAULIFLOWER_SEEDS, builder2));

        this.addDrop(ModBlocks.BANANA_BUSH_BLOCK, (block) -> (LootTable.Builder)this.applyExplosionDecay(block, LootTable.builder().pool(LootPool.builder().conditionally(BlockStatePropertyLootCondition.builder(ModBlocks.BANANA_BUSH_BLOCK).properties(StatePredicate.Builder.create().exactMatch(BananaBushBlock.AGE, 3))).with(ItemEntry.builder(ModItems.BANANA)).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0F, 3.0F))).apply(ApplyBonusLootFunction.uniformBonusCount(impl.getOrThrow(Enchantments.FORTUNE)))).pool(LootPool.builder().conditionally(BlockStatePropertyLootCondition.builder(ModBlocks.BANANA_BUSH_BLOCK).properties(StatePredicate.Builder.create().exactMatch(SweetBerryBushBlock.AGE, 2))).with(ItemEntry.builder(ModItems.BANANA)).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 2.0F))).apply(ApplyBonusLootFunction.uniformBonusCount(impl.getOrThrow(Enchantments.FORTUNE))))));


        addDrop(ModBlocks.STELLAR_LOG);
        addDrop(ModBlocks.STELLAR_WOOD);
        addDrop(ModBlocks.STRIPPED_STELLAR_LOG);
        addDrop(ModBlocks.STRIPPED_STELLAR_WOOD);
        addDrop(ModBlocks.STELLAR_PLANKS);
        addDrop(ModBlocks.STELLAR_SAPLING);

        addDrop(ModBlocks.STELLAR_LEAVES, leavesDrops(ModBlocks.STELLAR_LEAVES, ModBlocks.STELLAR_SAPLING, 0.0625f));
    }

    public LootTable.Builder multipleOreDrops(Block drop, Item item, float minDrops, float maxDrops) {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(drop, this.applyExplosionDecay(drop, ((LeafEntry.Builder<?>)
                ItemEntry.builder(item).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops))))
                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))));
    }
}
