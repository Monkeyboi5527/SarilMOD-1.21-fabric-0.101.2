package net.saril.sarilmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.saril.sarilmod.block.ModBlocks;
import net.saril.sarilmod.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
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
    }

    public LootTable.Builder multipleOreDrops(Block drop, Item item, float minDrops, float maxDrops) {
        RegistryWrapper.Impl<Enchantment> impl = this.registries.getOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(drop, this.applyExplosionDecay(drop, ((LeafEntry.Builder<?>)
                ItemEntry.builder(item).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops))))
                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))));
    }
}
