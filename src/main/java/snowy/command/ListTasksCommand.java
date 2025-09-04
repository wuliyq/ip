package snowy.command;

import snowy.ui.Ui;
import snowy.TaskList;
import snowy.Storage;

public class ListTasksCommand extends Command {
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        if (tasks.getSize() == 0) {
            ui.handleEmptyTaskList();
        } else {
            ui.listTasks(tasks);
        }
    }
}
