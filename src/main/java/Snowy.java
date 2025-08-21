import java.sql.Array;
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
            String[] parts = input.split(" ");
            String command = parts[0];
            line();
            if ((command.equals("mark") || command.equals("unmark")) &&
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
                            System.out.println("  [X] " + cur.getTask());
                        }
                        if (command.equals("unmark")) {
                            cur.unmark();
                            System.out.println("OK, I've marked this task as not done yet:");
                            System.out.println("  [ ] " + cur.getTask());
                        }
                    } else {
                        System.out.println("Invalid input! Please try again!");
                    }
                }
            } else {
                if (input.equals("bye") || input.equals("Bye")) {
                    bye();
                    break;
                } else if (input.equals("list") || input.equals("List")) {
                    list();
                } else {
                    tasks.add(new Task(input));
                    System.out.println("added: " + input);
                }
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
                if (cur.checkStatus()) {
                    System.out.println(num + ".[X] " + cur.getTask());
                } else {
                    System.out.println(num + ".[ ] " + cur.getTask());
                }
            }
        }
    }
}
