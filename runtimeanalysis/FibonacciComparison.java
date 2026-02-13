package algorithms;
class FibonacciComparison {

    /*
     * Recursive Fibonacci
     * Time Complexity: O(2^N)
     * Very slow due to repeated calculations
     */
    static int fibonacciRecursive(int n) {

        // Base case
        if (n <= 1) {
            return n;
        }

        // Recursive calls
        return fibonacciRecursive(n - 1)
                + fibonacciRecursive(n - 2);
    }

    /*
     * Iterative Fibonacci
     * Time Complexity: O(N)
     * Efficient and memory-friendly
     */
    static int fibonacciIterative(int n) {

        int a = 0, b = 1;

        for (int i = 2; i <= n; i++) {
            int sum = a + b;
            a = b;
            b = sum;
        }

        return b;
    }

    public static void main(String[] args) {

        long start = System.nanoTime();
        fibonacciRecursive(30);
        System.out.println("Recursive Time: " +
                (System.nanoTime() - start) + " ns");

        start = System.nanoTime();
        fibonacciIterative(30);
        System.out.println("Iterative Time: " +
                (System.nanoTime() - start) + " ns");
    }
}
