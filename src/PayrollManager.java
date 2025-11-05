package src;

/**
 * PayrollManager.java 
 * Main driver class for the Payroll Management Application.
 * Handles employee data entry, user interaction, and report generation.
 * 
 * @author Eddie C.
 * @since 05-Nov-2025
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.Scanner;

public class PayrollManager {

    /** Scanner object for reading user input throughout the application */
    private static Scanner userInput = new Scanner(System.in);

    /** ArrayList for storing Hourly employee objects */
    private static ArrayList<Employee> hourlyArr = new ArrayList<>();
    
    /** ArrayList for storing Salaried employee objects */
    private static ArrayList<Employee> salariedArr = new ArrayList<>();
    
    /** ArrayList for storing SalariedPlusCommission employee objects */
    private static ArrayList<Employee> salariedPlusCommissionArr = new ArrayList<>();
    
    /**
     * Main entry point for the Payroll Management Application.
     * Manages the application lifecycle from initialization to report generation.
     */

    public static void main(String[] args) {
        boolean toContinue = true;

        // Display the application's title
        Utility.displayTitle("PAYROLL MANAGEMENT APPLICATION");

        // Main application loop - runs until user chooses to exit
        while (toContinue) {
            Utility.addEmployee(userInput, hourlyArr, salariedArr, salariedPlusCommissionArr);
            toContinue = Utility.tryAgain(userInput);
        }

        // Display report title only if at least one employee exists
        if (hourlyArr.size() != 0 || salariedArr.size() != 0 || salariedPlusCommissionArr.size() != 0) {
            Utility.displayReportTitle();
        }

        // Generate and display paycheck report based on type
        Utility.generateReport(hourlyArr, "Hourly Employees");
        Utility.generateReport(salariedArr, "Salaried Employees");
        Utility.generateReport(salariedPlusCommissionArr, "Salaried + Commission Employees");

    }

}
