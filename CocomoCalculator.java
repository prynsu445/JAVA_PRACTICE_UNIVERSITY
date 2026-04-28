import java.util.Scanner;

public class CocomoCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter KLOC (thousands of lines of code): ");
        double kloc = sc.nextDouble();

        System.out.println("Select Mode: ");
        System.out.println("1. Organic");
        System.out.println("2. Semi-Detached");
        System.out.println("3. Embedded");
        int mode = sc.nextInt();

        double a = 0, b = 0, c = 2.5, d = 0;

        switch (mode) {
            case 1:
                a = 2.4; b = 1.05; d = 0.38;
                break;
            case 2:
                a = 3.0; b = 1.12; d = 0.35;
                break;
            case 3:
                a = 3.6; b = 1.20; d = 0.32;
                break;
            default:
                System.out.println("Invalid mode!");
                return;
        }

        // Effort
        double effort = a * Math.pow(kloc, b);

        // Development Time
        double time = c * Math.pow(effort, d);

        // People Required
        double people = effort / time;

        System.out.println("\n--- COCOMO Results ---");
        System.out.println("Effort (Person-Months): " + effort);
        System.out.println("Development Time (Months): " + time);
        System.out.println("People Required: " + people);

        sc.close();
    }
}