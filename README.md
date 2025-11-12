# Payroll-Management-System
This is a small console-based Java payroll system that manages multiple employee types — Salaried, Hourly, and Manager — and computes their pay according to their own rules. The program demonstrates core object-oriented concepts (abstraction, encapsulation, inheritance, polymorphism) while providing a simple, interactive menu for adding employees and printing a payroll summary. It solves the problem of calculating pay for mixed employee types (including overtime and bonuses) from a single unified structure.

Abstraction
The abstract class Employee defines shared properties and behaviors among all employees. It declares abstract methods such as calculatePay() and getType() which are implemented differently by each subclass. This ensures that all employees share a common structure while allowing flexibility for unique pay logic.

Encapsulation
Each class uses private fields for data such as name, bonus, salary, and hourly rate. Public methods like getName() and getBonus() provide controlled access to these fields. This prevents direct manipulation of class data and maintains integrity throughout the system.

Inheritance
The subclasses SalariedEmployee, HourlyEmployee, and Manager inherit from the abstract Employee class. Each subclass extends the parent class by adding its own unique properties and pay calculations. This structure eliminates redundancy and allows code reuse.

Polymorphism
Polymorphism is demonstrated when the system stores various employee objects in a single array of Employee type. Each subclass implements its own version of calculatePay(), and during runtime, the correct method is automatically called based on the actual employee type. This enables uniform handling of different employee objects through shared superclass references.

Exception Handling
The program includes try-catch blocks to manage invalid or unexpected user input, such as entering non-numeric values when numeric input is required. This prevents the program from crashing and provides clear error messages for users to correct their input.

Program Structure
The entire system is implemented in a single file named Main.java. The Employee class serves as the abstract base class containing common attributes and abstract methods. The subclasses SalariedEmployee, HourlyEmployee, and Manager extend this base class and implement specific pay calculation logic. The Main class contains the main method that runs the program, displaying a console-based menu where users can add employees, view payroll details, or exit the system. An array of Employee objects stores all employee information and demonstrates the use of arrays for managing multiple objects.

How to Run the Program
To run this program, ensure that the Java Development Kit (JDK) is installed on your computer. Save the code in a file named Main.java. Open a terminal or command prompt and navigate to the directory where the file is saved. Compile the program using the command
javac Main.java

After successful compilation, run the program using
java Main

Follow the on-screen prompts to add employees, enter their details, and view the payroll.

