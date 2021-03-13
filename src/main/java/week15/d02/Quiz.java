package week15.d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Quiz {

    List<Question> questions = new ArrayList<>();

    public void readFile(BufferedReader reader) {
        try (reader) {
            String question = null;
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("?")) {
                    question = line;
                } else {
                    String[] parts = line.split(" ");
                    int point = Integer.parseInt(parts[1]);
                    questions.add(new Question(question, parts[0], point, parts[2]));
                }
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("Point part isn't a number" + nfe);
        }
    }

    public List<String> questionsOfRequestedTopic(String topic) {
        return questions.stream()
                .filter(q -> q.getTopic().equals(topic))
                .map(Question::getQuestion)
                .collect(Collectors.toList());
    }

    public Question getRandomQuestion(Random rnd) {
        int index = rnd.nextInt(questions.size());
        return questions.get(index);
    }

    public Map<String, List<Question>> questionsByTopic() {
        return questions.stream()
                .collect(Collectors.groupingBy(Question::getTopic));
    }

    public String mostValuableTopic() {
        Map<String, Integer> pointsByTopic = questions.stream()
                .collect(Collectors.groupingBy(Question::getTopic, Collectors.summingInt(Question::getPoint)));

        int mostPoint = Integer.MIN_VALUE;
        String resultTopic = null;
        for (Map.Entry<String, Integer> entry : pointsByTopic.entrySet()) {
            int point = entry.getValue();
            if (point > mostPoint) {
                mostPoint = point;
                resultTopic = entry.getKey();
            }
        }
        return resultTopic;
    }

    public List<Question> getQuestions() {
        return new ArrayList<>(questions);
    }
}
