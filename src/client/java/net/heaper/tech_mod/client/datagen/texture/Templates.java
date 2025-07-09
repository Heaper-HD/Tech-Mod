package net.heaper.tech_mod.client.datagen.texture;

import java.util.HashMap;
import java.util.Map;

public class Templates {
    public static final Template RAW_IRON = new Template("Raw Iron", "raw_iron_template.png");
    public static final Template RAW_IRON_BLOCK = new Template("Raw Iron Block", "raw_iron_block_template.png");

    private static final Map<String, Template> TEMPLATE_MAP = new HashMap<>();

    static {
        register(RAW_IRON);
        register(RAW_IRON_BLOCK);
    }

    private static void register(Template template) {
        TEMPLATE_MAP.putIfAbsent(template.getName(), template);
    }

    public static Template getByName(String name) {
        return TEMPLATE_MAP.get(name);
    }
}
