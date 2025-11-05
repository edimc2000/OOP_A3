package OOP_A3;

import static java.lang.System.*;

import java.util.Scanner;

import OOP_A3.Utility;

public class Hourly extends Employee {
    public static final double OVERTIME_MULTIPLIER = 1.5;
    private double hourlyPay;
    private double hoursWorkForWeek;
    private double earnings;

    public double getHourlyPay() {
        return hourlyPay;
    }

    public double getHoursWorkForWeek() {
        return hoursWorkForWeek;
    }

    public void setHourlyPay(double hourlyPay) {
        this.hourlyPay = hourlyPay;
    }

    public void setHoursWorkForWeek(double getHoursWorkForWeek) {
        this.hoursWorkForWeek = getHoursWorkForWeek;
    }

    public void load() {
        super.load();

        // ------ scanner ↓ ------
        // out.print(" Hourly pay \t\t\t: ");
        // this.setHourlyPay(Double.parseDouble(this.getUserInput().nextLine()));
        // out.print(" Hours worked this past week \t: ");
        // this.setHoursWorkForWeek(Double.parseDouble(this.getUserInput().nextLine()));
        // ------ scanner ↑ ------

        // ------ ↓ for quick test: uncomment below to bypass scanner while commenting
        // ------ out the scanner above
        out.println("  Hourly pay \t\t\t: 20");
        this.setHourlyPay(20);

        out.println("  Hours worked this past week \t: 41");
        this.setHoursWorkForWeek(41);

        // ------ ↑ bypass scanner ↑

        out.println(Helper.section("divider"));
    }

    public double getEarnings() {
        if (this.hoursWorkForWeek > 40) {
            double overtimePay = (this.hoursWorkForWeek - 40) * OVERTIME_MULTIPLIER * this.hourlyPay;
            double birthdayBonus = this.getBonus();
            this.earnings = (this.hourlyPay * 40) + birthdayBonus + overtimePay;
        } else {
            this.earnings = (this.hourlyPay * this.hoursWorkForWeek) + this.getBonus();
        }
        this.setPaycheck(this.earnings);
        return this.earnings;
    }
}
