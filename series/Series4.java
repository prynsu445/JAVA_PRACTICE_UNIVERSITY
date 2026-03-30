import java.util.Scanner;
public class Series4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double sum = 0;
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                sum += 1;
            } else if (i % 2 == 0) {
                sum += Math.pow(i, 3);
            } else {
                sum += Math.pow(i, 2);
            }
        }
        System.out.println(sum);
    }
}