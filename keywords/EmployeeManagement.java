package keywords;

/**
 * The Employee class represents an employee with static company name and employee count, private fields, and final ID.
 * It demonstrates static, private, final keywords, instanceof, and type casting.
 */
class Employee{
    static String companyName = "PeerIsland";
    private static int empCount = 0;

    private String name, designation;
    private final int id;

    Employee(String name,int id, String designation){
        this.name = name;
        this.id = id;
        this.designation = designation;
        empCount++;
    }

    // Static method to display employee details with instanceof check and casting
    public static void displayDetails(Object obj){
        if(obj instanceof Employee){
            Employee e = (Employee) obj;
            System.out.println("Employee ID: " + e.id);
            System.out.println("Employee Name: " + e.name);
            System.out.println("Designation: " + e.designation);
        }else{
            System.out.println("Invalid Employee Details");
        }
    }

    // Static method to return total number of employees
    public static int displayTotalEmployees(){
        return empCount;
    }
}

/**
 * The EmployeeManagement class demonstrates employee management using various Java keywords.
 */
public class EmployeeManagement {
    public static void main(String[] args){
        Employee e1 = new Employee("Aayush Gautam", 121, "Software Engineer");
        Employee e2 = new Employee("Aman", 154, "DB Admin");
        Employee e3 = new Employee("Aryan", 132, "Cloud Engineer");

        System.out.println("Company Name: " + Employee.companyName);

        Employee.displayDetails(e1);
        System.out.println();
        Employee.displayDetails(e2);
        System.out.println();
        Employee.displayDetails(e3);


        System.out.println("\nTotal number of employees: " + Employee.displayTotalEmployees());
    }
}