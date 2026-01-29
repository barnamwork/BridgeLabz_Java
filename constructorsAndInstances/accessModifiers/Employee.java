package accessmodifiers;

import java.util.Scanner;

class Employee {

    public int employeeID;        // public
    protected String department;  // protected
    private double salary;        // private

    // public methods for private salary
    public void setSalary(double s) {
        salary = s;
    }

    public double getSalary() {
        return salary;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Manager m = new Manager();

        System.out.print("Employee ID: ");
        m.employeeID = sc.nextInt();
        sc.nextLine();

        System.out.print("Department: ");
        m.department = sc.nextLine();

        System.out.print("Salary: ");
        double s = sc.nextDouble();
        m.setSalary(s);

        m.display();
        System.out.println("Salary: " + m.getSalary());
    }
}

class Manager extends Employee {

    void display() {
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Department: " + department);
    }
}

