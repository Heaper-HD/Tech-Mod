package net.heaper.tech_mod.util;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;

public class ModLootTableModifiers {
    public static void Initialize() {
        LootTableEvents.MODIFY_DROPS.register((entry,context,stacks) -> {

        });
    }
}
