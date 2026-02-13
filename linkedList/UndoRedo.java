package linkedlist;

/*
Doubly Linked List: Undo / Redo Text Editor - Complete Implementation

IDEA:
Each node stores a version (state) of text.
- prev → Undo
- next → Redo
- current → current state

LIMIT:
History limited to last N states.
*/

class TextState {
    String content;
    TextState prev, next;

    TextState(String text) {
        content = text;
        prev = next = null;
    }
}

public class UndoRedo {

    TextState head, current;
    int size = 0;
    final int LIMIT = 10;

    /* ADD NEW STATE */
    public void addState(String text) {

        TextState newState = new TextState(text);

        if (head == null) {
            head = current = newState;
            size++;
            return;
        }

        // Remove redo history
        current.next = null;

        newState.prev = current;
        current.next = newState;
        current = newState;
        size++;

        // Maintain size limit
        if (size > LIMIT) {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    /* UNDO */
    public void undo() {
        if (current != null && current.prev != null)
            current = current.prev;
    }

    /* REDO */
    public void redo() {
        if (current != null && current.next != null)
            current = current.next;
    }

    /* DISPLAY CURRENT STATE */
    public void display() {
        if (current != null)
            System.out.println("Current Text: " + current.content);
    }
}
