package OOP_A3;

import static java.lang.System.*;

import java.util.Scanner;

public class SalariedPlusCommission extends Salaried {

    private double salesPastWeek;
    private double commissionRate;
    private double earnings;

    public double getSalesPastWeek() {
        return this.salesPastWeek;
    }

    public double getCommissionRate() {
        return this.commissionRate;
    }

    public void setSalesPastWeek(double amount) {
        this.salesPastWeek = amount;
    }

    public void setCommissionRate(double rate) {
        this.commissionRate = rate;
    }

    public double computeCommissionAmount() {
        return this.getCommissionRate() * this.getSalesPastWeek();
    }

    public void load() {
        super.load();

        // out.print("Sales for this past week \t: ");
        // this.setSalesPastWeek(Double.parseDouble(this.getUserInput().nextLine()));

        // out.print("Sales Commission rate\n (fraction paid to employee)\t: ");
        // this.setCommissionRate(Double.parseDouble(this.getUserInput().nextLine()));
        // out.println("-----------------------------------------------------------------");

        // ------ delete this block later ↓
        out.print("Sales for this past week \t: 1000 \n");
        this.setSalesPastWeek(1000);

        // out.print("Sales Commission rate\n (fraction paid to employee)\t: 0.10");
        // this.setCommissionRate(0.10);
        out.print("Sales Commission rate\n   (fraction paid to employee)\t: ");
        this.setCommissionRate(Double.parseDouble(this.getUserInput().nextLine()));
        out.println("-----------------------------------------------------------------");

        // ------ delete this block later ↑

    }

    public double getEarnings() {
        this.earnings = this.getWeeklySalary() + this.getBonus() + this.computeCommissionAmount();
        this.setPaycheck(this.earnings);
        return this.earnings;
    }

}
