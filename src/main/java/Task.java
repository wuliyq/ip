public class Task {
    private String task;
    private boolean done;

    public Task(String task) {
        this.task = task;
        this.done = false;
    }

    @Override
    public String toString() {
        return this.task;
    }

    public boolean checkStatus() {
        return this.done;
    }

    public void mark() {
        this.done = true;
    }

    public void unmark() {
        this.done = false;
    }
}
