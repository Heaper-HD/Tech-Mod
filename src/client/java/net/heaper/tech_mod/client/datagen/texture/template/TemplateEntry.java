package net.heaper.tech_mod.client.datagen.texture.template;

import java.awt.*;

public class TemplateEntry {
    public final Template template;
    public final Color overlayColor;

    public TemplateEntry(Template template, Color overlayColor) {
        this.template = template;
        this.overlayColor = overlayColor;
    }

    public Template getTemplate() {
        return template;
    }

    public Color getOverlayColor() {
        return overlayColor;
    }
}
