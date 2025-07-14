package net.heaper.tech_mod.stat;

import net.heaper.tech_mod.Tech_mod;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.stat.StatFormatter;
import net.minecraft.stat.Stats;
import net.minecraft.util.Identifier;

public class ModStats {
    public static final Identifier INTERACTED_WITH_PULVERIZER = register("interacted_with_pulverizer", StatFormatter.DEFAULT);

    private static Identifier register(String id, StatFormatter statFormatter) {
        Identifier identifier = Identifier.of(Tech_mod.MOD_ID, id);
        Registry.register(Registries.CUSTOM_STAT, id, identifier);
        Stats.CUSTOM.getOrCreateStat(identifier, statFormatter);
        return identifier;
    }

    public static void Initialize() {
    }
}
