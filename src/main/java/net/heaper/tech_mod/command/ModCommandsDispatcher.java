package net.heaper.tech_mod.command;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;

public class ModCommandsDispatcher {
    public static void Initialize() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, enviroment) -> {
            DebugElements.register(dispatcher);
        });
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, enviroment) -> {
            DebugCompounds.register(dispatcher);
        });
    }
}
