package net.saril.sarilmod.world;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;
import net.saril.sarilmod.SarilMod;
import net.saril.sarilmod.block.ModBlocks;

import java.util.List;

public class ModPlacedFeatures {

    public static final RegistryKey<PlacedFeature> UNSTABLE_SOLAR_MATTER_ORE_PLACED_KEY = registerKey("unstable_solar_matter_ore_placed_key");
    public static final RegistryKey<PlacedFeature> UNSTABLE_SOLAR_MATTER_NETHER_ORE_PLACED_KEY = registerKey("unstable_solar_matter_nether_ore_placed_key");
    public static final RegistryKey<PlacedFeature> UNSTABLE_SOLAR_MATTER_END_ORE_PLACED_KEY = registerKey("unstable_solar_matter_end_ore_placed_key");

    public static final RegistryKey<PlacedFeature> STELLAR_PLACED_KEY = registerKey("stellar_placed_key");

    public static final RegistryKey<PlacedFeature> BANANA_BUSH_PLACED_KEY = registerKey("banana_bush_placed_key");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatures = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, UNSTABLE_SOLAR_MATTER_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.UNSTABLE_SOLAR_MATTER_ORE_KEY),
                ModOrePlacement.modifiersWithCount(14,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))));
        register(context, UNSTABLE_SOLAR_MATTER_NETHER_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.UNSTABLE_SOLAR_MATTER_NETHER_ORE_KEY),
                ModOrePlacement.modifiersWithCount(14,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))));
        register(context, UNSTABLE_SOLAR_MATTER_END_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.UNSTABLE_SOLAR_MATTER_END_ORE_KEY),
                ModOrePlacement.modifiersWithCount(14,
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(-80), YOffset.fixed(80))));

        register(context, STELLAR_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.STELLAR_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                        PlacedFeatures.createCountExtraModifier(2, 0.2f, 2), ModBlocks.STELLAR_SAPLING)
        );

        register(context, BANANA_BUSH_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.BANANA_BUSH_KEY),
                RarityFilterPlacementModifier.of(32), SquarePlacementModifier.of(),
                PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(SarilMod.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                                                                   RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                                                                   PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}
