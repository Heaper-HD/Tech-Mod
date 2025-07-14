package net.heaper.tech_mod.client.datagen.builder.texture;

import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;
import net.minecraft.data.DataWriter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Path;

public class ImageWriter {
    public static void writeImage(Path path, BufferedImage image, DataWriter writer) throws IOException {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        ImageIO.write(image, "png", stream);
        byte[] data = stream.toByteArray();
        HashCode hash = Hashing.sha256().hashBytes(data);
        writer.write(path, data, hash);
    }
}
