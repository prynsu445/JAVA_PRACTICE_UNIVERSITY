import java.util.Scanner;

class Student {
    String name;
    int roll;
    int m1, m2, m3;
    double percentage;

    // Constructor
    Student(String name, int roll) {
        this.name = name;
        this.roll = roll;
    }

    void inputMarks() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter marks of 3 subjects:");
        m1 = sc.nextInt();
        m2 = sc.nextInt();
        m3 = sc.nextInt();
    }

    void calculatePercentage() {
        percentage = (m1 + m2 + m3) / 3.0;
    }

    double getPercentage() {
        return percentage;
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Roll: " + roll);
        System.out.println("Marks: " + m1 + ", " + m2 + ", " + m3);
        System.out.println("Percentage: " + percentage);
    }
}

public class Student1 {
    public static void main(String[] args) {

        Student s1 = new Student("Rahul", 101);
        Student s2 = new Student("Priya", 102);

        s1.inputMarks();
        s2.inputMarks();

        s1.calculatePercentage();
        s2.calculatePercentage();

        s1.display();
        s2.display();

        if(s1.getPercentage() > s2.getPercentage())
            System.out.println(s1.name + " has higher percentage");
        else
            System.out.println(s2.name + " has higher percentage");
    }
}