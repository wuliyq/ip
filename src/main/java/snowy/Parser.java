package snowy;

import snowy.command.AddTaskCommand;
import snowy.command.ByeCommand;
import snowy.command.DeleteCommand;
import snowy.command.FindCommand;
import snowy.command.ListTasksCommand;
import snowy.command.MarkCommand;
import snowy.task.Task;
import snowy.task.ToDo;
import snowy.task.Deadline;
import snowy.task.Event;
import snowy.ui.Ui;
import snowy.command.Command;

/**
 * Parses the input string that is passed from Ui into different commands with specific information.
 */
public class Parser {
    // private boolean isEnd;

//    public void endSession() {
//        this.isEnd = true;
//    }

    /**
     * Parses the input string based on its content to generate corresponding commands and execute tasks.
     *
     * @param input
     * @throws SnowyException
     */
    public static Command parse(String input) throws SnowyException {
        assert input != null && (!input.trim().isEmpty()) : "Input command should not be empty";
        String[] parts = input.split(" ", 2);
        String command = parts[0].toLowerCase();

        switch (command) {
        case "bye":
            return new ByeCommand();
        case "list":
            return new ListTasksCommand();
        case "todo":
            if (parts.length < 2) {
                throw new SnowyException("OOPS! The description of a todo cannot be empty!");
            }

            return new AddTaskCommand(new ToDo(parts[1]));
        case "deadline":
            if (parts.length < 2) {
                throw new SnowyException("OOPS! The description of a deadline cannot be empty!");
            }

            String[] ddlParts = parts[1].split(" /by ", 2);

            if (ddlParts.length < 2) {
                throw new SnowyException("You need to indicate a due date for a deadline task!");
            }

            return new AddTaskCommand(new Deadline(ddlParts[0], ddlParts[1]));
        case "event":
            if (parts.length < 2) {
                throw new SnowyException("OOPS! The description of an event cannot be empty!");
            }

            String[] eventParts = parts[1].split(" /from | /to ");

            if (eventParts.length < 3) {
                throw new SnowyException("An event needs a start and end time!");
            }

            return new AddTaskCommand(new Event(eventParts[0], eventParts[1] + " to " + eventParts[2]));
        case "mark":
            return new MarkCommand(Integer.parseInt(parts[1]), true);
        case "unmark":
            return new MarkCommand(Integer.parseInt(parts[1]), false);
        case "delete":
            return new DeleteCommand(Integer.parseInt(parts[1]));
        case "find":
            return new FindCommand(parts[1]);
        default:
            throw new SnowyException("Invalid input!");
        }
    }
}