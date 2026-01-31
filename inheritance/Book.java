package inheritance;

public class Book {
    String title;
    int publicationYear;

    Book(String title, int publicationYear){
        this.title = title;
        this.publicationYear=publicationYear;
    }

    void displayInfo(){
        System.out.println("The name of the book is " + title + " and ");
        System.out.println("The published year is " +  publicationYear);
    }

    static void main() {
        Book b = new Book("Java Book", 1995);
        Author a = new Author("Monkey tricks", 2026, "Gyandu Singh", "Hey This is your author who wrote moneky tricks , I hope you would like it fellas");
        a.displayInfo();
        b.displayInfo();
    }
}
class Author extends Book {
    String name;
    String bio;

    Author(String title, int publicationYear, String name, String bio) {
        super(title, publicationYear);
        this.name=name;
        this.bio=bio;
    }

    void displayInfo(){
        super.displayInfo();
        System.out.println("The name of the author is " +name);
        System.out.println("The bio of the author is " + bio);
        System.out.println();
}
}