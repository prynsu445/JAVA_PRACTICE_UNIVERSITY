public class SpecialNumber {
    public static void main(String[] args) {

        for (int i = 1000; i <= 9999; i++) {

            int first = i / 100;
            int last = i % 100;

            int sum = first + last;

            if (sum * sum == i)
                System.out.println(i);
        }
    }
}

//3025 =3025