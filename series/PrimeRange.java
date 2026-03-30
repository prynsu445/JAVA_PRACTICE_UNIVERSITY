import java.util.Scanner;
public class PrimeRange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        for (int i = m; i <= n; i++) {
            if (isPrime(i)) {
                int temp = i, sum = 0;
                while (temp > 0) {
                    sum += temp % 10;
                    temp /= 10;
                }
                if (isPrime(sum)) {
                    System.out.println(i);
                }
            }
        }
    }
    static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}