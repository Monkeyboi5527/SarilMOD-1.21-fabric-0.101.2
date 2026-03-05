package net.saril.sarilmod.world;

import com.google.common.collect.Lists;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.saril.sarilmod.SarilMod;
import net.saril.sarilmod.block.ModBlocks;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?,?>> UNSTABLE_SOLAR_MATTER_ORE_KEY = registerKey("unstable_solar_matter_ore");
    public static final RegistryKey<ConfiguredFeature<?,?>> UNSTABLE_SOLAR_MATTER_NETHER_ORE_KEY = registerKey("unstable_solar_matter_nether_ore");
    public static final RegistryKey<ConfiguredFeature<?,?>> UNSTABLE_SOLAR_MATTER_END_ORE_KEY = registerKey("unstable_solar_matter_end_ore");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherReplaceables = new TagMatchRuleTest(BlockTags.BASE_STONE_NETHER);
        RuleTest endReplaceables = new BlockMatchRuleTest(Blocks.END_STONE);

        List<OreFeatureConfig.Target> overworldSolarMatterOre =
                Lists.newArrayList(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.UNSTABLE_SOLAR_MATTER_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.DEEPSLATE_UNSTABLE_SOLAR_MATTER_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> netherSolarMatterOre =
                Lists.newArrayList(OreFeatureConfig.createTarget(netherReplaceables, ModBlocks.UNSTABLE_SOLAR_MATTER_NETHER_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> endSolarMatterOre =
                Lists.newArrayList(OreFeatureConfig.createTarget(endReplaceables, ModBlocks.UNSTABLE_SOLAR_MATTER_END_ORE.getDefaultState()));
        register(context, UNSTABLE_SOLAR_MATTER_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldSolarMatterOre, 12));
        register(context, UNSTABLE_SOLAR_MATTER_NETHER_ORE_KEY, Feature.ORE, new OreFeatureConfig(netherSolarMatterOre, 9));
        register(context, UNSTABLE_SOLAR_MATTER_END_ORE_KEY, Feature.ORE, new OreFeatureConfig(endSolarMatterOre, 24));

    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(SarilMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
