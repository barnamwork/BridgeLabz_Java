package level2;

import java.util.Scanner;

public class BMIProgram {

    public static void calculateBMI(double[][] data) {
        for (int i = 0; i < 10; i++) {
            double heightM = data[i][1] / 100;
            data[i][2] = data[i][0] / (heightM * heightM);
        }
    }

    public static String getStatus(double bmi) {
        if (bmi < 18.5) return "Underweight";
        if (bmi < 25) return "Normal";
        if (bmi < 30) return "Overweight";
        return "Obese";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] data = new double[10][3];

        for (int i = 0; i < 10; i++) {
            data[i][0] = sc.nextDouble(); // weight
            data[i][1] = sc.nextDouble(); // height
        }

        calculateBMI(data);

        for (int i = 0; i < 10; i++) {
            System.out.println("BMI = " + data[i][2] + " Status = " + getStatus(data[i][2]));
        }
    }
}

