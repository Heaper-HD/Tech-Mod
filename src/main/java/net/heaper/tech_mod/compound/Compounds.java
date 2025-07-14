package net.heaper.tech_mod.compound;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.heaper.tech_mod.component.ModDataComponentsType;
import net.heaper.tech_mod.element.Elements;

import java.util.HashMap;
import java.util.Map;

public class Compounds {
    //Basic compounds
    public static final Compound DIAMOND = new Compound("Diamond");
    public static final Compound SILICATE = new Compound("Silicate");
    public static final Compound HYDROXYL = new Compound("Hydroxyl");
    public static final Compound SILICON_MONOXIDE = new Compound("Silicon Monoxide");
    public static final Compound SILICON_DIOXIDE = new Compound("Silicon Dioxide");
    public static final Compound AMPHIBOLE = new Compound("Amphibole");
    public static final Compound SULFUR_DIOXIDE = new Compound("Sulfur Dioxide");
    public static final Compound CALCIUM_CARBONATE = new Compound("Calcium Carbonate");
    public static final Compound FAYALITE = new Compound("Fayalite");
    public static final Compound ORTHOCLASE = new Compound("Orthoclase");
    public static final Compound ALBITE = new Compound("Albite");
    public static final Compound DIOPSIDE = new Compound("Diopside");
    public static final Compound FERROSILITE = new Compound("Ferrosilite");
    public static final Compound ANNITE = new Compound("Annite");
    public static final Compound FORSTERITE = new Compound("Forsterite");
    public static final Compound HEDENBERGITE = new Compound("Hedenbergite");
    public static final Compound HEMATITE = new Compound("Hematite");
    public static final Compound ALUMINUM_OXIDE = new Compound("Aluminum oxide");
    public static final Compound ALUMINOSILICATE = new Compound("Aluminosilicate");
    public static final Compound REDSTONE = new Compound("Redstone");
    public static final Compound GLOWSTONE = new Compound("Glowstone");
    public static final Compound VANADIUM_STEEL = new Compound("Vanadium Steel");
    public static final Compound ANCIENT_MATERIAL = new Compound("Vanadium Steel");

    //Complex compounds
    public static final Compound LAPIS = new Compound("Lapis");
    public static final Compound EMERALD = new Compound("Emerald");
    public static final Compound NETHERITE = new Compound("Netherite");
    public static final Compound KAOLINITE = new Compound("Kaolinite");
    public static final Compound BIOTITE = new Compound("Biotite");

    public static final Map<String, Compound> COMPOUND_MAP = new HashMap<>();

    static{
        //Simple compounds
        DIAMOND.addElement(Elements.CARBON, 18);

        SILICATE.addElement(Elements.SILICON, 1);
        SILICATE.addElement(Elements.OXYGEN, 3);

        HYDROXYL.addElement(Elements.OXYGEN, 1);
        HYDROXYL.addElement(Elements.HYDROGEN, 1);

        SILICON_MONOXIDE.addElement(Elements.SILICON, 1);
        SILICON_MONOXIDE.addElement(Elements.OXYGEN, 1);

        SILICON_DIOXIDE.addElement(Elements.SILICON, 1);
        SILICON_DIOXIDE.addElement(Elements.OXYGEN, 2);

        SULFUR_DIOXIDE.addElement(Elements.SULFUR, 1);
        SULFUR_DIOXIDE.addElement(Elements.OXYGEN, 2);

        CALCIUM_CARBONATE.addElement(Elements.CALCIUM, 1);
        CALCIUM_CARBONATE.addElement(Elements.CARBON, 1);
        CALCIUM_CARBONATE.addElement(Elements.OXYGEN, 3);

        FAYALITE.addElement(Elements.MAGNESIUM, 1);
        FAYALITE.addElement(Elements.IRON, 1);
        FAYALITE.addElement(Elements.SILICON, 1);
        FAYALITE.addElement(Elements.OXYGEN, 4);

        ORTHOCLASE.addElement(Elements.POTASSIUM, 1);
        ORTHOCLASE.addElement(Elements.ALUMINIUM, 1);
        ORTHOCLASE.addElement(Elements.SILICON, 3);
        ORTHOCLASE.addElement(Elements.OXYGEN, 8);

        ALBITE.addElement(Elements.SODIUM, 1);
        ALBITE.addElement(Elements.ALUMINIUM, 1);
        ALBITE.addElement(Elements.SILICON, 3);
        ALBITE.addElement(Elements.OXYGEN, 8);

        DIOPSIDE.addElement(Elements.CALCIUM, 1);
        DIOPSIDE.addElement(Elements.MAGNESIUM, 1);
        DIOPSIDE.addElement(Elements.SILICON, 2);
        DIOPSIDE.addElement(Elements.OXYGEN, 6);

        FERROSILITE.addElement(Elements.IRON, 1);
        FERROSILITE.addElement(Elements.SILICON, 1);
        FERROSILITE.addElement(Elements.OXYGEN, 3);

        FORSTERITE.addElement(Elements.MAGNESIUM, 2);
        FORSTERITE.addElement(Elements.SILICON, 1);
        FORSTERITE.addElement(Elements.OXYGEN, 4);

        HEDENBERGITE.addElement(Elements.CALCIUM, 1);
        HEDENBERGITE.addElement(Elements.IRON, 1);
        HEDENBERGITE.addElement(Elements.SILICON, 2);
        HEDENBERGITE.addElement(Elements.OXYGEN, 6);

        HEMATITE.addElement(Elements.IRON, 2);
        HEMATITE.addElement(Elements.OXYGEN, 3);

        ALUMINUM_OXIDE.addElement(Elements.ALUMINIUM, 2);
        ALUMINUM_OXIDE.addElement(Elements.OXYGEN, 3);

        ALUMINOSILICATE.addElement(Elements.ALUMINIUM, 3);
        ALUMINOSILICATE.addElement(Elements.SILICON, 3);
        ALUMINOSILICATE.addElement(Elements.OXYGEN, 12);

        REDSTONE.addElement(Elements.MERCURY, 1);
        REDSTONE.addElement(Elements.SILICON, 1);
        REDSTONE.addElement(Elements.OXYGEN, 3);
        REDSTONE.addElement(Elements.PHOSPHORUS, 1);
        REDSTONE.addElement(Elements.SULFUR, 1);

        GLOWSTONE.addElement(Elements.GOLD, 1);
        GLOWSTONE.addElement(Elements.PHOSPHORUS, 4);
        GLOWSTONE.addElement(Elements.SULFUR, 4);
        GLOWSTONE.addElement(Elements.OXYGEN, 8);

        VANADIUM_STEEL.addElement(Elements.IRON, 1);
        VANADIUM_STEEL.addElement(Elements.VANADIUM, 1);

        //Complex compounds
        LAPIS.addElement(Elements.SODIUM, 3);
        LAPIS.addElement(Elements.CALCIUM, 3);
        LAPIS.addCompoundGroup(ALUMINOSILICATE, 1);
        LAPIS.addElement(Elements.SULFUR, 1);

        EMERALD.addElement(Elements.BERYLLIUM, 3);
        EMERALD.addElement(Elements.ALUMINIUM, 2);
        EMERALD.addCompoundGroup(SILICATE, 6);

        ANCIENT_MATERIAL.addElement(Elements.IRON, 2);
        ANCIENT_MATERIAL.addElement(Elements.NICKEL, 1);
        ANCIENT_MATERIAL.addElement(Elements.CARBON, 1);
        ANCIENT_MATERIAL.addCompoundGroup(VANADIUM_STEEL, 2);

        NETHERITE.addElement(Elements.GOLD, 4);
        NETHERITE.addCompoundGroup(ANCIENT_MATERIAL, 4);

        KAOLINITE.addElement(Elements.ALUMINIUM, 2);
        KAOLINITE.addElement(Elements.SILICON, 2);
        KAOLINITE.addElement(Elements.OXYGEN, 5);
        KAOLINITE.addCompoundGroup(HYDROXYL, 4);

        AMPHIBOLE.addElement(Elements.MAGNESIUM, 1);
        AMPHIBOLE.addElement(Elements.ALUMINIUM, 1);
        AMPHIBOLE.addElement(Elements.SILICON, 3);
        AMPHIBOLE.addElement(Elements.OXYGEN, 10);
        AMPHIBOLE.addCompoundGroup(HYDROXYL, 2);

        BIOTITE.addElement(Elements.IRON, 1);
        BIOTITE.addElement(Elements.ALUMINIUM, 1);
        BIOTITE.addElement(Elements.SILICON, 3);
        BIOTITE.addElement(Elements.OXYGEN, 10);
        BIOTITE.addCompoundGroup(HYDROXYL, 2);

        ANNITE.addElement(Elements.POTASSIUM, 1);
        ANNITE.addElement(Elements.IRON, 3);
        ANNITE.addElement(Elements.ALUMINIUM, 1);
        ANNITE.addElement(Elements.SILICON, 3);
        ANNITE.addElement(Elements.OXYGEN, 10);
        ANNITE.addCompoundGroup(HYDROXYL, 2);
    }

    static {
        //Simple compounds
        register(DIAMOND);
        register(SILICATE);
        register(HYDROXYL);
        register(SILICON_MONOXIDE);
        register(SILICON_DIOXIDE);
        register(SULFUR_DIOXIDE);
        register(CALCIUM_CARBONATE);
        register(CALCIUM_CARBONATE);
        register(FAYALITE);
        register(ORTHOCLASE);
        register(ALBITE);
        register(DIOPSIDE);
        register(FERROSILITE);
        register(ANNITE);
        register(FORSTERITE);
        register(HEDENBERGITE);
        register(HEMATITE);
        register(ALUMINUM_OXIDE);
        register(ALUMINOSILICATE);
        register(REDSTONE);
        register(GLOWSTONE);
        register(VANADIUM_STEEL);
        register(ANCIENT_MATERIAL);

        //Complex compounds
        register(LAPIS);
        register(EMERALD);
        register(NETHERITE);
        register(KAOLINITE);
        register(BIOTITE);
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

    public static final Codec<CompoundComponent> COMPOUND_VARIANT_CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.STRING.fieldOf("symbol").forGetter(v -> v.getCompound().getSymbol()),
                    ModDataComponentsType.PURITY_CODEC.fieldOf("purity").forGetter(CompoundComponent::getPurity)
            ).apply(instance, (symbol, purity) -> {
                Compound component = Compounds.getBySymbol(symbol);
                return new CompoundComponent(component, purity);
            })
    );
}
