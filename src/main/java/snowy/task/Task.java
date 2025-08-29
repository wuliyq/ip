package snowy.task;

public class Task {
    private String task;

    private boolean done;

    public Task(String task) {
        this.task = task;
    }

    public Task(String task, boolean isDone) {
        this.task = task;
        this.done = isDone;
    }

    @Override
    public String toString() {
        return this.task;
    }

    public boolean checkStatus() {
        return this.done;
    }

    /**
     * Changes the boolean attribute done of the task to true to mark it as done.
     */
    public void mark() {
        this.done = true;
    }

    /**
     * Changes the boolean attribute done of the task to false to mark it as not done.
     */
    public void unmark() {
        this.done = false;
    }
}
