package week05d05;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PlaylistTest {



    @Test
    public void testAdd(){
        Playlist test = new Playlist(Arrays.asList(
                new Song("Numb", 300, "Linkin Park"),
                new Song("In the end", 340, "Linkin Park"),
                new Song("Castle of glass", 280, "Linkin Park")
        ));

        assertEquals(3,test.getSongs().size());
    }

    @Test
    public void testExceptions(){
        Exception ex = assertThrows(IllegalArgumentException.class,()->new Song("",300,"sg"));
        assertEquals("Name and Artist must be something!",ex.getMessage());
    }
}