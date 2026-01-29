package level2;

import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int physics = sc.nextInt();
        int chemistry = sc.nextInt();
        int maths = sc.nextInt();

        double percentage = (physics + chemistry + maths) / 3.0;

        System.out.println("Percentage: " + percentage);

        if (percentage >= 80)
            System.out.println("Grade: A  Remarks: Level 4, above agency-normalized standards");
        else if (percentage >= 70)
            System.out.println("Grade: B  Remarks: Level 3, at agency-normalized standards");
        else if (percentage >= 60)
            System.out.println("Grade: C  Remarks: Level 2, below but approaching standards");
        else if (percentage >= 50)
            System.out.println("Grade: D  Remarks: Level 1, well below standards");
        else if (percentage >= 40)
            System.out.println("Grade: E  Remarks: Level 1-, too below standards");
        else
            System.out.println("Grade: R  Remarks: Remedial standards");

        sc.close();
    }
}
