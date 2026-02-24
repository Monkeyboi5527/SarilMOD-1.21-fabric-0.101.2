package net.saril.sarilmod.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.saril.sarilmod.SarilMod;
import net.saril.sarilmod.block.custom.MagicBlock;
import net.saril.sarilmod.block.custom.SolarMatterLampBlock;
import net.saril.sarilmod.sound.ModSounds;

public class ModBlocks {

    // ========= CORE BLOCKS =========

    public static final Block SOLAR_MATTER_BLOCK = registerBlock("solar_matter_block",
            new Block(AbstractBlock.Settings.copy(Blocks.NETHERITE_BLOCK)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK,
                            Identifier.of(SarilMod.MOD_ID, "solar_matter_block")))));

    public static final Block UNSTABLE_SOLAR_MATTER_BLOCK = registerBlock("unstable_solar_matter_block",
            new Block(AbstractBlock.Settings.copy(Blocks.NETHERITE_BLOCK)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK,
                            Identifier.of(SarilMod.MOD_ID, "unstable_solar_matter_block")))));

    public static final Block UNSTABLE_SOLAR_MATTER_ORE = registerBlock("unstable_solar_matter_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
                    AbstractBlock.Settings.copy(Blocks.ANCIENT_DEBRIS)
                            .registryKey(RegistryKey.of(RegistryKeys.BLOCK,
                                    Identifier.of(SarilMod.MOD_ID, "unstable_solar_matter_ore")))));

    public static final Block DEEPSLATE_UNSTABLE_SOLAR_MATTER_ORE = registerBlock("deepslate_unstable_solar_matter_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(3, 6),
                    AbstractBlock.Settings.copy(Blocks.ANCIENT_DEBRIS)
                            .registryKey(RegistryKey.of(RegistryKeys.BLOCK,
                                    Identifier.of(SarilMod.MOD_ID, "deepslate_unstable_solar_matter_ore")))));

    public static final Block MAGIC_BLOCK = registerBlock("magic_block",
            new MagicBlock(AbstractBlock.Settings.copy(Blocks.NETHERITE_BLOCK)
                    .sounds(ModSounds.MAGIC_BLOCK_SOUNDS)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK,
                            Identifier.of(SarilMod.MOD_ID, "magic_block")))));

    public static final Block SOLAR_MATTER_LAMP = registerBlock("solar_matter_lamp",
            new SolarMatterLampBlock(AbstractBlock.Settings.copy(Blocks.NETHERITE_BLOCK)
                    .luminance(state -> state.get(SolarMatterLampBlock.CLICKED) ? 15 : 0)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK,
                            Identifier.of(SarilMod.MOD_ID, "solar_matter_lamp")))));

    // ========= BUILDING VARIANTS =========

    public static final Block SOLAR_MATTER_STAIRS = registerBlock("solar_matter_stairs",
            new StairsBlock(SOLAR_MATTER_BLOCK.getDefaultState(),
                    AbstractBlock.Settings.copy(Blocks.NETHERITE_BLOCK)
                            .registryKey(RegistryKey.of(RegistryKeys.BLOCK,
                                    Identifier.of(SarilMod.MOD_ID, "solar_matter_stairs")))));

    public static final Block SOLAR_MATTER_SLAB = registerBlock("solar_matter_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.NETHERITE_BLOCK)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK,
                            Identifier.of(SarilMod.MOD_ID, "solar_matter_slab")))));

    public static final Block SOLAR_MATTER_BUTTON = registerBlock("solar_matter_button",
            new ButtonBlock(BlockSetType.IRON, 5,
                    AbstractBlock.Settings.copy(Blocks.NETHERITE_BLOCK)
                            .noCollision()
                            .registryKey(RegistryKey.of(RegistryKeys.BLOCK,
                                    Identifier.of(SarilMod.MOD_ID, "solar_matter_button")))));

    public static final Block SOLAR_MATTER_PRESSURE_PLATE = registerBlock("solar_matter_pressure_plate",
            new PressurePlateBlock(BlockSetType.IRON,
                    AbstractBlock.Settings.copy(Blocks.NETHERITE_BLOCK)
                            .noCollision()
                            .registryKey(RegistryKey.of(RegistryKeys.BLOCK,
                                    Identifier.of(SarilMod.MOD_ID, "solar_matter_pressure_plate")))));

    public static final Block SOLAR_MATTER_FENCE = registerBlock("solar_matter_fence",
            new FenceBlock(AbstractBlock.Settings.copy(Blocks.NETHERITE_BLOCK)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK,
                            Identifier.of(SarilMod.MOD_ID, "solar_matter_fence")))));

    public static final Block SOLAR_MATTER_FENCE_GATE = registerBlock("solar_matter_fence_gate",
            new FenceGateBlock(WoodType.SPRUCE,
                    AbstractBlock.Settings.copy(Blocks.NETHERITE_BLOCK)
                            .registryKey(RegistryKey.of(RegistryKeys.BLOCK,
                                    Identifier.of(SarilMod.MOD_ID, "solar_matter_fence_gate")))));

    public static final Block SOLAR_MATTER_WALL = registerBlock("solar_matter_wall",
            new WallBlock(AbstractBlock.Settings.copy(Blocks.NETHERITE_BLOCK)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK,
                            Identifier.of(SarilMod.MOD_ID, "solar_matter_wall")))));

    public static final Block SOLAR_MATTER_DOOR = registerBlock("solar_matter_door",
            new DoorBlock(BlockSetType.IRON,
                    AbstractBlock.Settings.copy(Blocks.NETHERITE_BLOCK)
                            .nonOpaque()
                            .registryKey(RegistryKey.of(RegistryKeys.BLOCK,
                                    Identifier.of(SarilMod.MOD_ID, "solar_matter_door")))));

    public static final Block SOLAR_MATTER_TRAPDOOR = registerBlock("solar_matter_trapdoor",
            new TrapdoorBlock(BlockSetType.IRON,
                    AbstractBlock.Settings.copy(Blocks.NETHERITE_BLOCK)
                            .nonOpaque()
                            .registryKey(RegistryKey.of(RegistryKeys.BLOCK,
                                    Identifier.of(SarilMod.MOD_ID, "solar_matter_trapdoor")))));

    // ========= REGISTRATION =========

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK,
                Identifier.of(SarilMod.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM,
                Identifier.of(SarilMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()
                        .registryKey(RegistryKey.of(RegistryKeys.ITEM,
                                Identifier.of(SarilMod.MOD_ID, name))).useBlockPrefixedTranslationKey()));
    }

    public static void registerModBlocks() {
        SarilMod.LOGGER.info("Registering Mod Blocks for " + SarilMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(SOLAR_MATTER_BLOCK);
            entries.add(UNSTABLE_SOLAR_MATTER_BLOCK);
            entries.add(UNSTABLE_SOLAR_MATTER_ORE);
            entries.add(DEEPSLATE_UNSTABLE_SOLAR_MATTER_ORE);
            entries.add(MAGIC_BLOCK);
        });
    }
}