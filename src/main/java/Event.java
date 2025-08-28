public class Event extends Task{
    
    // private String startTime;
    // private String endTime;
    private String time;

    public Event(String task, String time) {
        super(task);
        this.time = time;
    }

    public Event(String task, boolean isDone, String time) {
        super(task, isDone);
        this.time = time;
    }

    @Override
    public String toString() {
        return "[E]" +
                (this.checkStatus() ? "[X] " : "[ ] ") +
                super.toString() +
                // " (from: " +
                // this.startTime +
                // " to: " +
                // this.endTime +
                // ")";
                " (" +
                this.time + 
                ")";
    }
}
