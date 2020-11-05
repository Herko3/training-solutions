package intromethods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TodoList {

    private List<Todo> todos = new ArrayList<>();

    public void addTodo(String caption){
        todos.add(new Todo(caption));
    }

    public void finishTodos(String caption){
        for (Todo ciklus : todos){
            if (ciklus.getCaption().equals(caption)){
                ciklus.finish();
            }
        }
    }

    public void finishAllTodos(List<String> todosToFinish){
        for (Todo todo: todos){
            for(String item : todosToFinish){
                if(todo.getCaption().equals(item)){
                    todo.finish();
                }
            }
        }
    }

    public List<String> todosToFinish(){
        List<String> toFinish = new ArrayList<>();
        for (Todo finish : todos)
            if (!finish.isFinished()){
                toFinish.add(finish.getCaption());
            }
        return toFinish;
    }

    public int numberOfFinishedTodos(){
        int number = 0;
        for (Todo ciklus : todos){
            if(ciklus.isFinished()) {
                number++;
            }
        }
        return number;
    }

    @Override
    public String toString() {
        return todos.toString();
    }
}
