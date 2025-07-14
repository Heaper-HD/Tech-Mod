package net.heaper.tech_mod.client.datagen.builder.texture;

import java.awt.image.BufferedImage;


public class TextureLayeringUtil {
    public static BufferedImage staticLayer(BufferedImage base, BufferedImage layer) {
        int width = Math.min(base.getWidth(), layer.getWidth());
        int height = Math.min(base.getHeight(), layer.getHeight());
        BufferedImage result = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int baseARGB = base.getRGB(x, y);
                int layerARGB = layer.getRGB(x, y);
                int layerAlpha = (layerARGB >> 24) & 0xff;

                result.setRGB(x, y, layerAlpha > 0 ? layerARGB : baseARGB);
            }
        }

        return result;
    }

    public static BufferedImage blendLayer(BufferedImage base, BufferedImage layer) {
        int width = Math.min(base.getWidth(), layer.getWidth());
        int height = Math.min(base.getHeight(), layer.getHeight());
        BufferedImage result = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int baseARGB = base.getRGB(x ,y);
                int layerARGB = layer.getRGB(x, y);

                int layerAlpha = (layerARGB >> 24) & 0xff;

                if (layerAlpha == 0) {
                    result.setRGB(x, y, baseARGB);
                    continue;
                }

                float alpha = layerAlpha / 255f;

                int baseR = (baseARGB >> 16) & 0xff;
                int baseG = (baseARGB >> 8) & 0xff;
                int baseB = baseARGB & 0xff;

                int layerR = (layerARGB >> 16) & 0xff;
                int layerG = (layerARGB >> 8) & 0xff;
                int layerB = layerARGB & 0xff;

                int r = (int) (layerR * alpha + baseR * (1 - alpha));
                int g = (int) (layerG * alpha + baseG * (1 - alpha));
                int b = (int) (layerB * alpha + baseB * (1 - alpha));
                int a = Math.max((baseARGB >> 24) & 0xff, layerAlpha);

                result.setRGB(x, y, (a << 24) | (r << 16) | (g << 8) | b);
            }
        }

        return result;
    }

    public static BufferedImage multiplyLayer(BufferedImage base, BufferedImage layer) {
        int width = Math.min(base.getWidth(), layer.getWidth());
        int height = Math.min(base.getHeight(), layer.getHeight());
        BufferedImage result = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int baseARGB = base.getRGB(x ,y);
                int layerARGB = layer.getRGB(x, y);

                int baseA = (baseARGB >> 24) & 0xff;
                int baseR = (baseARGB >> 16) & 0xff;
                int baseG = (baseARGB >> 8) & 0xff;
                int baseB = baseARGB & 0xff;

                int layerA = (layerARGB >> 24) & 0xff;
                int layerR = (layerARGB >> 16) & 0xff;
                int layerG = (layerARGB >> 8) & 0xff;
                int layerB = layerARGB & 0xff;

                int r = (int) (layerR * baseR) / 255;
                int g = (int) (layerG * baseG) / 255;
                int b = (int) (layerB * baseB) / 255;
                int a = Math.max(baseA, layerA);

                result.setRGB(x, y, (a << 24) | (r << 16) | (g << 8) | b);
            }
        }
        return result;
    }
}
