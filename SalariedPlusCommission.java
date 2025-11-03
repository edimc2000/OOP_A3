package OOP_A3;

import static java.lang.System.*;

public class SalariedPlusCommission extends Salaried {

    private double salesPastWeek; 
    private double commissionRate; 
    private double earnings;

    SalariedPlusCommission(String name, String socialSecurityNumber, int birthMonth, int birthWeek, double weeklySalary, 
    double salesPastWeek, double commissionRate) {

        super(name, socialSecurityNumber, birthMonth, birthWeek, weeklySalary);
        this.salesPastWeek = salesPastWeek ;
        this.commissionRate = commissionRate; 

    }


    public double getEarnings() {
        double commissionAmount = this.commissionRate * this.salesPastWeek; 
        this.earnings = this.weeklySalary + this.getBonus() + commissionAmount;
        this.setPaycheck(this.earnings);
        return this.earnings;
    }

}
