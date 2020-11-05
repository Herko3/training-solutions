package intromethods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TodoListMain {

    public static void main(String[] args) {
        TodoList test = new TodoList();

        test.addTodo("Takarítás");
        test.addTodo("Főzés");
        test.addTodo("Mosás");
        test.addTodo("Push");

        test.finishTodos("Takarítás");
        System.out.println(test.todosToFinish());
        System.out.println("Elvégzett feladatok száma: " + test.numberOfFinishedTodos());
        List<String> didIt = new ArrayList<>();
        didIt = Arrays.asList("Mosás", "Push");
        test.finishAllTodos(didIt);


        System.out.println("Elvégzett feladatok száma: " + test.numberOfFinishedTodos());
        System.out.println(test.toString());
    }

}
