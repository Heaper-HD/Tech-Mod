package net.heaper.tech_mod.element;

public class Element {
    private final String name;
    private final String symbol;

    public Element(String name, String symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getNormal() {
        return symbol;
    }

    public String getImpure() {
        return symbol + '*';
    }

    public String getPure() {
        return symbol + '⁰';
    }

    @Override
    public String toString() {
        return getNormal();
    }
}
