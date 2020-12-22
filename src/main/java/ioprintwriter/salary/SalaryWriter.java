package ioprintwriter.salary;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class SalaryWriter {

    private List<String> names = new ArrayList<>();

    public SalaryWriter(List<String> names) {
        this.names = names;
    }

    public void writeNamesAndSalaries(Path file) {
        try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(file))){

            for(String name : names){
                writer.print(name);
                writer.print(": ");
                if(name.startsWith("Dr")){
                    writer.println(500000);
                } else if(name.startsWith("Mr") || name.startsWith("Mrs")){
                    writer.println(200000);
                } else{
                    writer.println(100000);
                }
            }

        } catch (IOException ioe){
            throw new IllegalStateException("Cannot read file", ioe);
        }
    }

}
