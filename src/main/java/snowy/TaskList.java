package snowy;

import snowy.task.*;

import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> list;

    public TaskList() {
        list = new ArrayList<>();
    }

    public TaskList(ArrayList<Task> tasks) {
        list = new ArrayList<>(tasks);
    }

    public boolean isEmptyList() {
        return list.isEmpty();
    }

    public ArrayList<Task> getTasks() {
        return list;
    }

    public int getSize() {
        return list.size();
    }

    public Task getTask(int index) {
        return list.get(index);
    }

    public void addTask(Task task) {
        list.add(task);
    }

    public void deleteTask(int taskNum) {
        list.remove(taskNum);
    }

//    public void addTask(Task task) {
//        list.add(task);
//    }
//
//    public void deleteTask(int num) {
//        list.remove(num - 1);
//    }
}
