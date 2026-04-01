import java.util.Scanner;

import mathop.MathsOperations;
import statop.StatsOperations;

public class MainPackageDemo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];

        System.out.println("Enter elements:");

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int max = MathsOperations.findMax(arr);
        int min = MathsOperations.findMin(arr);

        StatsOperations obj = new StatsOperations();

        double avg = obj.findAverage(arr);
        double median = obj.findMedian(arr);

        System.out.println("Maximum = " + max);
        System.out.println("Minimum = " + min);
        System.out.println("Average = " + avg);
        System.out.println("Median = " + median);
    }
}