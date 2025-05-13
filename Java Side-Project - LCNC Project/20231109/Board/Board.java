/**
 * The Board class manages the operations of Juniors, Seniors, and Managers within an organization.
 * It includes functionalities to add workers, assign tasks, apply penalties, give raises, promote juniors,
 * and authenticate managers for administrative operations.
 */

package Board;

import Workers.Manger.Manger;
import Workers.Normal.Junior.Junior;
import Workers.Normal.Normal;
import Workers.Normal.Senior.Senior;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Board {
    private ArrayList<Junior> juniors;
    private ArrayList<Manger> mangers;
    private ArrayList<Senior> seniors;
    private Scanner sc = new Scanner(System.in);

    /**
     * Constructor to initialize Board with existing lists of Juniors, Managers, and Seniors.
     */
    public Board(ArrayList<Junior> juniors, ArrayList<Manger> mangers, ArrayList<Senior> Seniors) {
        this.juniors = juniors;
        this.mangers = mangers;
        this.seniors = Seniors;
    }

    /**
     * Ensures user inputs a positive double value.
     * Handles invalid inputs and avoids buffer issues by using nextLine().
     *
     * @param Type The type of value being requested (used in prompts).
     * @return A positive double value entered by the user.
     */
    private double isPositiveDouble(String Type) {
        double num;
        while (true) {
            System.out.print("Enter " + Type + " :");
            String input = sc.nextLine().trim();

            try {
                num = Double.parseDouble(input);
                if (num < 0 || num == -0)
                    System.out.println(Type + " cannot be negative. Please try again.");
                else
                    break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a numeric value.");
            }

        }
        return num;
    }

    /**
     * Ensures user inputs a positive long value.
     * Handles invalid inputs and avoids buffer issues by using nextLine().
     *
     * @param Type The type of value being requested (used in prompts).
     * @return A positive long value entered by the user.
     */
    private long isPositiveLong(String Type) {
        long num;
        while (true) {
            System.out.print("Enter " + Type + " :");
            String input = sc.nextLine().trim();

            try {
                num = Long.parseLong(input);
                if (num < 0)
                    System.out.println(Type + " cannot be negative. Please try again.");
                else
                    break;

            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid long number.");
            }
        }
        return num;
    }


    /**
     * Adds a new Manager to the system with unique credentials.
     */
    public void addManger() {
        String name;
        do {
            System.out.println("Enter Manager Name: ");
            name = sc.nextLine();
        } while (name.isEmpty());

        double salary = isPositiveDouble("salary");

        String[] fieldOptions = {"HR", "PR", "Sales and Marketing", "Web Developer", "App Developer", "Data Scientist", "General"};
        String field = fieldOptions[Normal.getValidChoice(fieldOptions, "Choose a field: ")];

        String username, password;
        while (true) {
            System.out.println("Enter the username: ");
            username = sc.nextLine();

            System.out.println("Enter the password: ");
            password = sc.nextLine();

            boolean check = false;
            for (Manger i : mangers) {
                if (i.getUsername().equals(username)) {
                    System.out.println("Username already exists. Please choose a different one.");
                    check = true;
                    break;
                }
            }
            if (!check)
                break;
        }
        mangers.add(new Manger(name, salary, field, username, password));
        System.out.println("Manager added successfully.");
    }

    /**
     * Adds a new Junior or Senior worker to the system.
     */
    public void addWorker() {
        String name;
        do {
            System.out.println("Enter Worker Name");
            name = sc.nextLine();
        } while (name.isEmpty());

        double salary = isPositiveDouble("Worker's salary");

        String[] fieldOptions = {"HR", "PR", "Sales and Marketing", "Web Developer", "App Developer", "Data Scientist"};
        String field = fieldOptions[Normal.getValidChoice(fieldOptions, "Choose a field: ")];

        long maxTasks = isPositiveLong("MaxTasks");

        int workerType = Normal.getValidChoice(new String[]{"Junior", "Senior"}, "Choose Worker Junior or Senior");

        if (workerType == 0)
            juniors.add(new Junior(name, salary, field, maxTasks));
        else {
            long yearsExperience = isPositiveLong("Years of Experience :");
            seniors.add(new Senior(name, salary, field, maxTasks, yearsExperience));
        }
        System.out.println("Worker added successfully.");
    }

    /**
     * Assigns a task to an available Junior or Senior worker.
     */
    public void giveTask() {
        System.out.println("Choose if the worker is Junior or Senior");
        int workerType = Normal.getValidChoice(new String[]{"Junior", "Senior"},
                "Choose Worker Junior or Senior");

        ArrayList<? extends Normal> workers = workerType == 0 ? juniors : seniors;
        long[] workersIDs = new long[workers.size()];
        boolean atLeastOneAvailable = workers.stream()
                .anyMatch(Normal::available);
        if(workers.isEmpty() || !atLeastOneAvailable ){
            System.out.println("No available workers found.");
            return;
        }

        for (int i = 0; i < workers.size(); i++) {
            workers.get(i).showAllInfo();
            workersIDs[i] = workers.get(i).getId();
        }

        while (true) {
            long workerId = isPositiveLong("Worker ID");
            boolean check = false;
            for (int i = 0; i < workers.size(); i++) {
                if (workersIDs[i] == workerId && workers.get(i).available()) {
                    workers.get(i).addTask();
                    System.out.println("Task assigned successfully.");
                    return;
                }
            }
            System.out.println("Invalid Worker ID or the worker Has Maximum number of Tasks. Please try again.");
        }
    }

    /**
     * Applies a penalty to a worker's salary based on a percentage.
     */
    public void givePenalty() {
        System.out.println("Choose if the worker is Junior or Senior");
        int workerType = Normal.getValidChoice(new String[]{"Junior", "Senior"},
                "Choose Worker Junior or Senior");

        ArrayList<? extends Normal> workers = workerType == 0 ? juniors : seniors;
        long[] workersIDs = new long[workers.size()];
        if(workers.isEmpty()){
            System.out.println("No available workers found.");
            return;
        }

        for (int i = 0; i < workers.size(); i++) {
            workers.get(i).showAllInfo();
            workersIDs[i] = workers.get(i).getId();
        }

        while (true) {
            long workerId = isPositiveLong("Worker ID");
            boolean check = false;
            for (int i = 0; i < workers.size(); i++) {
                if (workersIDs[i] == workerId) {
                    double penaltyPercentage = isPositiveDouble("Penalty Percentage");
                    workers.get(i).addPenalty(penaltyPercentage);
                    System.out.println("Penalty added successfully.");
                    return;
                }
            }
            System.out.println("Invalid Worker ID. Please try again.");
        }

    }

    /**
     * Increases a worker's salary based on a percentage.
     */
    public void giveRaise() {
        System.out.println("Choose if the worker is Junior or Senior");
        int workerType = Normal.getValidChoice(new String[]{"Junior", "Senior"}, "Choose Worker Junior or Senior");

        ArrayList<? extends Normal> workers = workerType == 0 ? juniors : seniors;
        long[] workersIDs = new long[workers.size()];
        if(workers.isEmpty()){
            System.out.println("No available workers found.");
            return;
        }

        for (int i = 0; i < workers.size(); i++) {
            workers.get(i).showAllInfo();
            workersIDs[i] = workers.get(i).getId();
        }

        while (true) {
            long workerId = isPositiveLong("Worker ID");
            boolean check = false;
            for (int i = 0; i < workers.size(); i++) {
                if (workersIDs[i] == workerId) {
                    double percentage = isPositiveDouble("Raise Percentage");
                    workers.get(i).raiseSalary(percentage);
                    System.out.println("Salary raised successfully.");
                    return;
                }
            }
            System.out.println("Invalid Worker ID. Please try again.");
        }
    }

    /**
     * Promotes a Junior to Senior after completing a set number of tasks.
     */
    public void promoteJunior() {
        boolean Check = false;
        long CHECKOUTS_FOR_PROMOTION = 1;
        for (int i = 0; i < juniors.size(); i++) {
            if (juniors.get(i).getTasksDone() >= CHECKOUTS_FOR_PROMOTION) {
                System.out.println("Congratulations! " + juniors.get(i).getName() + " has been promoted to Senior.");
                Senior senior = new Senior(juniors.get(i).getName(), juniors.get(i).getSalary(), juniors.get(i).getFieldType(), juniors.get(i).getMaxTasks(), 1);
                seniors.add(senior);
                juniors.remove(i);
                Check = true;
            }
        }
        if(!Check)
            System.out.println("No Junior workers have completed enough tasks to be promoted.");
    }

    /**
     * Handles manager authentication and provides menu options for management tasks.
     */
    public void manage() {
        Manger user = null;
        while (true) {
            System.out.println("\nPlease Enter Your Username (or enter '#' to return): ");
            String username = sc.nextLine();
            if (Objects.equals(username, "#"))
                return;

            System.out.println("\nPlease Enter Your Password: ");
            String password = sc.nextLine();

            boolean check = false;
            for (Manger i : mangers) {
                if (i.getUsername().equals(username) && i.getPassword().equals(password)) {
                    check = true;
                    user = i;
                    break;
                }
            }
            if (check)
                break;
            System.out.println("Invalid Username or Password");
        }

        while (true) {
            System.out.println("\nWelcome, " + user.getName());
            String[] managerOptions = {"Add Worker", "Add Manager", "Give Task", "Give Penalty", "Give Raise", "Promote Junior", "Exit"};
            int menu = Normal.getValidChoice(managerOptions, "Choose from the options: ") + 1;
            switch (menu) {
                case 1 -> addWorker();
                case 2 -> addManger();
                case 3 -> giveTask();
                case 4 -> givePenalty();
                case 5 -> giveRaise();
                case 6 -> promoteJunior();
                case 7 -> {
                    return;
                }
            }
        }
    }



    /**
     * Placeholder for Junior-specific work functionality.
     */
    public void juniorWork() {
        int userIndex = -1;
        while (true) {
            System.out.println("\nPlease Enter Your name (or enter '#' to return): ");
            String name = sc.nextLine();
            if (Objects.equals(name, "#"))
                return;

            System.out.println("\nPlease Enter Your ID: ");
            long Id = isPositiveLong("your ID");

            boolean check = false;
            for (int i = 0 ; i < juniors.size() ; i++) {
                if (juniors.get(i).getName().equals(name) && juniors.get(i).getId() == Id) {
                    check = true;
                    userIndex = i;
                    break;
                }
            }
            if (check)
                break;
            System.out.println("Invalid name or id");
        }
        while (true) {
            System.out.println("\nWelcome, " + juniors.get(userIndex).getName());
            String[] juniorOptions = {"View Tasks", "Show All info", "Checkout Payment", "Remove a Task", "Exit"};
            int menu = Normal.getValidChoice(juniorOptions, "Choose from the options: ") + 1;
            switch (menu) {
                case 1 -> juniors.get(userIndex).showTasks();
                case 2 -> juniors.get(userIndex).showAllInfo();
                case 3 -> juniors.get(userIndex).checkoutPayment();
                case 4 -> juniors.get(userIndex).removeTask();
                case 5 -> {
                    return;
                }
            }
        }
    }

    /**
     * Placeholder for senior-specific work functionality.
     */
    public void seniorWork() {
        int userIndex = -1;
        while (true) {
            System.out.println("\nPlease Enter Your name (or enter '#' to return): ");
            String name = sc.nextLine();
            if (Objects.equals(name, "#"))
                return;

            System.out.println("\nPlease Enter Your ID: ");
            long Id = isPositiveLong("your ID");

            boolean check = false;
            for (int i = 0 ; i < seniors.size() ; i++) {
                if (seniors.get(i).getName().equals(name) && seniors.get(i).getId() == Id) {
                    check = true;
                    userIndex = i;
                    break;
                }
            }
            if (check)
                break;
            System.out.println("Invalid name or id");
        }
        while (true) {
            System.out.println("\nWelcome, " + seniors.get(userIndex).getName());
            String[] juniorOptions = {"View Tasks", "Show All info", "Checkout Payment", "Remove Task", "Exit"};
            int menu = Normal.getValidChoice(juniorOptions, "Choose from the options: ") + 1;
            switch (menu) {
                case 1 -> seniors.get(userIndex).showTasks();
                case 2 -> seniors.get(userIndex).showAllInfo();
                case 3 -> seniors.get(userIndex).checkoutPayment();
                case 4 -> seniors.get(userIndex).removeTask();
                case 5 -> {
                    return;
                }
            }
        }

    }
} 