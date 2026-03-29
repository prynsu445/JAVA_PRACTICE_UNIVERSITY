import java.util.Scanner;

public class Armstrong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        
        System.out.println("Enter the number: ");
        n = sc.nextInt();
        
        int temp = n, sum = 0;  // Moved this AFTER getting input
        
        while (temp > 0) {
            int d = temp % 10;
            sum += d * d * d;
            temp /= 10;
        }
        
        if (sum == n)
            System.out.println(n + " is an Armstrong number");
        else
            System.out.println(n + " is not an Armstrong number");
        
        sc.close(); // Good practice to close the scanner
    }
}