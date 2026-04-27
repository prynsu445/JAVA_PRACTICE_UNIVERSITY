import java.util.*;

class SJF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        int[] bt = new int[n];
        int[] wt = new int[n];
        int[] tat = new int[n];
        int[] pid = new int[n];

        // Input
        for (int i = 0; i < n; i++) {
            pid[i] = i + 1;
            System.out.print("Enter burst time for P" + pid[i] + ": ");
            bt[i] = sc.nextInt();
        }

        // Sort by burst time
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (bt[i] > bt[j]) {
                    // swap burst time
                    int temp = bt[i];
                    bt[i] = bt[j];
                    bt[j] = temp;

                    // swap process id
                    int temp2 = pid[i];
                    pid[i] = pid[j];
                    pid[j] = temp2;
                }
            }
        }

        // Calculate waiting time
        wt[0] = 0;
        for (int i = 1; i < n; i++) {
            wt[i] = wt[i - 1] + bt[i - 1];
        }

        // Calculate turnaround time
        for (int i = 0; i < n; i++) {
            tat[i] = wt[i] + bt[i];
        }

        // Display
        System.out.println("\nProcess\tBT\tWT\tTAT");
        for (int i = 0; i < n; i++) {
            System.out.println("P" + pid[i] + "\t" + bt[i] + "\t" + wt[i] + "\t" + tat[i]);
        }

        sc.close();
    }
}