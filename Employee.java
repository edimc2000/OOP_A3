package OOP_A3;

import java.util.Scanner;
import static java.lang.System.*;
import java.util.Calendar;

public abstract class Employee {

    public static final double BONUS_AMOUNT = 100.00;
    public static final double MAX_PAYCHECK = 1000.00;
    private String name;
    private String socialSecurityNumber;
    private int birthMonth;
    private int birthWeek;
    private double paycheck = 0;
    private Scanner userInput = new Scanner(System.in);

    public Scanner getUserInput() {
        return this.userInput;
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

        this.paycheck = amount > MAX_PAYCHECK ? MAX_PAYCHECK : amount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public void setBirthMonth(int birthMonth) {
        this.birthMonth = birthMonth;
    }

    public void setBirthWeek(int birthWeek) {
        this.birthWeek = birthWeek;
    }

    public void load() {
        Scanner userInput = new Scanner(System.in);

        // out.println("");
        // out.print("Name \t\t\t\t: ");
        // this.setName(this.getUserInput().nextLine());

        // out.print("Social Security Number \t\t: ");
        // this.setSocialSecurityNumber(this.getUserInput().nextLine());

        // out.print("Birthday month \t\t\t: ");
        // this.setBirthMonth(Integer.parseInt(this.getUserInput().nextLine()));

        // out.print("Birthday bonus week \t\t: ");
        // this.setBirthWeek(Integer.parseInt(this.getUserInput().nextLine()));


        out.println("");
        out.println("Name \t\t\t\t: Eddie");
        this.setName("Eddie");

        out.println("Social Security Number \t\t: 888-999-111");
        this.setSocialSecurityNumber("888-999-111");

        out.println("Birthday month \t\t\t: 11");
        this.setBirthMonth(Integer.parseInt("11"));

        out.println("Birthday bonus week \t\t: 2");
        this.setBirthWeek(Integer.parseInt("2"));

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
        int currentMonth = calendar.get(Calendar.MONTH) + 1;

        // out.println("\n\nDEBUG -- current M" + currentMonth + " current W = " + currentWeekOfMonth + "\n\n");
        boolean isEligibleForBonus = (currentMonth == this.birthMonth) && (currentWeekOfMonth == this.birthWeek);
        return isEligibleForBonus ? BONUS_AMOUNT : 0;
    }

    public abstract double getEarnings();

}