package properties;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class DatabaseConfiguration {

    Properties properties = new Properties();

    public DatabaseConfiguration() {
        InputStream is = this.getClass().getResourceAsStream("db.properties");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            properties.load(reader);
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Cannot read file");
        }
    }

    public DatabaseConfiguration(File file) {

        try (BufferedReader reader = Files.newBufferedReader(file.toPath())) {
            properties.load(reader);
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Cannot read file");
        }

    }

    public String getHost() {
        return properties.getProperty("db.host");
    }

    public int getPort() {
        String port = properties.getProperty("db.port");
        return Integer.parseInt(port);
    }

    public String getSchema() {
        return properties.getProperty("db.schema");
    }
}
