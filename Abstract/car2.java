class Vehicle {
    public void startEngine() {
        System.out.println("Vehicle engine starting...");
    }
}

// Subclass Car inheriting from Vehicle
class Car extends Vehicle {

    @Override
    public void startEngine() {
        System.out.println("Car engine starting with key...");
    }
}

// Subclass Motorcycle inheriting from Vehicle
class Motorcycle extends Vehicle {

    @Override
    public void startEngine() {
        System.out.println("Motorcycle engine starting with self-start...");
    }
}

class Codechef {
    public static void main(String[] args) {

        Vehicle myVehicle = new Vehicle();
        // Call Vehicle method
        myVehicle.startEngine();

        Car myCar = new Car();
        // Call Car method
        myCar.startEngine();

        Motorcycle myMotorcycle = new Motorcycle();
        // Call Motorcycle method
        myMotorcycle.startEngine();
    }
}