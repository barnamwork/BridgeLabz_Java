/*
 * CompanyComposition
 * ----------------------
 * This program demonstrates Composition.
 * A Company owns Departments and Employees.
 * If Company is destroyed, Departments and Employees are also destroyed.
 */

import java.util.ArrayList;

/* Employee class */
class Employee {

    // Employee name
    private String name;

    // Constructor to initialize employee
    public Employee(String name) {
        this.name = name;
    }

    // Returns employee name
    public String getName() {
        return name;
    }
}

/* Department class uses composition with Employee */
class Department {

    // Department name
    private String name;

    // List of employees
    private ArrayList<Employee> employees = new ArrayList<>();

    // Constructor to initialize department
    public Department(String name) {
        this.name = name;
    }

    // Adds employee to department
    public void addEmployee(String empName) {
        employees.add(new Employee(empName));
    }

    // Displays employees
    public void showEmployees() {
        System.out.println("Department: " + name);
        for (Employee e : employees) {
            System.out.println(e.getName());
        }
    }
}

/* Company class uses composition with Department */
class Company {

    // Company name
    private String name;

    // List of departments
    private ArrayList<Department> departments = new ArrayList<>();

    // Constructor to initialize company
    public Company(String name) {
        this.name = name;
    }

    // Adds department to company
    public void addDepartment(Department department) {
        departments.add(department);
    }

    // Deletes all departments
    public void closeCompany() {
        departments.clear();
        System.out.println("Company closed. All departments removed.");
    }
}

/* Main class */
public class CompanyComposition {

    public static void main(String[] args) {

        // Creating company
        Company company = new Company("TechCorp");

        // Creating department
        Department dev = new Department("Development");
        dev.addEmployee("Amit");
        dev.addEmployee("Neha");

        // Adding department to company
        company.addDepartment(dev);

        // Displaying employees
        dev.showEmployees();

        // Closing company
        company.closeCompany();
    }
}
