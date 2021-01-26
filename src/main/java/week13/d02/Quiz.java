package week13.d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Quiz {

    private List<Contestant> contestants = new ArrayList<>();

    public Quiz(InputStream is) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            String line;
            Contestant.correctAnswers = reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                addOrAppendContestant(parts);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file");
        }
    }

    private void addOrAppendContestant(String[] parts) {
        for (Contestant contestant : contestants) {
            if (contestant.getId().equals(parts[0])) {
                contestant.addAnswer(parts[1]);
                return;
            }
        }
        contestants.add(new Contestant(parts[0], parts[1]));
    }

    public boolean correctAnswerById(String id, int number){
        for(Contestant contestant : contestants){
            if(contestant.getId().equals(id)){
                String answers = contestant.getAnswers();
                return answers.charAt(number-1) == Contestant.correctAnswers.charAt(number-1);
            }
        }
        throw new IllegalArgumentException("No contestant with id: " + id);
    }

    public String idWithMostX(){
        Contestant result = contestants.get(0);
        int xNumber = result.getAnswerX();
        for(Contestant contestant : contestants){
            if(xNumber < contestant.getAnswerX()){
                result = contestant;
                xNumber = result.getAnswerX();
            }
        }
        return result.getId();
    }

    public String getMostScore(){
        Contestant result = contestants.get(0);
        int score = result.getScore();
        for(Contestant contestant : contestants){
            if(score < contestant.getScore()){
                result = contestant;
                score = result.getAnswerX();
            }
        }
        return result.getId();
    }
}