// Abstract class
abstract class Fruit {

    String colour;
    String taste;

    Fruit(String c, String t) {
        colour = c;
        taste = t;
    }

    abstract void display();
}

// Apple class
class Apple extends Fruit {

    Apple() {
        super("Red", "Sweet");
    }

    void display() {
        System.out.println("Apple -> Colour: " + colour + ", Taste: " + taste);
    }
}

// Banana class
class Banana extends Fruit {

    Banana() {
        super("Yellow", "Sweet");
    }

    void display() {
        System.out.println("Banana -> Colour: " + colour + ", Taste: " + taste);
    }
}

// Orange class
class Orange extends Fruit {

    Orange() {
        super("Orange", "Citrus");
    }

    void display() {
        System.out.println("Orange -> Colour: " + colour + ", Taste: " + taste);
    }
}

// Strawberry class
class Strawberry extends Fruit {

    Strawberry() {
        super("Red", "Sweet");
    }

    void display() {
        System.out.println("Strawberry -> Colour: " + colour + ", Taste: " + taste);
    }
}

// Main class
public class FruitTest {
    public static void main(String[] args) {

        Apple a = new Apple();
        Banana b = new Banana();
        Orange o = new Orange();
        Strawberry s = new Strawberry();

        a.display();
        b.display();
        o.display();
        s.display();
    }
}