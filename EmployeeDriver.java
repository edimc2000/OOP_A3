package OOP_A3;

import static java.lang.System.*;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeDriver {

    private static Scanner userInput = new Scanner(System.in);

    // Move ArrayList outside main method to make it accessible throughout the class
    private static ArrayList<Employee> hourlyArr = new ArrayList<>();
    private static ArrayList<Employee> salariedArr = new ArrayList<>();
    private static ArrayList<Employee> salariedPlusCommissionArr = new ArrayList<>();

    public static void main(String[] args) {

        boolean toContinue = true;

        while (toContinue) {
            addEmployee();
            toContinue = tryAgain();
            // out.println(toContinue);

        }

        // boolean asktryAgain = tryAgain();
        // out.println(asktryAgain);

     

        out.println("\n--------------------------------------------------------------"); 
        out.println("PAYCHECK REPORT : "); 
        out.println("--------------------------------------------------------------"); 
        if (hourlyArr.size() > 0) {
            int counter = 1;
            out.println("\nHourly Employees ---");
            for (Employee emp : hourlyArr) {
                out.print("\n" + counter);
                out.println(emp.toString());
                counter++;
            }

        }

        if (salariedArr.size() > 0) {
            int counter = 1;
            out.println("\nSalaried Employees ---");
            for (Employee emp : salariedArr) {
                out.print("\n" + counter);
                out.println(emp.toString());
                counter++;
            }
        }

        if (salariedPlusCommissionArr.size() > 0) {
            int counter = 1;
            out.println("\nSalaried + Commission Employees ---");
            for (Employee emp : salariedPlusCommissionArr) {
                out.print("\n" + counter);
                out.println(emp.toString());
                counter++;
            }
        }

    }

    public static String chooseEmployeeType() {
        out.println("Type (1) Hourly, (2) Salaried, (3) Salaried plus Commission");
        out.print("Enter 1, 2, or 3 \t\t: ");
        return userInput.nextLine();
    }

    public static boolean tryAgain() {
        // userInput.nextLine(); // clears the buffer / empty lines
        out.print("\nAdd more?\n (Y) for YES, any key for NO \t: ");
        String response = userInput.nextLine();
        boolean choice = response.toLowerCase().equals("y") ? true : false;
        return choice;
    }

    public static void addEmployee() {

        String employeeType = chooseEmployeeType();

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
}
