package OOP_A3;

import static java.lang.System.*;

import java.util.Scanner;

public class Salaried extends Employee {

    private double weeklySalary;
    private double earnings;

    public double getWeeklySalary() {
        return this.weeklySalary;
    }

    public void setWeeklySalary(double amount) {
        this.weeklySalary = amount;
    }

    public void load() {
        super.load();
        
        out.print("Salary \t: ");
        this.setWeeklySalary(Double.parseDouble(this.getUserInput().nextLine()));
    }

    public double getEarnings() {
        this.earnings = this.getWeeklySalary() + this.getBonus();
        this.setPaycheck(this.earnings);
        return this.earnings;
    }
}
