import java.util.Scanner;
public class Series2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int n = sc.nextInt();
        double sum = 0.0;
        for (int i = 0; i <= n; i++) {
            sum += 1.0 / Math.pow(x, i);
        }
        System.out.println(sum);
    }
}
