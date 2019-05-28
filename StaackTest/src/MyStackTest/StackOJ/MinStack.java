package MyStackTest.StackOJ;
//双栈
import java.util.Stack;

public class MinStack {
    Stack<Integer> mainStack = new Stack<>();
    Stack<Integer> tempStack = new Stack<>();

    void push(int x) {
        mainStack.push(x);
        if(tempStack.isEmpty()){
            tempStack.push(x);
        }else if(x < tempStack.peek()){
            tempStack.push(x);
        }
    }

    void pop() {

        if(tempStack.peek().equals(mainStack.peek())){
            tempStack.pop();
        }
        mainStack.pop();
    }

    int top() {
        return mainStack.peek();
    }

    int getMin() {
        return tempStack.peek();
    }

}
