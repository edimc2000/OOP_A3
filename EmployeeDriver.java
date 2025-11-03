package OOP_A3;

import static java.lang.System.*;

import OOP_A3.Hourly;

public class EmployeeDriver {
    public static void main(String[] args) {

        Hourly hEmp1 = new Hourly("Cardo", "111-222-333", 10, 2, 20, 20);
        Employee emp2 = new Employee("dalisay", "111-222-333", 1, 2  );

        // out.println(emp1.getName());
        // out.println(emp1.getSocialSecurityNumber());
        // out.println(emp1.getBirthMonth());
        // out.println(emp1.getBirthWeek());

        // Employee.load();
        // out.println(emp1.toString());

        out.println(hEmp1.getName());
        out.println(hEmp1.getBonus());
        out.println("Paycheck is : "+ hEmp1.getEarnings());
         out.println(hEmp1.toString());

out.println("--------------------------");
        out.println(emp2.getName());
        out.println(emp2.getBonus());
    }


}
