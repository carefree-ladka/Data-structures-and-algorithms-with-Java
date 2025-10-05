package DSA.Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {

    private record Node(int val, int min) {
    }

    private final Deque<Node> stack = new ArrayDeque<>();

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(new Node(val, val));
        } else {
            int currentMin = Math.min(val, stack.peek().min());
            stack.push(new Node(val, currentMin));
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().val();
    }

    public int getMin() {
        return stack.peek() != null ? stack.peek().min() : 0;
    }

    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(-2);
        obj.push(0);
        obj.push(-3);
        System.out.println(obj.getMin()); // -3
        obj.pop();
        System.out.println(obj.top());    // 0
        System.out.println(obj.getMin()); // -2
    }
}
