import java.util.*;

class FCFS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        int[] bt = new int[n];
        int[] wt = new int[n];
        int[] tat = new int[n];

        // Input burst time
        for (int i = 0; i < n; i++) {
            System.out.print("Enter BT for P" + (i+1) + ": ");
            bt[i] = sc.nextInt();
        }

        // Ready Queue (FCFS = input order)
        System.out.print("\nReady Queue: ");
        for (int i = 0; i < n; i++) {
            System.out.print("P" + (i+1) + " ");
        }

        // Waiting time
        wt[0] = 0;
        for (int i = 1; i < n; i++) {
            wt[i] = wt[i-1] + bt[i-1];
        }

        // Turnaround time
        for (int i = 0; i < n; i++) {
            tat[i] = wt[i] + bt[i];
        }

        // Gantt Chart
        System.out.println("\n\nGantt Chart:");
        System.out.print("0 ");
        int time = 0;
        for (int i = 0; i < n; i++) {
            time += bt[i];
            System.out.print("| P" + (i+1) + " | " + time + " ");
        }

        // Table
        System.out.println("\n\nProcess\tBT\tWT\tTAT");
        for (int i = 0; i < n; i++) {
            System.out.println("P"+(i+1)+"\t"+bt[i]+"\t"+wt[i]+"\t"+tat[i]);
        }

        sc.close();
    }
}