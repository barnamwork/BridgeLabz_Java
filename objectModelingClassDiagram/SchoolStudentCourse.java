package objectModelingClassDiagram;

/*
 * SchoolStudentCourse
 * ----------------------
 * Demonstrates:
 * 1. Aggregation between SchoolEntity and SchoolStudent
 * 2. Association (many-to-many) between SchoolStudent and SchoolCourse
 */

import java.util.ArrayList;

/* SchoolStudent class */
class SchoolStudent {

    // Student name
    private String name;

    // List of courses the student is enrolled in
    private ArrayList<SchoolCourse> courses = new ArrayList<>();

    // Constructor to initialize student
    public SchoolStudent(String name) {
        this.name = name;
    }

    // Enrolls student into a course (Association)
    public void enrollCourse(SchoolCourse course) {
        courses.add(course);
        course.addStudent(this);
    }

    // Displays courses enrolled by student
    public void viewCourses() {
        System.out.println(name + " enrolled in:");
        for (SchoolCourse c : courses) {
            System.out.println(c.getCourseName());
        }
    }

    // Returns student name
    public String getName() {
        return name;
    }
}

/* SchoolCourse class */
class SchoolCourse {

    // Course name
    private String courseName;

    // List of students enrolled in the course
    private ArrayList<SchoolStudent> students = new ArrayList<>();

    // Constructor to initialize course
    public SchoolCourse(String courseName) {
        this.courseName = courseName;
    }

    // Adds student to course
    public void addStudent(SchoolStudent student) {
        students.add(student);
    }

    // Displays students enrolled in course
    public void showStudents() {
        System.out.println("Students in " + courseName + ":");
        for (SchoolStudent s : students) {
            System.out.println(s.getName());
        }
    }

    // Returns course name
    public String getCourseName() {
        return courseName;
    }
}

/* SchoolEntity class (Aggregation with SchoolStudent) */
class SchoolEntity {

    // School name
    private String name;

    // List of students (Aggregation)
    private ArrayList<SchoolStudent> students = new ArrayList<>();

    // Constructor to initialize school
    public SchoolEntity(String name) {
        this.name = name;
    }

    // Adds student to school
    public void addStudent(SchoolStudent student) {
        students.add(student);
    }
}

/* Main class */
public class SchoolStudentCourse {

    public static void main(String[] args) {

        SchoolEntity school = new SchoolEntity("ABC School");

        SchoolStudent s1 = new SchoolStudent("Rahul");
        SchoolStudent s2 = new SchoolStudent("Anita");

        SchoolCourse c1 = new SchoolCourse("Maths");
        SchoolCourse c2 = new SchoolCourse("Science");

        school.addStudent(s1);
        school.addStudent(s2);

        s1.enrollCourse(c1);
        s1.enrollCourse(c2);
        s2.enrollCourse(c1);

        s1.viewCourses();
        c1.showStudents();
    }
}
