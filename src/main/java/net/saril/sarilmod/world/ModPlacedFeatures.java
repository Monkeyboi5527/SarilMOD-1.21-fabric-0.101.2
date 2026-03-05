package net.saril.sarilmod.world;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import net.saril.sarilmod.SarilMod;

import java.util.List;

public class ModPlacedFeatures {

    public static final RegistryKey<PlacedFeature> UNSTABLE_SOLAR_MATTER_ORE_PLACE_KEY = registerKey("unstable_solar_matter_ore_placed_key");
    public static final RegistryKey<PlacedFeature> UNSTABLE_SOLAR_MATTER_NETHER_ORE_PLACE_KEY = registerKey("unstable_solar_matter_nether_ore_placed_key");
    public static final RegistryKey<PlacedFeature> UNSTABLE_SOLAR_MATTER_END_ORE_PLACE_KEY = registerKey("unstable_solar_matter_end_ore_placed_key");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatures = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, UNSTABLE_SOLAR_MATTER_ORE_PLACE_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.UNSTABLE_SOLAR_MATTER_ORE_KEY),
                ModOrePlacement.modifiersWithCount(14,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))));
        register(context, UNSTABLE_SOLAR_MATTER_NETHER_ORE_PLACE_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.UNSTABLE_SOLAR_MATTER_NETHER_ORE_KEY),
                ModOrePlacement.modifiersWithCount(14,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))));
        register(context, UNSTABLE_SOLAR_MATTER_END_ORE_PLACE_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.UNSTABLE_SOLAR_MATTER_END_ORE_KEY),
                ModOrePlacement.modifiersWithCount(14,
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(-80), YOffset.fixed(80))));

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
