package accessmodifiers;

import java.util.Scanner;

class Student {

    public int rollNumber;      // public
    protected String name;      // protected
    private double CGPA;        // private

    // public methods for private CGPA
    public void setCGPA(double c) {
        CGPA = c;
    }

    public double getCGPA() {
        return CGPA;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        PostgraduateStudent p = new PostgraduateStudent();

        System.out.print("Roll Number: ");
        p.rollNumber = sc.nextInt();
        sc.nextLine();

        System.out.print("Name: ");
        p.name = sc.nextLine();

        System.out.print("CGPA: ");
        double c = sc.nextDouble();
        p.setCGPA(c);

        p.display();
        System.out.println("CGPA: " + p.getCGPA());
    }
}

class PostgraduateStudent extends Student {

    void display() {
        System.out.println("Roll No: " + rollNumber);
        System.out.println("Name: " + name);
    }
}

