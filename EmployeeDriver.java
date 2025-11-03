package OOP_A3;

import static java.lang.System.*;

public class EmployeeDriver {
    public static void main(String[] args) {

        Employee emp1 = new Employee("Cardo", "111-222-333", 10, 2);
        Employee emp2 = new Employee("dalisay", "111-222-333", 1, 2  );

        // out.println(emp1.getName());
        // out.println(emp1.getSocialSecurityNumber());
        // out.println(emp1.getBirthMonth());
        // out.println(emp1.getBirthWeek());

        // Employee.load();
        // out.println(emp1.toString());

        out.println(emp1.getName());
        out.println(emp1.getBonus());

out.println("--------------------------");
        out.println(emp2.getName());
        out.println(emp2.getBonus());
    }


}
