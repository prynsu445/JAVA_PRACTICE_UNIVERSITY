class Complex {

    int real;
    int imag;

    // default constructor
    Complex() {
        real = 0;
        imag = 0;
    }

    // parameter constructor
    Complex(int r, int i) {
        real = r;
        imag = i;
    }

    // copy constructor
    Complex(Complex c) {
        real = c.real;
        imag = c.imag;
    }

    // show complex number
    void showComplex() {
        System.out.println(real + " + " + imag + "i");
    }

    // addition
    Complex addComplex(Complex c) {
        return new Complex(real + c.real, imag + c.imag);
    }

    // subtraction
    Complex substractComplex(Complex c) {
        return new Complex(real - c.real, imag - c.imag);
    }

    // multiplication
    Complex multiplyComplex(Complex c) {

        int r = real * c.real - imag * c.imag;
        int i = real * c.imag + imag * c.real;

        return new Complex(r, i);
    }
}

// main class
public class ComplexTest {

    public static void main(String[] args) {

        Complex c1 = new Complex(2, 3);
        Complex c2 = new Complex(4, 5);
        Complex c3 = new Complex(c1);

        System.out.print("c1 = ");
        c1.showComplex();

        System.out.print("c2 = ");
        c2.showComplex();

        System.out.print("Copy c3 = ");
        c3.showComplex();

        System.out.print("Addition = ");
        c1.addComplex(c2).showComplex();

        System.out.print("Subtraction = ");
        c1.substractComplex(c2).showComplex();

        System.out.print("Multiplication = ");
        c1.multiplyComplex(c2).showComplex();
    }
}