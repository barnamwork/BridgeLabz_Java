package level2;

import java.util.Scanner;

public class BMIArray {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        double[] weight = new double[n];
        double[] height = new double[n];
        double[] bmi = new double[n];
        String[] status = new String[n];

        for (int i = 0; i < n; i++) {
            weight[i] = sc.nextDouble();
            height[i] = sc.nextDouble();

            double h = height[i] / 100;
            bmi[i] = weight[i] / (h * h);

            if (bmi[i] <= 18.4)
                status[i] = "Underweight";
            else if (bmi[i] <= 24.9)
                status[i] = "Normal";
            else if (bmi[i] <= 39.9)
                status[i] = "Overweight";
            else
                status[i] = "Obese";
        }

        for (int i = 0; i < n; i++)
            System.out.println(height[i] + " " + weight[i] + " " + bmi[i] + " " + status[i]);

        sc.close();
    }
}
