package net.heaper.tech_mod.client.datagen.texture.base;

import java.util.HashMap;
import java.util.Map;

public class Bases {
    public static final Base STONE = new Base("Stone", "stone.png");
    public static final Base DEEPSLATE = new Base("Deepslate", "deepslate.png");
    public static final Base NETHERRACK = new Base("Netherrack", "netherrack.png");
    public static final Base END_STONE = new Base("End Stoen", "end_stone.png");

    private static final Map<String, Base> BASE_MAP = new HashMap<>();

    static {
        register(STONE);
        register(DEEPSLATE);
        register(NETHERRACK);
        register(END_STONE);
    }

    private static void register(Base base) {
        BASE_MAP.put(base.getName().toLowerCase(), base);
    }

    private static Base getByName(String name) {
        return BASE_MAP.get(name.toLowerCase());
    }
}
