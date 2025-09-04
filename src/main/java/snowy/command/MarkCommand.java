package snowy.command;

import snowy.task.Task;
import snowy.ui.Ui;
import snowy.TaskList;
import snowy.Storage;

public class MarkCommand extends Command {
    private final int taskNum;
    private final boolean isMarkDone;

    public MarkCommand(int taskNum, boolean isMarkDone) {
        this.taskNum = taskNum;
        this.isMarkDone = isMarkDone;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Task task = tasks.getTask(taskNum);
        if (isMarkDone) {
            task.mark();
            ui.mark(task);
        } else {
            task.unmark();
            ui.unmark(task);
        }
        storage.save(tasks.getTasks());
    }
}
