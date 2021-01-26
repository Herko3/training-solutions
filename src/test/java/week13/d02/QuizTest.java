package week13.d02;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class QuizTest {


    @Test
    void testCorrectAnswersById(){
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("week13/d02/results.txt");
        Quiz quiz = new Quiz(is);

        assertTrue(quiz.correctAnswerById("AB123",1));
        assertFalse(quiz.correctAnswerById("BD452",1));
    }

    @Test
    void testMostX(){
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("week13/d02/results.txt");
        Quiz quiz = new Quiz(is);

        assertEquals("BD452",quiz.idWithMostX());
    }

    @Test
    void testMostScore(){
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("week13/d02/results.txt");
        Quiz quiz = new Quiz(is);

        assertEquals("AB123", quiz.getMostScore());
    }

}