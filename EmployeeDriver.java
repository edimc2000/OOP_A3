package OOP_A3;

import static java.lang.System.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeDriver {

    private static Scanner userInput = new Scanner(System.in);

    private static ArrayList<Employee> hourlyArr = new ArrayList<>();
    private static ArrayList<Employee> salariedArr = new ArrayList<>();
    private static ArrayList<Employee> salariedPlusCommissionArr = new ArrayList<>();

    public static void main(String[] args) {

        boolean toContinue = true;
        Utility.displayTitle();

        while (toContinue) {
            Utility.addEmployee(userInput, hourlyArr, salariedArr, salariedPlusCommissionArr);
            toContinue = Utility.tryAgain(userInput);
        }

        Utility.displayReportTitle();

        Utility.generateReport(hourlyArr, "Hourly Employees");
        Utility.generateReport(salariedArr, "Salaried Employees");
        Utility.generateReport(salariedPlusCommissionArr, "Salaried + Commission Employees");

    }




    
}
