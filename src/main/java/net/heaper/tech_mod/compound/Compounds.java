package net.heaper.tech_mod.compound;

import net.heaper.tech_mod.element.Elements;

import java.util.HashMap;
import java.util.Map;

public class Compounds {
    private static final Compound EMERALD = new Compound("Emerald");
    private static final Compound SILICATE = new Compound("Silicate");

    public static final Map<String, Compound> COMPOUND_MAP = new HashMap<>();

    static {
        SILICATE.addElement(Elements.SILICON, 1);
        SILICATE.addElement(Elements.OXYGEN, 3);

        EMERALD.addElement(Elements.BERYLLIUM, 3);
        EMERALD.addElement(Elements.ALUMINIUM, 2);
        EMERALD.addCompoundGroup(SILICATE, 6);
    }

    static {
        register(EMERALD);
        register(SILICATE);
    }

    private static void register(Compound compound) {
        COMPOUND_MAP.put(compound.getName().toLowerCase(), compound);
        COMPOUND_MAP.put(compound.getNormal(), compound);
    }

    public static Compound getByName(String name) {
        return COMPOUND_MAP.get(name.toLowerCase());
    }
}
