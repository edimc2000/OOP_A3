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

        // out.print("Salary \t\t\t\t: ");
        // this.setWeeklySalary(Double.parseDouble(this.getUserInput().nextLine()));
        // out.println("-----------------------------------------------------------------");

        // ------ delete this block later ↓
        out.print("Salary \t\t\t\t: 700");
        this.setWeeklySalary(700);
        out.print(this.getClass().toString());

        if ((this.getClass().toString()).contains("plus")) {
            out.println("\n-----------------------------------------------------------------");
        }

        // ------ delete this block later ↑
    }

    public double getEarnings() {
        this.earnings = this.getWeeklySalary() + this.getBonus();
        this.setPaycheck(this.earnings);
        return this.earnings;
    }
}
