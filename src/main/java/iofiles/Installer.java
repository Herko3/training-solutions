package iofiles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Installer {

    public void install(String installFolder) {
        Path folder = Path.of(installFolder);
        if (!Files.exists(folder) || !Files.isDirectory(folder)) {
            throw new IllegalArgumentException("The given directory doesn't exist");
        }

        InputStream is = this.getClass().getResourceAsStream("/install/install.txt");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if(line.endsWith("/")){
                    Files.createDirectories(folder.resolve(line));
                } else {
                    Files.copy(this.getClass().getResourceAsStream("/install/" + line),folder.resolve(line),StandardCopyOption.REPLACE_EXISTING);
                }
            }

        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot copy files", ioe);
        }
    }

}
