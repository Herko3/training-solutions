package exam03retake02;

public class Todo implements Comparable<Todo> {

    private String text;
    private int priority;
    private State state;

    public Todo(String name, int priority) {
        if (priority < 1 || priority > 5) {
            throw new IllegalArgumentException("Priority must be between 1-5");
        }
        this.text = name;
        this.priority = priority;
        state = State.NON_COMPLETED;
    }

    public void complete() {
        state = State.COMPLETED;
    }

    public String getText() {
        return text;
    }

    public int getPriority() {
        return priority;
    }

    public State getState() {
        return state;
    }

    @Override
    public int compareTo(Todo o) {
        return priority - o.priority;
    }
}
