package algorithms;
class StringPerformanceComparison {

    public static void main(String[] args) {

        int n = 1_000_000;

        /* ===================== String ===================== */

        /*
         * String is immutable.
         * Every concatenation creates a new object.
         * Time Complexity: O(N²)
         */
        long start = System.nanoTime();
        String str = "";

        for (int i = 0; i < n; i++) {
            str = str + "hello";
        }

        System.out.println("String Time: " +
                (System.nanoTime() - start) + " ns");

        /* ===================== StringBuilder ===================== */

        /*
         * StringBuilder is mutable and not thread-safe.
         * Best for single-threaded applications.
         * Time Complexity: O(N)
         */
        start = System.nanoTime();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb.append("hello");
        }

        System.out.println("StringBuilder Time: " +
                (System.nanoTime() - start) + " ns");

        /* ===================== StringBuffer ===================== */

        /*
         * StringBuffer is mutable and thread-safe.
         * Slightly slower due to synchronization.
         * Time Complexity: O(N)
         */
        start = System.nanoTime();
        StringBuffer sbuf = new StringBuffer();

        for (int i = 0; i < n; i++) {
            sbuf.append("hello");
        }

        System.out.println("StringBuffer Time: " +
                (System.nanoTime() - start) + " ns");
    }
}

