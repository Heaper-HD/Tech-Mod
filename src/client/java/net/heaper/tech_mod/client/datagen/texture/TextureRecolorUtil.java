package net.heaper.tech_mod.client.datagen.texture;

import java.awt.*;
import java.awt.image.BufferedImage;

public class TextureRecolorUtil {
    public static BufferedImage recolor(BufferedImage image, Color overlay) {
        BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);

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
                newImage.setRGB(x, y, newArgb);
            }
        }
        return newImage;
    }
}
