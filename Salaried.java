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
        // if (!(this.getClass().toString()).contains("Plus")) {
        // out.println("-----------------------------------------------------------------");
        // }

        // ------ delete this block later ↓
        int randomSalary = random.nextInt(200, 1000);
        out.print("Salary \t\t\t\t: " + randomSalary);
        this.setWeeklySalary(randomSalary);
        if (!(this.getClass().toString()).contains("Plus")) {
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
