package net.heaper.tech_mod.client.datagen.texture;

import java.awt.image.BufferedImage;


public class TextureLayeringUtil {
    public static BufferedImage layer(BufferedImage base, BufferedImage overlay) {
        return layer(base, overlay, null);
    }

    public static BufferedImage layer(BufferedImage base, BufferedImage overlay, BufferedImage shadow) {
        final float SHADOW_STRENGTH = 0.22f;

        int width = Math.min(base.getWidth(), overlay.getWidth());
        int height = Math.min(base.getHeight(), overlay.getHeight());
        BufferedImage result = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int baseRGB = base.getRGB(x, y);
                int pixel = baseRGB;

                int overlayARGB = overlay.getRGB(x, y);
                int overlayAlpha = (overlayARGB >> 24) & 0xff;
                if (overlayAlpha > 0) pixel = overlayARGB;

                if (shadow != null){
                    int shadowARGB = shadow.getRGB(x, y);
                    int shadowAlpha = (shadowARGB >> 24) & 0xff;

                    if (shadowAlpha > 0) {
                        System.out.println("Changing shadow at: "+ x + " and: " + y);
                        int r = (pixel >> 16) & 0xff;
                        int g = (pixel >> 8) & 0xff;
                        int b = pixel & 0xff;

                        int shadowR = (shadowARGB >> 16) & 0xff;
                        int shadowG = (shadowARGB >> 8) & 0xff;
                        int shadowB = shadowARGB & 0xff;

                        float shadowIntensity = (shadowR + shadowG + shadowB) / (3f * 255f);

                        float alphaFactor = (shadowAlpha / 255f) * SHADOW_STRENGTH;

                        r = (int) (r * (1 - alphaFactor * (1 - shadowIntensity)));
                        g = (int) (g * (1 - alphaFactor * (1 - shadowIntensity)));
                        b = (int) (b * (1 - alphaFactor * (1 - shadowIntensity)));

                        int alpha = (pixel >> 24) & 0xff;
                        pixel = (alpha << 24) | (r << 16) | (g << 8) | b;
                    }
                }

                result.setRGB(x, y, pixel);
            }
        }

        return result;
    }
}
