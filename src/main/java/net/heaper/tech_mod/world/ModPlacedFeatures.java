package net.heaper.tech_mod.world;

import net.heaper.tech_mod.Tech_mod;
import net.minecraft.registry.Registerable;
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

import java.util.List;

public class ModPlacedFeatures {
    public static final RegistryKey<PlacedFeature> ORE_URANIUM_SMALL = registryKey("ore_uranium_small");
    public static final RegistryKey<PlacedFeature> ORE_URANIUM_MEDIUM = registryKey("ore_uranium_medium");
    public static final RegistryKey<PlacedFeature> ORE_URANIUM_LARGE = registryKey("ore_uranium_large");
    public static final RegistryKey<PlacedFeature> ORE_URANIUM_BURIED = registryKey("ore_uranium_buried");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatures = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, ORE_URANIUM_SMALL, configuredFeatures.getOrThrow(ModConfiguredFeatures.ORE_URANIUM_SMALL),
                ModOrePlacement.modifiersWithCount(9, HeightRangePlacementModifier.trapezoid(YOffset.fixed(-64), YOffset.fixed(20))));
        register(context, ORE_URANIUM_MEDIUM, configuredFeatures.getOrThrow(ModConfiguredFeatures.ORE_URANIUM_MEDIUM),
                ModOrePlacement.modifiersWithCount(3, HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(40))));
        register(context, ORE_URANIUM_LARGE, configuredFeatures.getOrThrow(ModConfiguredFeatures.ORE_URANIUM_LARGE),
                ModOrePlacement.modifiersWithRarity(12, HeightRangePlacementModifier.trapezoid(YOffset.fixed(-64), YOffset.fixed(20))));
        register(context, ORE_URANIUM_BURIED, configuredFeatures.getOrThrow(ModConfiguredFeatures.ORE_URANIUM_BURIED),
                ModOrePlacement.modifiersWithCount(6, HeightRangePlacementModifier.trapezoid(YOffset.fixed(-64), YOffset.fixed(20))));
    }

    public static RegistryKey<PlacedFeature> registryKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(Tech_mod.MOD_ID, name));
    }

    public static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration, List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration, PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}
