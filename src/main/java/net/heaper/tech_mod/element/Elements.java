package net.heaper.tech_mod.element;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.heaper.tech_mod.component.ModDataComponentsType;

import java.util.HashMap;
import java.util.Map;

public class Elements {
    //Real life elements
    public static final Element HYDROGEN = new Element("Hydrogen", "H");
    public static final Element HELIUM = new Element("Helium", "He");
    public static final Element LITHIUM = new Element("Lithium", "Li");
    public static final Element BERYLLIUM = new Element("Beryllium", "Be");
    public static final Element BORON = new Element("Boron", "B");
    public static final Element CARBON = new Element("Carbon", "C");
    public static final Element NITROGEN = new Element("Nitrogen", "N");
    public static final Element OXYGEN = new Element("Oxygen", "O");
    public static final Element FLUORINE = new Element("Fluorine", "F");
    public static final Element NEON = new Element("Neon", "Ne");
    public static final Element SODIUM = new Element("Sodium", "Na");
    public static final Element MAGNESIUM = new Element("Magnesium", "Mg");
    public static final Element ALUMINIUM = new Element("Aluminium", "Al");
    public static final Element SILICON = new Element("Silicon", "Si");
    public static final Element PHOSPHORUS = new Element("Phosphorus", "P");
    public static final Element SULFUR = new Element("Sulfur", "S");
    public static final Element CHLORINE = new Element("Chlorine", "Cl");
    public static final Element ARGON = new Element("Argon", "Ar");
    public static final Element POTASSIUM = new Element("Potassium", "K");
    public static final Element CALCIUM = new Element("Calcium", "Ca");
    public static final Element SCANDIUM = new Element("Scandium", "Sc");
    public static final Element TITANIUM = new Element("Titanium", "Ti");
    public static final Element VANADIUM = new Element("Vanadium", "V");
    public static final Element CHROMIUM = new Element("Chromium", "Cr");
    public static final Element MANGANESE = new Element("Manganese", "Mn");
    public static final Element IRON = new Element("Iron", "Fe");
    public static final Element COBALT = new Element("Cobalt", "Co");
    public static final Element NICKEL = new Element("Nickel", "Ni");
    public static final Element COPPER = new Element("Copper", "Cu");
    public static final Element ZINC = new Element("Zinc", "Zn");
    public static final Element GALLIUM = new Element("Gallium", "Ga");
    public static final Element GERMANIUM = new Element("Germanium", "Ge");
    public static final Element ARSENIC = new Element("Arsenic", "As");
    public static final Element SELENIUM = new Element("Selenium", "Se");
    public static final Element BROMINE = new Element("Bromine", "Br");
    public static final Element KRYPTON = new Element("Krypton", "Kr");
    public static final Element RUBIDIUM = new Element("Rubidium", "Rb");
    public static final Element STRONTIUM = new Element("Strontium", "Sr");
    public static final Element YTTRIUM = new Element("Yttrium", "Y");
    public static final Element ZIRCONIUM = new Element("Zirconium", "Zr");
    public static final Element NIOBIUM = new Element("Niobium", "Nb");
    public static final Element MOLYBDENUM = new Element("Molybdenum", "Mo");
    public static final Element TECHNETIUM = new Element("Technetium", "Tc");
    public static final Element RUTHENIUM = new Element("Ruthenium", "Ru");
    public static final Element RHODIUM = new Element("Rhodium", "Rh");
    public static final Element PALLADIUM = new Element("Palladium", "Pd");
    public static final Element SILVER = new Element("Silver", "Ag");
    public static final Element CADMIUM = new Element("Cadmium", "Cd");
    public static final Element INDIUM = new Element("Indium", "In");
    public static final Element TIN = new Element("Tin", "Sn");
    public static final Element ANTIMONY = new Element("Antimony", "Sb");
    public static final Element TELLURIUM = new Element("Tellurium", "Te");
    public static final Element IODINE = new Element("Iodine", "I");
    public static final Element XENON = new Element("Xenon", "Xe");
    public static final Element CAESIUM = new Element("Caesium", "Cs");
    public static final Element BARIUM = new Element("Barium", "Ba");
    public static final Element HAFNIUM = new Element("Hafnium", "Hf");
    public static final Element TANTALUM = new Element("Tantalum", "Ta");
    public static final Element TUNGSTEN = new Element("Tungsten", "W");
    public static final Element RHENIUM = new Element("Rhenium", "Re");
    public static final Element OSMIUM = new Element("Osmium", "Os");
    public static final Element IRIDIUM = new Element("Iridium", "Ir");
    public static final Element PLATINUM = new Element("Platinum", "Pt");
    public static final Element GOLD = new Element("Gold", "Au");
    public static final Element MERCURY = new Element("Mercury", "Hg");
    public static final Element THALLIUM = new Element("Thallium", "Tl");
    public static final Element LEAD = new Element("Lead", "Pb");
    public static final Element BISMUTH = new Element("Bismuth", "Bi");
    public static final Element POLONIUM = new Element("Polonium", "Po");
    public static final Element ASTATINE = new Element("Astatine", "At");
    public static final Element RADON = new Element("Radon", "Rn");
    public static final Element FRANCIUM = new Element("Francium", "Fr");
    public static final Element RADIUM = new Element("Radium", "Ra");
    public static final Element RUTHERFORDIUM = new Element("Rutherfordium", "Rf");
    public static final Element DUBNIUM = new Element("Dubnium", "Db");
    public static final Element SEABORGIUM = new Element("Seaborgium", "Sg");
    public static final Element BOHRIUM = new Element("Bohrium", "Bh");
    public static final Element HASSIUM = new Element("Hassium", "Hs");
    public static final Element MEITNERIUM = new Element("Meitnerium", "Mt");
    public static final Element DARMSTADTIUM = new Element("Darmstadtium", "Ds");
    public static final Element ROENTGENIUM = new Element("Roentgenium", "Rg");
    public static final Element COPERNICIUM = new Element("Copernicium", "Cn");
    public static final Element NIHONIUM = new Element("Nihonium", "Nh");
    public static final Element FLEROVIUM = new Element("Flerovium", "Fl");
    public static final Element MOSCOVIUM = new Element("Moscovium", "Mc");
    public static final Element LIVERMORIUM = new Element("Livermorium", "Lv");
    public static final Element TENNESSINE = new Element("Tennessine", "Ts");
    public static final Element OGANESSON = new Element("Oganesson", "Og");
    public static final Element CERIUM = new Element("Cerium", "Ce");
    public static final Element PRASEODYMIUM = new Element("Praseodymium", "Pr");
    public static final Element NEODYMIUM = new Element("Neodymium", "Nd");
    public static final Element PROMETHIUM = new Element("Promethium", "Pm");
    public static final Element SAMARIUM = new Element("Samarium", "Sm");
    public static final Element EUROPIUM = new Element("Europium", "Eu");
    public static final Element GADOLINIUM = new Element("Gadolinium", "Gd");
    public static final Element TERBIUM = new Element("Terbium", "Tb");
    public static final Element DYSPROSIUM = new Element("Dysprosium", "Dy");
    public static final Element HOLMIUM = new Element("Holmium", "Ho");
    public static final Element ERBIUM = new Element("Erbium", "Er");
    public static final Element THULIUM = new Element("Thulium", "Tm");
    public static final Element YTTERBIUM = new Element("Ytterbium", "Yb");
    public static final Element LUTETIUM = new Element("Lutetium", "Lu");
    public static final Element THORIUM = new Element("Thorium", "Th");
    public static final Element PROTACTINIUM = new Element("Protactinium", "Pa");
    public static final Element URANIUM = new Element("Uranium", "U");
    public static final Element NEPTUNIUM = new Element("Neptunium", "Np");
    public static final Element PLUTONIUM = new Element("Plutonium", "Pu");
    public static final Element AMERICIUM = new Element("Americium", "Am");
    public static final Element CURIUM = new Element("Curium", "Cm");
    public static final Element BERKELIUM = new Element("Berkelium", "Bk");
    public static final Element CALIFORNIUM = new Element("Californium", "Cf");
    public static final Element EINSTEINIUM = new Element("Einsteinium", "Es");
    public static final Element FERMIUM = new Element("Fermium", "Fm");
    public static final Element MENDELEVIUM = new Element("Mendelevium", "Md");
    public static final Element NOBELIUM = new Element("Nobelium", "No");
    public static final Element LAWRENCIUM = new Element("Lawrencium", "Lr");

    //Mod made up elements
    public static final Element X_ELEMENT = new Element("X Element", "X");
    public static final Element ARENTINIUM = new Element("Arentinium", "Ae");

    private static final Map<String, Element> ELEMENT_MAP = new HashMap<>();

    static {
        register(HYDROGEN);
        register(HELIUM);
        register(LITHIUM);
        register(BERYLLIUM);
        register(BORON);
        register(CARBON);
        register(NITROGEN);
        register(OXYGEN);
        register(FLUORINE);
        register(NEON);
        register(SODIUM);
        register(MAGNESIUM);
        register(ALUMINIUM);
        register(SILICON);
        register(PHOSPHORUS);
        register(SULFUR);
        register(CHLORINE);
        register(ARGON);
        register(POTASSIUM);
        register(CALCIUM);
        register(SCANDIUM);
        register(TITANIUM);
        register(VANADIUM);
        register(CHROMIUM);
        register(MANGANESE);
        register(IRON);
        register(COBALT);
        register(NICKEL);
        register(COPPER);
        register(ZINC);
        register(GALLIUM);
        register(GERMANIUM);
        register(ARSENIC);
        register(SELENIUM);
        register(BROMINE);
        register(KRYPTON);
        register(RUBIDIUM);
        register(STRONTIUM);
        register(YTTRIUM);
        register(ZIRCONIUM);
        register(NIOBIUM);
        register(MOLYBDENUM);
        register(TECHNETIUM);
        register(RUTHENIUM);
        register(RHODIUM);
        register(PALLADIUM);
        register(SILVER);
        register(CADMIUM);
        register(INDIUM);
        register(TIN);
        register(ANTIMONY);
        register(TELLURIUM);
        register(IODINE);
        register(XENON);
        register(CAESIUM);
        register(BARIUM);
        register(HAFNIUM);
        register(TANTALUM);
        register(TUNGSTEN);
        register(RHENIUM);
        register(OSMIUM);
        register(IRIDIUM);
        register(PLATINUM);
        register(GOLD);
        register(MERCURY);
        register(THALLIUM);
        register(LEAD);
        register(BISMUTH);
        register(POLONIUM);
        register(ASTATINE);
        register(RADON);
        register(FRANCIUM);
        register(RADIUM);
        register(RUTHERFORDIUM);
        register(DUBNIUM);
        register(SEABORGIUM);
        register(BOHRIUM);
        register(HASSIUM);
        register(MEITNERIUM);
        register(DARMSTADTIUM);
        register(ROENTGENIUM);
        register(COPERNICIUM);
        register(NIHONIUM);
        register(FLEROVIUM);
        register(MOSCOVIUM);
        register(LIVERMORIUM);
        register(TENNESSINE);
        register(OGANESSON);
        register(CERIUM);
        register(PRASEODYMIUM);
        register(NEODYMIUM);
        register(PROMETHIUM);
        register(SAMARIUM);
        register(EUROPIUM);
        register(GADOLINIUM);
        register(TERBIUM);
        register(DYSPROSIUM);
        register(HOLMIUM);
        register(ERBIUM);
        register(THULIUM);
        register(YTTERBIUM);
        register(LUTETIUM);
        register(THORIUM);
        register(PROTACTINIUM);
        register(URANIUM);
        register(NEPTUNIUM);
        register(PLUTONIUM);
        register(AMERICIUM);
        register(CURIUM);
        register(BERKELIUM);
        register(CALIFORNIUM);
        register(EINSTEINIUM);
        register(FERMIUM);
        register(MENDELEVIUM);
        register(NOBELIUM);
        register(LAWRENCIUM);
        register(ARENTINIUM);
    }

    private static void register(Element element) {
        ELEMENT_MAP.put(element.getName().toLowerCase(), element);
        ELEMENT_MAP.put(element.getSymbol().toLowerCase(), element);
    }

    public static Element getByName(String name) {
        return ELEMENT_MAP.get(name.toLowerCase());
    }

    public static Element getBySymbol(String symbol){
        return ELEMENT_MAP.get(symbol.toLowerCase());
    }

    public static final Codec<ElementComponent> ELEMENT_VARIANT_CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.STRING.fieldOf("symbol").forGetter(v -> v.getElement().getSymbol()),
                    ModDataComponentsType.PURITY_CODEC.fieldOf("purity").forGetter(ElementComponent::getPurity)
            ).apply(instance, (symbol, purity) -> {
                Element element = Elements.getBySymbol(symbol);
                return new ElementComponent(element, purity);
            })
    );
}
