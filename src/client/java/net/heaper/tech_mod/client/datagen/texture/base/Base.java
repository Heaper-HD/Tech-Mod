package net.heaper.tech_mod.client.datagen.texture.base;

public enum Base {
    STONE("stone.png"),
    DEEPSLATE("deepslate.png"),
    NETHERRACK("netherrack.png"),
    END_STONE("end_stone.png");

    private final String overlayFile;

    Base(String overlayFile) {
        this.overlayFile = overlayFile;
    }

    public String getTextureFile() {
        return overlayFile;
    }
}
