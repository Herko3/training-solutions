package covid;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalTime;
import java.util.List;

public class PrintFile {

    public static final String HEADER = "Időpont;Név;Irányítószám;Életkor;E-mail cím;TAJ szám";

    public void saveToFile(List<Citizen> citizens, String fileName){
        LocalTime time = LocalTime.of(8,0);
        Path path = Path.of("src/main/resources/covid/", fileName);
        try(PrintWriter writer = new PrintWriter(Files.newBufferedWriter(path))){
            writer.println(HEADER);
            for(Citizen citizen: citizens){
             String line = String.format("%s;%s;%s;%d;%s;%s",time,citizen.getFullName(),citizen.getZipcode(),citizen.getAge(),citizen.getEmail(),citizen.getSsn());
             writer.println(line);
             time = time.plusMinutes(30);
            }
        } catch (IOException ioe){
            throw new IllegalArgumentException("Cannot write file", ioe);
        }
    }
}
