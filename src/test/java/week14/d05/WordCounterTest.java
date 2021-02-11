package week14.d05;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class WordCounterTest {

    @Test
    void testCounting(){
        WordCounter wc = new WordCounter();
        Path path = Path.of("src/main/resources/week14/d05/hachiko.srt");

        assertEquals(87,wc.countWords(path,"Hachi"));
    }

    @Test
    void test(){
        WordCounter wc = new WordCounter();
        Path path = Path.of("src/main/resources/week14/d05/hachiko.srt");

        System.out.println(wc.countWords(path,"haza","Hachiko","jó"));
    }

}