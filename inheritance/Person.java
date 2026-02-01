package inheritance;

public class Person {
    String name;
    int age;

    Person(String name, int age){
        this.name=name;
        this.age=age;
    }

    void displayRole(){
        System.out.println("Person name: " + name);
        System.out.println("Age: " + age);
    }

    static void main() {
        Person person = new Person("Human", 0);
        Teacher teacher = new Teacher ("Balaji", 30, "OOPS");
        Student student = new Student("Barnam", 21, 95);
        Staff staff = new Staff("Sunil", 45, 100);

        person.displayRole();
        System.out.println();
        teacher.displayRole();
        System.out.println();
        student.displayRole();
        System.out.println();
        staff.displayRole();
    }
}
class Teacher extends Person{
    String subject;

    Teacher(String name, int age, String subject){
        super(name, age);
        this.subject=subject;
    }

    void displayRole(){
        super.displayRole();
        System.out.println("The role of Person = Teacher");
        System.out.println("And Teaches the subject " + subject);
    }
}
class Student extends Person{
    int grade;

    Student(String name, int age, int grade){
        super(name, age);
        this.grade=grade;
    }

    void displayRole(){
        super.displayRole();
        System.out.println("The role of the person : Student");
        System.out.println("and its overall grade is : " + grade);
    }
}
class Staff extends Person{
    int id;

    Staff(String name, int age, int id){
        super(name, age);
        this.id = id;
    }

    void displayRole(){
        super.displayRole();
        System.out.println("The role of the person is : Staff");
        System.out.println("And Staff id is : "+id);
    }
}
