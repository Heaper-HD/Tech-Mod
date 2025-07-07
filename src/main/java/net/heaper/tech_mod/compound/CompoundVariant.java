package net.heaper.tech_mod.compound;

import net.heaper.tech_mod.element.PurityLevel;

public class CompoundVariant {
    private final Compound compound;
    private final PurityLevel purity;

    public CompoundVariant(Compound compound, PurityLevel purity) {
        this.compound = compound;
        this.purity = purity;
    }

    public Compound getCompound() {
        return compound;
    }

    public PurityLevel getPurity() {
        return purity;
    }

    public String getSymbol() {
        return switch (purity) {
            case NORMAL -> compound.getNormalSymbol();
            case IMPURE -> compound.getImpureSymbol();
            case PURE -> compound.getPureSymbol();
        };
    }
}
