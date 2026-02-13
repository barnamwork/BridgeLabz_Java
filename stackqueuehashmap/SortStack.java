package stackqueuehashmap;
import java.util.Stack;

/*
Sort a stack using recursion (ascending order).
No extra data structures allowed.
*/
class SortStackRecursively {

    // Main sort function
    static void sortStack(Stack<Integer> stack) {

        // Base case: stack empty
        if (stack.isEmpty())
            return;

        // Remove top element
        int top = stack.pop();

        // Sort remaining stack
        sortStack(stack);

        // Insert element at correct position
        insertSorted(stack, top);
    }

    // Insert element in sorted stack
    static void insertSorted(Stack<Integer> stack, int x) {

        // If stack empty or top <= x, push x
        if (stack.isEmpty() || stack.peek() <= x) {
            stack.push(x);
            return;
        }

        // Otherwise remove top and recur
        int temp = stack.pop();
        insertSorted(stack, x);

        // Push removed element back
        stack.push(temp);
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(3);
        st.push(1);
        st.push(4);
        st.push(2);

        sortStack(st);

        System.out.println(st); // [1, 2, 3, 4]
    }
}

