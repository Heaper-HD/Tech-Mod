package net.heaper.tech_mod.client;

import net.fabricmc.api.ClientModInitializer;
import net.heaper.tech_mod.Tech_mod;
import net.heaper.tech_mod.client.gui.screen.ingame.PulverizerScreen;
import net.heaper.tech_mod.client.tooltip.ModCompositionTooltipGenerator;
import net.heaper.tech_mod.screen.ModScreenHandlerType;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

public class Tech_modClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        Tech_mod.LOGGER.info("Generating items composition tooltips");
        ModCompositionTooltipGenerator.Initialize();

        HandledScreens.register(ModScreenHandlerType.PULVERIZER, PulverizerScreen::new);
    }
}
