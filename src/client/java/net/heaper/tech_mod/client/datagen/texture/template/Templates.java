package net.heaper.tech_mod.client.datagen.texture.template;

import java.util.HashMap;
import java.util.Map;

public class Templates {
    public static final Template RAW_IRON = new Template("Raw Iron", "raw_iron_template.png");
    public static final Template IRON_INGOT = new Template("Iron Ingot", "iron_ingot_template.png");
    public static final Template RAW_IRON_BLOCK = new Template("Raw Iron Block", "raw_iron_block_template.png");

    public static final Template IRON_ORE = new Template("Iron Ore", "iron_ore_template.png", "iron_ore_template_shadow.png");

    public static final Template COAL_BLOCK = new Template("Coal Block", "coal_block_template.png");
    public static final Template COPPER_BLOCK = new Template("Copper Block", "copper_block_template.png");
    public static final Template IRON_BLOCK = new Template("Iron Block", "iron_block_template.png");
    public static final Template REDSTONE_BLOCK = new Template("Redstone Block", "redstone_block_template.png");
    public static final Template LAPIS_BLOCK = new Template("Lapis Block", "lapis_block_template.png");
    public static final Template GOLD_BLOCK = new Template("Gold Block", "gold_block_template.png");
    public static final Template DIAMOND_BLOCK = new Template("Diamond Block", "diamond_block_template.png");
    public static final Template EMERALD_BLOCK = new Template("Emerald Block", "emerald_block_template.png");
    public static final Template NETHERITE_BLOCK = new Template("Netherite Block", "netherite_block_template.png");

    private static final Map<String, Template> TEMPLATE_MAP = new HashMap<>();

    static {
        register(RAW_IRON);
        register(IRON_INGOT);
        register(RAW_IRON_BLOCK);
        register(IRON_ORE);
        register(COAL_BLOCK);
        register(COPPER_BLOCK);
        register(IRON_BLOCK);
        register(REDSTONE_BLOCK);
        register(LAPIS_BLOCK);
        register(GOLD_BLOCK);
        register(DIAMOND_BLOCK);
        register(EMERALD_BLOCK);
        register(NETHERITE_BLOCK);
    }

    private static void register(Template template) {
        TEMPLATE_MAP.putIfAbsent(template.getName().toLowerCase(), template);
    }

    public static Template getByName(String name) {
        return TEMPLATE_MAP.get(name.toLowerCase());
    }
}
