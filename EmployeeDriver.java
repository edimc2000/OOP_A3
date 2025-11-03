package OOP_A3;

import static java.lang.System.*;

import java.util.Scanner;

import OOP_A3.Hourly;

public class EmployeeDriver {
    public static void main(String[] args) {

        // Employee emp1 = new Employee("Cardo", "111-222-333", 10, 2);
        // Hourly hEmp1 = new Hourly("Cardo", "111-222-333", 10, 2, 20, 20);
        // Salaried wEmp2 = new Salaried("dalisay", "111-222-333", 1, 2, 2000);
        // Salaried wEmp3 = new Salaried("emp3 tunying", "111-222-333", 10, 2, 2000);

        // SalariedPlusCommission spEmp4 = new SalariedPlusCommission("Tina",
        // "232-2323-456",
        // 10, 2, 200, 100, 0.10);

        // out.println(emp1.getName());
        // out.println(emp1.getSocialSecurityNumber());
        // out.println(emp1.getBirthMonth());
        // out.println(emp1.getBirthWeek());

        // emp1.load();
        // hEmp1.load();
        // out.println(emp1.toString());

        // out.println(hEmp1.getName());
        // out.println(hEmp1.getBonus());
        // out.println("Paycheck is : " + hEmp1.getEarnings());
        // out.println(hEmp1.toString());

        // out.println("--------------------------");
        // out.println(wEmp2.getName());
        // out.println(wEmp2.getBonus());
        // out.println("Paycheck is : " + wEmp2.getEarnings());
        // out.println(wEmp2.toString());

        // out.println("--------------------------");
        // out.println(wEmp3.getName());
        // out.println(wEmp3.getBonus());
        // out.println("Paycheck is : " + wEmp3.getEarnings());
        // out.println(wEmp3.toString());

        // out.println("-- s + comm------------------------");
        // out.println(spEmp4.getName());
        // out.println(spEmp4.getBonus());
        // out.println("Paycheck is : " + spEmp4.getEarnings());
        // out.println(spEmp4.toString());

        Scanner userInput = new Scanner(System.in);
        out.println("Type (1) Hourly, (2) Salaried, (3)Salaried plus Commission");
        out.print("Enter 0, 1, 2, or 3 \t: ");
        String employeeType = userInput.nextLine();
        String[] captures;
        switch (employeeType) {
            case "1":
                out.println("one is chosen");
                captures = Hourly.load();
                Hourly hourlyEmp1 = new Hourly(captures[0], captures[1],
                        Integer.parseInt(captures[2]), Integer.parseInt(captures[3]), 
                        Double.parseDouble(captures[4]), Double.parseDouble(captures[5]));
                        hourlyEmp1.getEarnings(); 
                out.println(hourlyEmp1.toString());
                break;

            case "0":
                out.println("zero is chosen");
                captures = Employee.load();
                // out.println("CAPTURE 0 --- : " + captures[0]);
                // out.println("creating emp1 ------");
                Employee emp1 = new Employee(captures[0], captures[1],
                        Integer.parseInt(captures[2]), Integer.parseInt(captures[3]));

                out.println(emp1.toString());

                break;
            default:
                break;
        }

    }

}
