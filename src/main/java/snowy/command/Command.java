package snowy.command;

import snowy.ui.Ui;
import snowy.TaskList;
import snowy.Storage;
import snowy.SnowyException;

public abstract class Command {
    public abstract void execute(TaskList tasks, Ui ui, Storage storage) throws SnowyException;

    public boolean isEnd() {
        return false;
    }
}
