package net.heaper.tech_mod.compound;

public class CompoundGroup implements CompoundComponent{
    private final Compound compound;
    private final int quantity;

    public CompoundGroup(Compound compound, int quantity) {
        this.compound = compound;
        this.quantity = quantity;
    }

    public Compound getCompound() {
        return compound;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String getNormal() {
        return '(' + compound.getNormal() + ')' + (quantity > 1 ? toSubscript(quantity) : "");
    }

    @Override
    public String getImpure() {
        return '(' + compound.getImpure() + ')' + (quantity > 1 ? toSubscript(quantity) : "");
    }

    @Override
    public String getPure() {
        return '(' + compound.getPure() + ')' + (quantity > 1 ? toSubscript(quantity) : "");
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
