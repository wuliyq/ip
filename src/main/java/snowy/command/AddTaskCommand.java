package snowy.command;

import snowy.TaskList;
import snowy.Storage;
import snowy.task.Task;

public class AddTaskCommand extends Command {
    private final Task task;

    public AddTaskCommand(Task task) {
        this.task = task;
    }

    @Override
    public String execute(TaskList tasks, Storage storage) {
        tasks.addTask(task);
//        ui.addTask(tasks, task);
        storage.save(tasks.getTaskList());
        return "Got it. I've added this task: " +
                task +
                ". " +
                "Now you have " +
                tasks.getSize() +
                (tasks.getSize() == 1 ? " task" : " tasks") +
                " in the list.";
    }
}
