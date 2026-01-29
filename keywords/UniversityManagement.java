package keywords;

/**
 * The Student class represents a student with static university name and student count, private fields, and final roll number.
 * It demonstrates static, private, final keywords, and instanceof operator.
 */
class Student{
    public static String universityName = "SRM University";
    private static int studentCount = 0;

    private String name;
    private final int rollNumber;
    private char grade;

    Student(String name, int rollNumber,char grade){
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        studentCount++;
    }

    // Method to display student details with instanceof check
    public void displayStudent(){
        if(this instanceof Student){
            System.out.println("Reg No: " + rollNumber);
            System.out.println("Student Name: "+ name);
            System.out.println("Grades secured: " + grade);
            System.out.println();
        }else{
            System.out.println("Invalid object instance");
        }

    }

    // Static method to return total number of students
    public static int totalStudents(){
        return studentCount;
    }
}

/**
 * The UniversityManagement class demonstrates university student management using various Java keywords.
 */
public class UniversityManagement {
    public static void main(String[] args){
        Student s1 = new Student("Aayush", 199, 'O');
        Student s2 =new Student("Aman", 196, 'A');

        System.out.println("University name: " + Student.universityName);
        s1.displayStudent();
        s2.displayStudent();

        System.out.println("Total number of students: " + Student.totalStudents());
    }
}