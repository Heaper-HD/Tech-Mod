package net.heaper.tech_mod.element;

public class ElementComponent {
    private final Element element;
    private final PurityLevel purity;

    public ElementComponent(Element element, PurityLevel purity) {
        this.element = element;
        this.purity = purity;
    }

    public Element getElement() {
        return element;
    }

    public PurityLevel getPurity() {
        return purity;
    }

    public String getSymbol() {
        return switch (purity) {
            case NORMAL -> element.getNormalSymbol();
            case IMPURE -> element.getImpureSymbol();
            case PURE -> element.getPureSymbol();
        };
    }
}
