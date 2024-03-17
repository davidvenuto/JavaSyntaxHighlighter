package sourceFiles;

import java.time.LocalDate;

public class Task {
    private String title;
    private LocalDate dueDate;
    private boolean isCompleted;

    public Task(String title, LocalDate dueDate) {
        this.title = title;
        this.dueDate = dueDate;
        this.isCompleted = false;
    }

    public void markAsCompleted() {
        isCompleted = true;
    }

    public String getTaskDetails() {
        return "Task: " + title + ", Due Date: " + dueDate + ", Completed: " + isCompleted;
    }
}
