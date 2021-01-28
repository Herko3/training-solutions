package properties;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Properties;
import java.util.Set;

public class DatabaseConfiguration {

    Properties properties = new Properties();

    public DatabaseConfiguration() {
    }

    public DatabaseConfiguration(File file) {

        try (BufferedReader reader = Files.newBufferedReader(file.toPath())) {
            properties.load(reader);
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Cannot read file");
        }

    }

    public String getHost() {
        Set<String> keys = properties.stringPropertyNames();
        String defaultKey = "host";
        for (String key : keys) {
            if (key.contains(defaultKey)) {
                return properties.getProperty(key);
            }
        }
        return properties.getProperty(defaultKey, "localhost");
    }

    public int getPort() {
        Set<String> keys = properties.stringPropertyNames();
        String defaultKey = "port";
        for (String key : keys) {
            if (key.contains(defaultKey)) {
                return Integer.parseInt(properties.getProperty(key));
            }
        }
        String port = properties.getProperty(defaultKey, "1021");
        return Integer.parseInt(port);
    }

    public String getSchema() {
        Set<String> keys = properties.stringPropertyNames();
        String defaultKey = "schema";
        for (String key : keys) {
            if (key.contains(defaultKey)) {
                return properties.getProperty(key);
            }
        }
        return properties.getProperty(defaultKey, "árvíztűrő");
    }
}
