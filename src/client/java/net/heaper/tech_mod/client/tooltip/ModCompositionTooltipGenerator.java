package net.heaper.tech_mod.client.tooltip;

import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.heaper.tech_mod.component.ModComponents;
import net.heaper.tech_mod.compound.CompoundComponent;
import net.heaper.tech_mod.element.ElementComponent;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class ModCompositionTooltipGenerator {
    public static void Initialize() {
        ItemTooltipCallback.EVENT.register((itemStack, tooltipContext, tooltipType, list) -> {
            boolean hasElements = itemStack.contains(ModComponents.ELEMENTS_COMPONENT);
            boolean hasCompounds = itemStack.contains(ModComponents.COMPOUNDS_COMPONENT);

            if (!hasElements && !hasCompounds) return;

            StringBuilder sb = new StringBuilder();

            if (hasElements) {
                List<ElementComponent> elements = itemStack.get(ModComponents.ELEMENTS_COMPONENT);
                for (int i = 0; i < elements.size(); i++) {
                    ElementComponent element = elements.get(i);
                    String suffix = switch (element.getPurity()) {
                        case NORMAL -> "";
                        case IMPURE -> "*";
                        case PURE -> "⁰";
                    };
                    sb.append(element.getElement().getSymbol()).append(suffix);
                    if (i < elements.size() - 1 || hasCompounds) {
                        sb.append(" + ");
                    }
                }
            }

            if (hasCompounds) {
                List<CompoundComponent> compounds = itemStack.get(ModComponents.COMPOUNDS_COMPONENT);
                for (int i = 0; i < compounds.size(); i++) {
                    CompoundComponent compound = compounds.get(i);
                    String suffix = switch (compound.getPurity()) {
                        case NORMAL -> "";
                        case IMPURE -> "*";
                        case PURE -> "⁰";
                    };
                    sb.append(compound.getCompound().getSymbol()).append(suffix);
                    if (i < compounds.size() - 1) {
                        sb.append(" + ");
                    }
                }
            }

            list.add(Text.literal(sb.toString()).formatted(Formatting.GRAY));
        });
    }
}
