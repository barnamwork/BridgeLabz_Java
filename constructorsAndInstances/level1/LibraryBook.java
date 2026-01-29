package Level1;

import java.util.Scanner;

// Library book system with borrow logic using Scanner

class LibraryBook {

    private String title;
    private String author;
    private double price;
    private boolean available = true;

    LibraryBook(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    void borrowBook() {
        if (available) {
            available = false;
            System.out.println("Book borrowed");
        } else {
            System.out.println("Book not available");
        }
    }

    void display() {
        System.out.println(title + " | " + author + " | " + price + " | Available: " + available);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Title: ");
        String t = sc.nextLine();
        System.out.print("Author: ");
        String a = sc.nextLine();
        System.out.print("Price: ");
        double p = sc.nextDouble();

        LibraryBook b = new LibraryBook(t, a, p);
        b.display();
        b.borrowBook();
        b.display();
    }
}

