package snowy.task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task {
    private LocalDate dateTime;

    public Deadline(String task, String time) {
        super(task);
        this.dateTime = LocalDate.parse(time, DateTimeFormatter.ofPattern("yyyy-mm-dd"));
    }
    
    public Deadline(String task, boolean isDone, String time) {
        super(task, isDone);
        this.dateTime = LocalDate.parse(time, DateTimeFormatter.ofPattern("yyyy-mm-dd"));
    }

    @Override
    public String toString() {
        return "[D]" +
            (this.checkStatus() ? "[X] " : "[ ] ") +
            super.toString() + 
            "(" +
            this.dateTime.format(DateTimeFormatter.ofPattern("MMM dd yyyy")) +
            ")";
    }
}
