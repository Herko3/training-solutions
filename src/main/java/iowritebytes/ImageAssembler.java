package iowritebytes;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class ImageAssembler {

    public void makeImageFile(byte[][] image, Path folder){
        Path file = folder.resolve("image.png");

        try (OutputStream os = new BufferedOutputStream(Files.newOutputStream(file))){

            for(byte[] bytes : image){
                for(byte b : bytes){
                    os.write(b);
                }
            }

        } catch (IOException ioe){
            throw new IllegalStateException("Cannot write file", ioe);
        }

    }


}
