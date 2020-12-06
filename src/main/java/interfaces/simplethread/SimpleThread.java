package interfaces.simplethread;

import interfaces.Runnable;

import java.util.ArrayList;
import java.util.List;

public class SimpleThread implements Runnable {

    private List<String> tasks = new ArrayList<>();

    @Override
    public void run() {
        while (nextStep());

    }

    public List<String> getTasks() {
        return tasks;
    }

    public SimpleThread(List<String> tasks) {
        this.tasks = tasks;
    }

    private boolean nextStep() {
        if(!tasks.isEmpty()){
            tasks.remove(tasks.size()-1);
            return true;
        }
        return false;
    }
}
