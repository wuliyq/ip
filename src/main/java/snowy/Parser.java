package snowy;

import snowy.task.*;

import snowy.ui.Ui;

/**
 * Parses the input string that is passed from Ui into different commands with specific information.
 */
public class Parser {
    public static boolean isEnd;

    /**
     * Parses the input string based on its content to generate corresponding commands and execute tasks.
     * @param input
     * @throws SnowyException
     */
    public static void parse(String input) throws SnowyException{
        try {
            if (input.equals("bye") || input.equals("Bye")) {
                Ui.bye();
                Parser.isEnd = true;
            } else if (input.equals("list") || input.equals("List")) {
                Ui.list();
            } else {
                String[] parts = input.split(" ");
                String command = parts[0];
                if (command.equals("todo") || command.equals("deadline") || command.equals("event")) {
                    Task task;
                    if (command.equals("todo")) {
                        if (parts.length < 2) {
                            throw new SnowyException("OOPS! The description of a todo cannot be empty!");
                        }
                        String content = input.substring(5);
                        task = new ToDo(content);
                    } else if (command.equals("deadline")) {
                        if (parts.length < 2) {
                            throw new SnowyException("OOPS! The description of a deadline cannot be empty!");
                        }
                        String content = input.substring(9);
                        if (!content.contains(" /by ")) {
                            throw new SnowyException("You need to indicate a due date for a deadline task!");
                        }
                        String[] ddlParts = content.split(" /");
                        task = new Deadline(ddlParts[0], ddlParts[1]);
                    } else {
                        if (parts.length < 2) {
                            throw new SnowyException("OOPS! The description of an event cannot be empty!");
                        }
                        String content = input.substring(6);
                        if ((!content.contains(" /from ")) || (!content.contains(" /to "))) {
                            throw new SnowyException("An event task needs to have both starting time and end time!");
                        }
                        String[] eventParts = content.split(" /");
                        task = new Event(eventParts[0], eventParts[0] + " " + eventParts[1]);
                    }
                    TaskList.list.add(task);
                    Ui.add(task);
                } else if ((command.equals("mark") || command.equals("unmark")) &&
                        parts.length > 1) {
                    int taskNum = -1;
                    try {
                        taskNum = Integer.parseInt(parts[1]);
                    } catch (NumberFormatException e) {
                        Ui.invalidInput("Invalid task number :(");
                    } finally {
                        if ((!TaskList.list.isEmpty()) &&
                                taskNum > 0 &&
                                taskNum <= TaskList.list.size()) {
                            Task cur = TaskList.list.get(taskNum - 1);
                            if (command.equals("mark")) {
                                cur.mark();
                                Ui.mark(cur);
                            }
                            if (command.equals("unmark")) {
                                cur.unmark();
                                Ui.unmark(cur);
                            }
                        }
                    }
                } else if (command.equals("delete") && parts.length > 1) {
                    int taskNum = -1;
                    try {
                        taskNum = Integer.parseInt(parts[1]);
                    } catch (NumberFormatException e) {
                        Ui.invalidInput("Invalid task number :(");
                    } finally {
                        if ((!TaskList.list.isEmpty()) && taskNum > 0 && taskNum <= TaskList.list.size()) {
                            TaskList.list.remove(taskNum);
                            Ui.delete(taskNum);
                        } else {
                            Ui.invalidInput("Invalid task number :(");
                        }
                    }
                } else {
                    Ui.invalidInput("Invalid input!");
                }
            }
        } catch (SnowyException e) {
            Ui.invalidInput(e.getMessage());
        }
    }
}
