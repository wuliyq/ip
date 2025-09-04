package snowy.command;

import snowy.ui.Ui;
import snowy.TaskList;
import snowy.Storage;

public class ByeCommand extends Command{
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.bye();
    }

    @Override
    public boolean isEnd() {
        return true;
    }
}
