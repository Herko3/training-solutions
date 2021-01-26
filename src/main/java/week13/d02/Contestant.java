package week13.d02;


public class Contestant {

    static String correctAnswers;

    private String id;
    private String answers;
    private int score = 0;
    private int answerX = 0;

    public Contestant(String id, String answer) {
        this.id = id;
        if ("X".equals(answer)) {
            answerX++;
        }
        this.answers = answer;
    }

    public String getId() {
        return id;
    }

    public String getAnswers() {
        return answers;
    }

    public int getScore() {
        return score;
    }

    public void addAnswer(String answer) {
        if ("X".equals(answer)) {
            answerX++;
        }
        this.answers += answer;
    }

    public void setScore(int score) {
        this.score += score;
    }

    public int getAnswerX() {
        return answerX;
    }

    public void calculateScore() {
        for (int i = 0; i < correctAnswers.length(); i++) {
            if(correctAnswers.charAt(i) == answers.charAt(i)){
                score += (i+1);
            } else if('X' != answers.charAt(i)){
                score -= 2;
            }
        }
    }
}
