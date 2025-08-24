public class Deadline extends Task {
    private String time;

    public Deadline(String task, String time) {
        super(task);
        this.time = time;
    }

    @Override
    public String toString() {
        return "[D]" +
                (this.checkStatus() ? "[X] " : "[ ] ") +
                super.toString() +
                " (by: " +
                this.time +
                ")";
    }
}
