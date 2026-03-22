package net.saril.sarilmod.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.saril.sarilmod.SarilMod;
import net.saril.sarilmod.block.custom.*;
import net.saril.sarilmod.sound.ModSounds;
import net.saril.sarilmod.world.tree.ModSaplingGenerators;

import java.util.function.Function;

public class ModBlocks {



    public static final Block SOLAR_MATTER_BLOCK = registerBlock("solar_matter_block",
            properties -> new Block(properties.strength(4f).requiresTool()));

    public static final Block UNSTABLE_SOLAR_MATTER_BLOCK = registerBlock("unstable_solar_matter_block",
            properties -> new Block(properties.strength(4f).requiresTool()));

    public static final Block UNSTABLE_SOLAR_MATTER_ORE = registerBlock("unstable_solar_matter_ore",
            properties -> new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
                    properties.strength(3f).requiresTool()));

    public static final Block DEEPSLATE_UNSTABLE_SOLAR_MATTER_ORE = registerBlock("deepslate_unstable_solar_matter_ore",
            properties -> new ExperienceDroppingBlock(UniformIntProvider.create(3, 6),
                    properties.strength(4f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));

    public static final Block UNSTABLE_SOLAR_MATTER_NETHER_ORE = registerBlock("unstable_solar_matter_nether_ore",
            properties -> new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
                    properties.strength(3f).requiresTool()));

    public static final Block UNSTABLE_SOLAR_MATTER_END_ORE = registerBlock("unstable_solar_matter_end_ore",
            properties -> new ExperienceDroppingBlock(UniformIntProvider.create(3, 6),
                    properties.strength(4f).requiresTool()));

    public static final Block MAGIC_BLOCK = registerBlock("magic_block",
            properties -> new MagicBlock(properties.strength(1f).requiresTool().sounds(ModSounds.MAGIC_BLOCK_SOUNDS)));

    public static final Block SOLAR_MATTER_LAMP = registerBlock("solar_matter_lamp",
            properties -> new SolarMatterLampBlock(properties.strength(1f).requiresTool()
                    .luminance(state -> state.get(SolarMatterLampBlock.CLICKED) ? 15 : 0)));

    public static final Block SOLAR_MATTER_STAIRS = registerBlock("solar_matter_stairs",
            properties -> new StairsBlock(ModBlocks.SOLAR_MATTER_BLOCK.getDefaultState(),
                    properties.strength(2f).requiresTool()));

    public static final Block SOLAR_MATTER_SLAB = registerBlock("solar_matter_slab",
            properties -> new SlabBlock(properties.strength(2f).requiresTool()));

    public static final Block SOLAR_MATTER_BUTTON = registerBlock("solar_matter_button",
            properties -> new ButtonBlock(BlockSetType.IRON, 5, properties.strength(2f).requiresTool().noCollision()));

    public static final Block SOLAR_MATTER_PRESSURE_PLATE = registerBlock("solar_matter_pressure_plate",
            properties -> new PressurePlateBlock(BlockSetType.IRON, properties.strength(2f).requiresTool()));

    public static final Block SOLAR_MATTER_FENCE = registerBlock("solar_matter_fence",
            properties -> new FenceBlock(properties.strength(2f).requiresTool()));

    public static final Block SOLAR_MATTER_FENCE_GATE = registerBlock("solar_matter_fence_gate",
            properties -> new FenceGateBlock(WoodType.SPRUCE, properties.strength(2f).requiresTool()));

    public static final Block SOLAR_MATTER_WALL = registerBlock("solar_matter_wall",
            properties -> new WallBlock(properties.strength(2f).requiresTool()));

    public static final Block SOLAR_MATTER_DOOR = registerBlock("solar_matter_door",
            properties -> new DoorBlock(BlockSetType.IRON, properties.strength(2f).requiresTool().nonOpaque()));

    public static final Block SOLAR_MATTER_TRAPDOOR = registerBlock("solar_matter_trapdoor",
            properties -> new TrapdoorBlock(BlockSetType.IRON, properties.strength(2f).requiresTool().nonOpaque()));

    public static final Block CAULIFLOWER_CROP = registerBlockWithoutBlockItem("cauliflower_crop",
            properties -> new CauliflowerCropBlock(properties.noCollision()
                    .ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP)
                    .pistonBehavior(PistonBehavior.DESTROY).mapColor(DyeColor.CYAN)));

    public static final Block BANANA_BUSH_BLOCK = registerBlockWithoutBlockItem("banana_bush",
            properties -> new BananaBushBlock(properties.noCollision()
                    .ticksRandomly().sounds(BlockSoundGroup.SWEET_BERRY_BUSH)
                    .pistonBehavior(PistonBehavior.BLOCK)));

    public static final Block STELLAR_LOG = registerBlock("stellar_log",
            properties -> new PillarBlock(properties
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F).sounds(BlockSoundGroup.WOOD)));

    public static final Block STELLAR_WOOD = registerBlock("stellar_wood",
            properties -> new PillarBlock(properties
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F).sounds(BlockSoundGroup.WOOD)));

    public static final Block STRIPPED_STELLAR_LOG = registerBlock("stripped_stellar_log",
            properties -> new PillarBlock(properties
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F).sounds(BlockSoundGroup.WOOD)));

    public static final Block STRIPPED_STELLAR_WOOD = registerBlock("stripped_stellar_wood",
            properties -> new PillarBlock(properties
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F).sounds(BlockSoundGroup.WOOD)));

    public static final Block STELLAR_PLANKS = registerBlock("stellar_planks",
            properties -> new Block(properties.strength(2f).sounds(BlockSoundGroup.WOOD)));

    public static final Block STELLAR_LEAVES = registerBlock("stellar_leaves",
            properties -> new LeavesBlock(properties
                    .mapColor(MapColor.DARK_GREEN).strength(0.2F).ticksRandomly()
                    .sounds(BlockSoundGroup.GRASS).nonOpaque()
                    .allowsSpawning(Blocks::canSpawnOnLeaves).suffocates(Blocks::never)
                    .blockVision(Blocks::never).pistonBehavior(PistonBehavior.IGNORE)
                    .solidBlock(Blocks::never)));

    public static final Block STELLAR_SAPLING = registerBlock("stellar_sapling",
            properties -> new ModSaplingBlock(ModSaplingGenerators.STELLAR, properties
                    .mapColor(MapColor.DARK_GREEN).noCollision().ticksRandomly().breakInstantly()
                    .sounds(BlockSoundGroup.GRASS).pistonBehavior(PistonBehavior.NORMAL), Blocks.NETHERITE_BLOCK));

    public static final Block CHAIR = registerBlock("chair",
            properties -> new ChairBlock(properties.nonOpaque()));

    public static final Block MATTER_STABILIZER = registerBlock("matter_stabilizer", MatterStabilizerBlock::new);



    private static Block registerBlock(String name, Function<AbstractBlock.Settings, Block> function) {
        Block toRegister = function.apply(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(SarilMod.MOD_ID, name))));
        registerBlockItem(name, toRegister);
        return Registry.register(Registries.BLOCK, Identifier.of(SarilMod.MOD_ID, name), toRegister);
    }

    private static Block registerBlockWithoutBlockItem(String name, Function<AbstractBlock.Settings, Block> function) {
        return Registry.register(Registries.BLOCK, Identifier.of(SarilMod.MOD_ID, name),
                function.apply(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(SarilMod.MOD_ID, name)))));
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(SarilMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings().useBlockPrefixedTranslationKey()
                        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(SarilMod.MOD_ID, name)))));
    }


    public static void registerModBlocks() {
        SarilMod.LOGGER.info("Registering Mod Blocks for " + SarilMod.MOD_ID);


        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.SOLAR_MATTER_BLOCK);
            entries.add(ModBlocks.UNSTABLE_SOLAR_MATTER_BLOCK);
            entries.add(ModBlocks.UNSTABLE_SOLAR_MATTER_ORE);
            entries.add(ModBlocks.DEEPSLATE_UNSTABLE_SOLAR_MATTER_ORE);
            entries.add(ModBlocks.MAGIC_BLOCK);
        });
    }


}
