package keywords;

/**
 * The Book class represents a book with static library name, private title and author, and final ISBN.
 * It demonstrates static, private, final keywords, and instanceof operator.
 */
class Book{
    private static String libraryName = "YES YAR YAM Library";

    private String title,author;
    private final int isbn;

    Book(String title, String author, int isbn){
        this.title = title;
        this.author = author;
        this.isbn = isbn;

    }

    // Static method to display the library name
    public static void displayLibraryName(){
        System.out.println("Library Name: " + libraryName);
    }

    // Method to display book details with instanceof check
    public void  displayDetails(){
        if(this instanceof Book) {
            System.out.println("Book Title: " + title);
            System.out.println("Author: " + author);
            System.out.println("ISBN: " + isbn);
        }else{
            System.out.println("Invalid Book object");
        }
    }
}

/**
 * The LibraryManagement class demonstrates library book management using various Java keywords.
 */
public class LibraryManagement {
    public static void main(String[] args){
        Book.displayLibraryName();

        Book b1 = new Book("Harry Potter and the Sorcerer's Stone", "J.K. Rowling", 12345);
        Book b2 = new Book("Three Men in a Boat", "Jerome K. Jerome", 67890);

        b1.displayDetails();
        System.out.println("-------------------");
        b2.displayDetails();

    }
}