import java.util.Scanner;

public class BobDistance {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();   // number of test cases

        while (t-- > 0) {

            int n = scanner.nextInt(); // number of days

            int[] a = new int[n]; // Alice distances
            int[] b = new int[n]; // Bob distances

            // input Alice distances
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }

            // input Bob distances
            for (int i = 0; i < n; i++) {
                b[i] = scanner.nextInt();
            }

            int count = 0;

            // check happiness condition
            for (int i = 0; i < n; i++) {

                if (a[i] <= 2 * b[i] && b[i] <= 2 * a[i]) {
                    count++;
                }
            }

            System.out.println(count);
        }

        scanner.close();
    }
}