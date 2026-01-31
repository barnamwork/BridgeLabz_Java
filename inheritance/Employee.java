package inheritance;

public class Employee {
    String name;
    int id;
    int salary;
    String hobby;

    Employee(){
        name="Employee ";
        id=0;
        salary= 0;
        hobby = "Gaming";
    }
    // This is a method which displays the details like name id and salary


    void displayDetails(){
        System.out.println("The employee name is "+name+" and employee id is "+id+" and employee salary is Rs"+salary);
        System.out.println();
    }

    static void main() {
        Employee employee = new Employee();
        Manager manager = new Manager();
        Developer developer = new Developer();
        Intern intern = new Intern();
        employee.displayDetails();
        manager.displayDetails();
        developer.displayDetails();
        intern.displayDetails();

    }
}
class Manager extends Employee {
    Manager(){
        name="Manager hu beta";
        id=90;
        salary= 110000;
        teamSize=15;
    }
    int teamSize;
    @Override
    void displayDetails(){
        System.out.println("The employee name is "+name+" and employee id is "+id+" and employee salary is Rs"+salary);
        System.out.println("The employee is a manager and its teamSize is "+teamSize + " and hobby is "+hobby);
        System.out.println();
    }
}
class Developer extends Employee {
    Developer(){
        name="Dev hu mai";
        id=5;
        salary= 50000;
        programmingLanguage="Java";
    }
    String programmingLanguage;
    @Override
    void displayDetails(){
        System.out.println("The employee name is "+name+" and employee id is "+id+" and employee salary is Rs"+salary);
        System.out.println("The employee is a developer and its programmingLanguage is "+programmingLanguage);
        System.out.println();
    }

}
class Intern extends Employee {
    Intern(){
        name="Bacha";
        id=1;
        salary= 10000;
    }
    @Override
    void displayDetails(){
        System.out.println("The intern name is "+name+" and intern id is "+id+" and intern salary is Rs "+salary);
        System.out.println("This a just a intern and not a employee");
        System.out.println();
    }
}
