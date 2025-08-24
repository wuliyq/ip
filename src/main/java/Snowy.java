import java.util.Scanner;
import java.util.ArrayList;

public class Snowy {
    public static ArrayList<Task> tasks = new ArrayList<>();

    public static void main(String[] args) {
        // Version 1:
//        System.out.println("Hello! I'm Snowy!\n");
//        System.out.println("What can I do for you?");
//        System.out.println("Bye! Hope to see you again :D");
        // Version 2:
        line();
        greeting();
        line();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            line();
            try {
                if (input.equals("bye") || input.equals("Bye")) {
                    bye();
                    break;
                } else if (input.equals("list") || input.equals("List")) {
                    list();
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
                            String[] ddlParts = content.split(" /by ");
                            task = new Deadline(ddlParts[0], ddlParts[1]);
                        } else {
                            if (parts.length < 2) {
                                throw new SnowyException("OOPS! The description of an event cannot be empty!");
                            }
                            String content = input.substring(6);
                            if ((!content.contains(" /from ")) || (!content.contains(" /to "))) {
                                throw new SnowyException("An event task needs to have both starting time and end time!");
                            }
                            String[] eventParts = content.split(" /from ");
                            String[] timings = eventParts[1].split(" /to ");
                            task = new Event(eventParts[0], timings[0], timings[1]);
                        }
                        tasks.add(task);
                        System.out.println("Got it. I've added this task:");
                        System.out.println("  " + task);
                        System.out.println("Now you have " +
                                tasks.size() +
                                (tasks.size() == 1 ? " task" : " tasks") +
                                " in the list.");
                    } else if ((command.equals("mark") || command.equals("unmark")) &&
                        parts.length > 1) {
                        int taskNum = -1;
                        try {
                            taskNum = Integer.parseInt(parts[1]);
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid task number :(");
                        } finally {
                            if ((!tasks.isEmpty()) &&
                                    taskNum > 0 &&
                                    taskNum <= tasks.size()) {
                                Task cur = tasks.get(taskNum - 1);
                                if (command.equals("mark")) {
                                    cur.mark();
                                    System.out.println("Sure! I've marked this task as done:");
                                    System.out.println("  " + cur);
                                }
                                if (command.equals("unmark")) {
                                    cur.unmark();
                                    System.out.println("OK, I've marked this task as not done yet:");
                                    System.out.println("  " + cur);
                                }
                            }
                        }
                    } else if (command.equals("delete") && parts.length > 1) {
                        int taskNum = -1;
                        try {
                            taskNum = Integer.parseInt(parts[1]);
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid task number :(");
                        } finally {
                            if ((!tasks.isEmpty()) && taskNum > 0 && taskNum <= tasks.size()) {
                                delete(taskNum);
                            } else {
                                System.out.println("Invalid task number :(");
                            }
                        }
                    } else {
                        System.out.println("Invalid input!");
                    }
                }
            } catch (SnowyException e) {
                System.out.println(e.getMessage());
            }
            line();
        }
        line();


//        String logo = " ____        _        \n"
//                + "|  _ \\ _   _| | _____ \n"
//                + "| | | | | | | |/ / _ \\\n"
//                + "| |_| | |_| |   <  __/\n"
//                + "|____/ \\__,_|_|\\_\\___|\n";
//        System.out.println("Hello from\n" + logo);
    }

    public static void line() {
        System.out.println("____________________________________________________________");
    }
    public static void greeting() {
        System.out.println("Hello! I'm Snowy!");
        System.out.println("What can I do for you?");
    }

    public static void bye() {
        System.out.println( "Bye! Hope to see you again :D");
    }

    public static void list() {
        if (!tasks.isEmpty()) {
            System.out.println("Here are the tasks in your list:");
            int count = tasks.size();
            for (int i = 0; i < count; i++) {
                Task cur = tasks.get(i);
                int num = i + 1;
                System.out.println(num + "." + cur);
            }
        }
    }

    public static void delete(int num) {
        System.out.println("Noted. I've removed this task:");
        System.out.println("  " + tasks.get(num - 1));
        tasks.remove(num - 1);
        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
    }
}
