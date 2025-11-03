package OOP_A3;

import static java.lang.System.*;

import java.util.Scanner;

public class Salaried extends Employee {

    double weeklySalary;
    private double earnings;

    Salaried(String name, String socialSecurityNumber, int birthMonth, int birthWeek, double weeklySalary) {

        super(name, socialSecurityNumber, birthMonth, birthWeek);
        this.weeklySalary = weeklySalary;

    }

    public static String[] load() {
        Scanner userInput = new Scanner(System.in);

        // --- below is the actual input capture --- ---
        // out.print("Name \t: ");
        // String nameCapture = userInput.nextLine();
        // out.print("Social Security Number \t: ");
        // String ssnCapture = userInput.nextLine();
        // out.print("Birthday month \t: ");
        // String birthMonthCapture = userInput.nextLine();
        // out.print("Birthday bonus week \t: ");
        // String birthWeekCapture = userInput.nextLine();
        // out.print("Salary \t: ");
        // String salaryCapture = userInput.nextLine();
   
        // -------------------------

        // // --- bdelete these test data --- ---
        String nameCapture = "Eddie";
        String ssnCapture = "123-556-665";
        String birthMonthCapture = "10";
        String birthWeekCapture = "2";
        String salaryCapture = "20"; 

        
        // // -------------------------

        String[] capturedData = { nameCapture, ssnCapture, birthMonthCapture, birthWeekCapture,
                salaryCapture,};

        return capturedData;
    }
    public double getWeeklySalary() {
        return this.weeklySalary;
    }

    public void setWeeklySalary(double amount) {
        this.weeklySalary = amount;
    }

    public double getEarnings() {

        this.earnings = this.weeklySalary + this.getBonus();
        this.setPaycheck(this.earnings);
        return this.earnings;
    }

}
