
import java.util.Scanner;

class JaggedArray {
    int[][] marks; // Array to hold marks of five children [cite: 8]
    String[] names = {"Child1", "Child2", "Child3", "Child4", "Child5"};

    // Constructor to allocate memory exactly as specified [cite: 10]
    JaggedArray() {
        marks = new int[5][];
        marks[0] = new int[3]; // Child1: 3 subjects [cite: 4]
        marks[1] = new int[5]; // Child2: 5 subjects [cite: 4]
        marks[2] = new int[2]; // Child3: 2 subjects [cite: 4]
        marks[3] = new int[6]; // Child4: 6 subjects [cite: 4]
        marks[4] = new int[4]; // Child5: 4 subjects [cite: 4]
    }

    // Input marks for each child [cite: 12]
    void inputMarks() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < marks.length; i++) {
            System.out.println("Enter " + marks[i].length + " marks for " + names[i] + ":");
            for (int j = 0; j < marks[i].length; j++) {
                marks[i][j] = sc.nextInt();
            }
        }
    }

    // Display marks and total [cite: 14, 16]
    void displayAnalysis() {
        System.out.println("\n--- Analysis Report ---");
        for (int i = 0; i < marks.length; i++) {
            int total = 0;
            int countOver80 = 0;
            
            System.out.print(names[i] + " marks: "); // Show name at beginning [cite: 14]
            
            for (int j = 0; j < marks[i].length; j++) {
                System.out.print(marks[i][j] + " ");
                total += marks[i][j]; // Calculate total [cite: 16]
                
                if (marks[i][j] > 80) countOver80++; // Count marks > 80 [cite: 18]
                
                // Alert for marks < 30 [cite: 19]
                if (marks[i][j] < 30) {
                    System.out.print("(ALERT: " + marks[i][j] + " is < 30!) ");
                }
            }
            System.out.println("\n Total: " + total);
            System.out.println(" Marks > 80: " + countOver80);
            System.out.println("-----------------------");
        }
    }

    public static void main(String[] args) {
        JaggedArray obj = new JaggedArray();
        obj.inputMarks();
        obj.displayAnalysis();
    }
}