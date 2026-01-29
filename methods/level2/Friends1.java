package level2;

import java.util.Scanner;

public class Friends1 {

    public static int youngest(int[] ages) {
        return Math.min(ages[0], Math.min(ages[1], ages[2]));
    }

    public static int tallest(int[] heights) {
        return Math.max(heights[0], Math.max(heights[1], heights[2]));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] age = new int[3];
        int[] height = new int[3];

        for (int i = 0; i < 3; i++) {
            age[i] = sc.nextInt();
            height[i] = sc.nextInt();
        }

        System.out.println("Youngest age = " + youngest(age));
        System.out.println("Tallest height = " + tallest(height));
    }
}
