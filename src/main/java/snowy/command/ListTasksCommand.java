package snowy.command;

import snowy.TaskList;
import snowy.Storage;

public class ListTasksCommand extends Command {
    @Override
    public String execute(TaskList tasks, Storage storage) {
        if (tasks.getSize() == 0) {
            return "You don't have upcoming tasks right now! Yeah! :D";
        } else {
            return tasks.toString();
        }
    }
}
