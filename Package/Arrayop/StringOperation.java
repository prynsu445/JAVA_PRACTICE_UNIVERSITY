package Arrayop;

public class StringOperation {

    String str;

    public StringOperation(String s) {
        str = s;
    }

    public void display() {
        System.out.println("String = " + str);
    }

    public int length() {
        return str.length();
    }

    public String reverse() {

        String rev = "";

        for(int i=str.length()-1;i>=0;i--)
            rev += str.charAt(i);

        return rev;
    }
}