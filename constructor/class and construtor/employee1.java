import java.util.Scanner;

class Employee {
    String name;
    int empNo, days, hours;
    double salaryPerHour, totalSalary;

    // Default constructor
    Employee() {
        name = "Unknown";
        empNo = 0;
        days = 0;
        hours = 0;
    }

    // Parameterized constructor
    Employee(String name, int empNo, int days, int hours) {
        this.name = name;
        this.empNo = empNo;
        this.days = days;
        this.hours = hours;
    }

    void inputInfo() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Name: ");
        name = sc.next();

        System.out.print("Enter EmpNo: ");
        empNo = sc.nextInt();

        System.out.print("Enter Working Days (<=31): ");
        days = sc.nextInt();

        System.out.print("Enter Working Hours per day (<=8): ");
        hours = sc.nextInt();
    }

    void inputSalary() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Salary per hour (<=500): ");
        salaryPerHour = sc.nextDouble();

        totalSalary = days * hours * salaryPerHour;
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("EmpNo: " + empNo);
        System.out.println("Working Days: " + days);
        System.out.println("Hours per day: " + hours);
        System.out.println("Salary/hour: " + salaryPerHour);
        System.out.println("Total Salary: " + totalSalary);
    }
}

public class employee1 {
    public static void main(String[] args) {

        Employee e1 = new Employee("Amit", 201, 25, 8);
        e1.inputSalary();

        Employee e2 = new Employee();
        e2.inputInfo();
        e2.inputSalary();

        e1.display();
        e2.display();
    }
}