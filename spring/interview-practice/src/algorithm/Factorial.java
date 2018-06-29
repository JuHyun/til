package algorithm;

public class Factorial {
    public static int factorial(int number) {
        return factorial_iter(1, 1, number);
    }

    private static int factorial_iter(int product, int count, int number) {
        if (count > number) return product;
        else
            return factorial_iter(product * count, ++count, number);
    }
}
