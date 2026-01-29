package accessmodifiers;

import java.util.Scanner;

class Book {

    public String ISBN;        // public
    protected String title;    // protected
    private String author;     // private

    // public methods for private author
    public void setAuthor(String a) {
        author = a;
    }

    public String getAuthor() {
        return author;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        EBook e = new EBook();

        System.out.print("ISBN: ");
        e.ISBN = sc.nextLine();

        System.out.print("Title: ");
        e.title = sc.nextLine();

        System.out.print("Author: ");
        String a = sc.nextLine();
        e.setAuthor(a);

        e.display();
        System.out.println("Author: " + e.getAuthor());
    }
}

class EBook extends Book {

    void display() {
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
    }
}

