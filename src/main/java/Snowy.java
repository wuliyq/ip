import java.util.Scanner;

public class Snowy {
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
            String command = scanner.next();
            if (command.equals("bye") || command.equals("Bye")) {
                line();
                bye();
                line();
                break;
            }
            line();
            System.out.println(command);
            line();
        }


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
}
