package Task2;

public class EvklidAlgoritm {
    public static int nod(int a, int b) {
        if (b == 0) {
            return a;
        } else if (a == 0) {
            return b;
        } else if (a < b) {
            return nod(b, a);
        } else {
            return nod(b, a % b);
        }
    }

    public static void main(String[] args) {
        int a = 42;
        int b = 56;
        int result = nod(a, b);

        System.out.println("НОД(" + a + ", " + b + ") = " + result);
    }
}
