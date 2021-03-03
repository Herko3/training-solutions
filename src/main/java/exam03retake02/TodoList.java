package exam03retake02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TodoList {

    private List<Todo> todos = new ArrayList<>();

    public void addTodo(Todo todo) {
        todos.add(todo);
    }

    public List<Todo> getTodos() {
        return new ArrayList<>(todos);
    }

    public long getNumberOfItemsLeft() {
        return todos.stream()
                .filter(todo -> todo.getState() == State.NON_COMPLETED)
                .count();
    }

    public List<String> getMostImportantTodosText() {
//        List<String> result = new ArrayList<>();
//        Collections.sort(todos);
        int lowestPriority = todos.stream().mapToInt(Todo::getPriority).min().getAsInt();
//        for (Todo todo : todos) {
//            if (todo.getPriority() == lowestPriority) {
//                result.add(todo.getText());
//            }
//        }
        return todos.stream()
                .filter(todo -> todo.getPriority() == lowestPriority)
                .map(Todo::getText)
                .collect(Collectors.toList());
    }

    public void deleteCompleted() {
        todos.removeIf(Todo::isCompleted);
    }
}
