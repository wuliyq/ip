package snowy;

import java.util.ArrayList;

import snowy.ui.Ui;

import snowy.task.Task;

/**
 * Demonstrates a chatbot to the user which user can type and pass to it commands and
 * the chatbot will give response.
 */
public class Snowy {
    public static ArrayList<Task> tasks;

    public static void main(String[] args) throws SnowyException {
        Storage storage = new Storage("./data/snowy.txt");

        ArrayList<Task> loadedTasks = storage.load();
        // Ui ui = new Ui();
        Ui.greeting();

        tasks = new ArrayList<>(loadedTasks);

        while (true) {
            Ui.readInput();
            if (Parser.isEnd) {
                Ui.bye();
            }
        }
    }
}
