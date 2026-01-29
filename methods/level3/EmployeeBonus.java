package level3;

public class EmployeeBonus {

    // b. Generate salary and years of service
    public static int[][] generateEmployeeData() {
        int[][] data = new int[10][2];
        // column 0 -> salary
        // column 1 -> years of service

        for (int i = 0; i < 10; i++) {
            data[i][0] = (int)(Math.random() * 90000) + 10000; // 5-digit salary
            data[i][1] = (int)(Math.random() * 10) + 1;       // 1–10 years
        }
        return data;
    }

    // c. Calculate new salary and bonus
    public static double[][] calculateBonus(int[][] data) {
        double[][] result = new double[10][2];
        // column 0 -> new salary
        // column 1 -> bonus amount

        for (int i = 0; i < 10; i++) {
            double salary = data[i][0];
            int years = data[i][1];

            double bonusRate = (years > 5) ? 0.05 : 0.02;
            double bonus = salary * bonusRate;

            result[i][1] = bonus;
            result[i][0] = salary + bonus;
        }
        return result;
    }

    // d. Display result in tabular format
    public static void displayTable(int[][] data, double[][] result) {

        double totalOldSalary = 0;
        double totalNewSalary = 0;
        double totalBonus = 0;

        System.out.println("Emp\tSalary\tYears\tBonus\tNew Salary");
        System.out.println("--------------------------------------------");

        for (int i = 0; i < 10; i++) {
            totalOldSalary += data[i][0];
            totalBonus += result[i][1];
            totalNewSalary += result[i][0];

            System.out.println(
                    (i + 1) + "\t" +
                            data[i][0] + "\t" +
                            data[i][1] + "\t" +
                            result[i][1] + "\t" +
                            result[i][0]
            );
        }

        System.out.println("--------------------------------------------");
        System.out.println("Total Old Salary : " + totalOldSalary);
        System.out.println("Total Bonus      : " + totalBonus);
        System.out.println("Total New Salary : " + totalNewSalary);
    }

    public static void main(String[] args) {

        int[][] employeeData = generateEmployeeData();
        double[][] bonusData = calculateBonus(employeeData);

        displayTable(employeeData, bonusData);
    }
}
