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
            head = newNode;
            return;
        }

        StudentNode temp = head;

        while(temp!=null){
            temp=temp.next;
        }
        temp.next=newNode;
    }


    public void deleteById (int rollNo){
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

        while (curr != null && curr.rollNumber != rollNo){
            prev = curr;
            curr = curr.next;
        }
        if(curr == null){
            System.out.println("Student not found");
        }
        else {
            prev.next = curr.next;
            System.out.println("Student deleted: " + rollNo + " Successfully");
        }

    }
    public void searchStudent(int rollNo){
        StudentNode temp = head;

        while( temp!=null ){
            if( temp.rollNumber == rollNo ){
                System.out.println("Student found");
                System.out.println("Name: " + temp.name + ", Age: " + temp.age + ", Grade: " + temp.grade );
                return;
            }
            temp=temp.next;
        }
        System.out.println("Student not found");

    }
    public void display(){
        if (head == null) {
            System.out.println("No records available");
            return;
        }

        StudentNode temp =head;
        while(temp!= null){
            System.out.println( temp.name+ " | " + temp.age + " | " + temp.grade + " | " + temp.rollNumber);
            temp=temp.next;
        }
    }

    public void insertAtPosition(int rollNumber, String name, int age, String grade, int position){
        if(position<=0){
            System.out.println("Position cannot be 0");
            return;
        }
        if(position ==1){
            addAtBeginning(rollNumber, name, age, grade);
            return;
        }

        StudentNode newNode = new StudentNode( rollNumber, name, age, grade );
        StudentNode temp = head;
        for( int i=1; i < position-1 && temp!=null; i++){
            temp = temp.next;
        }
        if(temp == null){
            System.out.println(" out of range : position ");
            return;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void deleteFromBeginning(){
        if(head == null){
            System.out.println("The list is Empty");
            return;
        }
        head = head.next;
    }

    public void deleteFromEnd(){
        if(head == null){
            System.out.println("The list is Empty");
            return;
        }
        if(head.next == null){
            head=null;
            return;
        }

        StudentNode temp = head;

        while(temp.next.next != null){
            temp = temp.next;
        }
        temp.next = null;
    }

    public void deleteFromPosition(int position) {

        if (head == null || position <= 0) {
            System.out.println("Invalid operation");
            return;
        }

        if (position == 1) {
            head = head.next;
            return;
        }
        StudentNode temp = head;

        for(int i=1; i<position-1 && temp.next!=null ; i++){
           temp=temp.next;
        }

        if(temp.next == null){
            System.out.println("Invalid");
            return;
        }
        temp.next=temp.next.next;

    }

}


public class StudentManagement {
    static void main() {

    }
}
