package net.heaper.tech_mod.client.datagen.texture.template;

import net.heaper.tech_mod.client.datagen.texture.base.Base;

public class TextureDefinition {
    private final TemplateConfig config;
    private final Base base;

    public TextureDefinition(TemplateConfig config, Base base) {
        this.config = config;
        this.base = base;
    }

    public TemplateConfig getTemplateEntry() {
        return config;
    }

    public Base getBase() {
        return base;
    }
}
