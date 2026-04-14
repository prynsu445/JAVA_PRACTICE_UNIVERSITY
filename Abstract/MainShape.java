abstract class Shape {
    double length, breadth, height;

    Shape(double l, double b, double h){
        length = l;
        breadth = b;
        height = h;
    }

    abstract double volume();
    abstract double surfaceArea();
}

// Cube
class Cube extends Shape {

    Cube(double side){
        super(side, side, side);
    }

    double volume(){
        return length * length * length;
    }

    double surfaceArea(){
        return 6 * length * length;
    }
}

// Cuboid
class Cuboid extends Shape {

    Cuboid(double l, double b, double h){
        super(l, b, h);
    }

    double volume(){
        return length * breadth * height;
    }

    double surfaceArea(){
        return 2 * (length*breadth + breadth*height + height*length);
    }
}

// Cylinder
class Cylinder extends Shape {

    Cylinder(double r, double h){
        super(r, r, h);
    }

    double volume(){
        return 3.14 * length * length * height;
    }

    double surfaceArea(){
        return 2 * 3.14 * length * (length + height);
    }
}

// Main class
public class MainShape {
    public static void main(String[] args){

        Cube c1 = new Cube(3);
        Cuboid c2 = new Cuboid(2,3,4);
        Cylinder c3 = new Cylinder(2,5);

        System.out.println("Cube Volume = " + c1.volume());
        System.out.println("Cube Surface Area = " + c1.surfaceArea());

        System.out.println("Cuboid Volume = " + c2.volume());
        System.out.println("Cuboid Surface Area = " + c2.surfaceArea());

        System.out.println("Cylinder Volume = " + c3.volume());
        System.out.println("Cylinder Surface Area = " + c3.surfaceArea());
    }
}