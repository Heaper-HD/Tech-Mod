package net.heaper.tech_mod.world;

import net.heaper.tech_mod.Tech_mod;
import net.heaper.tech_mod.block.ModBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import java.util.List;

public class ModConfiguredFeatures {
    public static RegistryKey<ConfiguredFeature<?, ?>> ORE_URANIUM_SMALL = registryKey("uranium_ore_small");
    public static RegistryKey<ConfiguredFeature<?, ?>> ORE_URANIUM_MEDIUM = registryKey("uranium_ore_medium");
    public static RegistryKey<ConfiguredFeature<?, ?>> ORE_URANIUM_LARGE = registryKey("uranium_ore_large");
    public static RegistryKey<ConfiguredFeature<?, ?>> ORE_URANIUM_BURIED = registryKey("uranium_ore_buried");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceable = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceable = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        //List of ores that can replace the target blocks
        List<OreFeatureConfig.Target> overworldUraniumOres = List.of(OreFeatureConfig.createTarget(stoneReplaceable, ModBlocks.URANIUM_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(deepslateReplaceable, ModBlocks.DEEPSLATE_URANIUM_ORE.getDefaultState()));

        //Sets the veins of uranium ore
        register(context, ORE_URANIUM_SMALL, Feature.ORE, new OreFeatureConfig(overworldUraniumOres, 3));
        register(context, ORE_URANIUM_MEDIUM, Feature.ORE, new OreFeatureConfig(overworldUraniumOres, 6));
        register(context, ORE_URANIUM_LARGE, Feature.ORE, new OreFeatureConfig(overworldUraniumOres, 9));
        register(context, ORE_URANIUM_BURIED, Feature.ORE, new OreFeatureConfig(overworldUraniumOres, 14, 1.0f));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registryKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(Tech_mod.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context, RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
