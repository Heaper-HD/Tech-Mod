package net.heaper.tech_mod.client.datagen.texture;

public class Template {
    private final String name;
    private final String templateFile;

    public Template(String name, String templateFile) {
        this.name = name;
        this.templateFile = templateFile;
    }

    public String getName() {
        return name;
    }

    public String getTemplateFile() {
        return templateFile;
    }
}
