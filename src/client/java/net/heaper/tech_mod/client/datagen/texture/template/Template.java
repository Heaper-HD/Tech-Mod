package net.heaper.tech_mod.client.datagen.texture.template;

public class Template {
    private final String name;
    private final String templateFile;
    private final String shadowFile;

    public Template(String name, String templateFile) {
        this.name = name;
        this.templateFile = templateFile;
        this.shadowFile = null;
    }

    public Template(String name, String templateFile, String shadowFile) {
        this.name = name;
        this.templateFile = templateFile;
        this.shadowFile = shadowFile;
    }

    public String getName() {
        return name;
    }

    public String getTemplateFile() {
        return templateFile;
    }

    public String getShadowFile() {
        return shadowFile;
    }
}
