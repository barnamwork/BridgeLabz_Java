package level3;

import java.util.Scanner;

public class StudentScorecard {

    // b. Generate random PCM marks (2-digit)
    public static int[][] generatePCMMarks(int n) {
        int[][] marks = new int[n][3];
        // column 0 -> Physics
        // column 1 -> Chemistry
        // column 2 -> Maths

        for (int i = 0; i < n; i++) {
            marks[i][0] = (int)(Math.random() * 90) + 10;
            marks[i][1] = (int)(Math.random() * 90) + 10;
            marks[i][2] = (int)(Math.random() * 90) + 10;
        }
        return marks;
    }

    // c. Calculate total, average and percentage
    public static double[][] calculateResults(int[][] marks) {
        int n = marks.length;
        double[][] result = new double[n][3];
        // column 0 -> total
        // column 1 -> average
        // column 2 -> percentage

        for (int i = 0; i < n; i++) {
            double total = marks[i][0] + marks[i][1] + marks[i][2];
            double average = total / 3;
            double percentage = (total / 300) * 100;

            // round to 2 digits
            average = Math.round(average * 100.0) / 100.0;
            percentage = Math.round(percentage * 100.0) / 100.0;

            result[i][0] = total;
            result[i][1] = average;
            result[i][2] = percentage;
        }
        return result;
    }

    // Grade calculation
    public static String getGrade(double percentage) {
        if (percentage >= 80) return "A";
        else if (percentage >= 70) return "B";
        else if (percentage >= 60) return "C";
        else if (percentage >= 50) return "D";
        else if (percentage >= 40) return "E";
        else return "R";
    }

    // d. Display scorecard in tabular format
    public static void displayScorecard(int[][] marks, double[][] result) {

        System.out.println("Stu\tPhy\tChem\tMath\tTotal\tAvg\t%\tGrade");
        System.out.println("--------------------------------------------------------");

        for (int i = 0; i < marks.length; i++) {
            System.out.println(
                    (i + 1) + "\t" +
                            marks[i][0] + "\t" +
                            marks[i][1] + "\t" +
                            marks[i][2] + "\t" +
                            result[i][0] + "\t" +
                            result[i][1] + "\t" +
                            result[i][2] + "\t" +
                            getGrade(result[i][2])
            );
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // a. Number of students
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[][] marks = generatePCMMarks(n);
        double[][] result = calculateResults(marks);

        displayScorecard(marks, result);

        sc.close();
    }
}
