package level1;

// This class stores employee details and displays them using an object

class DisplayEmployeeDetails {

    String name;
    int id;
    double salary;

    void display() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Salary: " + salary);
    }

    public static void main(String[] args) {
        DisplayEmployeeDetails emp = new DisplayEmployeeDetails();

        emp.name = "Rahul";
        emp.id = 101;
        emp.salary = 45000;

        emp.display();
    }
}

