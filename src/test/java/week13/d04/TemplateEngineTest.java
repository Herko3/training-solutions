package week13.d04;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class TemplateEngineTest {

    @Test
    void testMerge() {
        StringWriter sw = new StringWriter();

        Path template = Path.of("src/main/resources/template.txt");

        Map<String, Object> data =
                Map.of("nev", "John Doe",
                        "datum", LocalDate.of(2021, 1, 28),
                        "osszeg", 200000,
                        "hatarido", LocalDate.of(2021, 5, 28)
                );

        TemplateEngine test = new TemplateEngine();

        try (BufferedReader reader = Files.newBufferedReader(template);
             BufferedWriter writer = new BufferedWriter(sw)) {

            test.merge(reader,data,writer);

        } catch (IOException ioe) {
            throw new IllegalStateException();
        }

        System.out.println(sw.toString());

    }

}