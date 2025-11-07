_This README.md file was created with assistance from AI - GitHub Copilot. The remaining code was developed without AI support, except where explicitly indicated in the code comments._

# Payroll App (Inheritance & Polymorphism)

A small Java project demonstrating inheritance and polymorphism through a payroll program. The project implements three pay types (Hourly, Salaried, Salaried plus Commission), computes weekly earnings (including overtime and commission), applies a birthday bonus when applicable, and caps individual paychecks at $1,000.

## Project Overview

Files in this repository (package declared as `src` in sources):

- `src/Employee.java` 
	- Abstract base class that captures common employee fields and birthday bonus logic.
- `src/Hourly.java` 
	- Hourly employee implementation (hourly rate, overtime calculation).
- `src/Salaried.java` 
	- Salaried employee implementation (weekly salary).
- `src/SalariedPlusCommission.java` 
	- Salaried plus commission implementation (salary + commission on sales).
- `src/PayrollManager.java` 
	- Driver with `main` that manages the interactive flow.
- `src/Utility.java` 
	- UI helpers, input validation (`validatePositiveDouble`), menu and report generation.
- `shared/Helper.java` 
	- Formatting and safe parsing helpers (`stringToInt`, `stringToDouble`) and small console helpers.
- `shared/ColorStyle.java` 
	- ANSI color constants (note: contains an in-source AI comment about assisted comment generation).

## Quick Features

- Polymorphic employee hierarchy (abstract `Employee` + concrete subclasses).
- Overtime calculation for hourly employees (time-and-a-half for hours over 40).
- Commission calculations for salaried-plus-commission employees.
- Birthday bonus logic (uses `java.util.Calendar` to determine current month/week).
- Centralized numeric validation to prevent crashes from bad input.
- Formatted paycheck report output with basic console highlighting.

## Package / Class Structure (extracted from source)

Package: `src`

### `Employee` (file: `Employee.java`)

Instance fields (selected):
- `private String name`
- `private String socialSecurityNumber`
- `private int birthMonth`
- `private int birthWeek`
- `private double paycheck`

Key methods:
- `public abstract double getEarnings()` — implemented by subclasses.
- `public void load()` — interactive capture of name, SSN, birth month/week.
- `public double getBonus()` — returns `100.00` when current month/week matches employee birthday week.
- `public void setPaycheck(double)` — enforces `MAX_PAYCHECK` cap.

### `Hourly` (file: `Hourly.java`)

Fields and behavior:
- `hourlyPayRate`, `hoursWorked`.
- `getEarnings()` calculates overtime at 1.5x for hours over 40.
- `load()` prompts for hourly rate and hours worked and uses validation helpers.

### `Salaried` (file: `Salaried.java`)

Fields and behavior:
- `weeklySalary`.
- `getEarnings()` returns `weeklySalary` (plus any birthday bonus when applicable).

### `SalariedPlusCommission` (file: `SalariedPlusCommission.java`)

Fields and behavior:
- `weeklySalary`, `grossSales`, `commissionRate`.
- `getEarnings()` returns `weeklySalary + (grossSales * commissionRate / 100)`.

### `PayrollManager` (file: `PayrollManager.java`)

Driver behavior:
- Uses `Utility.addEmployee(...)` in a loop to collect employee records.
- Stores employees in separate `ArrayList<Employee>` collections per pay type and then calls `Utility.generateReport(...)` to print them.

### `Utility` (file: `Utility.java`)

Important methods:
- `chooseEmployeeType(Scanner)` — prints a menu (1=Hourly, 2=Salaried, 3=Salaried plus Commission) and returns the user's choice.
- `addEmployee(...)` — constructs the selected employee type, calls `load()`, computes earnings, and stores the object.
- `validatePositiveDouble(String, String, String, boolean)` — centralized numeric validation + re-prompt loop.
- `generateReport(List<Employee>, String)` — prints a formatted payroll section for the provided list.

### `shared/Helper` (file: `shared/Helper.java`)

Utility helpers:
- `stringToInt(String)` — safe integer parsing returning sentinel on failure.
- `stringToDouble(String)` — safe double parsing returning sentinel value on failure.
- Formatting helpers for currency and simple console helpers used by `Utility`.

## How to compile and run (Windows cmd.exe)

From the folder that contains the `src` and `shared` directories (project root), run:

```bat
javac -d out src\\*.java shared\\*.java
java -cp out src.PayrollManager
```

Notes:
- The program is interactive. Enter numeric menu choices (1–3) when prompted and respond to `Add another? (Y/N)`.
- The code uses ANSI escape sequences for colored output; use a terminal that supports them for best readability.

## Actual sample output (representative)

This is a short representative transcript capturing the program flow and a sample final report. Prompts are shown followed by example user input.

![A session with 1- hourly and 3- Salaried plu Commission, no error.](/screenshots/session1and3noerror.png)

## Validation and error handling

Numeric parsing is centralized to avoid runtime exceptions. Key points:

- `shared.Helper.stringToDouble(...)` and `shared.Helper.stringToInt(...)` perform safe parsing and return a sentinel value instead of throwing.
- `Utility.validatePositiveDouble(...)` encapsulates the user re-prompt loop and displays contextual error messages and a limited number of retry attempts.
- Invalid inputs (non-numeric, empty, or out-of-range values) produce a short error message and re-prompt. The program shuts down if the maximum attempt limit is reached.

Example of a re-prompt:

![A session with errors and re-prompt.](/screenshots/sessionInputErrors.png)

## Requirements

- Java 8 or later
- No external dependencies (uses only Java Standard Library)
- ANSI enabled terminal for best experience 

## Contact

If you have questions or need further changes, reply here or refer to the course materials.
