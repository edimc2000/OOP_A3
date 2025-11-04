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

        int employeeType = chooseEmployeeType();

        switch (employeeType) {

            case 1: // Employee: Hourly
                Hourly hourlyEmp1 = new Hourly();
                hourlyEmp1.load();
                hourlyEmp1.getEarnings();
                out.println(hourlyEmp1.toString());
                hourlyArr.add(hourlyEmp1);
                break;

            case 2:// Employee: Salaried
                Salaried salariedEmp1 = new Salaried();
                salariedEmp1.load();
                salariedEmp1.getEarnings();
                out.println(salariedEmp1.toString());
                salariedArr.add(salariedEmp1);
                break;

            case 3: // Employee: Salaried plus commission
                SalariedPlusCommission salariedPlusCommissionEmp1 = new SalariedPlusCommission();
                salariedPlusCommissionEmp1.load();
                salariedPlusCommissionEmp1.getEarnings();
                out.println(salariedPlusCommissionEmp1.toString());
                salariedPlusCommissionArr.add(salariedPlusCommissionEmp1);
                break;

            default:
                out.println("invalid entry");
                break;
        }

        boolean asktryAgain = tryAgain();
        out.println(asktryAgain);

        // test
        if (hourlyArr.size() > 0) {
         out.println("Hourly Employees ---");
            for (Employee emp : hourlyArr) {
                out.println(emp.toString());
            }
        }
 
    }

    public static int chooseEmployeeType() {
        out.println("Type (1) Hourly, (2) Salaried, (3)Salaried plus Commission");
        out.print("Enter 1, 2, or 3 \t\t: ");
        return userInput.nextInt();
    }

    public static boolean tryAgain() {
        userInput.nextLine(); // clears the buffer / empty lines
        out.print("\nAdd more?\n (Y) for Yes, any key for No \t: ");
        String response = userInput.nextLine();
        boolean choice = response.toLowerCase().equals("y") ? true : false;
        return choice;
    }

}
