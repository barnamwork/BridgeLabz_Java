package level2;

import java.util.Scanner;

public class GradeArray {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] phy = new int[n];
        int[] chem = new int[n];
        int[] math = new int[n];
        double[] percent = new double[n];
        char[] grade = new char[n];

        for (int i = 0; i < n; i++) {
            phy[i] = sc.nextInt();
            chem[i] = sc.nextInt();
            math[i] = sc.nextInt();

            percent[i] = (phy[i] + chem[i] + math[i]) / 3.0;

            if (percent[i] >= 80)
                grade[i] = 'A';
            else if (percent[i] >= 60)
                grade[i] = 'B';
            else if (percent[i] >= 40)
                grade[i] = 'C';
            else
                grade[i] = 'F';
        }

        for (int i = 0; i < n; i++)
            System.out.println(percent[i] + " " + grade[i]);

        sc.close();
    }
}

