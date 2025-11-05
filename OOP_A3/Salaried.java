package OOP_A3;

import static java.lang.System.*;

import java.util.Scanner;

import shared.Helper;

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

        // ------ scanner ↓ ------
        // out.print(" Salary \t\t\t: ");
        // this.setWeeklySalary(Double.parseDouble(this.getUserInput().nextLine()));
        // if (!(this.getClass().toString()).contains("Plus")) {
        // out.println(Helper.section("divider"));
        // }
        // ------ scanner ↑ ------

        // ------ ↓ for quick test: uncomment below to bypass scanner while commenting
        // ------ out the scanner above
        int randomSalary = random.nextInt(200, 1000);
        out.print("  Salary \t\t\t: " + randomSalary + "\n");
        this.setWeeklySalary(randomSalary);
        if (!(this.getClass().toString()).contains("Plus")) {
            out.println(Helper.section("divider"));
        }
        // ------ ↑ bypass scanner ↑
    }

    public double getEarnings() {
        this.earnings = this.getWeeklySalary() + this.getBonus();
        this.setPaycheck(this.earnings);
        return this.earnings;
    }
}
