package net.heaper.tech_mod.client.datagen.builder.texture.template;

import java.util.HashMap;
import java.util.Map;

public class Templates {
    public static final Template RAW_IRON = new Template.Builder("Raw Iron", "raw_iron_template.png").build();
    public static final Template RAW_COPPER = new Template.Builder("Raw Copper", "raw_copper_template.png")
            .rust("raw_copper_rust_template.png")
            .build();

    public static final Template IRON_INGOT = new Template.Builder("Iron Ingot", "iron_ingot_template.png").build();

    public static final Template RAW_IRON_BLOCK = new Template.Builder("Raw Iron Block", "raw_iron_block_template.png").build();

    public static final Template IRON_ORE = new Template.Builder("Iron Ore", "iron_ore_template.png")
            .shadow("iron_ore_shadow_template.png").build();
    public static final Template COPPER_ORE = new Template.Builder("Copper Ore", "copper_ore_template.png")
            .shadow("copper_ore_shadow_template.png")
            .rust("copper_ore_rust_template.png").build();

    public static final Template COAL_BLOCK = new Template.Builder("Coal Block", "coal_block_template.png").build();
    public static final Template COPPER_BLOCK = new Template.Builder("Copper Block", "copper_block_template.png").build();
    public static final Template IRON_BLOCK = new Template.Builder("Iron Block", "iron_block_template.png").build();
    public static final Template REDSTONE_BLOCK = new Template.Builder("Redstone Block", "redstone_block_template.png").build();
    public static final Template LAPIS_BLOCK = new Template.Builder("Lapis Block", "lapis_block_template.png").build();
    public static final Template GOLD_BLOCK = new Template.Builder("Gold Block", "gold_block_template.png").build();
    public static final Template DIAMOND_BLOCK = new Template.Builder("Diamond Block", "diamond_block_template.png").build();
    public static final Template EMERALD_BLOCK = new Template.Builder("Emerald Block", "emerald_block_template.png").build();
    public static final Template NETHERITE_BLOCK = new Template.Builder("Netherite Block", "netherite_block_template.png").build();

    private static final Map<String, Template> TEMPLATE_MAP = new HashMap<>();

    static {
        register(RAW_IRON);
        register(RAW_COPPER);

        register(IRON_INGOT);

        register(RAW_IRON_BLOCK);

        register(IRON_ORE);
        register(COPPER_ORE);

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
