package OOP_A3;

import static java.lang.System.*;

public class Salaried extends Employee {

    double weeklySalary;
    private double earnings;

    Salaried(String name, String socialSecurityNumber, int birthMonth, int birthWeek, double weeklySalary) {

        super(name, socialSecurityNumber, birthMonth, birthWeek);
        this.weeklySalary = weeklySalary;

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
