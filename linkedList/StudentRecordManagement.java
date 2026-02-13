package linkedlist;
import java.util.Scanner;

/*
This program manages student records using a singly linked list.

Each student record is stored in a node.
Each node contains student details and a reference to the next node.

The program allows the user to:
- Add student records
- Delete a student record
- Search for a student
- Update student grade
- Display all student records
*/

/*
This class represents a single node of the linked list.
Each node stores data of one student and a link to the next node.
*/
class StudentNode {

    int rollNo;          // Stores the roll number of the student
    String name;         // Stores the name of the student
    int age;             // Stores the age of the student
    char grade;          // Stores the grade of the student
    StudentNode next;    // Stores reference to the next node

    /*
    Constructor is used to initialize the node with student details.
    When a node is created, next is set to null by default.
    */
    StudentNode(int rollNo, String name, int age, char grade) {
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

/*
This class implements all linked list operations.
The head variable stores the address of the first node.
*/
class StudentLinkedList {

    StudentNode head;    // Head of the linked list

    /*
    Adds a new student record at the beginning of the list.

    Steps:
    1. Create a new node
    2. Point new node's next to the current head
    3. Move head to the new node
    */
    void addAtBeginning(int rollNo, String name, int age, char grade) {

        StudentNode newNode = new StudentNode(rollNo, name, age, grade);

        newNode.next = head;   // New node points to old head
        head = newNode;        // Head is updated to new node
    }

    /*
    Adds a new student record at the end of the list.

    Steps:
    1. Create a new node
    2. If list is empty, make new node the head
    3. Otherwise, traverse till the last node
    4. Link last node to new node
    */
    void addAtEnd(int rollNo, String name, int age, char grade) {

        StudentNode newNode = new StudentNode(rollNo, name, age, grade);

        // If the list is empty
        if (head == null) {
            head = newNode;
            return;
        }

        // Traverse to the last node
        StudentNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        // Attach new node at the end
        temp.next = newNode;
    }

    /*
    Adds a student record at a specific position.
    Position is 1-based (position 1 means beginning).

    Steps:
    1. Validate position
    2. Traverse to the node before the position
    3. Adjust next pointers
    */
    void addAtPosition(int position, int rollNo, String name, int age, char grade) {

        // Invalid position
        if (position <= 0) {
            System.out.println("Invalid position");
            return;
        }

        // If position is 1, insert at beginning
        if (position == 1) {
            addAtBeginning(rollNo, name, age, grade);
            return;
        }

        StudentNode newNode = new StudentNode(rollNo, name, age, grade);
        StudentNode temp = head;

        // Move to node before the given position
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }

        // If position is beyond list length
        if (temp == null) {
            System.out.println("Position out of range");
            return;
        }

        // Insert new node by adjusting links
        newNode.next = temp.next;
        temp.next = newNode;
    }

    /*
    Deletes a student record using roll number.

    Steps:
    1. Check if list is empty
    2. If head node matches, delete head
    3. Otherwise, find the node before the target
    4. Change next pointer to skip the target node
    */
    void deleteByRollNo(int rollNo) {

        // If list is empty
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        // If the student to be deleted is at head
        if (head.rollNo == rollNo) {
            head = head.next;
            System.out.println("Student deleted successfully");
            return;
        }

        StudentNode temp = head;

        // Traverse to find the previous node
        while (temp.next != null && temp.next.rollNo != rollNo) {
            temp = temp.next;
        }

        // Student not found
        if (temp.next == null) {
            System.out.println("Student not found");
        } else {
            // Remove the node by skipping it
            temp.next = temp.next.next;
            System.out.println("Student deleted successfully");
        }
    }

    /*
    Searches for a student record using roll number.
    Linear search is performed since it is a linked list.
    */
    void searchByRollNo(int rollNo) {

        StudentNode temp = head;

        // Traverse through the list
        while (temp != null) {

            if (temp.rollNo == rollNo) {
                System.out.println("Student Found");
                System.out.println("Roll No : " + temp.rollNo);
                System.out.println("Name    : " + temp.name);
                System.out.println("Age     : " + temp.age);
                System.out.println("Grade   : " + temp.grade);
                return;
            }

            temp = temp.next;
        }

        System.out.println("Student not found");
    }

    /*
    Updates the grade of a student using roll number.
    */
    void updateGrade(int rollNo, char newGrade) {

        StudentNode temp = head;

        while (temp != null) {

            if (temp.rollNo == rollNo) {
                temp.grade = newGrade;
                System.out.println("Grade updated successfully");
                return;
            }

            temp = temp.next;
        }

        System.out.println("Student not found");
    }

    /*
    Displays all student records present in the list.
    */
    void displayAll() {

        // If no records exist
        if (head == null) {
            System.out.println("No student records available");
            return;
        }

        StudentNode temp = head;

        // Traverse and print each student record
        while (temp != null) {
            System.out.println("Roll No : " + temp.rollNo);
            System.out.println("Name    : " + temp.name);
            System.out.println("Age     : " + temp.age);
            System.out.println("Grade   : " + temp.grade);
            System.out.println("----------------------");

            temp = temp.next;
        }
    }
}

/*
Main class containing menu-driven user interface.
*/
public class StudentRecordManagement{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentLinkedList list = new StudentLinkedList();
        int choice;

        // Menu runs until user chooses Exit
        do {
            System.out.println("\nStudent Record Management System");
            System.out.println("1. Add at Beginning");
            System.out.println("2. Add at End");
            System.out.println("3. Add at Position");
            System.out.println("4. Delete by Roll Number");
            System.out.println("5. Search by Roll Number");
            System.out.println("6. Update Grade");
            System.out.println("7. Display All Records");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Roll No: ");
                    int r1 = sc.nextInt();
                    sc.nextLine(); // Consume newline
                    System.out.print("Enter Name: ");
                    String n1 = sc.nextLine();
                    System.out.print("Enter Age: ");
                    int a1 = sc.nextInt();
                    System.out.print("Enter Grade: ");
                    char g1 = sc.next().charAt(0);
                    list.addAtBeginning(r1, n1, a1, g1);
                    break;

                case 2:
                    System.out.print("Enter Roll No: ");
                    int r2 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String n2 = sc.nextLine();
                    System.out.print("Enter Age: ");
                    int a2 = sc.nextInt();
                    System.out.print("Enter Grade: ");
                    char g2 = sc.next().charAt(0);
                    list.addAtEnd(r2, n2, a2, g2);
                    break;

                case 3:
                    System.out.print("Enter Position: ");
                    int pos = sc.nextInt();
                    System.out.print("Enter Roll No: ");
                    int r3 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String n3 = sc.nextLine();
                    System.out.print("Enter Age: ");
                    int a3 = sc.nextInt();
                    System.out.print("Enter Grade: ");
                    char g3 = sc.next().charAt(0);
                    list.addAtPosition(pos, r3, n3, a3, g3);
                    break;

                case 4:
                    System.out.print("Enter Roll No to delete: ");
                    int rd = sc.nextInt();
                    list.deleteByRollNo(rd);
                    break;

                case 5:
                    System.out.print("Enter Roll No to search: ");
                    int rs = sc.nextInt();
                    list.searchByRollNo(rs);
                    break;

                case 6:
                    System.out.print("Enter Roll No: ");
                    int ru = sc.nextInt();
                    System.out.print("Enter New Grade: ");
                    char ng = sc.next().charAt(0);
                    list.updateGrade(ru, ng);
                    break;

                case 7:
                    list.displayAll();
                    break;

                case 8:
                    System.out.println("Exiting program");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 8);

        sc.close();
    }
}
