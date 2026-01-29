package level2;

import java.util.Scanner;

public class BMI2D {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        double[][] personData = new double[n][3];
        String[] status = new String[n];

        for (int i = 0; i < n; i++) {
            double w = sc.nextDouble();
            double h = sc.nextDouble();

            if (w <= 0 || h <= 0) {
                i--;
                continue;
            }

            personData[i][0] = w;
            personData[i][1] = h;
            double hm = h / 100;
            personData[i][2] = w / (hm * hm);

            if (personData[i][2] <= 18.4)
                status[i] = "Underweight";
            else if (personData[i][2] <= 24.9)
                status[i] = "Normal";
            else if (personData[i][2] <= 39.9)
                status[i] = "Overweight";
            else
                status[i] = "Obese";
        }

        for (int i = 0; i < n; i++)
            System.out.println(personData[i][1] + " " + personData[i][0] + " " + personData[i][2] + " " + status[i]);

        sc.close();
    }
}
