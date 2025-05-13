package Tasks;

import java.time.LocalDate;

/**
 * The {@code Tasks} class represents a task assigned to a worker, including its description,
 * bonus, priority, status, and deadline.
 *
 * <p>It provides methods to manage task details, update status, and check deadlines.</p>
 *
 * @author Aly El-Deen Yasser
 * @version 1.1
 */
public class Tasks {
    private static int idCounter = 1;
    int taskID = idCounter++;
    private String description;
    private double bonus;
    private String priority;
    private LocalDate deadline;

    /**
     * Constructs a new {@code Tasks} object with the specified details.
     *
     * @param description A brief description of the task.
     * @param bonus       The bonus amount associated with the task.
     * @param priority    The priority level of the task.
     * @param deadline    The deadline for task completion.
     */
    public Tasks( String description, double bonus, String priority, LocalDate deadline) {
        this.description = description;
        this.bonus = bonus;
        this.priority = priority;
        this.deadline = deadline;
    }


    /**
     * Checks if the task is overdue based on the current date.
     *
     * @return {@code true} if overdue, {@code false} otherwise.
     */
    public boolean isOverdue() {
        return LocalDate.now().isAfter(deadline);
    }

    /**
     * Displays full details of the task.
     */
    public void showTaskDetails() {
        System.out.println("Task ID: " + taskID);
        System.out.println("Task Description: " + description);
        System.out.println("Bonus: " + bonus);
        System.out.println("Priority: " + priority);
        System.out.println("Deadline: " + deadline);
        System.out.println("Overdue: " + (isOverdue() ? "Yes" : "No"));
    }
}
