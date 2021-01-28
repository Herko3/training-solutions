package week13.d04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Map;

public class TemplateEngine {

    public void merge(BufferedReader reader, Map<String, Object> data, BufferedWriter writer) {
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("{")) {
                    line = replaceKeyValue(line, data);
                }
                write(line, writer);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }
    }

    private void write(String s, BufferedWriter writer) {
        try {
            writer.write(s + "\n");
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot write file", ioe);
        }
    }

    private String replaceKeyValue(String s, Map<String, Object> data) {
        int start = s.indexOf("{");
        int end = s.indexOf("}");
        String key = s.substring(start + 1, end);
        s = s.replace("{" + key + "}", data.get(key).toString());
        return s;
    }
}
