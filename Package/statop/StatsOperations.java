package statop;

import java.util.Arrays;

public class StatsOperations {

    public double findAverage(int arr[]) {
        int sum = 0;

        for(int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }

        return (double)sum / arr.length;
    }

    public double findMedian(int arr[]) {

        Arrays.sort(arr);

        if(arr.length % 2 == 0) {
            return (arr[arr.length/2] + arr[arr.length/2 - 1]) / 2.0;
        }
        else {
            return arr[arr.length/2];
        }
    }
}