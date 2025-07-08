package net.heaper.tech_mod.client.tooltip;

import net.minecraft.block.Blocks;
import net.minecraft.item.Item;

import java.util.HashMap;
import java.util.Map;

public class ModCompositionTooltips {
    public static final Map<Item, String> TOOLTIP_MAP = new HashMap<>();

    public static void registerTooltips() {
        //Minecraft base composts
        final String clayCompost = "Al₂Si₂O₅(OH)₄";
        final String stoneCompost = "SiO₂";
        final String deepslateCompost = "CaCO₃ + SiO₂";
        final String netherrackCompost = "CaCO₃ + MgFeSiO₄ + SiO₂ + SO₃";
        final String graniteCompost = "SiO₂ + KAlSi₃O₈ + MgAlSi₃O₁₀(OH)₂";
        final String andesiteCompost = "NaAlSi₃O₈ + CaMgSi₂O₆ + (Fe,Mg)SiO₃";
        final String dioriteCompost = "NaAlSi₃O₈ + CaMgSi₂O₆ + K(Fe,Mg)AlSi₃O₁₀(OH)₂";
        final String tuffCompost = "SiO₂ + KAlSi₃O₈ + Al₂Si₂O₅(OH)₄ + X";
        final String basaltCompost = "NaAlSi₃O₈ + FeSiO₃ + (Mg,Fe)₂SiO₄";
        final String blackstoneCompost = "NaAlSi₃O₈ + CaFeSi₂O₆ + Fe₂O₃ + SO₃";
        final String obsidianCompost = "SiO₂ + Al₂O₃ + Fe₂O₃";
        final String coalCompound = "C";
        final String copperCompound = "Cu";
        final String ironCompound = "Fe";
        final String lapisCompound = "Na₃Ca(Al₃Si₃O₁₂)S";
        final String redstoneCompound = "HgSiO₃PS";
        final String goldCompost = "Au";
        final String diamondCompost = "C";
        final String emeraldCompost = "(Be₃Al₂Si₆O₁₈ + Cr³⁺)";
        final String amethystCompost = "SiO₂ + Fe";
        final String quartzCompost = "SiO₂";
        final String glowstoneCompost = "AuP₄S₄O₈";
        final String netheriteCompost = "Fe₂AuNiC(FeV)";

        //Mod composts
        final String uraniumCompound = "U";

        TOOLTIP_MAP.put(Blocks.SANDSTONE.asItem(), stoneCompost + " + CaCO₃");
        TOOLTIP_MAP.put(Blocks.RED_SAND.asItem(), stoneCompost + " + Fe₂O₃");
        TOOLTIP_MAP.put(Blocks.RED_SANDSTONE.asItem(), stoneCompost + " + Fe₂O₃");
    }
}
