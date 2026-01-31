package objectModelingClassDiagram;
/*
 * UniversityManagement
 * ------------------------
 * Demonstrates Association and Aggregation
 * between Student, Professor, and Course.
 */

import java.util.ArrayList;

/* Course class */
class Course {

    // Course name
    private String name;

    // Constructor to initialize course
    public Course(String name) {
        this.name = name;
    }

    // Returns course name
    public String getName() {
        return name;
    }
}

/* Student class */
class Student {

    // Student name
    private String name;

    // Courses enrolled by student
    private ArrayList<Course> courses = new ArrayList<>();

    // Constructor to initialize student
    public Student(String name) {
        this.name = name;
    }

    // Enrolls student into course
    public void enrollCourse(Course course) {
        courses.add(course);
        System.out.println(name + " enrolled in " + course.getName());
    }
}

/* Professor class */
class Professor {

    // Professor name
    private String name;

    // Constructor to initialize professor
    public Professor(String name) {
        this.name = name;
    }

    // Assigns professor to course
    public void assignProfessor(Course course) {
        System.out.println(name + " assigned to teach " + course.getName());
    }
}

/* Main class */
public class UniversityManagement {

    public static void main(String[] args) {

        Student student = new Student("Ravi");
        Professor professor = new Professor("Dr. Kumar");

        Course course = new Course("Data Structures");

        student.enrollCourse(course);
        professor.assignProfessor(course);
    }
}

