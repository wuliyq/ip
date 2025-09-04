package snowy;

import snowy.ui.Ui;
import snowy.command.Command;
import java.util.Scanner;

import snowy.task.Task;

/**
 * Demonstrates a chatbot to the user which user can type and pass to it commands and
 * the chatbot will give response.
 */
public class Snowy {
    private final Storage storage;
    private final TaskList tasks;
    private final Ui ui;

    public Snowy(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        tasks = new TaskList(storage.load());
    }

    public void run() {
        ui.greeting();
        Scanner scanner = new Scanner(System.in);
        boolean isExit = false;
        while (!isExit) {
            String input = scanner.nextLine();
            try {
                Command cmd = Parser.parse(input);
                cmd.execute(tasks, ui, storage);
            } catch (SnowyException e) {
                ui.handleInvalidInput(e.getMessage());
            }
        }
    }

    public static void main(String[] args) throws SnowyException {
        new Snowy("data/snowy.txt").run();
    }
}