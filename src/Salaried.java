package src;

import static java.lang.System.*;

import shared.ColorStyle;
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
     * If an invalid salary amount is provided, displays error messages and
     * re-prompts the user until valid input is received.
     * 
     * @param amount the weekly salary to validate and set (must be positive)
     */
    public void setWeeklySalary(double amount) {
        while (amount <= 0) {
            Utility.displayError();
            Utility.displayError("Salary must be greater than 0",
                    Utility.getErrorMessagePosition("specific"));
            Helper.applyHighlighter("  Salary \t\t\t: ", ColorStyle.BRIGHT_YELLOW, ColorStyle.BLACK_BG);
            Helper.moveToLastCharPreviousLine("last", 34);

            try {
                amount = Double.parseDouble(Employee.getUserInput().nextLine());
            } catch (NumberFormatException e) {
                amount = -1; // Force loop to continue
            }
        }
        this.weeklySalary = amount;
    }

    /**
     * Loads salaried employee data including base employee information
     * and weekly salary. Displays a formatted divider after data entry
     * unless this is a SalariedPlusCommission subclass.
     */
    public void load() {
        super.load();
        out.print("  Salary \t\t\t: ");
        this.setWeeklySalary(Double.parseDouble(Employee.getUserInput().nextLine()));
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
