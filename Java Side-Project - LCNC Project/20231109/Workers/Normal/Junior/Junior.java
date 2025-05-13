package Workers.Normal.Junior;

import Workers.Normal.Normal;

/**
 * The {@code Junior} class extends the {@link Normal} class and represents a junior-level worker.
 *
 * <p>In addition to the features inherited from {@code Normal}, this class tracks the number of
 * successful payment checkouts completed by the junior worker.</p>
 *
 * @author Aly El-Deen Yasser
 * @version 1.0
 */
public class Junior extends Normal {

    private long numebrCheckout = 0;

    /**
     * Constructs a new {@code Junior} worker with the specified details.
     *
     * @param Name      The worker's name.
     * @param Salary    The base salary of the worker.
     * @param FieldType The field or department the worker belongs to.
     * @param MaxTasks  The maximum number of tasks the worker can handle.
     */
    public Junior(String Name, double Salary, String FieldType, long MaxTasks) {
        super(Name, Salary, FieldType, MaxTasks);
    }

    public long getTasksDone() {
        return numebrCheckout;
    }

    /**
     * Overrides the {@code checkoutPayment} method to increment the checkout count
     * after each successful payment process.
     */
    @Override
    public void checkoutPayment() {
        super.checkoutPayment();
        numebrCheckout++;
    }

    /**
     * Displays all worker info and adds completed checkouts for juniors.
     */
    @Override
    public void showAllInfo() {
        super.showAllInfo();
        System.out.println("Checkouts completed: " + numebrCheckout);
    }
}
