package week15.d02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class QuizTest {

    Quiz quiz;

    @BeforeEach
    void init(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(Quiz.class.getResourceAsStream("kerdesek.txt")));
        quiz = new Quiz();
        quiz.readFile(reader);
    }

    @Test
    void testGetQuestionsByTopic(){
        List<String> result = quiz.questionsOfRequestedTopic("matematika");
        assertEquals("Mennyi az elso 100 szam osszege?",result.get(3));
        assertEquals(21,result.size());
    }

    @Test
    void testRandomQuestion(){
        Random rnd = new Random(5);
        Question result = quiz.getRandomQuestion(rnd);

        assertEquals("Hany lakosa volt Magyarorszag legkisebb telepulesenek, Iborfianak, 2012 januar 1-en?",result.getQuestion());
        assertEquals(3,result.getPoint());
    }

    @Test
    void testMapping(){
        Map<String, List<Question>> result = quiz.questionsByTopic();
        assertEquals(21,result.get("matematika").size());
    }

    @Test
    void mostPoint(){
        String result = quiz.mostValuableTopic();

        assertEquals("matematika",result);
    }

}