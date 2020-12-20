package week08.d03;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StringListsTest {

    List<String> list = Arrays.asList("aaa", "aa", "bb", "cccc", "dd");

    @Test
    public void testMethod(){
        StringLists stringList = new StringLists();
        List<String> expected = Arrays.asList("aa", "bb", "dd");

        assertEquals(expected,stringList.shortestWords(list));
    }

}