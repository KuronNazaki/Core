// In this project, i'll learn the Java Core.

public class Core {
    public static void main(String[] args) {
        System.out.println("Factorial of 20 is " + Factorial(20));
    }

    static public long Factorial (int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * Factorial(n - 1);
        }
    }
}
