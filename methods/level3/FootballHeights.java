package level3;

public class FootballHeights {

    // Method to generate random heights (150–250 cm)
    public static int[] generateHeights() {
        int[] heights = new int[11];
        for (int i = 0; i < heights.length; i++) {
            heights[i] = (int)(Math.random() * 101) + 150;
        }
        return heights;
    }

    // Method to find sum of heights
    public static int findSum(int[] heights) {
        int sum = 0;
        for (int h : heights) {
            sum += h;
        }
        return sum;
    }

    // Method to find mean height
    public static double findMean(int[] heights) {
        return (double) findSum(heights) / heights.length;
    }

    // Method to find shortest height
    public static int findShortest(int[] heights) {
        int min = heights[0];
        for (int h : heights) {
            if (h < min)
                min = h;
        }
        return min;
    }

    // Method to find tallest height
    public static int findTallest(int[] heights) {
        int max = heights[0];
        for (int h : heights) {
            if (h > max)
                max = h;
        }
        return max;
    }

    public static void main(String[] args) {

        int[] heights = generateHeights();

        System.out.println("Player Heights:");
        for (int h : heights)
            System.out.print(h + " ");

        System.out.println("\n\nShortest Height: " + findShortest(heights));
        System.out.println("Tallest Height: " + findTallest(heights));
        System.out.println("Mean Height: " + findMean(heights));
    }
}
