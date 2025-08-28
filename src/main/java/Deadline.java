public class Deadline extends Task {

    private String time;

    public Deadline(String task, String time) {
        super(task);
        this.time = time;
    }
    
    public Deadline(String task, boolean isDone, String time) {
            super(task, isDone);
            this.time = time;
        }

    @Override
    public String toString() {
        return "[D]" +
            (this.checkStatus() ? "[X] " : "[ ] ") +
            super.toString() + 
            "(" +
            this.time +
            ")";
            // " (by: " +
            // this.time +
            // ")";
    }
}
