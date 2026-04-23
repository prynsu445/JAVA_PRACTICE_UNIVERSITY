import java.util.*;

class Process {
    int id;
    int arrivalTime;
    int burstTime;
    int remainingTime;
    int completionTime;
    int turnaroundTime;
    int waitingTime;
    int startTime;
    
    public Process(int id, int arrivalTime, int burstTime) {
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.startTime = -1;
    }
}

public class RoundRobinScheduler {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();
        
        System.out.print("Enter time quantum: ");
        int timeQuantum = sc.nextInt();
        
        List<Process> processes = new ArrayList<>();
        
        // Input process details
        for (int i = 0; i < n; i++) {
            System.out.println("\nProcess " + (i + 1) + ":");
            System.out.print("Arrival Time: ");
            int at = sc.nextInt();
            System.out.print("Burst Time: ");
            int bt = sc.nextInt();
            processes.add(new Process(i + 1, at, bt));
        }
        
        // Run Round Robin scheduling
        roundRobin(processes, timeQuantum);
        
        sc.close();
    }
    
    public static void roundRobin(List<Process> processes, int timeQuantum) {
        int n = processes.size();
        int currentTime = 0;
        int completed = 0;
        int totalWaitingTime = 0;
        int totalTurnaroundTime = 0;
        
        // Sort processes by arrival time initially
        processes.sort(Comparator.comparingInt(p -> p.arrivalTime));
        
        Queue<Process> readyQueue = new LinkedList<>();
        List<String> ganttChart = new ArrayList<>();
        List<Integer> timePoints = new ArrayList<>();
        timePoints.add(currentTime);
        
        int index = 0;
        boolean[] isAdded = new boolean[n];
        
        System.out.println("\n" + "=".repeat(80));
        System.out.println("ROUND ROBIN SCHEDULING (Time Quantum = " + timeQuantum + ")");
        System.out.println("=".repeat(80));
        
        // Add first process if arrives at time 0
        if (processes.get(0).arrivalTime == 0) {
            readyQueue.add(processes.get(0));
            isAdded[0] = true;
            index++;
        }
        
        System.out.println("\n--- Execution Started ---\n");
        
        while (completed < n) {
            if (readyQueue.isEmpty()) {
                // CPU idle, jump to next arrival
                ganttChart.add("Idle");
                timePoints.add(currentTime);
                
                if (index < n) {
                    currentTime = processes.get(index).arrivalTime;
                    timePoints.add(currentTime);
                } else {
                    break;
                }
                
                // Add all processes that have arrived by this time
                while (index < n && processes.get(index).arrivalTime <= currentTime) {
                    if (!isAdded[index]) {
                        readyQueue.add(processes.get(index));
                        isAdded[index] = true;
                    }
                    index++;
                }
                continue;
            }
            
            // Get next process from ready queue
            Process currentProcess = readyQueue.poll();
            
            // Record start time if first time
            if (currentProcess.startTime == -1) {
                currentProcess.startTime = currentTime;
            }
            
            // Execute process
            int executionTime = Math.min(timeQuantum, currentProcess.remainingTime);
            
            // Add to gantt chart
            ganttChart.add("P" + currentProcess.id);
            timePoints.add(currentTime + executionTime);
            
            System.out.println("Time " + currentTime + " - P" + currentProcess.id + 
                             " executes for " + executionTime + " units");
            
            // Update time and remaining time
            currentTime += executionTime;
            currentProcess.remainingTime -= executionTime;
            
            // Add newly arrived processes to ready queue
            while (index < n && processes.get(index).arrivalTime <= currentTime) {
                if (!isAdded[index]) {
                    readyQueue.add(processes.get(index));
                    isAdded[index] = true;
                }
                index++;
            }
            
            // If process not finished, add back to ready queue
            if (currentProcess.remainingTime > 0) {
                readyQueue.add(currentProcess);
                System.out.println("  → P" + currentProcess.id + " added back to ready queue (remaining: " 
                                 + currentProcess.remainingTime + ")");
            } else {
                // Process completed
                completed++;
                currentProcess.completionTime = currentTime;
                currentProcess.turnaroundTime = currentProcess.completionTime - currentProcess.arrivalTime;
                currentProcess.waitingTime = currentProcess.turnaroundTime - currentProcess.burstTime;
                
                totalWaitingTime += currentProcess.waitingTime;
                totalTurnaroundTime += currentProcess.turnaroundTime;
                
                System.out.println("  ✓ P" + currentProcess.id + " completed at time " + currentTime);
            }
            
            // Show ready queue status
            System.out.print("  Ready Queue: [");
            if (readyQueue.isEmpty()) {
                System.out.print("Empty");
            } else {
                for (Process p : readyQueue) {
                    System.out.print("P" + p.id + "(" + p.remainingTime + ") ");
                }
            }
            System.out.println("]\n");
        }
        
        // Display Gantt Chart
        displayGanttChart(ganttChart, timePoints);
        
        // Display process details
        displayProcessTable(processes);
        
        // Calculate and display averages
        System.out.println("\n" + "=".repeat(80));
        System.out.printf("Average Waiting Time: %.2f\n", (float) totalWaitingTime / n);
        System.out.printf("Average Turnaround Time: %.2f\n", (float) totalTurnaroundTime / n);
        System.out.println("=".repeat(80));
    }
    
    public static void displayGanttChart(List<String> processes, List<Integer> timePoints) {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("GANTT CHART");
        System.out.println("=".repeat(80));
        
        // Top border
        System.out.print(" ");
        for (int i = 0; i < processes.size(); i++) {
            System.out.print("+-------");
        }
        System.out.println("+");
        
        // Process names
        System.out.print(" ");
        for (String p : processes) {
            System.out.printf("|  %-4s ", p);
        }
        System.out.println("|");
        
        // Bottom border
        System.out.print(" ");
        for (int i = 0; i < processes.size(); i++) {
            System.out.print("+-------");
        }
        System.out.println("+");
        
        // Time points
        System.out.print(" ");
        for (int i = 0; i < timePoints.size(); i++) {
            System.out.printf("%-7d ", timePoints.get(i));
        }
        System.out.println("\n");
    }
    
    public static void displayProcessTable(List<Process> processes) {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("PROCESS DETAILS");
        System.out.println("=".repeat(80));
        
        System.out.printf("%-10s %-15s %-15s %-15s %-15s %-15s\n", 
                         "Process", "Arrival Time", "Burst Time", 
                         "Completion", "Turnaround", "Waiting");
        System.out.println("-".repeat(80));
        
        for (Process p : processes) {
            System.out.printf("P%-9d %-15d %-15d %-15d %-15d %-15d\n",
                             p.id, p.arrivalTime, p.burstTime,
                             p.completionTime, p.turnaroundTime, p.waitingTime);
        }
    }
}