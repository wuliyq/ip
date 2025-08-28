

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    private final String filePath;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    public ArrayList<Task> load() {
        ArrayList<Task> tasks = new ArrayList<>();
        File file = new File(filePath);

        if (!file.exists()) {
            // create folder if it does not exist
            file.getParentFile().mkdirs();
            return tasks; // Return empty list if file does not exist
        }

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                try {
                    tasks.add(parseLine(line));
                } catch (Exception e) {
                    System.out.println("Corrupted line: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading file: " + e.getMessage());
        }
        return tasks;
    }
    
    public void save(ArrayList<Task> tasks) {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (Task task : tasks) {
                writer.write(task.toString() + System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

    public Task parseLine(String line) throws Exception {
        String[] parts = line.split(" | ");
        if (parts.length < 3) {
            throw new Exception("Invalid input!");
        }
        String type = parts[0];
        boolean isDone = parts[1].equals("1");
        String task = parts[2];
        switch (type) {
            case "T":
                return new ToDo(task, isDone);
            case "D":
                return new Deadline(task, isDone, parts[3]);
            case "E":
                return new Event(task, isDone, parts[3]);
            default:
                throw new IllegalArgumentException("Unknown task type: " + type);
        }
    }

}
