package net.heaper.tech_mod.client.datagen.builder.texture;

import java.awt.*;
import java.awt.image.BufferedImage;

public class TextureRecolorUtil {
    public static BufferedImage recolor(BufferedImage image, Color overlay) {
        BufferedImage result = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);

        float gamma = 1.2f;

        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                int argb = image.getRGB(x, y);
                int alpha = (argb >> 24) & 0xff;
                if (alpha == 0) continue;

                int r = (argb >> 16) & 0xff;
                int g = (argb >> 8) & 0xff;
                int b = argb & 0xff;

                float brightness = (r + g + b) / (3f * 255f);

                float adjustedBrightness = (float) Math.pow(brightness, 1.0f / gamma);
                adjustedBrightness = Math.min(adjustedBrightness, 1.0f);

                int newR = (int)(overlay.getRed() * adjustedBrightness);
                int newB = (int)(overlay.getBlue() * adjustedBrightness);
                int newG = (int)(overlay.getGreen() * adjustedBrightness);

                int newArgb = (alpha << 24) | (newR << 16) | (newG << 8) | newB;
                result.setRGB(x, y, newArgb);
            }
        }
        return result;
    }

    public static BufferedImage darken(BufferedImage image, float factor) {
        if (factor < 0f || factor > 1f) throw new IllegalArgumentException("Darken factory must be between 0 and 1");
        BufferedImage result = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);

        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                int argb = image.getRGB(x, y);
                int alpha = (argb >> 24) & 0xff;
                if (alpha == 0) continue;

                int r = (int) (((argb >> 16 ) & 0xff) * (1 - factor));
                int g = (int) (((argb >> 8 ) & 0xff) * (1 - factor));
                int b = (int) ((argb & 0xff) * (1 - factor));

                int newArgb = (alpha << 24) | (r << 16) | (g << 8) | b;
                result.setRGB(x, y, newArgb);
            }
        }

        return result;
    }

    public static BufferedImage brighten(BufferedImage image, float factor) {
        if (factor < 0f || factor > 1f) throw new IllegalArgumentException("Brightness factor must between 0 and 1");
        BufferedImage result = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);

        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                int argb = image.getRGB(x, y);
                int alpha = (argb >> 24) & 0xff;
                if (alpha == 0) continue;

                int r = (int) (((argb >> 16 ) & 0xff) * (1 - factor));
                int g = (int) (((argb >> 8 ) & 0xff) * (1 - factor));
                int b = (int) ((argb & 0xff) * (1 - factor));

                r = Math.min(255, r);
                g = Math.min(255, g);
                b = Math.min(255, b);

                int newArgb = (alpha << 24) | (r << 16) | (g << 8) | b;
                result.setRGB(x, y, newArgb);
            }
        }

        return result;
    }
}