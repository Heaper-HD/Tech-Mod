package net.heaper.tech_mod.client.datagen.texture.template;

import net.heaper.tech_mod.client.datagen.texture.base.Base;

public class TextureDefinition {
    private final TemplateEntry templateEntry;
    private final Base base;

    public TextureDefinition(TemplateEntry templateEntry, Base base) {
        this.templateEntry = templateEntry;
        this.base = base;
    }

    public TemplateEntry getTemplateEntry() {
        return templateEntry;
    }

    public Base getBase() {
        return base;
    }
}
