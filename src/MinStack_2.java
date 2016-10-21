import java.util.Stack;

/**
 * Created by crainax on 2016/10/20.
 */
public class MinStack_2 {

    private Stack<Integer> mStack;
    private Stack<Integer> mMinStack;

    /**
     * initialize your data structure here.
     */
    public MinStack_2() {
        mStack = new Stack<>();
        mMinStack = new Stack<>();
    }

    public void push(int x) {
        mStack.push(x);

        if (mMinStack.isEmpty() || mMinStack.peek() >= x) {
            mMinStack.push(x);
        }

    }

    public void pop() {
        Integer pop = mStack.pop();
        if (!mMinStack.isEmpty() && mMinStack.peek().equals(pop)) {
            mMinStack.pop();
        }
    }

    public int top() {
        return mStack.peek();
    }

    public int getMin() {
        return mMinStack.peek();
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

}
