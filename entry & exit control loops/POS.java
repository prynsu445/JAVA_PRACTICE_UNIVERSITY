import java.util.Scanner;

public class POS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int temp = n, sum = 0;

        while (temp > 0) {
            sum += temp % 10;
            temp /= 10;
        }

        System.out.println("Sum = " + sum);

        int s = sum;
        while (s > 0) {
            int d = s % 10;

            int check = n;
            while (check > 0) {
                if (check % 10 == d)
                    System.out.print(d + " ");
                check /= 10;
            }
            s /= 10;
        }
    }
}
//1234 =10