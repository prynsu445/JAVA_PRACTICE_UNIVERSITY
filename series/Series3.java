import java.util.Scanner;
public class Series3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double sum = 0.0;
        for (int i = 1; i <= n; i++) {
            long fact = 1;
            for (int j = 1; j <= i; j++) {
                fact *= j;
            }
            sum += 1.0 / fact;
        }
        System.out.println(sum);
    }
}