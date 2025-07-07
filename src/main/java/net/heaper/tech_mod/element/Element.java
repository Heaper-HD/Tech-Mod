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

    public String getNormalSymbol() {
        return getSymbol() + "";
    }

    public String getImpureSymbol() {
        return getSymbol() + "*";
    }

    public String getPureSymbol() {
        return getSymbol() + "⁰";
    }



    @Override
    public String toString() {
        return getSymbol();
    }
}
