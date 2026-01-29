package level1;

// This class stores book details and displays them using a method

class DisplayBookDetails {

    String title;
    String author;
    double price;

    void display() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
    }

    public static void main(String[] args) {
        DisplayBookDetails b = new DisplayBookDetails();

        b.title = "Java Basics";
        b.author = "James";
        b.price = 299;

        b.display();
    }
}


