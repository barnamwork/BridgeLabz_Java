package objectModelingClassDiagram;

/*
 * LibraryAggregation
 * ----------------------
 * This program demonstrates Aggregation.
 * A Library contains multiple Book objects.
 * Books can exist independently of a Library.
 */

import java.util.ArrayList;

/* Book class represents a book entity */
class Book {

    // Title of the book
    private String title;

    // Author of the book
    private String author;

    // Constructor to initialize book details
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // Returns book title
    public String getTitle() {
        return title;
    }

    // Returns book author
    public String getAuthor() {
        return author;
    }
}

/* Library class aggregates Book objects */
class Library {

    // Name of the library
    private String name;

    // List of books (Aggregation)
    private ArrayList<Book> books = new ArrayList<>();

    // Constructor to initialize library name
    public Library(String name) {
        this.name = name;
    }

    // Adds a book to the library
    public void addBook(Book book) {
        books.add(book);
    }

    // Displays all books in the library
    public void showBooks() {
        System.out.println("Library: " + name);
        for (Book book : books) {
            System.out.println(book.getTitle() + " by " + book.getAuthor());
        }
    }
}

/* Main class to run the program */
public class LibraryAggregation{

    public static void main(String[] args) {

        // Creating book objects independently
        Book b1 = new Book("Java Basics", "James Gosling");
        Book b2 = new Book("OOP Concepts", "Robert Martin");

        // Creating library objects
        Library lib1 = new Library("City Library");
        Library lib2 = new Library("College Library");

        // Adding books to libraries
        lib1.addBook(b1);
        lib2.addBook(b1);
        lib2.addBook(b2);

        // Displaying books
        lib1.showBooks();
        lib2.showBooks();
    }
}
