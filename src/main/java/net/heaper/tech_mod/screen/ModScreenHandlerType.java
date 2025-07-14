package net.heaper.tech_mod.screen;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;

public class ModScreenHandlerType {
    public static final ScreenHandlerType<PulverizerScreenHandler> PULVERIZER = register("pulverizer", PulverizerScreenHandler::new);

    private static<T extends ScreenHandler> ScreenHandlerType<T> register(String id, ScreenHandlerType.Factory<T> factory) {
        return Registry.register(Registries.SCREEN_HANDLER, id, new ScreenHandlerType<>(factory, FeatureFlags.DEFAULT_ENABLED_FEATURES));
    }

    public static void Initialize(){
    }
}
