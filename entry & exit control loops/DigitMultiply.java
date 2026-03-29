import java.util.Scanner;

public class DigitMultiply {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        while (n >= 10) {
            int product = 1;

            while (n > 0) {
                int d = n % 10;

                if (d != 0)
                    product *= d;

                n /= 10;
            }

            n = product;
        }

        System.out.println(n);
    }
}
//406--24--8