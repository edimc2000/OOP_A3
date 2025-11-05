package src;

import static java.lang.System.*;

import java.util.Scanner;

import shared.ColorStyle;
import shared.Helper;

import java.util.ArrayList;
import java.util.List;


public class Utility {

    public static StringBuilder buildDisplay = new StringBuilder();

    public static void displayTitle(String appTitle) {
        Helper.clearScreen();
        Helper.clearScreen();
        Helper.applyHighlighter(generateBoxedTitle(buildDisplay, appTitle).toString(),
                ColorStyle.WHITE, ColorStyle.BLUE_BG);
        resetDisplayBuilder();
    }

    public static void displayError() {
        Helper.moveToLastCharPreviousLine("last", 40);
        Helper.applyHighlighter(" Invalid Input ", ColorStyle.RED, ColorStyle.WHITE_BG);
    }

    public static StringBuilder generateBoxedTitle(StringBuilder buildString, String title) {
        buildString.append(Helper.section("open") + "\n");
        buildString.append(Helper.printBalancedTitle(title,
                64, " │", "│ ") + "\n");
        buildString.append(Helper.section("close"));
        return buildString;
    }

    public static void resetDisplayBuilder() {
        buildDisplay.setLength(0);
    }

    public static void displayReportTitle() {
        out.println("");
        Helper.applyHighlighter(generateBoxedTitle(buildDisplay, "PAYCHECK REPORT").toString(),
                ColorStyle.WHITE, ColorStyle.BLUE_BG);
        resetDisplayBuilder();
        out.println("");
    }

    public static void generateReport(List<Employee> employees, String title) {

        if (employees.size() > 0) {
            out.print("\n ");
            buildDisplay.append(Helper.printBalancedTitle(title, 66, "", ""));
            Helper.applyHighlighter(buildDisplay.toString(), ColorStyle.TORQUISE_BLUE, ColorStyle.BLACK_BG);
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

        Helper.applyHighlighter(buildDisplay.toString(), ColorStyle.TORQUISE_BLUE, ColorStyle.BLACK_BG);
        resetDisplayBuilder();
        out.println("");

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

}
