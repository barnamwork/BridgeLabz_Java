package objectModelingClassDiagram;

/*
 * UniversityFacultyDepartment
 * --------------------------------
 * Demonstrates:
 * 1. Composition between University and Department
 * 2. Aggregation between University and Faculty
 */

import java.util.ArrayList;

/* Faculty class (Aggregation) */
class Faculty {

    // Faculty name
    private String name;

    // Constructor to initialize faculty
    public Faculty(String name) {
        this.name = name;
    }

    // Returns faculty name
    public String getName() {
        return name;
    }
}

/* Department class (Composition) */
class Department {

    // Department name
    private String name;

    // Constructor to initialize department
    public Department(String name) {
        this.name = name;
    }

    // Returns department name
    public String getName() {
        return name;
    }
}

/* University class */
class University {

    // University name
    private String name;

    // Departments (Composition)
    private ArrayList<Department> departments = new ArrayList<>();

    // Faculty members (Aggregation)
    private ArrayList<Faculty> faculties = new ArrayList<>();

    // Constructor to initialize university
    public University(String name) {
        this.name = name;
    }

    // Adds department to university
    public void addDepartment(Department department) {
        departments.add(department);
    }

    // Adds faculty to university
    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    // Deletes university and its departments
    public void deleteUniversity() {
        departments.clear();
        System.out.println("University deleted. All departments removed.");
    }
}

/* Main class */
public class UniversityFacultyDepartment {

    public static void main(String[] args) {

        University uni = new University("XYZ University");

        Department d1 = new Department("Computer Science");
        Faculty f1 = new Faculty("Dr. Sharma");

        uni.addDepartment(d1);
        uni.addFaculty(f1);

        uni.deleteUniversity();

        System.out.println("Faculty still exists: " + f1.getName());
    }
}
