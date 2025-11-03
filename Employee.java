package OOP_A3;

import java.util.Scanner;
import static java.lang.System.*;

import java.util.Calendar;

public class Employee {

    private String name;
    private String socialSecurityNumber;
    private int birthMonth;
    private int birthWeek;
    private double paycheck = 0;

    Employee(String name, String socialSecurityNumber, int birthMonth, int birthWeek) {
        this.name = name;
        this.socialSecurityNumber = socialSecurityNumber;
        this.birthMonth = birthMonth;
        this.birthWeek = birthWeek;
    }

    public String getName() {
        return this.name;
    }

    public String getSocialSecurityNumber() {
        return this.socialSecurityNumber;
    }

    public int getBirthMonth() {
        return this.birthMonth;
    }

    public int getBirthWeek() {
        return this.birthWeek;
    }

    public double getPaycheck() {
        return this.paycheck;
    }

    public void setPaycheck(double amount) {
        
        this.paycheck = amount > 1000 ? 1000 : amount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public void setBithMonth(int birthMonth) {
        this.birthMonth = birthMonth;
    }

    public void setBirthWeek(int birthWeek) {
        this.birthWeek = birthWeek;
    }

    public static String[] load() {
        Scanner userInput = new Scanner(System.in);

        out.print("Name \t: ");
        String nameCapture = userInput.nextLine();
        out.print("Social Security Number \t: ");
        String ssnCapture = userInput.nextLine();
        out.print("Birthday month \t: ");
        String birthMonthCapture = userInput.nextLine();
        out.print("Birthday bonus week \t: ");
        String birthWeekCapture = userInput.nextLine();

        String[] capturedData = { nameCapture, ssnCapture, birthMonthCapture, birthWeekCapture };
        return capturedData;
    }

    @Override // pay check computation missing
    public String toString() {

        String display = String.format("%s\t\t: %s\n%s\t: %s\n%s\t\t: $%s",
                "Employee", this.getName(), "Social Security Number", this.getSocialSecurityNumber(),
                "Paycheck", Helper.formatTwoDecimals(getPaycheck()));
        return display;
    }

    // once the pay check variable is created, match this part to auto increment the
    // paycheck by 100
    public double getBonus() {
        // part 4
        // getting the current month and week to determine eligibility for $100 birthday
        // bonus
        Calendar calendar = Calendar.getInstance();
        int currentWeekOfMonth = calendar.get(Calendar.WEEK_OF_MONTH);
        int currentMonth = calendar.get(Calendar.MONTH)+1;

        out.println("\n\nDEBUG -- current M" + currentMonth+ " current W = " + currentWeekOfMonth +"\n\n");
        boolean isEligibleForBonus = (currentMonth == this.birthMonth) && (currentWeekOfMonth == this.birthWeek);
        return isEligibleForBonus ? 100 : 0;
    }

}