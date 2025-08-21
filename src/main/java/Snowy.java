import java.sql.Array;
import java.util.Scanner;
import java.util.ArrayList;

public class Snowy {
    public static ArrayList<String> tasks = new ArrayList<>();

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
            String command = scanner.nextLine();
            line();
            if (command.equals("bye") || command.equals("Bye")) {
                bye();
                break;
            } else if (command.equals("list") || command.equals("List")) {
                list();
            } else {
                tasks.add(command);
                System.out.println("added: " + command);
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
            int count = tasks.size();
            for (int i = 0; i < count; i++) {
                System.out.println(i + ". " + tasks.get(i));
            }
        }
    }
}
