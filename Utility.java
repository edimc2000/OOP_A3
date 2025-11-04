package OOP_A3;

import static java.lang.System.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Utility {

    public static void displayTitle() {
        clearScreen();

        section("open");
        printBalancedTitle(" ***** PAYROLL MANAGEMENT APPLICATION *****", 64);
        section("close");
    }

    public static void displayReportTitle() {

        section("open");
        printBalancedTitle(" ***** PAYCHECK REPORT *****", 64);
        section("close");
    }

    public static void generateReport(List<Employee> employees, String title) {
        if (employees.size() > 0) {
            displayReportTitle();

            section("open");
            printBalancedTitle(title, 64);
            section("close");

            int counter = 1;
            for (Employee emp : employees) {

                out.print("\n  " + counter);
                out.println(emp.toString());
                counter++;
            }
            section("divider");
        }
    }

    public static boolean tryAgain(Scanner userInput) {
        boolean isAddAnother = true;
        String response = "y";
        while (isAddAnother) {

            out.print("\n Add another? (Y/N): \t: ");
            response = userInput.nextLine().toLowerCase();
            if (response.equals("y") || response.equals("n")) {
                break;
            }
        }
        boolean choice = response.equals("y") ? true : false;
        return choice;
    }

    public static String chooseEmployeeType(Scanner userInput) {
        section("open");
        printBalancedTitle("ADD A PAYCHECK", 64);
        out.println("├────────────────────────────────────────────────────────────────┤");
        out.println(String.format("│%-64s│", (" SELECT PAY TYPE ")));
        out.println(String.format("│%-32s│", "").replace(" ", " -").trim());
        out.println(String.format("│%-64s│", ("    1 - Hourly")));
        out.println(String.format("│%-64s│", ("    2 - Salaried ")));
        out.println(String.format("│%-64s│", ("    3 - Salaried plus Commission")));
        section("close");
        out.print(" \n Enter your choice (1 - 3)\t: ");
        return userInput.nextLine();

    }

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
                // out.println(hourlyEmp1.toString());
                hourlyArr.add(hourlyEmp1);
                break;

            case "2":// Employee: Salaried
                Salaried salariedEmp1 = new Salaried();
                salariedEmp1.load();
                salariedEmp1.getEarnings();
                // out.println(salariedEmp1.toString());
                salariedArr.add(salariedEmp1);
                break;

            case "3": // Employee: Salaried plus commission
                SalariedPlusCommission salariedPlusCommissionEmp1 = new SalariedPlusCommission();
                salariedPlusCommissionEmp1.load();
                salariedPlusCommissionEmp1.getEarnings();
                // out.println(salariedPlusCommissionEmp1.toString());
                salariedPlusCommissionArr.add(salariedPlusCommissionEmp1);
                break;

            default:
                out.println("invalid entry");
                break;
        }

    }

    // clear screen
    public static void clearScreen() {
        out.print("\033[H\033[2J");
        out.flush();
    }

    // formatting
    public static void printBalancedTitle(String title, int totalWidth) {
        // Calculate the exact padding needed for center alignment
        int totalSpaces = totalWidth - title.length();
        int leftSpaces = totalSpaces / 2;
        int rightSpaces = totalSpaces - leftSpaces;

        String formatted = " ".repeat(leftSpaces) + title + " ".repeat(rightSpaces);
        System.out.println(String.format("│%s│", formatted));
    }

    // formatting sections

    public static void section(String direction) {
        if (direction.equals("open")) {
            out.println("\n");
            out.println("┌────────────────────────────────────────────────────────────────┐");

        }
        if (direction.equals("close")) {
            out.println("└────────────────────────────────────────────────────────────────┘");

        }

        if (direction.equals("divider")) {
            out.println("\n─────────────────────────────────────────────────────────────────");
        }
    }
}
