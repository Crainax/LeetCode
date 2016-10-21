import annotation.TimeOut;

/**
 * Created by crainax on 2016/10/20.
 */
@TimeOut
public class MinStack {

    private Node root;

    private class Node {
        int value;
        Node next;

        Node() {
            this(0);
        }

        Node(int value) {
            this.value = value;
        }

        Node getNext() {
            return next;
        }

        void setNext(Node next) {
            this.next = next;
        }

        int getValue() {
            return value;
        }

        void setValue(int value) {
            this.value = value;
        }
    }

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        root = new Node();
    }

    public void push(int x) {
        Node node = new Node(x);

        Node last = root;
        while (last.getNext() != null) {
            last = last.getNext();
        }
        last.setNext(node);
    }

    public void pop() {
        if (root.getNext() == null) {
            throw new IllegalStateException("Stack has not any element.");
        }

        Node last = root;
        while (last.getNext().getNext() != null) {
            last = last.getNext();
        }
        last.setNext(null);
    }

    public int top() {
        if (root.getNext() == null) {
            throw new IllegalStateException("Stack has not any element.");
        }

        Node last = root;
        while (last.getNext() != null) {
            last = last.getNext();
        }
        return last.getValue();
    }

    public int getMin() {

        Node first = root.getNext();
        if (first == null) {
            throw new IllegalStateException("Stack has not any element.");
        }

        int min = first.getValue();
        for (Node node = first; node != null; node = node.getNext()) {
            int value = node.getValue();
            min = (value > min) ? min : value;
        }

        return min;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin();
        minStack.pop();
        minStack.top();
        minStack.getMin();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
