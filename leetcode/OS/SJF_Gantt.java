import java.util.*;

class Process {
    int pid;
    int burstTime;
    int waitingTime;
    int turnaroundTime;

    Process(int pid, int bt) {
        this.pid = pid;
        this.burstTime = bt;
    }
}

public class SJF_Gantt {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        Process[] p = new Process[n];

        // Input
        for (int i = 0; i < n; i++) {
            System.out.print("Enter burst time for P" + (i + 1) + ": ");
            int bt = sc.nextInt();
            p[i] = new Process(i + 1, bt);
        }

        // Sort by burst time (SJF)
        Arrays.sort(p, Comparator.comparingInt(proc -> proc.burstTime));

        // Calculate Waiting Time
        p[0].waitingTime = 0;
        for (int i = 1; i < n; i++) {
            p[i].waitingTime = p[i - 1].waitingTime + p[i - 1].burstTime;
        }

        // Calculate Turnaround Time
        for (int i = 0; i < n; i++) {
            p[i].turnaroundTime = p[i].waitingTime + p[i].burstTime;
        }

        // Display Table
        System.out.println("\nPID\tBT\tWT\tTAT");

        double totalWT = 0, totalTAT = 0;

        for (Process proc : p) {
            System.out.println("P" + proc.pid + "\t" + proc.burstTime + "\t" +
                    proc.waitingTime + "\t" + proc.turnaroundTime);

            totalWT += proc.waitingTime;
            totalTAT += proc.turnaroundTime;
        }

        System.out.println("\nAverage Waiting Time = " + (totalWT / n));
        System.out.println("Average Turnaround Time = " + (totalTAT / n));

        // ---------------- GANTT CHART ----------------
        System.out.println("\nGantt Chart:");

        // Top bar
        System.out.print(" ");
        for (int i = 0; i < n; i++) {
            System.out.print("----");
        }
        System.out.println();

        // Process IDs
        System.out.print("|");
        for (int i = 0; i < n; i++) {
            System.out.print(" P" + p[i].pid + " |");
        }
        System.out.println();

        // Bottom bar
        System.out.print(" ");
        for (int i = 0; i < n; i++) {
            System.out.print("----");
        }
        System.out.println();

        // Time line
        int time = 0;
        System.out.print("0");
        for (int i = 0; i < n; i++) {
            time += p[i].burstTime;
            System.out.print("    " + time);
        }
        System.out.println();

        sc.close();
    }
}