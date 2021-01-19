package week12.d02;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReadFromFileTest {

    private InputStream is = ReadFromFile.class.getResourceAsStream("kerites.txt");

    @TempDir
    public File folder;

    @Test
    void testReadFromFile() {

        ReadFromFile readFromFile = new ReadFromFile(is);
        assertEquals(98, readFromFile.getHouseList().size());
        assertEquals("P", readFromFile.getHouseList().get(0).getColorOfHedge());
        assertEquals("S", readFromFile.getHouseList().get(readFromFile.getHouseList().size() - 1).getColorOfHedge());

    }

    @Test
    void housesByArea() {
        ReadFromFile readFromFile = new ReadFromFile(is);
        List<House> result = readFromFile.housesByArea();

        assertEquals(8,result.get(0).getWidth());
        assertEquals(20,result.get(result.size()-1).getWidth());
    }

    @Test
    void lastNumber() {
        ReadFromFile readFromFile = new ReadFromFile(is);
        assertEquals(78,readFromFile.lastNumber());
    }

    @Test
    void writeOddStreetView() {
        File file = new File(folder, "test.txt");
        Path targetPath = file.toPath();

        ReadFromFile readFromFile = new ReadFromFile(is);
        readFromFile.writeOddStreetView(targetPath);

        assertTrue(Files.exists(folder.toPath().resolve("test.txt")));

    }
}