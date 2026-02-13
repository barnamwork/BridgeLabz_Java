package linkedlist;

/*
Singly Linked List: Inventory Management System - Complete Implementation

This standalone Java class implements a FULL singly linked list
to manage inventory items.

NODE STRUCTURE:
- ItemNode:
  itemId (int unique key)
  itemName (String)
  quantity (int)
  price (double)
  next (ItemNode)

LIST MAINTENANCE:
- head: first item (null = empty)
- Singly linked list (only next pointer)
- Insertions adjust next pointers carefully
- Deletions bypass target node using prev.next
- Traversal using while(temp != null)

FULL OPERATIONS IMPLEMENTED (menu-driven Scanner):
1. addFirst()            → Insert item at beginning O(1)
2. addLast()             → Insert item at end O(n)
3. addAtPosition()       → Insert at given position O(n)
4. removeByItemId()      → Delete item by ID O(n)
5. updateQuantity()      → Modify quantity by ID O(n)
6. searchByIdOrName()    → Search item by ID or Name O(n)
7. calculateTotalValue() → Sum(price * quantity) O(n)
8. sortByName()          → Sort inventory by name (asc/desc)
9. sortByPrice()         → Sort inventory by price (asc/desc)
10.displayAll()          → Display all items

EDGE CASES HANDLED:
- Empty list
- Single node list
- Invalid position
- Item not found
- Sorting empty / single list

Sorting Method:
- Bubble sort–style swapping of node DATA
- (Simpler & safer for singly linked list in exams)

Author: AI Assistant | Date: 2026 | Java Data Structures
*/

import java.util.Scanner;

// Node class representing one inventory item
class ItemNode {

    int itemId;          // Unique item identifier
    String itemName;     // Name of item
    int quantity;        // Quantity available
    double price;        // Price per unit
    ItemNode next;       // Pointer to next item

    // Constructor initializes item data
    ItemNode(int id, String name, int qty, double price) {
        this.itemId = id;
        this.itemName = name;
        this.quantity = qty;
        this.price = price;
        this.next = null;
    }
}

// Inventory management using singly linked list
public class InventoryManagementSystem {

    ItemNode head;   // Head of the linked list

    // Constructor initializes empty list
    public InventoryManagementSystem() {
        head = null;
    }

    /*
     * 1. ADD FIRST: Insert item at beginning O(1)
     * - newNode.next = head
     * - head = newNode
     */
    public void addFirst(Scanner sc) {

        System.out.print("Item ID: ");
        int id = sc.nextInt(); sc.nextLine();
        System.out.print("Item Name: ");
        String name = sc.nextLine();
        System.out.print("Quantity: ");
        int qty = sc.nextInt();
        System.out.print("Price: ");
        double price = sc.nextDouble();

        ItemNode newNode = new ItemNode(id, name, qty, price);
        newNode.next = head;
        head = newNode;

        System.out.println("Item added at beginning.");
    }

    /*
     * 2. ADD LAST: Insert item at end O(n)
     * - Traverse to last node
     * - last.next = newNode
     */
    public void addLast(Scanner sc) {

        System.out.print("Item ID: ");
        int id = sc.nextInt(); sc.nextLine();
        System.out.print("Item Name: ");
        String name = sc.nextLine();
        System.out.print("Quantity: ");
        int qty = sc.nextInt();
        System.out.print("Price: ");
        double price = sc.nextDouble();

        ItemNode newNode = new ItemNode(id, name, qty, price);

        if (head == null) {   // Empty list
            head = newNode;
        } else {
            ItemNode temp = head;
            while (temp.next != null) { // Move to last
                temp = temp.next;
            }
            temp.next = newNode;
        }
        System.out.println("Item added at end.");
    }

    /*
     * 3. ADD AT POSITION: Insert at given position O(n)
     * - Position is 1-based
     * - pos=1 → addFirst
     */
    public void addAtPosition(Scanner sc) {

        System.out.print("Position (1-based): ");
        int pos = sc.nextInt();

        if (pos < 1) {
            System.out.println("Invalid position!");
            return;
        }

        System.out.print("Item ID: ");
        int id = sc.nextInt(); sc.nextLine();
        System.out.print("Item Name: ");
        String name = sc.nextLine();
        System.out.print("Quantity: ");
        int qty = sc.nextInt();
        System.out.print("Price: ");
        double price = sc.nextDouble();

        ItemNode newNode = new ItemNode(id, name, qty, price);

        if (pos == 1) {               // Insert at beginning
            newNode.next = head;
            head = newNode;
            return;
        }

        ItemNode temp = head;
        int i = 1;

        // Traverse to (pos-1)
        while (i < pos - 1 && temp != null) {
            temp = temp.next;
            i++;
        }

        if (temp == null) {
            System.out.println("Position out of range!");
            return;
        }

        newNode.next = temp.next;
        temp.next = newNode;

        System.out.println("Item added at position " + pos + ".");
    }

    /*
     * 4. REMOVE BY ITEM ID: Delete first match O(n)
     */
    public void removeByItemId(Scanner sc) {

        System.out.print("Enter Item ID to remove: ");
        int id = sc.nextInt();

        if (head == null) {
            System.out.println("Inventory is empty!");
            return;
        }

        if (head.itemId == id) {   // Remove head
            head = head.next;
            System.out.println("Item removed.");
            return;
        }

        ItemNode temp = head;

        while (temp.next != null && temp.next.itemId != id) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Item not found!");
        } else {
            temp.next = temp.next.next;
            System.out.println("Item removed.");
        }
    }

    /*
     * 5. UPDATE QUANTITY BY ITEM ID O(n)
     */
    public void updateQuantity(Scanner sc) {

        System.out.print("Item ID: ");
        int id = sc.nextInt();
        System.out.print("New Quantity: ");
        int qty = sc.nextInt();

        ItemNode temp = head;

        while (temp != null) {
            if (temp.itemId == id) {
                temp.quantity = qty;
                System.out.println("Quantity updated.");
                return;
            }
            temp = temp.next;
        }

        System.out.println("Item not found!");
    }

    /*
     * 6. SEARCH BY ITEM ID OR NAME O(n)
     */
    public void searchByIdOrName(Scanner sc) {

        System.out.print("Enter Item ID (or -1 to skip): ");
        int id = sc.nextInt(); sc.nextLine();
        System.out.print("Enter Item Name (or empty to skip): ");
        String name = sc.nextLine();

        ItemNode temp = head;

        while (temp != null) {
            if ((id != -1 && temp.itemId == id) ||
                    (!name.isEmpty() && temp.itemName.equalsIgnoreCase(name))) {
                displayItem(temp);
                return;
            }
            temp = temp.next;
        }

        System.out.println("Item not found!");
    }

    /*
     * 7. CALCULATE TOTAL INVENTORY VALUE O(n)
     * Formula: sum(price * quantity)
     */
    public void calculateTotalValue() {

        double total = 0;
        ItemNode temp = head;

        while (temp != null) {
            total += temp.price * temp.quantity;
            temp = temp.next;
        }

        System.out.println("Total Inventory Value = " + total);
    }

    /*
     * 8. SORT BY ITEM NAME (ASC / DESC)
     * - Bubble sort logic
     * - Swaps DATA, not nodes
     */
    public void sortByName(boolean ascending) {

        if (head == null || head.next == null) return;

        for (ItemNode i = head; i.next != null; i = i.next) {
            for (ItemNode j = i.next; j != null; j = j.next) {
                if ((ascending && i.itemName.compareToIgnoreCase(j.itemName) > 0) ||
                        (!ascending && i.itemName.compareToIgnoreCase(j.itemName) < 0)) {
                    swapData(i, j);
                }
            }
        }
        System.out.println("Sorted by name.");
    }

    /*
     * 9. SORT BY PRICE (ASC / DESC)
     */
    public void sortByPrice(boolean ascending) {

        if (head == null || head.next == null) return;

        for (ItemNode i = head; i.next != null; i = i.next) {
            for (ItemNode j = i.next; j != null; j = j.next) {
                if ((ascending && i.price > j.price) ||
                        (!ascending && i.price < j.price)) {
                    swapData(i, j);
                }
            }
        }
        System.out.println("Sorted by price.");
    }

    // Helper: swap item data
    private void swapData(ItemNode a, ItemNode b) {
        int id = a.itemId; a.itemId = b.itemId; b.itemId = id;
        String name = a.itemName; a.itemName = b.itemName; b.itemName = name;
        int qty = a.quantity; a.quantity = b.quantity; b.quantity = qty;
        double price = a.price; a.price = b.price; b.price = price;
    }

    /*
     * 10. DISPLAY ALL ITEMS O(n)
     */
    public void displayAll() {

        if (head == null) {
            System.out.println("Inventory empty!");
            return;
        }

        ItemNode temp = head;
        while (temp != null) {
            displayItem(temp);
            temp = temp.next;
        }
    }

    // Display single item
    private void displayItem(ItemNode item) {
        System.out.println("ID: " + item.itemId +
                " | Name: " + item.itemName +
                " | Qty: " + item.quantity +
                " | Price: " + item.price);
    }

    // MAIN: Menu-driven execution
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        InventoryManagementSystem inv = new InventoryManagementSystem();
        int choice;

        do {
            System.out.println("\n1.Add First 2.Add Last 3.Add Position");
            System.out.println("4.Remove ID 5.Update Qty 6.Search");
            System.out.println("7.Total Value 8.Sort Name 9.Sort Price");
            System.out.println("10.Display All 0.Exit");
            System.out.print("Choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: inv.addFirst(sc); break;
                case 2: inv.addLast(sc); break;
                case 3: inv.addAtPosition(sc); break;
                case 4: inv.removeByItemId(sc); break;
                case 5: inv.updateQuantity(sc); break;
                case 6: inv.searchByIdOrName(sc); break;
                case 7: inv.calculateTotalValue(); break;
                case 8: inv.sortByName(true); break;
                case 9: inv.sortByPrice(true); break;
                case 10: inv.displayAll(); break;
                case 0: System.out.println("Exiting Inventory System"); break;
                default: System.out.println("Invalid choice!");
            }
        } while (choice != 0);

        sc.close();
    }
}
/* END - Inventory Management System using Singly Linked List */
