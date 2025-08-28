import java.util.Scanner;

public class Ui {
    public static void readInput() throws SnowyException {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Parser.parse(input);
    }
    public static void line() {
        System.out.println("____________________________________________________________");
    }

    public static void greeting() {
        line();
        System.out.println("Hello! I'm Snowy!");
        System.out.println("What can I do for you?");
        line();
    }

    public static void bye() {
        System.out.println( "Bye! Hope to see you again :D");
    }

    public static void list() {
        if (!TaskList.list.isEmpty()) {
            System.out.println("Here are the tasks in your list:");
            int count = TaskList.list.size();
            for (int i = 0; i < count; i++) {
                Task cur = TaskList.list.get(i);
                int num = i + 1;
                System.out.println(num + "." + cur);
            }
        }
    }

    public static void add(Task task) {
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + task);
        System.out.println("Now you have " +
                TaskList.list.size() +
                (TaskList.list.size() == 1 ? " task" : " tasks") +
                " in the list.");
    }

    public static void invalidInput(String message) {
        System.out.println(message);
    }

    public static void mark(Task task) {
        System.out.println("Sure! I've marked this task as done:");
        System.out.println("  " + task);
    }

    public static void unmark(Task task) {
        System.out.println("OK, I've marked this task as not done yet:");
        System.out.println("  " + task);
    }

    public static void delete(int num) {
        System.out.println("Noted. I've removed this task:");
        System.out.println("  " + TaskList.list.get(num - 1));
        System.out.println("Now you have " + TaskList.list.size() + " tasks in the list.");
    }


}
