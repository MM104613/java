package MyStackTest.Impl;

import MyStackTest.Stack;

public class Test {
    public static void main(String[] args) {
        Stack<Integer> stack = new ArrayStack<>(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.getSize());


    }
}
