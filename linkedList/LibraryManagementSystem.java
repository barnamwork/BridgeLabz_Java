package linkedlist;

import java.util.Scanner;

/*
Doubly Linked List: Library Management System - Complete Implementation

NODE STRUCTURE:
- BookNode:
  bookId (int unique key)
  title (String)
  author (String)
  genre (String)
  available (boolean)
  next (BookNode)
  prev (BookNode)

LIST MAINTENANCE:
- head: first book
- tail: last book
- Doubly linked list allows traversal in BOTH directions

OPERATIONS IMPLEMENTED:
1. addFirst()        → Insert book at beginning O(1)
2. addLast()         → Insert book at end O(1)
3. addAtPosition()   → Insert book at specific position O(n)
4. removeByBookId()  → Delete book by ID O(n)
5. searchByTitle()   → Search book by title O(n)
6. searchByAuthor()  → Search book by author O(n)
7. updateAvailability() → Update availability status O(n)
8. displayForward()  → Traverse from head to tail
9. displayReverse()  → Traverse from tail to head
10.countBooks()      → Count total books O(n)

EDGE CASES HANDLED:
- Empty list
- Single book
- Delete head / tail / middle
- Invalid position
- Book not found

Author: AI Assistant | 2026
*/

// Book node (doubly linked)
class BookNode {

    int bookId;
    String title;
    String author;
    String genre;
    boolean available;

    BookNode next;
    BookNode prev;

    BookNode(int id, String t, String a, String g, boolean avail) {
        bookId = id;
        title = t;
        author = a;
        genre = g;
        available = avail;
        next = prev = null;
    }
}

// Library management class
public class LibraryManagementSystem {

    BookNode head, tail;

    public LibraryManagementSystem() {
        head = tail = null;
    }

    /* ADD BOOK AT BEGINNING O(1) */
    public void addFirst(Scanner sc) {

        System.out.print("Book ID: ");
        int id = sc.nextInt(); sc.nextLine();
        System.out.print("Title: ");
        String t = sc.nextLine();
        System.out.print("Author: ");
        String a = sc.nextLine();
        System.out.print("Genre: ");
        String g = sc.nextLine();
        System.out.print("Available (true/false): ");
        boolean avail = sc.nextBoolean();

        BookNode newNode = new BookNode(id, t, a, g, avail);

        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        System.out.println("Book added at beginning.");
    }

    /* ADD BOOK AT END O(1) */
    public void addLast(Scanner sc) {

        System.out.print("Book ID: ");
        int id = sc.nextInt(); sc.nextLine();
        System.out.print("Title: ");
        String t = sc.nextLine();
        System.out.print("Author: ");
        String a = sc.nextLine();
        System.out.print("Genre: ");
        String g = sc.nextLine();
        System.out.print("Available (true/false): ");
        boolean avail = sc.nextBoolean();

        BookNode newNode = new BookNode(id, t, a, g, avail);

        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        System.out.println("Book added at end.");
    }

    /* ADD BOOK AT POSITION O(n) */
    public void addAtPosition(Scanner sc) {

        System.out.print("Position (1-based): ");
        int pos = sc.nextInt();
        sc.nextLine();

        if (pos < 1) {
            System.out.println("Invalid position!");
            return;
        }

        System.out.print("Book ID: ");
        int id = sc.nextInt(); sc.nextLine();
        System.out.print("Title: ");
        String t = sc.nextLine();
        System.out.print("Author: ");
        String a = sc.nextLine();
        System.out.print("Genre: ");
        String g = sc.nextLine();
        System.out.print("Available (true/false): ");
        boolean avail = sc.nextBoolean();

        BookNode newNode = new BookNode(id, t, a, g, avail);

        if (pos == 1) {
            if (head == null) {
                head = tail = newNode;
            } else {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            }
            return;
        }

        BookNode temp = head;
        int i = 1;

        while (i < pos - 1 && temp != null) {
            temp = temp.next;
            i++;
        }

        if (temp == null) {
            System.out.println("Position out of range!");
            return;
        }

        newNode.next = temp.next;
        newNode.prev = temp;

        if (temp.next != null)
            temp.next.prev = newNode;
        else
            tail = newNode;

        temp.next = newNode;

        System.out.println("Book added at position " + pos);
    }

    /* REMOVE BOOK BY ID O(n) */
    public void removeByBookId(Scanner sc) {

        System.out.print("Enter Book ID to remove: ");
        int id = sc.nextInt();

        BookNode temp = head;

        while (temp != null) {
            if (temp.bookId == id) {

                if (temp == head)
                    head = head.next;

                if (temp == tail)
                    tail = tail.prev;

                if (temp.prev != null)
                    temp.prev.next = temp.next;

                if (temp.next != null)
                    temp.next.prev = temp.prev;

                System.out.println("Book removed.");
                return;
            }
            temp = temp.next;
        }

        System.out.println("Book not found!");
    }

    /* SEARCH BY TITLE */
    public void searchByTitle(Scanner sc) {

        System.out.print("Enter Title: ");
        sc.nextLine();
        String title = sc.nextLine();

        BookNode temp = head;

        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                displayBook(temp);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book not found!");
    }

    /* SEARCH BY AUTHOR */
    public void searchByAuthor(Scanner sc) {

        System.out.print("Enter Author: ");
        sc.nextLine();
        String author = sc.nextLine();

        BookNode temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.author.equalsIgnoreCase(author)) {
                displayBook(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found)
            System.out.println("No books found by this author.");
    }

    /* UPDATE AVAILABILITY */
    public void updateAvailability(Scanner sc) {

        System.out.print("Book ID: ");
        int id = sc.nextInt();
        System.out.print("Available (true/false): ");
        boolean avail = sc.nextBoolean();

        BookNode temp = head;

        while (temp != null) {
            if (temp.bookId == id) {
                temp.available = avail;
                System.out.println("Availability updated.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book not found!");
    }

    /* DISPLAY FORWARD */
    public void displayForward() {

        BookNode temp = head;
        while (temp != null) {
            displayBook(temp);
            temp = temp.next;
        }
    }

    /* DISPLAY REVERSE */
    public void displayReverse() {

        BookNode temp = tail;
        while (temp != null) {
            displayBook(temp);
            temp = temp.prev;
        }
    }

    /* COUNT BOOKS */
    public void countBooks() {

        int count = 0;
        BookNode temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }
        System.out.println("Total Books = " + count);
    }

    // Helper to display a book
    private void displayBook(BookNode b) {
        System.out.println("ID: " + b.bookId +
                " | Title: " + b.title +
                " | Author: " + b.author +
                " | Genre: " + b.genre +
                " | Available: " + b.available);
    }
}
