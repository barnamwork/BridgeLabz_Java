package linkedlist;
import java.util.Scanner;

/*
This program manages movie records using a Doubly Linked List.

A doubly linked list allows traversal in both directions:
- Forward using next pointer
- Backward using prev pointer

Each node represents one movie.
*/

/*
MovieNode represents one node of the doubly linked list.
It stores movie information and links to previous and next nodes.
*/
class MovieNode {

    String title;          // Stores the title of the movie
    String director;       // Stores the director name
    int year;              // Stores the year of release
    double rating;         // Stores movie rating

    MovieNode next;        // Points to the next movie node
    MovieNode prev;        // Points to the previous movie node

    /*
    Constructor initializes all data fields of the movie node.
    When a node is created, next and prev pointers are set to null.
    */
    MovieNode(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.next = null;  // No next node initially
        this.prev = null;  // No previous node initially
    }
}

/*
MovieDoublyLinkedList class handles all operations on the list.
It maintains both head and tail pointers.
*/
class MovieDoublyLinkedList {

    MovieNode head;    // Points to the first movie in the list
    MovieNode tail;    // Points to the last movie in the list

    /*
    Adds a movie at the beginning of the list.

    Steps:
    1. Create a new node
    2. If list is empty, head and tail both point to new node
    3. Otherwise:
       - new node's next points to current head
       - current head's prev points to new node
       - head is updated to new node
    */
    void addAtBeginning(String title, String director, int year, double rating) {

        // Create a new movie node
        MovieNode newNode = new MovieNode(title, director, year, rating);

        // If list is empty
        if (head == null) {
            head = tail = newNode;
            return;
        }

        // Link new node with current head
        newNode.next = head;
        head.prev = newNode;

        // Update head pointer
        head = newNode;
    }

    /*
    Adds a movie at the end of the list.

    Steps:
    1. Create new node
    2. If list is empty, make it head and tail
    3. Otherwise:
       - current tail's next points to new node
       - new node's prev points to current tail
       - tail is updated
    */
    void addAtEnd(String title, String director, int year, double rating) {

        MovieNode newNode = new MovieNode(title, director, year, rating);

        // If list is empty
        if (tail == null) {
            head = tail = newNode;
            return;
        }

        // Connect new node at the end
        tail.next = newNode;
        newNode.prev = tail;

        // Update tail pointer
        tail = newNode;
    }

    /*
    Adds a movie at a specific position (1-based index).

    Example:
    position = 1 → beginning
    position = last → end
    */
    void addAtPosition(int position, String title, String director, int year, double rating) {

        // Position must be positive
        if (position <= 0) {
            System.out.println("Invalid position");
            return;
        }

        // Insert at beginning
        if (position == 1) {
            addAtBeginning(title, director, year, rating);
            return;
        }

        MovieNode temp = head;

        // Move temp to the node before the required position
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }

        // If position is beyond current list size
        if (temp == null || temp.next == null) {
            addAtEnd(title, director, year, rating);
            return;
        }

        // Create new node
        MovieNode newNode = new MovieNode(title, director, year, rating);

        // Adjust pointers to insert node
        newNode.next = temp.next;
        newNode.prev = temp;
        temp.next.prev = newNode;
        temp.next = newNode;
    }

    /*
    Removes a movie record using its title.

    Steps:
    1. Traverse the list
    2. If movie found:
       - Adjust pointers based on node position
       - Update head or tail if required
    */
    void removeByTitle(String title) {

        // If list is empty
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        MovieNode temp = head;

        // Traverse through list
        while (temp != null) {

            // Check if current node matches title
            if (temp.title.equalsIgnoreCase(title)) {

                // If node is head
                if (temp == head) {
                    head = head.next;

                    if (head != null)
                        head.prev = null;
                    else
                        tail = null;
                }

                // If node is tail
                else if (temp == tail) {
                    tail = tail.prev;
                    tail.next = null;
                }

                // If node is in middle
                else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }

                System.out.println("Movie removed successfully");
                return;
            }

            temp = temp.next;
        }

        System.out.println("Movie not found");
    }

    /*
    Searches movies based on director name.
    Multiple movies can have the same director.
    */
    void searchByDirector(String director) {

        MovieNode temp = head;
        boolean found = false;

        // Traverse list
        while (temp != null) {

            if (temp.director.equalsIgnoreCase(director)) {
                displaySingleMovie(temp);
                found = true;
            }

            temp = temp.next;
        }

        if (!found)
            System.out.println("No movies found for this director");
    }

    /*
    Searches movies based on rating.
    */
    void searchByRating(double rating) {

        MovieNode temp = head;
        boolean found = false;

        while (temp != null) {

            if (temp.rating == rating) {
                displaySingleMovie(temp);
                found = true;
            }

            temp = temp.next;
        }

        if (!found)
            System.out.println("No movies found with this rating");
    }

    /*
    Updates the rating of a movie using its title.
    */
    void updateRating(String title, double newRating) {

        MovieNode temp = head;

        while (temp != null) {

            if (temp.title.equalsIgnoreCase(title)) {
                temp.rating = newRating;
                System.out.println("Rating updated successfully");
                return;
            }

            temp = temp.next;
        }

        System.out.println("Movie not found");
    }

    /*
    Displays all movie records in forward direction.
    Traversal starts from head and moves using next pointer.
    */
    void displayForward() {

        if (head == null) {
            System.out.println("No movie records available");
            return;
        }

        MovieNode temp = head;

        while (temp != null) {
            displaySingleMovie(temp);
            temp = temp.next;
        }
    }

    /*
    Displays all movie records in reverse direction.
    Traversal starts from tail and moves using prev pointer.
    */
    void displayReverse() {

        if (tail == null) {
            System.out.println("No movie records available");
            return;
        }

        MovieNode temp = tail;

        while (temp != null) {
            displaySingleMovie(temp);
            temp = temp.prev;
        }
    }

    /*
    Helper method to display one movie record.
    */
    void displaySingleMovie(MovieNode movie) {
        System.out.println("Title    : " + movie.title);
        System.out.println("Director : " + movie.director);
        System.out.println("Year     : " + movie.year);
        System.out.println("Rating   : " + movie.rating);
        System.out.println("---------------------------");
    }
}

/*
Main class containing the menu-driven program.
*/
public class MovieManagementSystem{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        MovieDoublyLinkedList list = new MovieDoublyLinkedList();
        int choice;

        // Loop continues until user chooses Exit
        do {
            System.out.println("\nMovie Management System");
            System.out.println("1. Add Movie at Beginning");
            System.out.println("2. Add Movie at End");
            System.out.println("3. Add Movie at Position");
            System.out.println("4. Remove Movie by Title");
            System.out.println("5. Search Movie by Director");
            System.out.println("6. Search Movie by Rating");
            System.out.println("7. Update Movie Rating");
            System.out.println("8. Display Movies Forward");
            System.out.println("9. Display Movies Reverse");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // Consume leftover newline

            switch (choice) {

                case 1:
                case 2:
                case 3:

                    // If insertion at position
                    if (choice == 3) {
                        System.out.print("Enter Position: ");
                        int pos = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Title: ");
                        String t = sc.nextLine();
                        System.out.print("Enter Director: ");
                        String d = sc.nextLine();
                        System.out.print("Enter Year: ");
                        int y = sc.nextInt();
                        System.out.print("Enter Rating: ");
                        double r = sc.nextDouble();

                        list.addAtPosition(pos, t, d, y, r);
                        break;
                    }

                    System.out.print("Enter Title: ");
                    String t = sc.nextLine();
                    System.out.print("Enter Director: ");
                    String d = sc.nextLine();
                    System.out.print("Enter Year: ");
                    int y = sc.nextInt();
                    System.out.print("Enter Rating: ");
                    double r = sc.nextDouble();

                    if (choice == 1)
                        list.addAtBeginning(t, d, y, r);
                    else
                        list.addAtEnd(t, d, y, r);
                    break;

                case 4:
                    System.out.print("Enter Movie Title to remove: ");
                    list.removeByTitle(sc.nextLine());
                    break;

                case 5:
                    System.out.print("Enter Director name: ");
                    list.searchByDirector(sc.nextLine());
                    break;

                case 6:
                    System.out.print("Enter Rating: ");
                    list.searchByRating(sc.nextDouble());
                    break;

                case 7:
                    System.out.print("Enter Movie Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter New Rating: ");
                    double nr = sc.nextDouble();
                    list.updateRating(title, nr);
                    break;

                case 8:
                    list.displayForward();
                    break;

                case 9:
                    list.displayReverse();
                    break;

                case 10:
                    System.out.println("Exiting program");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 10);

        sc.close();
    }
}
