package ioreadbytes.byteacount;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class ByteChecker {

    public int readBytesAndFindAs(String fileName){
        Path folder = Path.of("src","main","resources","ioreadbytes","byteacount");
        Path file = folder.resolve(fileName);
        int aCount = 0;

        try(InputStream inputStream = new BufferedInputStream(Files.newInputStream(file))){
            byte[] bytes = new byte[1000];
            int size;
            while((size = inputStream.read(bytes)) > 0){
                aCount += countA(bytes);
            }
        } catch (IOException ioe){
            throw new IllegalStateException("Cannot read file", ioe);
        }
        return aCount;
    }

    private int countA(byte[] bytes){
        int count = 0;
        for(byte b : bytes){
            if (b == 97){
                count++;
            }
        }
        return count;
    }

}
