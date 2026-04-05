class Fraction {
    int num;
    int denum;

    // Default constructor
    Fraction() {
        num = 0;
        denum = 1;
    }

    // One argument constructor
    Fraction(int n) {
        num = n;
        denum = 1;
    }

    // Two argument constructor
    Fraction(int n, int d) {
        num = n;
        denum = d;
    }

    // Copy constructor
    Fraction(Fraction f) {
        num = f.num;
        denum = f.denum;
    }

    void show() {
        System.out.println(num + "/" + denum);
    }

    Fraction add(Fraction f) {
        int n = num * f.denum + denum * f.num;
        int d = denum * f.denum;
        return new Fraction(n, d).reduce();
    }

    Fraction subtract(Fraction f) {
        int n = num * f.denum - denum * f.num;
        int d = denum * f.denum;
        return new Fraction(n, d).reduce();
    }

    Fraction multiply(Fraction f) {
        int n = num * f.num;
        int d = denum * f.denum;
        return new Fraction(n, d).reduce();
    }

    Fraction div(Fraction f) {
        int n = num * f.denum;
        int d = denum * f.num;
        return new Fraction(n, d).reduce();
    }

    int compare(Fraction f) {
        int a = num * f.denum;
        int b = denum * f.num;

        if (a == b) return 0;
        else if (a > b) return 1;
        else return -1;
    }

    void mixed() {
        int whole = num / denum;
        int remainder = num % denum;

        if (remainder == 0)
            System.out.println("Mixed: " + whole);
        else
            System.out.println("Mixed: " + whole + " " + remainder + "/" + denum);
    }

    Fraction reduce() {
        int gcd = 1;

        for (int i = 1; i <= num && i <= denum; i++) {
            if (num % i == 0 && denum % i == 0)
                gcd = i;
        }

        return new Fraction(num / gcd, denum / gcd);
    }
}

public class FractionDemo {
    public static void main(String[] args) {

        Fraction f1 = new Fraction();
        Fraction f2 = new Fraction(3);
        Fraction f3 = new Fraction(4, 6);
        Fraction f4 = new Fraction(f3);

        System.out.print("Fraction 1: ");
        f1.show();

        System.out.print("Fraction 2: ");
        f2.show();

        System.out.print("Fraction 3: ");
        f3.show();

        System.out.print("Fraction 4 (Copy): ");
        f4.show();

        System.out.print("Addition: ");
        f2.add(f3).show();

        System.out.print("Subtraction: ");
        f2.subtract(f3).show();

        System.out.print("Multiplication: ");
        f2.multiply(f3).show();

        System.out.print("Division: ");
        f2.div(f3).show();

        System.out.println("Compare result: " + f2.compare(f3));

        f3.mixed();
    }
}