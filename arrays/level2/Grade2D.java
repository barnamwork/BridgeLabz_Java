package level2;

import java.util.Scanner;

public class Grade2D {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] marks = new int[n][3];
        double[] percent = new double[n];
        char[] grade = new char[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++)
                marks[i][j] = sc.nextInt();

            percent[i] = (marks[i][0] + marks[i][1] + marks[i][2]) / 3.0;

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
