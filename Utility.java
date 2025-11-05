package OOP_A3;

import static java.lang.System.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Utility {

    public static StringBuilder buildDisplay = new StringBuilder();

    public static void applyHighlighter(String display, String foreground, String background) {
        String[] lines = display.split("\n");
        String colorCode = foreground + background;

        for (String line : lines) {
            out.println(colorCode + line + ColorStyle.RESET_FORMATTING);
        }
    }

    public static void displayTitle() {
        clearScreen();
        buildDisplay.append(section("open") + "\n");
        buildDisplay.append(printBalancedTitle(" ***** PAYROLL MANAGEMENT APPLICATION *****",
                64, " │", "│ ") + "\n");
        buildDisplay.append(section("close"));
         applyHighlighter(buildDisplay.toString(), ColorStyle.WHITE, ColorStyle.BLUE_BG);
        buildDisplay.setLength(0);

    }

    public static void displayReportTitle() {
        out.println("");
        buildDisplay.append(section("open") + "\n");
        buildDisplay.append(printBalancedTitle(" ***** PAYCHECK REPORT *****",
                64, " │", "│ ") + "\n");
        buildDisplay.append(section("close"));
        applyHighlighter(buildDisplay.toString(), ColorStyle.WHITE, ColorStyle.BLUE_BG);

        buildDisplay.setLength(0);
        out.println("");
    }

    public static void generateReport(List<Employee> employees, String title) {

        if (employees.size() > 0) {
            out.print("\n ");
            buildDisplay.append(printBalancedTitle(title, 66, "", ""));

            applyHighlighter(buildDisplay.toString(), ColorStyle.TORQUISE_BLUE , ColorStyle.BLACK_BG);

            out.println(section("divider"));

            int counter = 1;
            for (Employee emp : employees) {

                out.print("\n  " + counter);
                out.println(emp.toString());
                counter++;
            }
            buildDisplay.setLength(0);
        }
    }

    public static boolean tryAgain(Scanner userInput) {
        boolean isAddAnother = true;
        String response = "y";
        while (isAddAnother) {

            out.print("\n Add another? (Y/N): \t\t: ");
            response = userInput.nextLine().toLowerCase();
            if (response.equals("y") || response.equals("n")) {
                break;
            }
        }
        boolean choice = response.equals("y") ? true : false;
        return choice;
    }

    public static String chooseEmployeeType(Scanner userInput) {

        // out.println(section("open"));

        // out.println(printBalancedTitle("ADD A PAYCHECK", 64, " │", "│ "));
        // out.println(String.format(" ├%-64s┤", "*".repeat(64)).replace("*", "─"));
        // out.println(String.format(" │%-64s│", (" SELECT PAY TYPE ")));
        // out.println(String.format(" │%-64s│", "*".repeat(64)).replace("*", "-"));
        // out.println(String.format(" │%-64s│", (" 1 - Hourly")));
        // out.println(String.format(" │%-64s│", (" 2 - Salaried ")));
        // out.println(String.format(" │%-64s│", (" 3 - Salaried plus Commission")));
        // out.println(section("close"));

        out.println("");
        buildDisplay.append(section("open"));
        buildDisplay.append("\n" + printBalancedTitle("ADD A PAYCHECK", 64, " │", "│ "));
        buildDisplay.append("\n" + String.format(" ├%-64s┤ ", "*".repeat(64)).replace("*", "─"));
        buildDisplay.append("\n" + String.format(" │%-64s│ ", (" SELECT PAY TYPE ")));
        buildDisplay.append("\n" + String.format(" │%-64s│ ", "*".repeat(64)).replace("*", "-"));
        buildDisplay.append("\n" + String.format(" │%-64s│ ", ("    1 - Hourly")));
        buildDisplay.append("\n" + String.format(" │%-64s│ ", ("    2 - Salaried ")));
        buildDisplay.append("\n" + String.format(" │%-64s│ ", ("    3 - Salaried plus Commission")));
        buildDisplay.append("\n" + section("close"));

        // applyHighlighter(buildDisplay.toString(), ColorStyle.WHITE, ColorStyle.TORQUISE_BLUE_BG);
        applyHighlighter(buildDisplay.toString(), ColorStyle.TORQUISE_BLUE, ColorStyle.BLACK_BG);
        buildDisplay.setLength(0);
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
    public static String printBalancedTitle(String title, int totalWidth, String borderLeft, String borderRight) {
        // Calculate the exact padding needed for center alignment
        int totalSpaces = totalWidth - title.length();
        int leftSpaces = totalSpaces / 2;
        int rightSpaces = totalSpaces - leftSpaces;

        String formatted = " ".repeat(leftSpaces) + title + " ".repeat(rightSpaces);
        // System.out.println(String.format(border + "%s" + border, formatted));

        return String.format(borderLeft + "%s" + borderRight, formatted);
    }
    // │
    // formatting sections

    public static String section(String direction) {
        StringBuilder headerDesign = new StringBuilder("");

        if (direction.equals("open")) {
            headerDesign.append(String.format(" ┌%-64s┐ ", "*".repeat(64))
                    .replace("*", "─"));
            return headerDesign.toString();

        }
        if (direction.equals("close")) {
            headerDesign.append(String.format(" └%-64s┘ ", "*".repeat(64))
                    .replace("*", "─"));
            return headerDesign.toString();
        }

        if (direction.equals("divider")) {
            headerDesign.append(String.format("%-69s", "")
                    .replace(" ", "-").trim());
            return headerDesign.toString();
        }

        return headerDesign.toString();

    }
}
