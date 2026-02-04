package linkedList;

class StudentNode {
    //including their Roll Number, Name, Age, and Grade
    int rollNumber;
    String name;
    int age;
    String grade;
    StudentNode next;

    StudentNode(int rollNumber, String name, int age, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

class StudentSinglyLinkedList{
    private StudentNode head;

    public void addAtBeginning(int rollNumber, String name, int age, String grade){
        StudentNode newNode = new StudentNode(rollNumber, name, age, grade);
        newNode.next=head;
        head=newNode;
    }

    public void addAtEnd(int rollNumber, String name, int age, String grade){
        StudentNode newNode = new StudentNode(rollNumber, name, age, grade);
        if(head == null){
            head=newNode;
            return;
        }
        StudentNode temp = head;

        while(temp!=null){
            temp=temp.next;
        }
        temp.next=newNode;
    }


    public void deleteById(int rollNo){
        if (head == null){
            System.out.println("The list is empty");
            return;
        }
        if (head.rollNumber == rollNo){
            head=head.next;
            System.out.println("Student deleted");
            return;
        }

        StudentNode prev = head;
        StudentNode curr = head.next;

        while (curr!=null && curr.rollNumber!=rollNo){

        }

    }
    public void searchEmployee(){

    }
    public void display(){

    }

}


public class StudentManagement {

}
