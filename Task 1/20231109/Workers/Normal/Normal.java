/**
 * The {@code Normal} class extends the {@link Worker} class and represents a regular worker
 * with advanced task management, penalties, bonuses, and salary adjustment features.
 *
 * <p><strong>Features:</strong></p>
 * <ul>
 *   <li>Manage tasks with descriptions, priorities, bounces, and deadlines.</li>
 *   <li>Enforce maximum task limits per worker.</li>
 *   <li>Apply penalties (as percentage deductions) and bonuses to the salary.</li>
 *   <li>Validate user inputs for all task attributes, ensuring data consistency.</li>
 *   <li>Adjust salary through penalties, bonuses, and raises.</li>
 *   <li>Comprehensive checkout system to finalize payments based on tasks.</li>
 * </ul>
 *
 * @version 1.5
 * @author Aly El-Deen Yasser Ali
 */

package Workers.Normal;

import Tasks.Tasks;
import Workers.Worker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Normal extends Worker {

    private double Penalties = 0, Bounces = 0;
    private long numberTasks = 0, maxTasks = 0;
    // adding id
    private static int lastId = 0;
    private int id;
    private ArrayList<Tasks> TasksToDo = new ArrayList<Tasks>();
    /**
     * Constructor to initialize a Normal worker.
     *
     * @param Name      The worker's name.
     * @param Salary    The base salary.
     * @param FieldType The department or field.
     * @param MaxTasks  The maximum number of tasks.
     */
    public Normal(String Name, double Salary, String FieldType, long MaxTasks) {
        super(Name, Salary, FieldType);
        this.maxTasks = MaxTasks;
        id = lastId++;
    }

    /**
     * Displays a menu and returns a validated user choice.
     *
     * @param options The menu options.
     * @param Menu    The menu title.
     * @return The validated choice.
     */
    public static int getValidChoice(String[] options, String Menu) {
        Scanner sc = new Scanner(System.in);
        int choice = -1;
        while (true) {
            System.out.println(Menu);
            for (int i = 0; i < options.length; i++)
                System.out.println((i + 1) + ". " + options[i]);
            System.out.print("Select an option (1 - " + options.length + "): ");

            try {
                String input = sc.nextLine().trim();
                if (input.matches("\\d+")) {
                    choice = Integer.parseInt(input);
                    if (choice >= 1 && choice <= options.length)
                        break;
                    else
                        System.out.println("Invalid choice. Please select a valid option.");
                } else {
                    System.out.println("Invalid input! Please enter a single number.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
            }
        }
        return choice - 1;

    }

    /**
     * Displays all tasks assigned to the worker.
     */
    public void showTasks() {
        for (int i = 0; i < TasksToDo.size(); i++) {
            System.out.println("Task No: " + (i + 1));
            TasksToDo.get(i).showTaskDetails();
            System.out.println();
        }
        System.out.println("Total tasks: " + numberTasks);
    }

    /**
     * Adds a new task with user input and validation.
     */
    public void addTask() {
        if (TasksToDo.size() == maxTasks) {
            System.out.println("Maximum tasks reached");
            return;
        }
        Scanner sc = new Scanner(System.in);
        String description;
        do{
            System.out.print("Enter task description: ");
            description = sc.nextLine();
        }while (description.isEmpty());

        String[] optionsOfPriority = {"High", "Medium", "Low"};
        String priority = optionsOfPriority[getValidChoice(optionsOfPriority, "\n===== Choose Priority =====")];

        String bounceChoice = new String[]{"Yes", "No"}
                [getValidChoice(new String[]{"Yes", "No"}, "\n===== Is there a bounce? =====")];
        double bounce = 0;
        if (Objects.equals(bounceChoice, "Yes")) {
            while (true) {
                System.out.print("Enter the bounce: ");

                if (sc.hasNextDouble()) {
                    bounce = sc.nextDouble();
                    if (bounce < 0)
                        System.out.println("Bounce cannot be negative.");
                    else
                        break;
                } else {
                    System.out.println("Invalid input! Enter a numeric value.");
                    sc.next();
                }
            }
        }

        LocalDate deadline;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        sc.nextLine();
        while (true) {
            System.out.print("Enter deadline (yyyy-MM-dd): ");
            String input = sc.nextLine();

            try {
                deadline = LocalDate.parse(input, formatter);

                if (deadline.isBefore(LocalDate.now()))
                    System.out.println("Deadline cannot be in the past.");
                else
                    break;
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format! Use yyyy-MM-dd.");
            }
        }

        Tasks task = new Tasks(description, bounce, priority, deadline);
        TasksToDo.add(task);
        numberTasks++;
    }

    /**
     * Adds a bonus to the worker's total.
     *
     * @param Bounce The bonus amount.
     */
    public void addBounce(double Bounce) {
        Bounces += Bounce;
    }

    /**
     * Applies a penalty as a percentage of the base salary.
     *
     * @param Percentage The penalty percentage.
     */
    public void addPenalty(double Percentage) {
        if (Percentage < 0)
            throw new IllegalArgumentException("Percentage should be positive.");

        this.Penalties += getSalary() * (Percentage / 100);
        System.out.println("Penalty applied: " + Penalties);
    }

    /**
     * Raises the worker's salary by a given percentage.
     *
     * @param percentage The raise percentage.
     */
    public void raiseSalary(double percentage) {
        if (percentage < 0) {
            throw new IllegalArgumentException("Percentage must be positive.");
        }
        double raiseAmount = this.getSalary() * (percentage / 100);
        this.setSalary(this.getSalary() + raiseAmount);
    }
    public long getId(){
        return id;
    }
    public boolean available(){
        return TasksToDo.size() != maxTasks;
    }
    public long getMaxTasks(){
        return maxTasks;
    }

    /**
     * Displays all worker information, including tasks and financial details.
     */
    public void showAllInfo() {
        System.out.println("ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Salary: " + getSalary());
        System.out.println("Field Type: " + getFieldType());
        System.out.println("Penalties: " + Penalties);
        System.out.println("Bounces: " + Bounces);
        System.out.println("Total Tasks: " + numberTasks);
    }

    public void removeTask(){
        if(TasksToDo.isEmpty()){
            System.out.println("No tasks to remove.");
            return;
        }
        Scanner sc = new Scanner(System.in);
        for(int i = 0 ; i < TasksToDo.size();i++){
            System.out.println("Task No: " + (i + 1));
            TasksToDo.get(i).showTaskDetails();
        }
        int index = -1;
        while(true){
            while (true) {
                System.out.print("Enter task order to remove:");
                String input = sc.nextLine().trim();

                try {
                    index = (int) (Long.parseLong(input)-1);
                    if (index < 0)
                        System.out.println("task order cannot be negative. Please try again.");
                    else
                        break;

                } catch (NumberFormatException e) {
                    System.out.println("Invalid input! Please enter a valid long number.");
                }
            }
            if(index < TasksToDo.size())
                break;
            System.out.println("Invalid task number. Please try again.");

        }
        this.TasksToDo.remove(TasksToDo.get( index));
        System.out.println("Task is removed: " + index);
    }

    /**
     * Calculates and displays the final payment after considering penalties and bonuses.
     * Resets counters post-checkout.
     */
    public void checkoutPayment() {
        int TASKS_TO_CHECkOUT = 10;
        if (numberTasks < TASKS_TO_CHECkOUT) {
            System.out.println("No tasks to pay.");
            return;
        }
        double totalPayment = getSalary() - Penalties + Bounces;
        System.out.println("Total Payment: " + totalPayment);
        numberTasks = 0;
        Penalties = 0;
        Bounces = 0;
    }
}
