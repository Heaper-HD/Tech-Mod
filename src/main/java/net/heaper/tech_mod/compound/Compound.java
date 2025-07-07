package net.heaper.tech_mod.compound;

import net.heaper.tech_mod.element.Element;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Compound {
    private final String name;
    private final Map<Element, Integer> flatElements = new LinkedHashMap<>();
    private final List<CompoundComponent> components = new LinkedList<>();

    public Compound(String name) {
        this.name = name;
    }

    public void addElement(Element element, int amount) {
        components.add(new SimpleElementWrapper(element, amount));
        flatElements.merge(element, amount, Integer::sum);
    }

    public void addCompoundGroup(Compound compound, int quantity) {
        CompoundGroup group = new CompoundGroup(compound, quantity);
        components.add(group);

        for (Map.Entry<Element, Integer> entry : compound.getAllElementsFlat().entrySet()) {
            flatElements.merge(entry.getKey(), entry.getValue() * quantity, Integer::sum);
        }
    }

    public static Compound fromCodec(String name, String symbol) {
        Compound compound = new Compound(name);
        return compound;
    }

    public Map<Element, Integer> getAllElementsFlat() {
        return flatElements;
    }

    public List<CompoundComponent> getComponents() {
        return components;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return formatFormula("");
    }

    public String getNormalSymbol() {
        return formatFormula("");
    }

    public String getImpureSymbol() {
        return formatFormula("*");
    }

    public String getPureSymbol() {
        return formatFormula("⁰");
    }

    private String formatFormula(String suffix) {
        StringBuilder sb = new StringBuilder();
        for (CompoundComponent component : components) {
            if (component instanceof SimpleElementWrapper simple) {
                sb.append(simple.getFormatted(suffix));
            } else if (component instanceof CompoundGroup group) {
                sb.append(group.getNormal().replace("*", suffix). replace("⁰", suffix));
            }
        }
        sb.append(suffix);
        return sb.toString();
    }
}
