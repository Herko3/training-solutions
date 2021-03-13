package week15.d03;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PostFinderTest {

    private List<Post> posts = Arrays.asList(
            new Post("Post1", LocalDate.of(2020,10,2),null,"blabla","John Doe"),
            new Post("Post2", LocalDate.of(2020,11,2),null,"blabla","Jack Doe"),
            new Post("Post3", LocalDate.of(2020,10,2),LocalDate.of(2021,3,10),"blabla","Jack Doe"),
            new Post("Post4", LocalDate.of(2021,10,2),null,"blabla","Jack Doe")
    );

    @Test
    public void testOnlyPublished(){

        assertEquals(2,new PostFinder(posts).findPosts("John Doe").size());
    }


    @Test
    public void testUserCanSeeUnpublished(){

        assertEquals(3,new PostFinder(posts).findPosts("Jack Doe").size());
    }
}