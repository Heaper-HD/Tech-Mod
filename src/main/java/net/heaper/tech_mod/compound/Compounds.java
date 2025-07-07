package net.heaper.tech_mod.compound;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.heaper.tech_mod.component.ModComponents;
import net.heaper.tech_mod.element.Elements;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Compounds {
    //Basic compounds
    public static final Compound SILICATE = new Compound("Silicate");
    public static final Compound HYDROXYL = new Compound("Hydroxyl");
    public static final Compound SILICON_DIOXIDE = new Compound("Silicon Dioxide");
    public static final Compound CALCIUM_CARBONATE = new Compound("Calcium Carbonate");
    public static final Compound DIAMOND = new Compound("Diamond");

    //Complex compounds
    public static final Compound EMERALD = new Compound("Emerald");
    public static final Compound KAOLINITE = new Compound("Kaolinite");

    public static final Map<String, Compound> COMPOUND_MAP = new HashMap<>();

    static{
        SILICATE.addElement(Elements.SILICON, 1);
        SILICATE.addElement(Elements.OXYGEN, 3);
        HYDROXYL.addElement(Elements.OXYGEN, 1);
        HYDROXYL.addElement(Elements.HYDROGEN, 1);
        SILICON_DIOXIDE.addElement(Elements.SILICON, 1);
        SILICON_DIOXIDE.addElement(Elements.OXYGEN, 1);
        CALCIUM_CARBONATE.addElement(Elements.CALCIUM, 1);
        CALCIUM_CARBONATE.addElement(Elements.CARBON, 1);
        CALCIUM_CARBONATE.addElement(Elements.OXYGEN, 3);

        DIAMOND.addElement(Elements.CARBON, 18);

        EMERALD.addElement(Elements.BERYLLIUM, 3);
        EMERALD.addElement(Elements.ALUMINIUM, 2);
        EMERALD.addCompoundGroup(SILICATE, 6);
        KAOLINITE.addElement(Elements.ALUMINIUM, 2);
        KAOLINITE.addElement(Elements.SILICON, 2);
        KAOLINITE.addElement(Elements.OXYGEN, 5);
        KAOLINITE.addCompoundGroup(HYDROXYL, 4);
    }

    static {
        register(SILICATE);
        register(HYDROXYL);
        register(SILICON_DIOXIDE);
        register(CALCIUM_CARBONATE);
        register(EMERALD);
        register(DIAMOND);
    }

    private static void register(Compound compound) {
        COMPOUND_MAP.put(compound.getName().toLowerCase(), compound);
        COMPOUND_MAP.put(compound.getSymbol().toLowerCase(), compound);
    }

    public static Compound getByName(String name) {
        return COMPOUND_MAP.get(name.toLowerCase());
    }

    public static Compound getBySymbol(String symbol) {
        return COMPOUND_MAP.get(symbol.toLowerCase());
    }

    public static final Codec<CompoundVariant> COMPOUND_VARIANT_CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.STRING.fieldOf("symbol").forGetter(v -> v.getCompound().getSymbol()),
                    ModComponents.PURITY_CODEC.fieldOf("purity").forGetter(CompoundVariant::getPurity)
            ).apply(instance, (symbol, purity) -> {
                Compound component = Compounds.getBySymbol(symbol);
                return new CompoundVariant(component, purity);
            })
    );

    public static final Codec<List<CompoundVariant>> COMPOUND_VARIANT_LIST_CODEC = Codec.list(COMPOUND_VARIANT_CODEC);
}
