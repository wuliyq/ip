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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Here are the tasks in you list:\n");
        int total = list.size();
        for (int i = 0; i < total; i++) {
            Task cur = list.get(i);
            sb.append(i + 1).append(". ").append(cur).append("\n");
        }
        return sb.toString();
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
