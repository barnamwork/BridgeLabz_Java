package level2;

// This class handles movie ticket booking using constructor and displays ticket details

class BookMovieTicket {

    String movieName;
    int seatNumber;
    double price;

    // Parameterized Constructor
    BookMovieTicket(String movieName, int seatNumber, double price) {
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.price = price;
    }

    void display() {
        System.out.println("Movie: " + movieName);
        System.out.println("Seat No: " + seatNumber);
        System.out.println("Price: " + price);
    }

    public static void main(String[] args) {
        BookMovieTicket t = new BookMovieTicket("Avengers", 15, 250);
        t.display();
    }
}

