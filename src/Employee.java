package src;

import static java.lang.System.*;
import java.util.Scanner;
import java.util.Calendar;

import shared.ColorStyle;
import shared.Helper;

/**
 * Employee.java
 * Base abstract class representing a generic employee in the payroll system.
 * Provides common functionality for all employee types including personal
 * information, bonus calculations, and earnings management.
 * 
 * @author Eddie C.
 * @version 1.0
 * @since 2025-11-05
 */

public abstract class Employee {
    /** Constant bonus amount awarded during birthday week */
    public static final double BONUS_AMOUNT = 100.00;

    /** Maximum paycheck amount limit */
    public static final double MAX_PAYCHECK = 1000.00;

    /** Employee's name */
    private String name;

    /** Employee's Social Security Number */
    private String socialSecurityNumber;

    /** Employee's birth month (1-12) used for bonus calculation */
    private int birthMonth;

    /** Employee's birth week (1-4) used for bonus calculation */
    private int birthWeek;

    /** Calculated paycheck amount */
    private double paycheck;

    /** Shared scanner for user input */
    private static final Scanner userInput = new Scanner(System.in);

    /**
     * Abstract method to calculate employee earnings.
     * Must be implemented by subclasses based on pay structure.
     * 
     * @return the total calculated earnings as double
     */
    public abstract double getEarnings();

    /**
     * Gets the shared Scanner object for user input.
     * 
     * @return the Scanner object for reading user input
     */
    public static Scanner getUserInput() {
        return userInput;
    }

    /**
     * Gets the employee's name.
     * 
     * @return the employee's name as String
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets the employee's social security number.
     * 
     * @return the social security number as String
     */
    public String getSocialSecurityNumber() {
        return this.socialSecurityNumber;
    }

    /**
     * Gets the employee's birth month.
     * 
     * @return the birth month as integer (1-12)
     */
    public int getBirthMonth() {
        return this.birthMonth;
    }

    /**
     * Gets the employee's birth week for bonus calculation.
     * 
     * @return the birth week as integer (1-4)
     */
    public int getBirthWeek() {
        return this.birthWeek;
    }

    /**
     * Gets the employee's paycheck amount.
     * 
     * @return the paycheck amount as double
     */
    public double getPaycheck() {
        return this.paycheck;
    }

    /**
     * Sets the employee's paycheck amount with maximum limit enforcement.
     * If amount exceeds MAX_PAYCHECK, it is capped at the maximum value.
     * 
     * @param amount the paycheck amount to set
     */
    public void setPaycheck(double amount) {
        this.paycheck = amount > MAX_PAYCHECK ? MAX_PAYCHECK : amount;
    }

    /**
     * Sets the employee's name.
     * 
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the employee's social security number.
     * 
     * @param socialSecurityNumber the social security number to set
     */
    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    /**
     * Sets the employee's birth month with validation and error handling.
     * If an invalid month is provided, displays error messages and re-prompts
     * the user until valid input is received.
     * 
     * @param birthMonth the birth month to validate and set (1-12)
     */
    public void setBirthMonth(int birthMonth) {
        while (birthMonth < 1 || birthMonth > 12) {
            Utility.displayError();
            Utility.displayError("Birth month must be between 1 and 12", Utility.getErrorMessagePosition("specific"));
            Helper.applyHighlighter("  Birthday month (1 - 12) \t: ", ColorStyle.BRIGHT_YELLOW, ColorStyle.BLACK_BG);
            Helper.moveToLastCharPreviousLine("last", 34);

            try {
                birthMonth = Integer.parseInt(getUserInput().nextLine());
            } catch (NumberFormatException e) {
                birthMonth = -1; // Force loop to continue
            }
        }
        this.birthMonth = birthMonth;
    }

    /**
     * Sets the employee's birth week with validation and error handling.
     * If an invalid week is provided, displays error messages and re-prompts
     * the user until valid input is received.
     * 
     * @param birthWeek the birth week to validate and set (1-4)
     */
    public void setBirthWeek(int birthWeek) {
        while (birthWeek < 1 || birthWeek > 4) {
            Utility.displayError();
            Utility.displayError("Birth week must be between 1 and 4", Utility.getErrorMessagePosition("specific"));
            Helper.applyHighlighter("  Birthday bonus week (1 - 4) \t: ", ColorStyle.BRIGHT_YELLOW,
                    ColorStyle.BLACK_BG);
            Helper.moveToLastCharPreviousLine("last", 34);

            try {
                birthWeek = Integer.parseInt(getUserInput().nextLine());
            } catch (NumberFormatException e) {
                birthWeek = -1; // Force loop to continue
            }
        }
        this.birthWeek = birthWeek;
    }

    /**
     * Loads basic input capture for employee information - name and SSN .
     * Collects name, social security number, birth month, and birth week.
     * Displays formatted input prompts and section dividers.
     */
    public void load() {

        /** Show line to divide section */
        out.println(Helper.section("divider"));

        /** Data capture */
        out.print("  Name \t\t\t\t: ");
        this.setName(getUserInput().nextLine());

        out.print("  Social Security Number \t: ");
        this.setSocialSecurityNumber(getUserInput().nextLine());

        out.print("  Birthday month (1 - 12) \t: ");
        this.setBirthMonth(Integer.parseInt(getUserInput().nextLine()));

        out.print("  Birthday bonus week (1 - 4) \t: ");
        this.setBirthWeek(Integer.parseInt(getUserInput().nextLine()));
    }

    /**
     * Returns formatted string representation of employee information.
     * Includes name, social security number, and formatted paycheck amount.
     * 
     * @return formatted employee information as String
     */
    @Override
    public String toString() {
        String display = String.format("\t%s\t\t: %s\n\t%s\t: %s\n\t%s\t\t: $%s",
                "Employee", this.getName().toUpperCase(), "Social Security Number",
                this.getSocialSecurityNumber(), "Paycheck", Helper.formatTwoDecimals(getPaycheck()));
        return display;
    }

    /**
     * Calculates birthday bonus eligibility and amount.Awards BONUS_AMOUNT if
     * current month and week match employee's birth month and week.
     * 
     * @return bonus amount (100.00 if eligible, 0.00 otherwise)
     * @see #BONUS_AMOUNT
     */
    public double getBonus() {
        Calendar calendar = Calendar.getInstance();
        int currentWeekOfMonth = calendar.get(Calendar.WEEK_OF_MONTH);
        int currentMonth = calendar.get(Calendar.MONTH) + 1;

        boolean isEligibleForBonus = (currentMonth == this.birthMonth) && (currentWeekOfMonth == this.birthWeek);
        return isEligibleForBonus ? BONUS_AMOUNT : 0;
    }

}