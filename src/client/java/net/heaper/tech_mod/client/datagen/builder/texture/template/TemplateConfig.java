package net.heaper.tech_mod.client.datagen.builder.texture.template;

import java.awt.*;

public class TemplateConfig {
    public final Template template;
    public final Color overlayColor;
    public final float rustIntensity;

    public TemplateConfig(Template template, Color overlayColor, float rustIntensity) {
        this.template = template;
        this.overlayColor = overlayColor;
        this.rustIntensity = rustIntensity;
    }

    public TemplateConfig(Template template, Color overlayColor) {
        this(template, overlayColor, 1f);
    }

    public Template getTemplate() {
        return template;
    }

    public Color getOverlayColor() {
        return overlayColor;
    }

    public Float getRustIntensity() {
        return rustIntensity;
    }
}
