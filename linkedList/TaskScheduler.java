package linkedlist;
import java.util.Scanner;

/*
This program implements a Task Scheduler using a Circular Linked List.

In a circular linked list:
- The last node does NOT point to null
- The last node's next pointer points back to the first node (head)
- Traversal keeps looping in a circular manner

Each node represents one task.
*/

/*
TaskNode represents a single task in the scheduler.
Each node stores task details and a reference to the next task.
*/
class TaskNode {

    int taskId;          // Unique ID for the task
    String taskName;     // Name of the task
    int priority;        // Priority of the task
    String dueDate;      // Due date of the task

    TaskNode next;       // Points to the next task in the circular list

    /*
    Constructor initializes the task details.
    Initially, next is set to null.
    */
    TaskNode(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

/*
This class implements the Circular Linked List for task scheduling.
It maintains:
- head → first task
- current → currently executing task
*/
class TaskCircularLinkedList {

    TaskNode head;       // Points to the first task
    TaskNode current;    // Points to the current task

    /*
    Add a task at the beginning of the circular linked list.

    Steps:
    1. Create a new node
    2. If list is empty:
       - new node points to itself
       - head and current point to new node
    3. Otherwise:
       - Traverse to last node
       - Last node points to new node
       - New node points to head
       - Update head
    */
    void addAtBeginning(int id, String name, int priority, String dueDate) {

        TaskNode newNode = new TaskNode(id, name, priority, dueDate);

        // If list is empty
        if (head == null) {
            newNode.next = newNode; // Circular reference
            head = current = newNode;
            return;
        }

        // Traverse to the last node
        TaskNode temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }

        // Insert new node at beginning
        newNode.next = head;
        temp.next = newNode;
        head = newNode;
    }

    /*
    Add a task at the end of the circular linked list.

    Steps:
    1. Create new node
    2. If list is empty, same as add at beginning
    3. Otherwise:
       - Traverse to last node
       - Last node points to new node
       - New node points to head
    */
    void addAtEnd(int id, String name, int priority, String dueDate) {

        TaskNode newNode = new TaskNode(id, name, priority, dueDate);

        // If list is empty
        if (head == null) {
            newNode.next = newNode;
            head = current = newNode;
            return;
        }

        TaskNode temp = head;

        // Move to last node
        while (temp.next != head) {
            temp = temp.next;
        }

        // Insert at end
        temp.next = newNode;
        newNode.next = head;
    }

    /*
    Add a task at a specific position (1-based index).

    Steps:
    1. Validate position
    2. If position is 1 → add at beginning
    3. Traverse to position-1
    4. Adjust links
    */
    void addAtPosition(int position, int id, String name, int priority, String dueDate) {

        if (position <= 0) {
            System.out.println("Invalid position");
            return;
        }

        if (position == 1) {
            addAtBeginning(id, name, priority, dueDate);
            return;
        }

        TaskNode newNode = new TaskNode(id, name, priority, dueDate);
        TaskNode temp = head;

        // Traverse to node before position
        for (int i = 1; i < position - 1 && temp.next != head; i++) {
            temp = temp.next;
        }

        // Insert new node
        newNode.next = temp.next;
        temp.next = newNode;
    }

    /*
    Remove a task using Task ID.

    Steps:
    1. Check if list is empty
    2. If only one node exists
    3. If task is head
    4. If task is in middle or end
    */
    void removeByTaskId(int taskId) {

        // If list is empty
        if (head == null) {
            System.out.println("Task list is empty");
            return;
        }

        TaskNode temp = head;
        TaskNode prev = null;

        // Case: Only one node
        if (head.next == head && head.taskId == taskId) {
            head = current = null;
            System.out.println("Task removed successfully");
            return;
        }

        // Traverse the circular list
        do {
            if (temp.taskId == taskId) {

                // If removing head node
                if (temp == head) {
                    TaskNode last = head;
                    while (last.next != head) {
                        last = last.next;
                    }

                    head = head.next;
                    last.next = head;
                } else {
                    prev.next = temp.next;
                }

                // Adjust current pointer if needed
                if (current == temp) {
                    current = temp.next;
                }

                System.out.println("Task removed successfully");
                return;
            }

            prev = temp;
            temp = temp.next;

        } while (temp != head);

        System.out.println("Task not found");
    }

    /*
    View the current task and move to the next task.

    Since list is circular, next task always exists.
    */
    void viewAndMoveNext() {

        if (current == null) {
            System.out.println("No tasks available");
            return;
        }

        System.out.println("Current Task:");
        displaySingleTask(current);

        // Move to next task
        current = current.next;
    }

    /*
    Display all tasks starting from head.

    Traversal stops when head is reached again.
    */
    void displayAllTasks() {

        if (head == null) {
            System.out.println("No tasks to display");
            return;
        }

        TaskNode temp = head;

        do {
            displaySingleTask(temp);
            temp = temp.next;
        } while (temp != head);
    }

    /*
    Search tasks by priority.
    Multiple tasks can have the same priority.
    */
    void searchByPriority(int priority) {

        if (head == null) {
            System.out.println("No tasks available");
            return;
        }

        TaskNode temp = head;
        boolean found = false;

        do {
            if (temp.priority == priority) {
                displaySingleTask(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found)
            System.out.println("No tasks found with this priority");
    }

    /*
    Helper method to display a single task.
    */
    void displaySingleTask(TaskNode task) {
        System.out.println("Task ID   : " + task.taskId);
        System.out.println("Task Name : " + task.taskName);
        System.out.println("Priority  : " + task.priority);
        System.out.println("Due Date  : " + task.dueDate);
        System.out.println("---------------------------");
    }
}

/*
Main class containing menu-driven interface.
*/
public class TaskScheduler {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        TaskCircularLinkedList scheduler = new TaskCircularLinkedList();
        int choice;

        do {
            System.out.println("\nTask Scheduler");
            System.out.println("1. Add Task at Beginning");
            System.out.println("2. Add Task at End");
            System.out.println("3. Add Task at Position");
            System.out.println("4. Remove Task by ID");
            System.out.println("5. View Current Task & Move Next");
            System.out.println("6. Display All Tasks");
            System.out.println("7. Search Task by Priority");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                case 2:
                case 3:
                    if (choice == 3) {
                        System.out.print("Enter Position: ");
                        int pos = sc.nextInt();
                        System.out.print("Enter Task ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter Task Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Priority: ");
                        int pr = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter Due Date: ");
                        String date = sc.nextLine();

                        scheduler.addAtPosition(pos, id, name, pr, date);
                        break;
                    }

                    System.out.print("Enter Task ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Task Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Priority: ");
                    int pr = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Due Date: ");
                    String date = sc.nextLine();

                    if (choice == 1)
                        scheduler.addAtBeginning(id, name, pr, date);
                    else
                        scheduler.addAtEnd(id, name, pr, date);
                    break;

                case 4:
                    System.out.print("Enter Task ID to remove: ");
                    scheduler.removeByTaskId(sc.nextInt());
                    break;

                case 5:
                    scheduler.viewAndMoveNext();
                    break;

                case 6:
                    scheduler.displayAllTasks();
                    break;

                case 7:
                    System.out.print("Enter Priority to search: ");
                    scheduler.searchByPriority(sc.nextInt());
                    break;

                case 8:
                    System.out.println("Exiting Task Scheduler");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 8);

        sc.close();
    }
}
