package stackqueuehashmap;
import java.util.Stack;

/*
Queue implementation using two stacks.

enqueue(x):
- Push element into stackEnq

dequeue():
- If stackDeq is empty:
    - Move all elements from stackEnq to stackDeq
- Pop from stackDeq
*/
class QueueUsingStacks {

    Stack<Integer> stackEnq = new Stack<>();
    Stack<Integer> stackDeq = new Stack<>();

    // Enqueue operation
    void enqueue(int x) {
        stackEnq.push(x);
    }

    // Dequeue operation
    int dequeue() {

        // If both stacks are empty → queue is empty
        if (stackEnq.isEmpty() && stackDeq.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        // Transfer elements only when stackDeq is empty
        if (stackDeq.isEmpty()) {
            while (!stackEnq.isEmpty()) {
                stackDeq.push(stackEnq.pop());
            }
        }

        return stackDeq.pop();
    }

    public static void main(String[] args) {
        QueueUsingStacks q = new QueueUsingStacks();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        System.out.println(q.dequeue()); // 10
        System.out.println(q.dequeue()); // 20
    }
}

