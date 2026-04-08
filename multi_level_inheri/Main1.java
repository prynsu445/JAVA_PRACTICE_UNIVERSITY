import java.util.Scanner;

// Base Class
class Number {
    protected int arr[];
    protected int n;

    Number(int n) {
        this.n = n;
        arr = new int[n];
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter " + n + " numbers:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
    }

    void displayNumbers() {
        System.out.println("All Numbers:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

// Derived Class 1
class OddNum extends Number {
    protected int oddArr[];
    protected int oddCount = 0;

    OddNum(int n) {
        super(n);

        // count odd numbers
        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 != 0)
                oddCount++;
        }

        oddArr = new int[oddCount];
    }

    void copyOddNumbers() {
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 != 0) {
                oddArr[j++] = arr[i];
            }
        }
    }

    void displayOddNumbers() {
        System.out.println("Odd Numbers:");
        for (int i = 0; i < oddCount; i++) {
            System.out.print(oddArr[i] + " ");
        }
        System.out.println();
    }
}

// Derived Class 2
class PrimeNum extends OddNum {
    private int primeArr[];
    private int primeCount = 0;

    PrimeNum(int n) {
        super(n);

        // count prime numbers
        for (int i = 0; i < oddCount; i++) {
            if (isPrime(oddArr[i]))
                primeCount++;
        }

        primeArr = new int[primeCount];
    }

    boolean isPrime(int num) {
        if (num < 2) return false;

        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    void copyPrimeNumbers() {
        int j = 0;
        for (int i = 0; i < oddCount; i++) {
            if (isPrime(oddArr[i])) {
                primeArr[j++] = oddArr[i];
            }
        }
    }

    void displayPrimeNumbers() {
        System.out.println("Prime Numbers:");
        for (int i = 0; i < primeCount; i++) {
            System.out.print(primeArr[i] + " ");
        }
        System.out.println();
    }
}

// Main Class
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        PrimeNum obj = new PrimeNum(n);

        obj.displayNumbers();
        obj.copyOddNumbers();
        obj.displayOddNumbers();
        obj.copyPrimeNumbers();
        obj.displayPrimeNumbers();
    }
}