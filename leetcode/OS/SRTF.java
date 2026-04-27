import java.util.*;

class SRTF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        int[] at = new int[n]; // Arrival Time
        int[] bt = new int[n]; // Burst Time
        int[] rt = new int[n]; // Remaining Time
        int[] wt = new int[n];
        int[] tat = new int[n];
        int[] ct = new int[n];

        // Input
        for (int i = 0; i < n; i++) {
            System.out.print("Enter AT and BT for P" + (i+1) + ": ");
            at[i] = sc.nextInt();
            bt[i] = sc.nextInt();
            rt[i] = bt[i];
        }

        int complete = 0, time = 0, min = Integer.MAX_VALUE;
        int shortest = -1;
        boolean found;

        System.out.println("\nGantt Chart:");

        while (complete != n) {
            found = false;
            min = Integer.MAX_VALUE;

            // Find shortest remaining time at current time
            for (int i = 0; i < n; i++) {
                if (at[i] <= time && rt[i] > 0 && rt[i] < min) {
                    min = rt[i];
                    shortest = i;
                    found = true;
                }
            }

            if (!found) {
                System.out.print("| idle ");
                time++;
                continue;
            }

            // Execute 1 unit
            System.out.print("| P" + (shortest+1) + " ");
            rt[shortest]--;
            time++;

            // If completed
            if (rt[shortest] == 0) {
                complete++;
                ct[shortest] = time;

                tat[shortest] = ct[shortest] - at[shortest];
                wt[shortest] = tat[shortest] - bt[shortest];
            }
        }

        System.out.println("| " + time);

        // Output Table
        System.out.println("\nProcess\tAT\tBT\tCT\tWT\tTAT");
        for (int i = 0; i < n; i++) {
            System.out.println("P"+(i+1)+"\t"+at[i]+"\t"+bt[i]+"\t"+ct[i]+"\t"+wt[i]+"\t"+tat[i]);
        }

        sc.close();
    }
}