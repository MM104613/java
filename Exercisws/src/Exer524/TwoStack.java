package Exer524;

import java.util.Stack;

public class TwoStack {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.isEmpty()) {
            for (int i = 0; i < stack1.size() - 1; i++) {
                stack2.push(stack1.pop());
            }
           return  stack1.pop();
        } else {
           return  stack2.pop();
        }
    }

}
