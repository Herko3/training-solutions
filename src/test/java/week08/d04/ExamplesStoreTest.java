package week08.d04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExamplesStoreTest {

    @Test
    public void testRead(){
        ExamplesStore es = new ExamplesStore();
        assertEquals(2,es.getTitlesOfExamples("examples.md").size());
        assertEquals("# Első feladat",es.getTitlesOfExamples("examples.md").get(0));
    }

}