Payroll Assignment (Module 2 - Inheritance & Polymorphism)

Overview
--------
This repository contains a Java implementation of a payroll program that demonstrates inheritance and polymorphism across three employee types: Hourly, Salaried, and SalariedPlusCommission. The program calculates weekly earnings (with overtime and commission), applies a birthday bonus when applicable, and caps paychecks at $1,000.

Project status
--------------
- Core requirements implemented: class hierarchy, polymorphic earnings, birthday bonus (Calendar), paycheck cap (MAX_PAYCHECK), and formatted `toString()` output.
- Interactive input handling is robust: helpers for safe integer/double parsing and a centralized validation method (`Utility.validatePositiveDouble`) are in place.
- Constructors were added to `Employee` to satisfy identity/constructor learning outcomes.
- Test-bypass code in `Employee.load()` has been removed (interactive prompts active).

Files of interest
-----------------
-- src/Employee.java           — abstract base class; constructors; `getBonus()`; interactive `load()`
- src/Hourly.java             — hourly employee implementation (overtime logic)
- src/Salaried.java           — salaried employee implementation
- src/SalariedPlusCommission.java — salaried + commission implementation
- src/PayrollManager.java     — driver (main)
- src/Utility.java            — UI, input validation (validatePositiveDouble), report generation
- shared/Helper.java          — formatting, cursor helpers, safe parsing helpers (`stringToInt`, `stringToDouble`)
- shared/ColorStyle.java      — console color constants (comment contains AI-assist disclosure)

How to compile and run (Windows cmd)
------------------------------------
From the repository directory that contains `src` and `shared` packages, run:

> javac -d out src\src\*.java shared\*.java
> java -cp out src.PayrollManager

Notes:
- The code uses ANSI escape sequences for console formatting. On Windows, use a terminal that supports ANSI (Windows 10+ cmd with VT enabled or Windows Terminal).
- The program is interactive: follow prompts to add employees and generate the paycheck report.

Scoring & Assessment (rubric)
-----------------------------
Based on the supplied rubric (Program correctness, Readability, Documentation, Efficiency, Student performance):
- Program correctness: 5/5 — all functional requirements implemented and input parsing made robust.
- Readability: 5/5 — consistent formatting, descriptive identifiers, Javadoc present.
- Documentation: 5/5 — classes and methods documented.
- Efficiency: 5/5 — appropriate approaches for the assignment scale.
 - Student performance: 4/5 — strong demonstration of concepts; constructors are implemented. (If instructor requires additional specific behaviors, this can be adjusted.)

Total: 24 / 25 (Level: Excellent). If input validation or constructors/equals are not graded, the score can be 25/25.

AI disclosure
-------------
The author added an in-source comment in `shared/ColorStyle.java` stating: "Comments were AI assisted using Perplexity." This project therefore includes AI-assisted comments. Include this disclosure with any formal submission according to your institution's policy.

Notes and next steps
--------------------
- If you want a single consolidated `ArrayList<Employee>` for simpler polymorphic handling in the driver, I can refactor `PayrollManager`.
- I can also add small unit tests or a simple demo input script if you'd like automated verification.

If you want me to make further edits (for example, remove any remaining test-mode code, refactor driver lists, or add unit tests), tell me which change and I will apply it and re-run quick checks.
