import java.util.*;

class Vehicle {
    private String brand;
    private String country_of_origin;
    private double base_price;

    public void input() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Brand: ");
        brand = sc.nextLine();

        System.out.print("Enter Country of Origin: ");
        country_of_origin = sc.nextLine();

        System.out.print("Enter Base Price: ");
        base_price = sc.nextDouble();
    }

    public String getBrand() {
        return brand;
    }

    public String getCountry() {
        return country_of_origin;
    }

    public double getBasePrice() {
        return base_price;
    }

    public void display() {
        System.out.println("Brand: " + brand);
        System.out.println("Country: " + country_of_origin);
        System.out.println("Base Price: " + base_price);
    }
}

class Car extends Vehicle {
    private String model;
    private int speed;
    private double market_price;

    public void read() {
        Scanner sc = new Scanner(System.in);

        input();

        System.out.print("Enter Model: ");
        model = sc.nextLine();

        System.out.print("Enter Speed (km/hr): ");
        speed = sc.nextInt();

        calculatePrice();
    }

    private void calculatePrice() {
        if (speed > 80) {
            market_price = getBasePrice() + (0.15 * getBasePrice());
        } else {
            market_price = getBasePrice() - (0.05 * getBasePrice());
        }
    }

    public void show() {
        display();
        System.out.println("Model: " + model);
        System.out.println("Speed: " + speed);
        System.out.println("Market Price: " + market_price);
    }
}

public class TestCar {
    public static void main(String[] args) {
        Car c = new Car();

        c.read();

        System.out.println("\nCar Details:");
        c.show();
    }
}