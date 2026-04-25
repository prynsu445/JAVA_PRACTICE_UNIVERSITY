import java.util.*;

class Process {
    int pid, at, bt, wt, tat, ct;
    boolean completed = false;

    Process(int pid, int at, int bt) {
        this.pid = pid;
        this.at = at;
        this.bt = bt;
    }
}

public class SJF_ReadyQueue {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        Process[] p = new Process[n];

        // Input arrival time & burst time
        for (int i = 0; i < n; i++) {
            System.out.print("Enter AT and BT for P" + (i + 1) + ": ");
            int at = sc.nextInt();
            int bt = sc.nextInt();
            p[i] = new Process(i + 1, at, bt);
        }

        int time = 0, completed = 0;

        List<Integer> gantt = new ArrayList<>();
        List<Integer> timeLine = new ArrayList<>();
        timeLine.add(0);

        while (completed < n) {

            // Build Ready Queue
            List<Process> readyQueue = new ArrayList<>();
            for (Process proc : p) {
                if (!proc.completed && proc.at <= time) {
                    readyQueue.add(proc);
                }
            }

            // If no process is ready → CPU idle
            if (readyQueue.isEmpty()) {
                time++;
                continue;
            }

            // Select process with minimum burst time
            Process current = Collections.min(readyQueue, Comparator.comparingInt(proc -> proc.bt));

            // Execute process
            gantt.add(current.pid);
            time += current.bt;

            current.ct = time;
            current.tat = current.ct - current.at;
            current.wt = current.tat - current.bt;
            current.completed = true;

            timeLine.add(time);
            completed++;
        }

        // Display Table
        System.out.println("\nPID\tAT\tBT\tWT\tTAT\tCT");

        double totalWT = 0, totalTAT = 0;

        for (Process proc : p) {
            System.out.println("P" + proc.pid + "\t" + proc.at + "\t" + proc.bt + "\t" +
                    proc.wt + "\t" + proc.tat + "\t" + proc.ct);

            totalWT += proc.wt;
            totalTAT += proc.tat;
        }

        System.out.println("\nAverage WT = " + (totalWT / n));
        System.out.println("Average TAT = " + (totalTAT / n));

        // ---------------- GANTT CHART ----------------
        System.out.println("\nGantt Chart:");

        // Top bar
        for (int i = 0; i < gantt.size(); i++) {
            System.out.print("----");
        }
        System.out.println();

        // Process sequence
        for (int pid : gantt) {
            System.out.print("| P" + pid + " ");
        }
        System.out.println("|");

        // Bottom bar
        for (int i = 0; i < gantt.size(); i++) {
            System.out.print("----");
        }
        System.out.println();

        // Timeline
        for (int t : timeLine) {
            System.out.print(t + "   ");
        }
        System.out.println();

        sc.close();
    }
}