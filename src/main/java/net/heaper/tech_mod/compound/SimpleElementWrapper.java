package net.heaper.tech_mod.compound;

import net.heaper.tech_mod.element.Element;

public class SimpleElementWrapper implements CompoundComponent {
    private final Element element;
    private final int amount;

    public SimpleElementWrapper(Element element, int amount) {
        this.element = element;
        this.amount = amount;
    }

    public Element getElement() {
        return element;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String getNormal() {
        return getFormatted("");
    }

    @Override
    public String getImpure() {
        return getFormatted("*");
    }

    @Override
    public String getPure() {
        return getFormatted("⁰");
    }

    public String getFormatted(String suffix) {
        return element.getSymbol() + (amount > 1 ? toSubscript(amount) : "") + suffix;
    }

    private String toSubscript(int number) {
        return String.valueOf(number)
                .replace('0', '₀')
                .replace('1', '₁')
                .replace('2', '₂')
                .replace('3', '₃')
                .replace('4', '₄')
                .replace('5', '₅')
                .replace('6', '₆')
                .replace('7', '₇')
                .replace('8', '₈')
                .replace('9', '₉');
    }
}
