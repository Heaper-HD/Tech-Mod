package net.heaper.tech_mod.client.datagen.texture.base;

public class Base {
    private final String name;
    private final String overlayFile;

    public Base(String name, String overlayFile) {
        this.name = name;
        this.overlayFile = overlayFile;
    }

    public String getName() {
        return name;
    }

    public String getOverlayFile() {
        return overlayFile;
    }
}
