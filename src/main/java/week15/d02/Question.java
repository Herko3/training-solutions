package week15.d02;

public class Question {

    private String question;
    private String answer;
    private int point;
    private String topic;

    public Question(String question, String answer, int point, String topic) {
        this.question = question;
        this.answer = answer;
        this.point = point;
        this.topic = topic;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public int getPoint() {
        return point;
    }

    public String getTopic() {
        return topic;
    }

    @Override
    public String toString() {
        return "Question{" +
                "question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", point=" + point +
                ", topic='" + topic + '\'' +
                '}';
    }
}