import java.util.ArrayList;

public class TaskList {
    public static ArrayList<Task> list;
    public TaskList() {
        list = new ArrayList<>();
    }

    public TaskList(ArrayList<Task> tasks) {
        list = new ArrayList<>(tasks);
    }

//    public void addTask(Task task) {
//        list.add(task);
//    }
//
//    public void deleteTask(int num) {
//        list.remove(num - 1);
//    }
}
