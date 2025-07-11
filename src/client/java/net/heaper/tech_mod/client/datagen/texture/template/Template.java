package net.heaper.tech_mod.client.datagen.texture.template;

public class Template {
    private final String name;
    private final String templateFile;
    private final String shadowFile;
    private final String rustFile;

    private Template(Builder builder) {
        this.name = builder.name;
        this.templateFile = builder.templateFile;
        this.shadowFile = builder.shadowFile;
        this.rustFile = builder.rustFile;
    }

    public static class Builder {
        private final String name;
        private final String templateFile;
        private String shadowFile;
        private String rustFile;

        public Builder(String name, String templateFile) {
            this.name = name;
            this.templateFile = templateFile;
        }

        public Builder shadow(String shadowFile) {
            this.shadowFile = shadowFile;
            return this;
        }

        public Builder rust(String rustFile) {
            this.rustFile = rustFile;
            return this;
        }

        public Template build() {
            return new Template(this);
        }
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

    public String getRustFile() {
        return rustFile;
    }
}
