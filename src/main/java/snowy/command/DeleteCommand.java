package snowy.command;

import snowy.ui.Ui;
import snowy.TaskList;
import snowy.Storage;
import snowy.task.Task;

public class DeleteCommand extends Command{
    private final int taskNum;

    public DeleteCommand(int taskNum) {
        this.taskNum = taskNum;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Task task = tasks.getTask(taskNum);
        tasks.deleteTask(taskNum);
        ui.delete(tasks, task);
        storage.save(tasks.getTasks());
    }
}
