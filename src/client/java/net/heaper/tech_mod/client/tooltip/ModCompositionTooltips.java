package net.heaper.tech_mod.client.tooltip;

import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.heaper.tech_mod.block.ModBlocks;
import net.heaper.tech_mod.component.ModComponents;
import net.heaper.tech_mod.compound.CompoundVariant;
import net.heaper.tech_mod.element.ElementVariant;
import net.heaper.tech_mod.item.ModItems;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModCompositionTooltips {
    public static final Map<Item, String> TOOLTIP_MAP = new HashMap<>();

    public static void registerTooltips() {
        //Minecraft base composts
        final String clayCompost = "Al₂Si₂O₅(OH)₄";
        final String stoneCompost = "SiO₂";
        final String deepslateCompost = "CaCO₃ + SiO₂";
        final String netherrackCompost = "CaCO₃ + MgFeSiO₄ + SiO₂ + SO₃";
        final String graniteCompost = "SiO₂ + KAlSi₃O₈ + (Fe,Mg)AlSi₃O₁₀(OH)₂";
        final String andesiteCompost = "NaAlSi₃O₈ + CaMgSi₂O₆ + (Fe,Mg)SiO₃";
        final String dioriteCompost = "NaAlSi₃O₈ + CaMgSi₂O₆ + (Fe,Mg)AlSi₃O₁₀(OH)₂";
        final String tuffCompost = "SiO₂ + KAlSi₃O₈ + Al₂Si₂O₅(OH)₄ + X";
        final String basaltCompost = "(Ca,Na)(Al,Si)₄O₈ + (Mg,Fe)SiO₃ + (Mg,Fe)₂SiO₄";
        final String blackstoneCompost = "(Ca,Na)(Al,Si)₄O₈ + (Ca,Fe,Mg)(Si,Al)₂O₆ + Fe₂O₃ + SO₃";
        final String obsidianCompost = "SiO₂ + Al₂O₃ + Fe₂O₃";
        final String coalCompound = "C";
        final String copperCompound = "Cu";
        final String ironCompound = "Fe";
        final String lapisCompound = "Na₃Ca(Al₃Si₃O₁₂)S";
        final String redstoneCompound = "HgSiO₃PS";
        final String goldCompost = "Au";
        final String diamondCompost = "C";
        final String emeraldCompost = "(Be₃Al₂Si₆O₁₈ + Cr³⁺)";
        final String amethystCompost = "SiO₂ + Fe³⁺";
        final String quartzCompost = "SiO₂";
        final String glowstoneCompost = "SiO₂ + CaO + WO₃ + S + Eu³⁺";
        final String netheriteCompost = "(WC·FeV)ZrSiO₄C";

        //Mod composts
        final String uraniumCompound = "U";

        TOOLTIP_MAP.put(Blocks.SANDSTONE.asItem(), stoneCompost + " + CaCO₃");
        TOOLTIP_MAP.put(Blocks.RED_SAND.asItem(), stoneCompost + " + Fe₂O₃");
        TOOLTIP_MAP.put(Blocks.RED_SANDSTONE.asItem(), stoneCompost + " + Fe₂O₃");
    }

    public static void Initialize() {
        ItemTooltipCallback.EVENT.register((itemStack, tooltipContext, tooltipType, list) -> {
            if (itemStack.contains(ModComponents.ELEMENTS_COMPONENT)) {
                List<ElementVariant> elements = itemStack.get(ModComponents.ELEMENTS_COMPONENT);
                if (!elements.isEmpty()) {
                    StringBuilder sb = new StringBuilder();

                    for (int i = 0; i < elements.size(); i++) {
                        ElementVariant element = elements.get(i);
                        String suffix = switch (element.getPurity()) {
                            case NORMAL -> "";
                            case IMPURE -> "*";
                            case PURE -> "⁰";
                        };

                        sb.append(element.getElement().getSymbol()).append(suffix);

                        if (i < elements.size() - 1) {
                            sb.append(" + ");
                        }
                    }

                    list.add(Text.literal(sb.toString()).formatted(Formatting.GRAY));
                }
            } else if (itemStack.contains(ModComponents.COMPOUNDS_COMPONENT)) {
                List<CompoundVariant> compounds = itemStack.get(ModComponents.COMPOUNDS_COMPONENT);
                if (!compounds.isEmpty()) {
                    StringBuilder sb = new StringBuilder();

                    for (int i = 0; i < compounds.size(); i++) {
                        CompoundVariant compound = compounds.get(i);
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

                    list.add(Text.literal(sb.toString()).formatted(Formatting.GRAY));
                }
            }
        });
    }
}
