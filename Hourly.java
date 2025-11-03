package OOP_A3;

import static java.lang.System.*;

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
