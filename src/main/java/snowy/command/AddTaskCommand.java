package snowy.command;

import snowy.ui.Ui;
import snowy.TaskList;
import snowy.Storage;
import snowy.task.Task;

public class AddTaskCommand extends Command {
    private final Task task;

    public AddTaskCommand(Task task) {
        this.task = task;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        tasks.addTask(task);
        ui.addTask(tasks, task);
        storage.save(tasks.getTasks());
    }
}
