package src;

import static java.lang.System.*;

import shared.Helper;

/**
 * Salaried.java
 * The Salaried class represents an employee with fixed weekly pay.
 * Extends the Employee class and implements wage calculations including
 * birthday bonuses.
 * 
 * @author Eddie C.
 * @version 1.0
 * @since 2025-11-05
 */

public class Salaried extends Employee {

    /** Creates Salaried employee with initial salary data. */
    public Salaried(String name, String ssn, int birthMonth, int birthWeek, String weeklySalary) {
        super(name, ssn, birthMonth, birthWeek);
        this.setWeeklySalary(weeklySalary);
    }

    public Salaried() {
        super("", "", 1, 1);
        this.weeklySalary = 0.0;
    }

    /** The fixed weekly salary amount for this employee */
    private double weeklySalary;

    /**
     * Gets the weekly salary amount for this employee.
     * 
     * @return the weekly salary as double
     */
    public double getWeeklySalary() {
        return this.weeklySalary;
    }

    /**
     * Sets the weekly salary with validation and error handling.
     * Delegates to utility method for positive double validation with attempt
     * tracking. Displays appropriate error messages and re-prompts until valid
     * input is received.
     * 
     * @param weeklySalary the weekly salary as a string to validate and
     *                     convert to double
     */
    public void setWeeklySalary(String weeklySalary) {
        this.weeklySalary = Utility.validatePositiveDouble(
                weeklySalary,
                "Salary",
                "Salary must be greater than 0",
                false);
    }

    /**
     * Loads salaried employee data including base employee information
     * and weekly salary. Displays a formatted divider after data entry
     * unless this is a SalariedPlusCommission subclass.
     */
    public void load() {
        super.load();
        out.print("  Salary \t\t\t: ");
        this.setWeeklySalary(Employee.getUserInput().nextLine());
        if (shouldDisplayDivider()) {
            out.println(Helper.section("divider"));
        }
    }

    /**
     * Calculates the total earnings for this salaried employee.
     * Includes fixed weekly salary and birthday bonus if applicable.
     * 
     * <p>
     * <b>Calculation Formula:</b>
     * </p>
     * <ul>
     * <li>Weekly salary: fixed amount regardless of hours</li>
     * <li>Birthday bonus: added if applicable</li>
     * </ul>
     * 
     * @return the total calculated earnings as double
     */
    @Override
    public double getEarnings() {
        double calculated = this.getWeeklySalary() + this.getBonus();
        this.setPaycheck(calculated);
        return calculated;
    }

    /**
     * Determines whether to display the section divider.
     * Can be overridden by subclasses to modify behavior.
     * 
     * @return true if divider should be displayed, false otherwise
     */
    protected boolean shouldDisplayDivider() {
        return true; // Default behavior - always show divider
    }
}
