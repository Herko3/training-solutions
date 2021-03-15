package covid;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PrintFileTest {

    @Test
    void testCreateFile(){
        PrintFile printFile = new PrintFile();
        List<Citizen> citizens = Arrays.asList(
                new Citizen("John Doe", "1214", 28, "jd@gmail.com", "123456781"),
                new Citizen("Jack Doe", "1214", 30, "jd@asd.com", "12346534")
        );
        String fileName = "test.txt";
        printFile.saveToFile(citizens,fileName);

        String expected = "08:00;John Doe;1214;28;jd@gmail.com;123456781";
        String expected2 = "08:30;Jack Doe;1214;30;jd@asd.com;12346534" ;

        String line1;
        String line2;

        try(BufferedReader reader = Files.newBufferedReader(Path.of("src/main/resources/covid/", fileName))){
            reader.readLine();
            line1 = reader.readLine();
            line2 = reader.readLine();
        }catch(IOException ioe){
            throw new IllegalArgumentException("Cannot read", ioe);
        }

        assertEquals(expected,line1);
        assertEquals(expected2,line2);
    }

}