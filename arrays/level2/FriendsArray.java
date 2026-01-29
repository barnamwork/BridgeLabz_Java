package level2;

import java.util.Scanner;

public class FriendsArray {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] age = new int[3];
        int[] height = new int[3];

        for (int i = 0; i < 3; i++) {
            age[i] = sc.nextInt();
            height[i] = sc.nextInt();
        }

        int youngest = age[0];
        int tallest = height[0];
        int yIndex = 0, tIndex = 0;

        for (int i = 1; i < 3; i++) {
            if (age[i] < youngest) {
                youngest = age[i];
                yIndex = i;
            }
            if (height[i] > tallest) {
                tallest = height[i];
                tIndex = i;
            }
        }

        System.out.println("Youngest friend index: " + yIndex);
        System.out.println("Tallest friend index: " + tIndex);

        sc.close();
    }
}

