import java.util.Scanner;

public class BobDistance {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        while (t-- > 0) {

            int n = scanner.nextInt();

            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }

            int count = 0;

            for (int i = 0; i < n; i++) {
                int b = scanner.nextInt();

                if (a[i] <= 2 * b && b <= 2 * a[i]) {
                    count++;
                }
            }

            System.out.println(count);
        }

        scanner.close();
    }
}