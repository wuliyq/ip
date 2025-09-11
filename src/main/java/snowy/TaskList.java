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

    public ArrayList<Task> getTaskList() {
        return list;
    }

    public int getSize() {
        return list.size();
    }

    public Task getTask(int index) {
        assert index >= 0 && index < list.size() : "Index out of bounds";
        Task t = list.get(index);
        assert t != null : "Task at index " + index + " should not be null";
        return t;
    }

    public void addTask(Task task) {
        assert task != null : "Empty task should not be added to the task list";
        list.add(task);
    }

    public void deleteTask(int taskNum) {
        assert taskNum >= 0 && taskNum < list.size() : "TaskNum out of bounds";
        list.remove(taskNum);
    }
}
