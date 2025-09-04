package snowy.command;

import java.util.ArrayList;

import snowy.ui.Ui;
import snowy.TaskList;
import snowy.Storage;
import snowy.task.Task;

public class FindCommand extends Command {
    private final String keyWord;

    public FindCommand(String keyWord) {
        this.keyWord = keyWord;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ArrayList<Task> result = new ArrayList<>();
        int count = tasks.getSize();
        for (int i = 0; i < count; i++) {
            Task task = tasks.getTask(i);
            if (task.toString().toLowerCase().contains(keyWord.toLowerCase())) {
                result.add(task);
            }
        }
        if (result.isEmpty()) {
            ui.handleInvalidInput("No tasks found with keyword: " + keyWord);
        } else {
            ui.listFoundTasks(result);
        }
    }
}
