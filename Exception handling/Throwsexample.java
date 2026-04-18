import java.util.Scanner;

public class Throwsexample {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            System.out.print("Enter size of array: ");
            int n = sc.nextInt();

            int[] numbers = new int[n];

            System.out.println("Enter " + n + " numbers:");

            for(int i = 0; i < n; i++) {
                numbers[i] = sc.nextInt();
            }

            System.out.print("Enter index number to access: ");
            int index = sc.nextInt();

            System.out.println("Value at index " + index + " is: " + numbers[index]);

            System.out.print("Enter a number to divide 100: ");
            int num = sc.nextInt();

            int result = 100 / num;
            System.out.println("Result = " + result);

        }

        // Multiple catch blocks
        catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Array index is out of bounds!");
        }

        catch(ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero!");
        }

        catch(java.util.InputMismatchException e) {
            System.out.println("Error: Invalid input (string instead of number)!");
        }

        catch(Exception e) {
            System.out.println("General Error occurred!");
        }

        finally {
            System.out.println("Program executed successfully (finally block always runs).");
        }

        sc.close();
    }
}