package week05d05;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PlaylistTest {

    Playlist test = new Playlist(Arrays.asList(
            new Song("Numb", 300, "Linkin Park"),
            new Song("In the end", 340, "Linkin Park"),
            new Song("Castle of glass", 280, "Linkin Park")
    ));


    @Test
    public void testAdd(){
       assertEquals(3,test.getSongs().size());
    }

    @Test
    public void testExceptions(){
        Exception ex = assertThrows(IllegalArgumentException.class,()->new Song("",300,"sg"));
        assertEquals("Name and Artist must be something!",ex.getMessage());
        Exception ex2 = assertThrows(IllegalArgumentException.class,()->new Song("sg",300,""));
        assertEquals("Name and Artist must be something!",ex2.getMessage());
        Exception ex3 = assertThrows(IllegalArgumentException.class,()->new Song(null,300,"sg"));
        assertEquals("Name and Artist must be something!",ex3.getMessage());
        Exception ex4 = assertThrows(IllegalArgumentException.class,()->new Song("sg",300,null));
        assertEquals("Name and Artist must be something!",ex4.getMessage());

        Exception ex6 = assertThrows(IllegalArgumentException.class,()->new Playlist(null));
        assertEquals("Playlist is empty",ex6.getMessage());
        Exception ex5 = assertThrows(IllegalArgumentException.class,()->new Playlist(new ArrayList<>()));
        assertEquals("Playlist is empty",ex5.getMessage());
    }

    @Test
    public void testGreater () {

    }
}