package Level1;

import java.util.Scanner;

// Hotel booking using default, parameterized and copy constructors with Scanner

class HotelBooking {

    private String guestName;
    private String roomType;
    private int nights;

    HotelBooking() {
        guestName = "Guest";
        roomType = "Standard";
        nights = 1;
    }

    HotelBooking(String guestName, String roomType, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }

    HotelBooking(HotelBooking hb) {
        this.guestName = hb.guestName;
        this.roomType = hb.roomType;
        this.nights = hb.nights;
    }

    void display() {
        System.out.println(guestName + " | " + roomType + " | " + nights);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Guest Name: ");
        String g = sc.nextLine();
        System.out.print("Room Type: ");
        String r = sc.nextLine();
        System.out.print("Nights: ");
        int n = sc.nextInt();

        HotelBooking b1 = new HotelBooking(g, r, n);
        HotelBooking b2 = new HotelBooking(b1);

        b1.display();
        b2.display();
    }
}

