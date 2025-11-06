package src;

import static java.lang.System.*;
import shared.ColorStyle;
import shared.Helper;

/**
 * Hourly.java
 * The Hourly class represents an employee paid on an hourly basis.
 * Extends the Employee class and implements hourly wage calculations
 * including overtime pay and birthday bonuses.
 * 
 * @author Eddie C.
 * @version 1.0
 * @since 2025-11-05
 */

public class Hourly extends Employee {

    /** Overtime multiplier constant for hours beyond 40 hours per week */
    public static final double OVERTIME_MULTIPLIER = 1.5;

    /** The hourly pay rate for this employee */
    private double hourlyPayRate;

    /** The number of hours worked in the past week */
    private double hoursWorkedForWeek;

    /**
     * Gets the hourly pay rate for this employee.
     * 
     * @return the hourly pay rate as double
     */
    public double getHourlyPayRate() {
        return this.hourlyPayRate;
    }

    /**
     * Gets the number of hours worked in the past week.
     * 
     * @return hours worked as double
     */
    public double getHoursWorkedForWeek() {
        return this.hoursWorkedForWeek;
    }

    /**
     * Sets the hourly pay rate with validation and error handling.
     * If an invalid pay rate is provided, displays error messages and re-prompts
     * the user until valid input is received.
     * 
     * @param hourlyPayRate the hourly pay rate to validate and set (must be
     *                      positive)
     */
    public void setHourlyPayRate(double hourlyPayRate) {
        while (hourlyPayRate <= 0) {
            Utility.displayError();
            Utility.displayError("Hourly pay must be greater than 0", Utility.getErrorMessagePosition("specific"));
            Helper.applyHighlighter("  Hourly pay \t\t\t: ", ColorStyle.BRIGHT_YELLOW, ColorStyle.BLACK_BG);
            Helper.moveToLastCharPreviousLine("last", 34);

            try {
                hourlyPayRate = Double.parseDouble(Employee.getUserInput().nextLine());
            } catch (NumberFormatException e) {
                hourlyPayRate = -1; // Force loop to continue
            }
        }
        this.hourlyPayRate = hourlyPayRate;
    }

    /**
     * Sets the hours worked with validation and error handling.
     * If invalid hours are provided, displays error messages and re-prompts
     * the user until valid input is received.
     * 
     * @param hoursWorkedForWeek the hours worked to validate and set (must be
     *                           positive)
     */
    public void setHoursWorkedForWeek(double hoursWorkedForWeek) {
        while (hoursWorkedForWeek <= 0) {
            Utility.displayError();
            Utility.displayError("Hours worked must be greater than 0", Utility.getErrorMessagePosition("specific"));
            Helper.applyHighlighter("  Hours worked this past week \t: ", ColorStyle.BRIGHT_YELLOW,
                    ColorStyle.BLACK_BG);
            Helper.moveToLastCharPreviousLine("last", 34);

            try {
                hoursWorkedForWeek = Double.parseDouble(Employee.getUserInput().nextLine());
            } catch (NumberFormatException e) {
                hoursWorkedForWeek = -1; // Force loop to continue
            }
        }
        this.hoursWorkedForWeek = hoursWorkedForWeek;
    }

    /**
     * Loads hourly employee data including base employee information,
     * hourly pay rate, and hours worked. Uses test data for demonstration.
     * Displays a formatted divider after data entry.
     */
    public void load() {
        super.load();

        /** Data capture */
        out.print("  Hourly pay \t\t\t: ");
        this.setHourlyPayRate(Double.parseDouble(Employee.getUserInput().nextLine()));
        out.print("  Hours worked this past week \t: ");
        this.setHoursWorkedForWeek(Double.parseDouble(Employee.getUserInput().nextLine()));

        /** Show line to divide section */
        out.println(Helper.section("divider"));
    }

    /**
     * Calculates the total earnings for this hourly employee.
     * Includes regular pay, overtime pay (1.5x rate after 40 hours),
     * and birthday bonus if applicable.
     * 
     * <p>
     * <b>Calculation Formula:</b>
     * </p>
     * <ul>
     * <li>Regular hours: up to 40 hours at standard rate</li>
     * <li>Overtime hours: hours beyond 40 at 1.5x rate</li>
     * <li>Birthday bonus: added if applicable</li>
     * </ul>
     * 
     * @return the total calculated earnings as double
     * @see #OVERTIME_MULTIPLIER
     */
    @Override
    public double getEarnings() {
        double calculated;
        if (this.hoursWorkedForWeek > 40) {
            double overtimePay = (this.hoursWorkedForWeek - 40) * OVERTIME_MULTIPLIER * this.hourlyPayRate;
            double birthdayBonus = this.getBonus();
            calculated = (this.hourlyPayRate * 40) + birthdayBonus + overtimePay;
        } else {
            calculated = (this.hourlyPayRate * this.hoursWorkedForWeek) + this.getBonus();
        }
        this.setPaycheck(calculated);
        return calculated;
    }
}
