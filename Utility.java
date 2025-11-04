package OOP_A3;

import static java.lang.System.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Utility {

    public static void displayTitle() {
        clearScreen();
        out.println("\n*************** Payroll Management Application *******************\n");
    }

    public static void displayReportTitle() {
        out.println("\n\n********************* PAYCHECK REPORT ***************************\n");
    }

    public static void generateReport(List<Employee> employees, String title) {
        if (employees.size() > 0) {
            out.println("\n" + title + " ---");
            int counter = 1;
            for (Employee emp : employees) {
                out.print("\n" + counter);
                out.println(emp.toString());
                counter++;
            }
        }
    }

    public static boolean tryAgain(Scanner userInput) {
        // userInput.nextLine(); // clears the buffer / empty lines
        out.print("\nAdd more?\n (Y) for YES, any key for NO \t: ");
        String response = userInput.nextLine();
        boolean choice = response.toLowerCase().equals("y") ? true : false;
        return choice;
    }

    public static String chooseEmployeeType(Scanner userInput) {
        out.println("");
        out.println("Type (1) Hourly, (2) Salaried, (3) Salaried plus Commission");
        out.print("Enter 1, 2, or 3 \t\t: ");
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
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
