package src;

import static java.lang.System.*;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

import shared.ColorStyle;
import shared.Helper;

/**
 * Utility.java
 * The Utility class provides centralized utility methods for the payroll
 * management system. Handles user interface display, input validation,
 * report generation, and employee management. Serves as the main controller for
 * user interactions and visual presentation.
 * 
 * @author Eddie C.
 * @version 1.0
 * @since 2025-11-05
 */
public class Utility {

    /** * Default cursor position for general error messages */
    private static final int ERROR_POSITION_GENERAL = 40;

    /** * Cursor position for specific detailed error messages */
    private static final int ERROR_POSITION_SPECIFIC = 56;

    /** * Cursor position for input prompt */
    private static final int CURSOR_POSITION_PROMPT = 34;

    /** Error value constant for invalid input */
    private static final int ERROR_VALUE = -1;

    /** Maximum number of input attempts */
    private static final int MAX_ATTEMPT = 5;

    /** Closes the program if the maximum attempt limit is reached. */
    public static void closeOnMaxAttempt(int counter) {
        // out.println("COUNTER DEBUG => " + counter);
        // out.println("COUNTER MAX => " + Utility.getMaxAttempt());
        if (Utility.getMaxAttempt() == counter) {

            Utility.displayError("Maximum attempts reached. Closing program ...",
                    Utility.getErrorMessagePosition("specific"));
            System.exit(1);
        }
    }

    /** Returns a formatted string showing current and maximum attempts. */
    public static String showAttempts(int counter) {
        return "  ** Attempt " + (counter) + "/" + Utility.getMaxAttempt() + " ** ";
    }

    /**
     * Retrieves the appropriate cursor position for error message display
     * based on the error type. Provides consistent positioning for different
     * types of error feedback.
     * 
     * @param type the type of error message: "general" for generic errors,
     *             "specific" for detailed error messages
     * @return the cursor position integer for the specified error type,
     *         defaults to ERROR_POSITION_GENERAL for unknown types
     */

    public static int getErrorMessagePosition(String type) {

        if (type.equals("general")) {
            return ERROR_POSITION_GENERAL;
        }
        if (type.equals("specific")) {
            return ERROR_POSITION_SPECIFIC;
        }
        if (type.equals("cursor")) {
            return CURSOR_POSITION_PROMPT;
        }

        return ERROR_POSITION_GENERAL;
    }

    /** Returns the error value for input validation. */
    public static int getErrorValueForInput() {
        return ERROR_VALUE;
    }

    /**
     * Returns the maximum number of input attempts .
     */
    public static int getMaxAttempt() {
        return MAX_ATTEMPT;
    }

    /** StringBuilder instance for building dynamic display content */
    public static StringBuilder buildDisplay = new StringBuilder();

    /**
     * Displays the main application title screen with formatted borders and color
     * highlighting. Clears the screen and presents the application title in a
     * boxed format.
     * 
     * @param appTitle the title text to display for the application
     */
    public static void displayTitle(String appTitle) {
        Helper.clearScreen();
        Helper.applyHighlighter(generateBoxedTitle(buildDisplay, appTitle).toString(),
                ColorStyle.WHITE, ColorStyle.BLUE_BG);
        resetDisplayBuilder();
    }

    /**
     * Displays a general error message for invalid input.
     * Positions the error message appropriately and applies visual highlighting.
     */
    public static void displayError() {
        Helper.moveToPosition("last", getErrorMessagePosition("general"));
        Helper.applyHighlighter(" Invalid Input ", ColorStyle.RED, ColorStyle.WHITE_BG);
    }

    /**
     * Displays a specific error message at a designated screen position.
     * Provides targeted feedback for input validation failures.
     * 
     * @param specificMessage the detailed error message to display
     * @param position        the screen position to display the error message
     */

    public static void displayError(String specificMessage, int position) {
        Helper.moveToPosition("last", position);
        Helper.applyHighlighter(String.format(" %s ", specificMessage), ColorStyle.RED, ColorStyle.WHITE_BG);
    }

    /**
     * Generates a formatted boxed title with centered text and borders.
     * Creates a title display for various screen sections.
     * 
     * @param buildString the StringBuilder to append the formatted title to
     * @param title       the text content to center within the box
     * @return the StringBuilder with the appended boxed title
     */
    public static StringBuilder generateBoxedTitle(StringBuilder buildString, String title) {
        buildString.append(Helper.section("open") + "\n");
        buildString.append(Helper.printBalancedTitle(title,
                64, " │", "│ ") + "\n");
        buildString.append(Helper.section("close"));
        return buildString;
    }

    /**
     * Resets the display builder by clearing its content.
     * Prepares the builder for new content generation.
     */
    public static void resetDisplayBuilder() {
        buildDisplay.setLength(0);
    }

    /**
     * Displays the paycheck report title with formatted borders and color
     * highlighting. Includes appropriate spacing before and after the title
     * display.
     */
    public static void displayReportTitle() {
        out.println("");
        Helper.applyHighlighter(generateBoxedTitle(buildDisplay, "PAYCHECK REPORT").toString(),
                ColorStyle.WHITE, ColorStyle.BLUE_BG);
        resetDisplayBuilder();
        out.println("");
    }

    /**
     * Generates and displays a formatted employee report for the specified employee
     * list. Only generates the report if the employee list is not empty.
     * 
     * @param employees the list of Employee objects to include in the report
     * @param title     the section title to display for this employee category
     */
    public static void generateReport(List<Employee> employees, String title) {
        if (employees.size() > 0) {
            out.print("\n ");
            buildDisplay.append(Helper.printBalancedTitle(title, 66, "", ""));
            Helper.applyHighlighter(buildDisplay.toString(), ColorStyle.TURQUOISE_BLUE, ColorStyle.BLACK_BG);
            out.println(Helper.section("divider"));

            int counter = 1;
            for (Employee emp : employees) {

                out.print("\n  " + counter);
                out.println(emp.toString());
                counter++;
            }
            resetDisplayBuilder();
        }
    }

    /**
     * Prompts the user to continue adding employees or exit the data entry process.
     * Validates user input to ensure only 'Y' or 'N' responses are accepted.
     * 
     * @param userInput the Scanner object for reading user input
     * @return true if user wants to add another employee, false otherwise
     */
    public static boolean tryAgain(Scanner userInput) {
        boolean addAnother = true;
        String response = "y";
        while (addAnother) {
            out.print("\n Add another? (Y/N): \t\t: ");
            response = userInput.nextLine().toLowerCase();
            if (response.equals("y") || response.equals("n")) {
                break;
            }
            displayError();
        }
        boolean choice = response.equals("y") ? true : false;
        return choice;
    }

    /**
     * Displays the employee type selection menu and captures user choice.
     * Presents three pay type options with formatted display and color
     * highlighting.
     * 
     * @param userInput the Scanner object for reading user input
     * @return the user's selection as a String ("1", "2", or "3")
     */
    public static String chooseEmployeeType(Scanner userInput) {
        out.println("");
        buildDisplay.append(Helper.section("open"));
        buildDisplay.append("\n" + Helper.printBalancedTitle("ADD A PAYCHECK", 64, " │", "│ "));
        buildDisplay.append("\n" + String.format(" ├%-64s┤ ", "*".repeat(64)).replace("*", "─"));
        buildDisplay.append("\n" + String.format(" │%-64s│ ", (" SELECT PAY TYPE ")));
        buildDisplay.append("\n" + String.format(" │%-64s│ ", "*".repeat(64)).replace("*", "-"));
        buildDisplay.append("\n" + String.format(" │%-64s│ ", ("    1 - Hourly")));
        buildDisplay.append("\n" + String.format(" │%-64s│ ", ("    2 - Salaried ")));
        buildDisplay.append("\n" + String.format(" │%-64s│ ", ("    3 - Salaried plus Commission")));
        buildDisplay.append("\n" + Helper.section("close"));

        Helper.applyHighlighter(buildDisplay.toString(), ColorStyle.TURQUOISE_BLUE, ColorStyle.BLACK_BG);
        resetDisplayBuilder();
        out.println("");

        out.print(" \n Enter your choice (1 - 3)\t: ");
        return userInput.nextLine();
    }

    /**
     * Adds a new employee to the appropriate list based on user selection.
     * Creates the appropriate employee object, loads data, calculates earnings,
     * and stores in the corresponding ArrayList.
     * 
     * @param userInput                 the Scanner object for reading user input
     * @param hourlyArr                 ArrayList for storing Hourly employee
     *                                  objects
     * @param salariedArr               ArrayList for storing Salaried employee
     *                                  objects
     * @param salariedPlusCommissionArr ArrayList for storing SalariedPlusCommission
     *                                  employee objects
     */
    public static void addEmployee(Scanner userInput,
            ArrayList<Employee> hourlyArr,
            ArrayList<Employee> salariedArr,
            ArrayList<Employee> salariedPlusCommissionArr) {

        String employeeType = Utility.chooseEmployeeType(userInput);

        switch (String.valueOf(employeeType)) {

            case "1": // Employee: Hourly
                Hourly hourlyEmp1 = new Hourly();
                hourlyEmp1.load();
                hourlyEmp1.getEarnings();
                hourlyArr.add(hourlyEmp1);
                break;

            case "2":// Employee: Salaried
                Salaried salariedEmp1 = new Salaried();
                salariedEmp1.load();
                salariedEmp1.getEarnings();
                salariedArr.add(salariedEmp1);
                break;

            case "3": // Employee: Salaried plus commission
                SalariedPlusCommission salariedPlusCommissionEmp1 = new SalariedPlusCommission();
                salariedPlusCommissionEmp1.load();
                salariedPlusCommissionEmp1.getEarnings();
                salariedPlusCommissionArr.add(salariedPlusCommissionEmp1);
                break;

            default:
                displayError();
                break;
        }

    }

    /**
     * Validates and converts a string to a positive or non-negative double with
     * attempt tracking.
     * 
     * @param input        the string input to validate and convert to double
     * @param fieldName    the display name for the field (e.g., "Salary", "Sales")
     * @param errorMessage the specific error message for invalid range
     * @param allowZero    true to allow zero values (non-negative validation),
     *                     false to require positive values (greater than zero)
     * @return the validated double value meeting the specified range criteria
     */
    public static double validatePositiveDouble(String input, String fieldName, String errorMessage,
            boolean allowZero) {
        double convertedValue = Helper.stringToDouble(input);
        int counter = 1;

        // Flexible condition: <= 0 for positive-only, < 0 for non-negative
        boolean isInvalid = allowZero ? (convertedValue < 0) : (convertedValue <= 0);

        while (isInvalid && counter <= Utility.getMaxAttempt()) {
            Utility.displayError();

            if (convertedValue == Utility.getErrorValueForInput()) {
                Utility.displayError("Please enter a valid number" +
                        Utility.showAttempts(counter), Utility.getErrorMessagePosition("specific"));
            } else {
                Utility.displayError(errorMessage +
                        Utility.showAttempts(counter), Utility.getErrorMessagePosition("specific"));
            }

            Utility.closeOnMaxAttempt(counter);
            counter++;

            Helper.applyHighlighter(String.format("  %-29s : ", fieldName), ColorStyle.BRIGHT_YELLOW,
                    ColorStyle.BLACK_BG);
            Helper.moveToPosition("last", Utility.getErrorMessagePosition("cursor"));

            String newInput = Employee.getUserInput().nextLine();
            convertedValue = Helper.stringToDouble(newInput);
            isInvalid = allowZero ? (convertedValue < 0) : (convertedValue <= 0);
        }

        return convertedValue;
    }

}
