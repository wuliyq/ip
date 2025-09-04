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
//        try {
//            if (input.equals("bye") || input.equals("Bye")) {
//                Ui.bye();
//                // endSession();
//            } else if (input.equals("list") || input.equals("List")) {
//                snowy.listTasks();
//            } else {
//                String[] parts = input.split(" ");
//                String command = parts[0];
//                if (command.equals("todo") || command.equals("deadline") || command.equals("event")) {
//                    Task task;
//                    if (command.equals("todo")) {
//                        if (parts.length < 2) {
//                            throw new SnowyException("OOPS! The description of a todo cannot be empty!");
//                        }
//                        String content = input.substring(5);
//                        task = new ToDo(content);
//                    } else if (command.equals("deadline")) {
//                        if (parts.length < 2) {
//                            throw new SnowyException("OOPS! The description of a deadline cannot be empty!");
//                        }
//                        String content = input.substring(9);
//                        if (!content.contains(" /by ")) {
//                            throw new SnowyException("You need to indicate a due date for a deadline task!");
//                        }
//                        String[] ddlParts = content.split(" /");
//                        task = new Deadline(ddlParts[0], ddlParts[1]);
//                    } else {
//                        if (parts.length < 2) {
//                            throw new SnowyException("OOPS! The description of an event cannot be empty!");
//                        }
//                        String content = input.substring(6);
//                        if ((!content.contains(" /from ")) || (!content.contains(" /to "))) {
//                            throw new SnowyException("An event task needs to have both starting time and end time!");
//                        }
//                        String[] eventParts = content.split(" /");
//                        task = new Event(eventParts[0], eventParts[0] + " " + eventParts[1]);
//                    }
//                    Snowy.addTask(task);
//                } else if ((command.equals("mark") || command.equals("unmark")) &&
//                        parts.length > 1) {
//                    int taskNum = -1;
//                    try {
//                        taskNum = Integer.parseInt(parts[1]);
//                    } catch (NumberFormatException e) {
//                        Ui.handleInvalidInput("Invalid task number :(");
//                    } finally {
//                        if ((!Snowy.checkListStatus()) &&
//                                taskNum > 0 &&
//                                taskNum <= TaskList.list.size()) {
//                            Task cur = TaskList.list.get(taskNum - 1);
//                            if (command.equals("mark")) {
//                                cur.mark();
//                                Ui.mark(cur);
//                            }
//                            if (command.equals("unmark")) {
//                                cur.unmark();
//                                Ui.unmark(cur);
//                            }
//                        }
//                    }
//                } else if (command.equals("delete") && parts.length > 1) {
//                    int taskNum = -1;
//                    try {
//                        taskNum = Integer.parseInt(parts[1]);
//                    } catch (NumberFormatException e) {
//                        Ui.handleInvalidInput("Invalid task number :(");
//                    } finally {
//                        if ((!TaskList.list.isEmpty()) && taskNum > 0 && taskNum <= TaskList.list.size()) {
//                            TaskList.list.remove(taskNum);
//                            Ui.delete(taskNum);
//                        } else {
//                            Ui.handleInvalidInput("Invalid task number :(");
//                        }
//                    }
//                } else {
//                    Ui.handleInvalidInput("Invalid input!");
//                }
//            }
//        } catch (SnowyException e) {
//            Ui.handleInvalidInput(e.getMessage());
//        }
//    }
//}
