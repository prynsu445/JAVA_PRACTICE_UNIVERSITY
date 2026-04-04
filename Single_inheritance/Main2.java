import java.util.Scanner;

class Person {
    protected String name;
    protected int id;
    protected int year_of_join;

    void inputPerson(Scanner sc) {

        name = sc.nextLine();

        id = sc.nextInt();
        year_of_join = sc.nextInt();

        sc.nextLine();   // fix: clear buffer
    }
}

class Teacher extends Person {

    double basic = 15500;
    double da = 110;
    double hra = 15;
    double epf = 12;

    String sub_taught;

    void inputTeacher(Scanner sc) {

        inputPerson(sc);

        sub_taught = sc.nextLine();
    }

    void annualReport() {

        double da_amt = basic * da / 100;
        double hra_amt = basic * hra / 100;

        double monthly_salary = basic + da_amt + hra_amt;

        double yearly_salary = monthly_salary * 12;

        double yearly_epf = basic * epf / 100 * 12;

        System.out.println("Name: " + name);
        System.out.println("Id: " + id);
        System.out.println("Subject Taught: " + sub_taught);
        System.out.println("Joining Year: " + year_of_join);
        System.out.println("Basic Salary per Month: " + basic);
        System.out.println("Total Net Salary per Year: " + yearly_salary);
        System.out.println("Total EPF per Year: " + yearly_epf);
    }
}

class Student extends Person {

    double fees_per_sem = 18000;

    String course;

    int duration = 4;

    void inputStudent(Scanner sc) {

        inputPerson(sc);

        course = sc.nextLine();
    }

    void showStudentDetails() {

        int total_sem = duration * 2;

        double total_fees = total_sem * fees_per_sem;

        System.out.println("Name: " + name);
        System.out.println("Id: " + id);
        System.out.println("Course Offered: " + course);
        System.out.println("Joining Year: " + year_of_join);
        System.out.println("Total Fees: " + total_fees);
    }
}

public class Main2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Teacher t = new Teacher();

        t.inputTeacher(sc);

        t.annualReport();

        Student s = new Student();

        s.inputStudent(sc);

        s.showStudentDetails();

        sc.close();
    }
}