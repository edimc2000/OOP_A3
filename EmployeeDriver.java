package OOP_A3;

import static java.lang.System.*;

import java.util.Scanner;

public class EmployeeDriver {
    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);
        out.println("Type (1) Hourly, (2) Salaried, (3)Salaried plus Commission");
        out.print("Enter 0, 1, 2, or 3 \t: ");
        String employeeType = userInput.nextLine();
        String[] captures;
        switch (employeeType) {
             case "3":
                out.println("three is chosen  - len => " );
                
                captures = SalariedPlusCommission.load();
                SalariedPlusCommission salariedPlusCommissionEmp1 = new SalariedPlusCommission(captures[0], captures[1],
                        Integer.parseInt(captures[2]), Integer.parseInt(captures[3]),
                        Double.parseDouble(captures[4]), Double.parseDouble(captures[5]), 
                        Double.parseDouble(captures[6]));
                salariedPlusCommissionEmp1.getEarnings();
                out.println(salariedPlusCommissionEmp1.toString());
                break;

            case "1":
                out.println("one is chosen");
                captures = Hourly.load();
                Hourly hourlyEmp1 = new Hourly(captures[0], captures[1],
                        Integer.parseInt(captures[2]), Integer.parseInt(captures[3]),
                        Double.parseDouble(captures[4]), Double.parseDouble(captures[5]));
                hourlyEmp1.getEarnings();
                out.println(hourlyEmp1.toString());
                break;

            case "2":
                out.println("two is chosen");
                captures = Salaried.load();
                Salaried SalariedEmp1 = new Salaried(captures[0], captures[1],
                        Integer.parseInt(captures[2]), Integer.parseInt(captures[3]),
                        Double.parseDouble(captures[4]));
                SalariedEmp1.getEarnings();
                out.println(SalariedEmp1.toString());
                break;

            case "0":
                // this is to test the parent class
                out.println("zero is chosen");
                captures = Employee.load();
                Employee emp1 = new Employee(captures[0], captures[1],
                        Integer.parseInt(captures[2]), Integer.parseInt(captures[3]));

                out.println(emp1.toString());

                break;
            default:
            out.println("invalid entry");
                break;
        }

    }

}
