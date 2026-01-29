package instancevsclass;

import java.util.Scanner;

class Course {

    // Instance variables
    String courseName;
    int duration;
    double fee;

    // Class variable
    static String instituteName = "Default Institute";

    Course(String name, int duration, double fee) {
        this.courseName = name;
        this.duration = duration;
        this.fee = fee;
    }

    // Instance method
    void displayCourseDetails() {
        System.out.println("Course: " + courseName);
        System.out.println("Duration: " + duration + " months");
        System.out.println("Fee: " + fee);
        System.out.println("Institute: " + instituteName);
    }

    // Class method
    static void updateInstituteName(String name) {
        instituteName = name;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter course name: ");
        String cn = sc.nextLine();
        System.out.print("Enter duration (months): ");
        int d = sc.nextInt();
        System.out.print("Enter fee: ");
        double f = sc.nextDouble();
        sc.nextLine();
        System.out.print("Enter institute name: ");
        String inst = sc.nextLine();

        Course.updateInstituteName(inst);

        Course c = new Course(cn, d, f);
        c.displayCourseDetails();
    }
}

