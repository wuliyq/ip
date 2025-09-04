package snowy.command;

import snowy.TaskList;
import snowy.Storage;
import snowy.task.Task;

public class DeleteCommand extends Command{
    private final int taskNum;

    public DeleteCommand(int taskNum) {
        this.taskNum = taskNum;
    }

    @Override
    public String execute(TaskList tasks, Storage storage) {
        Task task = tasks.getTask(taskNum);
        tasks.deleteTask(taskNum);
        storage.save(tasks.getTasks());
        return "Noted. I've removed this task: " +
                task +
                ". " +
                "Now you have " + tasks.getSize() + " tasks in the list.";
    }
}
