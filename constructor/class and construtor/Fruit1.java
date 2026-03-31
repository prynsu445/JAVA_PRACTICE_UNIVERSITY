
import java.util.Scanner;

class Fruit {
    double pricePerKg;
    double quantity;
    int grade;
    double totalPrice;

    // Default constructor
    Fruit() {
        pricePerKg = 100;
        quantity = 1;
        grade = 1;
        totalPrice = pricePerKg * quantity;
    }

    // Parameterized constructor
    Fruit(double p, double q, int g) {
        pricePerKg = p;
        quantity = q;
        grade = g;
        totalPrice = pricePerKg * quantity;
    }

    // Copy constructor
    Fruit(Fruit f) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter new fruit grade: ");
        int newGrade = sc.nextInt();

        quantity = f.quantity;
        grade = newGrade;

        pricePerKg = (f.pricePerKg / f.grade) * newGrade;

        totalPrice = pricePerKg * quantity;
    }

    void displayDetail() {
        System.out.println("Price/kg: " + pricePerKg);
        System.out.println("Quantity: " + quantity);
        System.out.println("Grade: " + grade);
        System.out.println("Total Price: " + totalPrice);
    }
}

public class Fruit1 {
    public static void main(String[] args) {

        Fruit f1 = new Fruit(); // default

        Fruit f2 = new Fruit(120, 2, 2); // parameterized

        Fruit f3 = new Fruit(f2); // copy constructor

        f1.displayDetail();
        f2.displayDetail();
        f3.displayDetail();
    }
}