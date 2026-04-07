import java.util.Scanner;

class Number {
    int arr[];
    int n;

    Number(int n) {
        this.n = n;
        arr = new int[n];

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter " + n + " numbers:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
    }

    void display() {
        System.out.println("All numbers:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

class OddNum extends Number {
    int oddArr[];
    int countOdd = 0;

    OddNum(int n) {
        super(n);

        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 != 0)
                countOdd++;
        }

        oddArr = new int[countOdd];
    }

    void copyOdd() {
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 != 0) {
                oddArr[j++] = arr[i];
            }
        }
    }

    void displayOdd() {
        System.out.println("Odd numbers:");
        for (int i = 0; i < countOdd; i++) {
            System.out.print(oddArr[i] + " ");
        }
        System.out.println();
    }
}

class PrimeNum extends OddNum {
    int primeArr[];
    int countPrime = 0;

    PrimeNum(int n) {
        super(n);
        copyOdd();

        for (int i = 0; i < countOdd; i++) {
            if (isPrime(oddArr[i]))
                countPrime++;
        }

        primeArr = new int[countPrime];
    }

    boolean isPrime(int num) {
        if (num < 2)
            return false;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    void copyPrime() {
        int j = 0;
        for (int i = 0; i < countOdd; i++) {
            if (isPrime(oddArr[i])) {
                primeArr[j++] = oddArr[i];
            }
        }
    }

    void displayPrime() {
        System.out.println("Prime numbers:");
        for (int i = 0; i < countPrime; i++) {
            System.out.print(primeArr[i] + " ");
        }
        System.out.println();
    }
}

public class Multilevel1 {
    public static void main(String args[]) {
        PrimeNum obj = new PrimeNum(6);

        obj.display();
        obj.displayOdd();

        obj.copyPrime();
        obj.displayPrime();
    }
}