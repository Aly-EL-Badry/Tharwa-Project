package Workers;

/**
 * The {@code Worker} class represents an employee with basic attributes such as
 * name, salary, and field type. It provides methods to retrieve worker information
 * and adjust the salary.
 *
 * <p>This class can serve as a base class for more specialized worker types
 * (e.g., Manager, JuniorWorker, SeniorWorker) using inheritance.</p>
 *
 * @author Aly El-Deen Yasser
 * @version 1.0
 */
public class Worker {
    private final String name;
    private double salary;
    /** The field or department type the worker belongs to (e.g., HRss, Sales and Marketing, PRs,
                                                                  Web Developer, Data Scientists, APP Developers ).**/
    private final String fieldType;

    /**
     * Constructs a new {@code Worker} with the specified name, salary, and field type.
     *
     * @param name       The name of the worker.
     * @param salary     The initial salary of the worker.
     * @param FieldType  The department or field the worker belongs to.
     */
    public Worker(String name, double salary, String FieldType) {
        this.name = name;
        this.fieldType = FieldType;
        this.salary = salary;
    }

    // Get Functions
    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public String getFieldType() {
        return fieldType;
    }

    // Set Functions
    public void setSalary(double salary) {
        this.salary = salary;
    }
}
