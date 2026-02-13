package linkedlist;

/*
Circular Linked List: Online Ticket Reservation System
-----------------------------------------------------

This program implements an Online Ticket Reservation System
using a Circular Singly Linked List.

WHY CIRCULAR LINKED LIST?
- Ticket reservations are processed in a continuous cycle
- After the last ticket, traversal returns to the first ticket
- Circular linked list avoids NULL checks during traversal

NODE STRUCTURE:
TicketNode
- ticketId        : Unique ticket identifier
- customerName    : Name of customer
- movieName       : Movie booked
- seatNumber      : Seat number
- bookingTime     : Time of booking
- next            : Points to next ticket (circular)

LIST PROPERTY:
- head points to the first ticket
- last node's next ALWAYS points to head
- No node ever points to null

OPERATIONS IMPLEMENTED:
1. bookTicket()      → Add new ticket at end O(n)
2. cancelTicket()    → Remove ticket by ID O(n)
3. displayTickets()  → Display all tickets O(n)
4. countTickets()    → Count total booked tickets O(n)

EDGE CASES HANDLED:
- Empty list
- Single ticket
- Deleting head
- Deleting middle or last ticket
- Ticket not found

Author: AI Assistant | 2026 | Java Data Structures
*/

// ======================= TICKET NODE =======================
class TicketNode {

    int ticketId;           // Unique ticket ID
    String customerName;    // Customer name
    String movieName;       // Movie name
    String seatNumber;      // Seat number
    String bookingTime;     // Booking time
    TicketNode next;        // Next ticket (circular link)

    /*
    Constructor initializes ticket details.
    next is set to null initially.
    */
    TicketNode(int id, String cust, String movie, String seat, String time) {
        ticketId = id;
        customerName = cust;
        movieName = movie;
        seatNumber = seat;
        bookingTime = time;
        next = null;
    }
}

// ======================= TICKET RESERVATION SYSTEM =======================
public class TicketReservationSystem {

    TicketNode head;    // Head of circular linked list

    // Constructor initializes empty list
    public TicketReservationSystem() {
        head = null;
    }

    /*
     * 1. BOOK TICKET (ADD AT END) O(n)
     *
     * Steps:
     * 1. If list is empty:
     *    - head = newTicket
     *    - newTicket.next = head (self-loop)
     * 2. Else:
     *    - Traverse to last node
     *    - last.next = newTicket
     *    - newTicket.next = head
     */
    public void bookTicket(TicketNode newTicket) {

        // Case 1: Empty list
        if (head == null) {
            head = newTicket;
            newTicket.next = head;   // Circular link
            System.out.println("Ticket booked successfully.");
            return;
        }

        // Case 2: Non-empty list → find last node
        TicketNode temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }

        // Insert ticket at end
        temp.next = newTicket;
        newTicket.next = head;

        System.out.println("Ticket booked successfully.");
    }

    /*
     * 2. CANCEL TICKET BY TICKET ID O(n)
     *
     * Steps:
     * 1. If list is empty → nothing to delete
     * 2. Traverse circular list using do-while
     * 3. If only one node exists:
     *    - head = null
     * 4. If deleting head:
     *    - Move head to next
     *    - Fix last node's next pointer
     * 5. If deleting middle/last:
     *    - prev.next = current.next
     */
    public void cancelTicket(int id) {

        // If list is empty
        if (head == null) {
            System.out.println("No tickets to cancel.");
            return;
        }

        TicketNode current = head;
        TicketNode prev = null;

        do {
            // Check if ticket ID matches
            if (current.ticketId == id) {

                // Case 1: Only one ticket
                if (current == head && current.next == head) {
                    head = null;
                }

                // Case 2: More than one ticket
                else {

                    // If deleting head ticket
                    if (current == head) {
                        TicketNode last = head;
                        while (last.next != head) {
                            last = last.next;
                        }
                        head = head.next;
                        last.next = head;
                    }
                    // Deleting middle or last ticket
                    else {
                        prev.next = current.next;
                    }
                }

                System.out.println("Ticket ID " + id + " cancelled.");
                return;
            }

            prev = current;
            current = current.next;

        } while (current != head);

        // Ticket ID not found
        System.out.println("Ticket ID " + id + " not found.");
    }

    /*
     * 3. DISPLAY ALL TICKETS O(n)
     *
     * Traversal:
     * - Start from head
     * - Continue until head is reached again
     */
    public void displayTickets() {

        // If list is empty
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        TicketNode temp = head;

        System.out.println("\n=== BOOKED TICKETS ===");

        do {
            System.out.println("Ticket ID    : " + temp.ticketId);
            System.out.println("Customer     : " + temp.customerName);
            System.out.println("Movie        : " + temp.movieName);
            System.out.println("Seat Number  : " + temp.seatNumber);
            System.out.println("Booking Time : " + temp.bookingTime);
            System.out.println("---------------------------");

            temp = temp.next;

        } while (temp != head);
    }

    /*
     * 4. COUNT TOTAL TICKETS O(n)
     *
     * Counts number of nodes in circular list.
     */
    public int countTickets() {

        // If list is empty
        if (head == null)
            return 0;

        int count = 0;
        TicketNode temp = head;

        do {
            count++;
            temp = temp.next;
        } while (temp != head);

        return count;
    }

    // ======================= MAIN METHOD (TESTING) =======================
    public static void main(String[] args) {

        TicketReservationSystem trs = new TicketReservationSystem();

        // Sample bookings
        trs.bookTicket(new TicketNode(101, "Amit", "Inception", "A1", "10:00 AM"));
        trs.bookTicket(new TicketNode(102, "Neha", "Avatar", "B3", "10:05 AM"));
        trs.bookTicket(new TicketNode(103, "Rahul", "Interstellar", "C2", "10:10 AM"));

        // Display tickets
        trs.displayTickets();

        // Cancel a ticket
        trs.cancelTicket(102);

        // Display after cancellation
        trs.displayTickets();

        // Count tickets
        System.out.println("Total Tickets Booked = " + trs.countTickets());
    }
}

/*
END OF ONLINE TICKET RESERVATION SYSTEM
This implementation is suitable for:
- Data Structures exams
- Circular Linked List practice
- Interview explanations
*/
