package stackqueuehashmap;
/*
Custom HashMap using Separate Chaining.

Collision handling:
- Each index stores a linked list of nodes
*/
class MyHashMap {

    // Node for linked list
    class Node {
        int key, value;
        Node next;

        Node(int k, int v) {
            key = k;
            value = v;
            next = null;
        }
    }

    // Fixed size hash table
    private final int SIZE = 10;
    private Node[] table = new Node[SIZE];

    // Hash function: converts key into index
    private int hash(int key) {
        return key % SIZE;
    }

    // Insert or update key-value pair
    public void put(int key, int value) {

        int index = hash(key);

        // If bucket empty, insert directly
        if (table[index] == null) {
            table[index] = new Node(key, value);
            return;
        }

        Node curr = table[index];

        // Traverse linked list
        while (curr != null) {

            // If key exists, update value
            if (curr.key == key) {
                curr.value = value;
                return;
            }

            // Move to next node
            if (curr.next == null)
                break;

            curr = curr.next;
        }

        // Add new node at end
        curr.next = new Node(key, value);
    }

    // Retrieve value using key
    public Integer get(int key) {

        int index = hash(key);
        Node curr = table[index];

        while (curr != null) {
            if (curr.key == key)
                return curr.value;
            curr = curr.next;
        }

        return null; // key not found
    }

    // Remove key from map
    public void remove(int key) {

        int index = hash(key);
        Node curr = table[index], prev = null;

        while (curr != null) {

            if (curr.key == key) {

                // Removing first node
                if (prev == null)
                    table[index] = curr.next;
                else
                    prev.next = curr.next;

                return;
            }

            prev = curr;
            curr = curr.next;
        }
    }
}

