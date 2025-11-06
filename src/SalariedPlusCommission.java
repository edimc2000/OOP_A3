package src;

import static java.lang.System.*;

import shared.ColorStyle;
import shared.Helper;

/**
 * SalariedPlusCommission.java
 * The SalariedPlusCommission class represents an employee with both fixed
 * salary and commission-based pay. Extends the Salaried class and implements
 * additional commission calculations on top of base salary and bonuses.
 * 
 * @author Eddie C.
 * @version 1.0
 * @since 2025-11-05
 */

public class SalariedPlusCommission extends Salaried {

    /** The sales amount in the past week */
    private double salesPastWeek;

    /** The commission rate as a fraction (e.g., 0.10 for 10%) */
    private double commissionRate;

    /**
     * Gets the sales amount in the past week.
     * 
     * @return the sales amount as double
     */
    public double getSalesPastWeek() {
        return this.salesPastWeek;
    }

    /**
     * Gets the commission rate as a fraction.
     * 
     * @return the commission rate as double (e.g., 0.10 for 10%)
     */
    public double getCommissionRate() {
        return this.commissionRate;
    }

    /**
     * Sets the sales amount with validation and error handling.
     * If an invalid sales amount is provided, displays error messages and
     * re-prompts the user until valid input is received.
     * 
     * @param amount the sales amount to validate and set (must be non-negative)
     */
    public void setSalesPastWeek(double amount) {
        while (amount < 0) {
            Utility.displayError();
            Utility.displayError("Sales amount cannot be negative",
                    Utility.getErrorMessagePosition("specific"));
            Helper.applyHighlighter("  Sales for this past week \t: ", ColorStyle.BRIGHT_YELLOW, ColorStyle.BLACK_BG);
            Helper.moveToLastCharPreviousLine("last", 34);

            try {
                amount = Double.parseDouble(Employee.getUserInput().nextLine());
            } catch (NumberFormatException e) {
                amount = -1; // Force loop to continue
            }
        }
        this.salesPastWeek = amount;
    }

    /**
     * Sets the commission rate with validation and error handling.
     * If an invalid commission rate is provided, displays error messages and
     * re-prompts the user until valid input is received.
     * 
     * @param rate the commission rate to validate and set (must be between 0 and 1
     *             inclusive)
     */
    public void setCommissionRate(double rate) {
        while (rate < 0 || rate > 1) {
            Utility.displayError();
            Utility.displayError("Commission rate must be between 0 and 1",
                    Utility.getErrorMessagePosition("specific"));
            Helper.applyHighlighter("  Sales Commission rate\n  (fraction paid to employee)\t: ",
                    ColorStyle.BRIGHT_YELLOW, ColorStyle.BLACK_BG);
            Helper.moveToLastCharPreviousLine("last", 34);

            try {
                rate = Double.parseDouble(Employee.getUserInput().nextLine());
            } catch (NumberFormatException e) {
                rate = -1; // Force loop to continue
            }
        }
        this.commissionRate = rate;
    }

    /**
     * Calculates the commission amount based on sales and commission rate.
     * 
     * @return the calculated commission amount as double
     */
    public double computeCommissionAmount() {
        return this.getCommissionRate() * this.getSalesPastWeek();
    }

    /**
     * Loads salaried plus commission employee data including base employee
     * information, weekly salary, sales data, and commission rate. Extends the
     * Salaried class loading process with additional commission-related inputs.
     */
    @Override
    public void load() {
        super.load();

        out.print("  Sales for this past week \t: ");
        this.setSalesPastWeek(Double.parseDouble(Employee.getUserInput().nextLine()));

        out.print("  Sales Commission rate\n  (fraction paid to employee)\t: ");
        this.setCommissionRate(Double.parseDouble(Employee.getUserInput().nextLine()));

        out.println(Helper.section("divider"));

    }

    /**
     * Calculates the total earnings for this salaried plus commission employee.
     * Includes fixed weekly salary, commission amount, and birthday bonus if
     * applicable.
     * 
     * <p>
     * <b>Calculation Formula:</b>
     * </p>
     * <ul>
     * <li>Weekly salary: fixed base amount</li>
     * <li>Commission: sales amount × commission rate</li>
     * <li>Birthday bonus: added if applicable</li>
     * </ul>
     * 
     * @return the total calculated earnings as double
     */
    @Override
    public double getEarnings() {

        double calculated = this.getWeeklySalary() + this.getBonus() + this.computeCommissionAmount();
        this.setPaycheck(calculated);
        return calculated;
    }

    /**
     * Determines whether to display the section divider in the base Salaried class.
     * 
     * @return false to suppress the divider in Salaried.load()
     */
    @Override
    protected boolean shouldDisplayDivider() {
        return false; // Override to suppress divider
    }

}
