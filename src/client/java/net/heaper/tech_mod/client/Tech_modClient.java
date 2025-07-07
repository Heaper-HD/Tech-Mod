package net.heaper.tech_mod.client;

import net.fabricmc.api.ClientModInitializer;
import net.heaper.tech_mod.Tech_mod;
import net.heaper.tech_mod.client.tooltip.ModCompositionTooltipGenerator;

public class Tech_modClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        Tech_mod.LOGGER.info("Generating items composition tooltips");
        ModCompositionTooltipGenerator.Initialize();
    }
}
