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

    /**
     * Creates a Salaried employee with initial salary data.
     * 
     * @param name         the employee's name
     * @param ssn          the employee's social security number
     * @param birthMonth   the employee's birth month (1-12)
     * @param birthWeek    the employee's birth week (1-4)
     * @param weeklySalary the weekly salary amount as a string
     */
    public Salaried(String name, String ssn, int birthMonth, int birthWeek, String weeklySalary) {
        super(name, ssn, birthMonth, birthWeek);
        this.setWeeklySalary(weeklySalary);
    }

    /**
     * Creates a default Salaried employee with empty values.
     * Name and SSN are empty strings, birth month and week are set to 1,
     * and weekly salary is set to 0.
     */
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
