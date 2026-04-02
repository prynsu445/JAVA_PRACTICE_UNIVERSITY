import Arrayop.ArrayOperation;
import Arrayop.StringOperation;

public class Main2 {

    public static void main(String[] args) {

        ArrayOperation arrObj = new ArrayOperation();

        arrObj.insert(10);
        arrObj.insert(20);
        arrObj.insert(30);

        arrObj.insertAtPosition(15,1);

        arrObj.deleteAtPosition(2);

        System.out.print("Array Elements: ");
        arrObj.display();

        System.out.println();

        StringOperation strObj = new StringOperation("JAVA");

        strObj.display();

        System.out.println("Length = " + strObj.length());

        System.out.println("Reverse = " + strObj.reverse());
    }
}