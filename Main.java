import java.util.Scanner;

// ---------------- ABSTRACT CLASS ----------------
abstract class Employee {
    private String name;
    private double bonus;

    public Employee(String name, double bonus) {
        this.name = name;
        this.bonus = bonus;
    }

    public String getName() {
        return name;
    }

    public double getBonus() {
        return bonus;
    }

    public abstract double calculatePay();
    public abstract String getType();
}

// ---------------- SUBCLASSES ----------------
class SalariedEmployee extends Employee {
    private double monthlySalary;

    public SalariedEmployee(String name, double monthlySalary, double bonus) {
        super(name, bonus);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculatePay() {
        return monthlySalary + getBonus();
    }

    @Override
    public String getType() {
        return "Salaried Employee";
    }
}

class HourlyEmployee extends Employee {
    private double hoursWorked;
    private double hourlyRate;

    public HourlyEmployee(String name, double hoursWorked, double hourlyRate, double bonus) {
        super(name, bonus);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculatePay() {
        double basePay;
        if (hoursWorked > 40) {
            double overtime = hoursWorked - 40;
            basePay = (40 * hourlyRate) + (overtime * hourlyRate * 1.5);
        } else {
            basePay = hoursWorked * hourlyRate;
        }
        return basePay + getBonus();
    }

    @Override
    public String getType() {
        return "Hourly Employee";
    }
}

class Manager extends Employee {
    private double monthlySalary;

    public Manager(String name, double monthlySalary, double bonus) {
        super(name, bonus);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculatePay() {
        return monthlySalary + getBonus();
    }

    @Override
    public String getType() {
        return "Manager";
    }
}

// ---------------- MAIN CLASS ----------------
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Employee[] employees = new Employee[100]; // fixed array for demonstration
        int count = 0;
        boolean running = true;

        while (running) {
            System.out.println("\n=== SIMPLE PAYROLL SYSTEM ===");
            System.out.println("1. Add Salaried Employee");
            System.out.println("2. Add Hourly Employee");
            System.out.println("3. Add Manager");
            System.out.println("4. Show Payroll");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice;
            try {
                choice = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a number.");
                sc.nextLine(); // clear invalid input
                continue;
            }
            sc.nextLine(); // consume newline

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter name: ");
                        String sName = sc.nextLine();
                        System.out.print("Enter monthly salary: ");
                        double sSalary = sc.nextDouble();
                        System.out.print("Enter bonus: ");
                        double sBonus = sc.nextDouble();
                        employees[count++] = new SalariedEmployee(sName, sSalary, sBonus);
                        System.out.println("Salaried employee added!");
                        break;

                    case 2:
                        System.out.print("Enter name: ");
                        String hName = sc.nextLine();
                        System.out.print("Enter hours worked: ");
                        double hours = sc.nextDouble();
                        System.out.print("Enter hourly rate: ");
                        double rate = sc.nextDouble();
                        System.out.print("Enter bonus: ");
                        double hBonus = sc.nextDouble();
                        employees[count++] = new HourlyEmployee(hName, hours, rate, hBonus);
                        System.out.println("Hourly employee added!");
                        break;

                    case 3:
                        System.out.print("Enter name: ");
                        String mName = sc.nextLine();
                        System.out.print("Enter monthly salary: ");
                        double mSalary = sc.nextDouble();
                        System.out.print("Enter bonus: ");
                        double mBonus = sc.nextDouble();
                        employees[count++] = new Manager(mName, mSalary, mBonus);
                        System.out.println("Manager added!");
                        break;

                    case 4:
                        System.out.println("\n---- PAYROLL ----");
                        if (count == 0) {
                            System.out.println("No employees added yet.");
                        } else {
                            double total = 0;
                            for (int i = 0; i < count; i++) {
                                Employee emp = employees[i];
                                double pay = emp.calculatePay();
                                total += pay;
                                System.out.printf("%s (%s) - ₱%.2f%n",
                                        emp.getName(), emp.getType(), pay);
                            }
                            System.out.printf("-------------------------\nTotal Payroll: ₱%.2f%n", total);
                        }
                        break;

                    case 5:
                        running = false;
                        System.out.println("Exiting Payroll System... Goodbye!");
                        break;

                    default:
                        System.out.println("Invalid choice! Try again.");
                }
            } catch (Exception e) {
                System.out.println("Error: Invalid input. Please try again.");
                sc.nextLine(); // clear scanner buffer
            }
        }
        sc.close();
    }
}
