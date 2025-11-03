package OOP_A3;

import static java.lang.System.*;

import java.util.Scanner;

public class Hourly extends Employee {

    private double hourlyPay;
    private double hoursWorkForWeek;
    private double earnings;

    Hourly(String name, String socialSecurityNumber, int birthMonth, int birthWeek,
            double hourlyPay, double hoursWorkForWeek) {

        super(name, socialSecurityNumber, birthMonth, birthWeek);
        this.hourlyPay = hourlyPay;
        this.hoursWorkForWeek = hoursWorkForWeek;

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
        // out.print("Hourly pay \t: ");
        // String hourlyPayCapture = userInput.nextLine();
        // out.print("Hours worked this past week \t: ");
        // String hoursWorkedCapture = userInput.nextLine();

        // -------------------------

        // // --- bdelete these test data --- ---
        String nameCapture = "Eddie";
        String ssnCapture = "123-556-665";
        String birthMonthCapture = "10";
        String birthWeekCapture = "2";
        String hourlyPayCapture = "20"; 
        String hoursWorkedCapture = "41"; 
        
        // // -------------------------

        String[] capturedData = { nameCapture, ssnCapture, birthMonthCapture, birthWeekCapture,
                hourlyPayCapture, hoursWorkedCapture };

        return capturedData;
    }

    public double getEarnings() {

        if (this.hoursWorkForWeek > 40) {
            double overtimePay = (this.hoursWorkForWeek - 40) * 1.5 * this.hourlyPay;
            double birthdayBonus = this.getBonus();
            this.earnings = (this.hourlyPay * 40) + birthdayBonus + overtimePay;

            out.println(" overtime\t: " + (this.hoursWorkForWeek - 40) + "hrs");
            out.println(" Regular pay\t: " + (this.hourlyPay * 40));
            out.println(" overtime pay\t: " + overtimePay);
            out.println(" Birthday bonus\t: " + birthdayBonus);

        } else {
            this.earnings = (this.hourlyPay * this.hoursWorkForWeek) + this.getBonus();
        }

        this.setPaycheck(this.earnings);
        return this.earnings;
    }
}
