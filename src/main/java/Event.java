public class Event extends Task{
    
    private String startTime;
    private String endTime;

    public Event(String task, String start, String end) {
        super(task);
        this.startTime = start;
        this.endTime = end;
    }

    @Override
    public String toString() {
        return "[E]" +
                (this.checkStatus() ? "[X] " : "[ ] ") +
                super.toString() +
                " (from: " +
                this.startTime +
                " to: " +
                this.endTime +
                ")";
    }
}
