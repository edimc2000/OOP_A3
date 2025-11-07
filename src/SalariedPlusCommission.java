package src;

import static java.lang.System.*;

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

    /**
     * Creates an employee with salary, sales, and commission data.
     * 
     * @param name           the employee's name
     * @param ssn            the employee's social security number
     * @param birthMonth     the employee's birth month (1-12)
     * @param birthWeek      the employee's birth week (1-4)
     * @param weeklySalary   the weekly base salary as a string
     * @param salesPastWeek  the sales amount for the past week as a string
     * @param commissionRate the commission rate as a string
     */
    public SalariedPlusCommission(String name, String ssn, int birthMonth, int birthWeek,
            String weeklySalary, String salesPastWeek, String commissionRate) {
        super(name, ssn, birthMonth, birthWeek, weeklySalary);
        this.setSalesPastWeek(salesPastWeek);
        this.setCommissionRate(commissionRate);
    }

    /**
     * Creates a default SalariedPlusCommission employee with empty values.
     * Name and SSN are empty strings, birth month and week are set to 1,
     * and sales/commission are set to 0. Weekly salary defaults to 1.0.
     */
    public SalariedPlusCommission() {
        super("", "", 1, 1, "1.0");
        this.salesPastWeek = 0.0;
        this.commissionRate = 0.0;
    }

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
     * Sets the sales amount for the past week with validation and error handling.
     * Delegates to utility method for non-negative double validation with attempt
     * tracking. Displays appropriate error messages and re-prompts until valid
     * input is received.
     * 
     * @param salesPastWeek the sales amount as a string to validate and
     *                      convert to double (must be non-negative)
     */

    public void setSalesPastWeek(String salesPastWeek) {
        this.salesPastWeek = Utility.validatePositiveDouble(
                salesPastWeek,
                "Sales (past week)",
                "Sales amount cannot be negative",
                true); // true = can be >= 0
    }

    /**
     * Sets the commission rate with validation and error handling.
     * Delegates to utility method for non-negative double validation with attempt
     * tracking. Displays appropriate error messages and re-prompts until valid
     * input is received.
     * 
     * @param commissionRate the commission rate as a string to validate and
     *                       convert to double (must be non-negative)
     */
    public void setCommissionRate(String commissionRate) {
        this.commissionRate = Utility.validatePositiveDouble(
                commissionRate,
                "Commission rate",
                "Commission rate must be non-negative",
                true); // true = allow zero values
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
        this.setSalesPastWeek(Employee.getUserInput().nextLine());

        out.print("  Sales Commission rate\n  (fraction paid to employee)\t: ");
        this.setCommissionRate(Employee.getUserInput().nextLine());

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
