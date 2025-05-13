package Workers.Normal.Senior;

import Workers.Normal.Normal;

public class Senior extends Normal {
    private long yearsExperience;

    /**
     * Constructs a new {@code Normal} worker with the specified details.
     *
     * @param Name      The worker's name.
     * @param Salary    The base salary of the worker.
     * @param FieldType The field or department the worker belongs to.
     * @param MaxTasks  The maximum number of tasks the worker can handle.
     */
    public Senior(String Name, double Salary, String FieldType, long MaxTasks, long YearsExperience) {
        super(Name, Salary, FieldType, MaxTasks);
        this.yearsExperience = YearsExperience;
    }

    /**
     * Displays all worker info and adds completed checkouts for juniors.
     */
    @Override
    public void showAllInfo() {
        super.showAllInfo();
        System.out.println("Years of experience: " + yearsExperience);
    }

}
