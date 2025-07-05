package net.heaper.tech_mod.util;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.util.Identifier;

public class ModLootTableModifiers {
    public static final Identifier DIAMOND_ORE = Identifier.of("minecraft", "blocks/diamond_ore");
    public static final Identifier DEEPSLATE_DIAMOND_ORE = Identifier.of("minecraft", "blocks/deepslate_diamond_ore");

    public static void Initialize() {

        LootTableEvents.REPLACE.register((key, tableBuilder, source, registry) -> {
            if (DIAMOND_ORE.equals(key.getValue()) || DEEPSLATE_DIAMOND_ORE.equals(key.getValue())) {


            }

            return null;
        });
    }
}
