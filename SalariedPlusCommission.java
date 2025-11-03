package OOP_A3;

import static java.lang.System.*;

import java.util.Scanner;

public class SalariedPlusCommission extends Salaried {

    private double salesPastWeek;
    private double commissionRate;
    private double earnings;

    SalariedPlusCommission(String name, String socialSecurityNumber, int birthMonth, int birthWeek, double weeklySalary,
            double salesPastWeek, double commissionRate) {

        super(name, socialSecurityNumber, birthMonth, birthWeek, weeklySalary);
        this.salesPastWeek = salesPastWeek;
        this.commissionRate = commissionRate;

    }
    public static String[] load() {
        Scanner userInput = new Scanner(System.in);
        // String[] capturedData = new String[7]; 

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
        // out.print("Sales for this past week \t: ");
        // String salesCapture = userInput.nextLine();
        out.print("Sales Commission rate\n   (fraction paid to employee)\t: ");
        // String commissionCapture = userInput.nextLine();

        // -------------------------

        // // --- bdelete these test data --- ---
        String nameCapture = "Eddie";
        String ssnCapture = "123-556-665";
        String birthMonthCapture = "10";
        String birthWeekCapture = "1";
        String salaryCapture = "800";
        String salesCapture = "2000";
        String commissionCapture = "0.25";

        // // -------------------------

        String[] capturedData = { nameCapture, ssnCapture, birthMonthCapture, birthWeekCapture,
                salaryCapture, salesCapture, commissionCapture };

        return capturedData;
    }

    public double getEarnings() {
        double commissionAmount = this.commissionRate * this.salesPastWeek;
        this.earnings = this.weeklySalary + this.getBonus() + commissionAmount;
        this.setPaycheck(this.earnings);
        return this.earnings;
    }

}
