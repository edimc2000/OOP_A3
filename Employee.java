package OOP_A3;

import java.util.Scanner;
import static java.lang.System.*;

import java.util.Calendar;

public class Employee {

    private String name;
    private String socialSecurityNumber;
    private int birthMonth;
    private int birthWeek;

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

    // requires more to get entry and load - see requirement 2
    public static void load() {
        Scanner userInput = new Scanner(System.in);
        out.println("type Hourly(1), Salaried(2), Salaried plus Commission(3)");
        out.println("Enter 1, 2, or 3 ==> ");
        String employeeNumber = userInput.nextLine();
        out.println("your entry is : " + employeeNumber);

    }

    @Override // pay check computation missing
    public String toString() {
        String display = String.format("%s\t\t: %s\n%s\t: %s\n%s\t\t: $%s",
                "Employee", this.getName(), "Social Security Number", this.getSocialSecurityNumber(),
                "Paycheck", "<fix this>");
        return display;
    }


    // once the pay check variable is created, match this part to auto increment the paycheck by 100 
    public double getBonus() {
        // part 4
        // getting the current month and week to determine eligibility for $100 birthday bonus 
        Calendar calendar = Calendar.getInstance();
        int currentWeekOfMonth = calendar.get(Calendar.WEEK_OF_MONTH);
        int currentMonth = calendar.get(Calendar.MONTH);
        boolean isEligibleForBonus = (currentMonth == this.birthMonth) && (currentWeekOfMonth == this.birthWeek);
        return isEligibleForBonus ? 100 : 0;
    }

}