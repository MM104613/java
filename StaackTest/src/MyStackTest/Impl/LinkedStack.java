package MyStackTest.Impl;
import MyStackTest.Stack;

public class LinkedStack<T> implements Stack<T> {
    private Node top;//栈顶
    private int currentSize;//栈的大小
    public class Node{
        private T t;//数据
        private Node next;//下一个节点
        public Node(T t, Node next) {
            this.t = t;
            this.next = next;
        }
    }
    @Override
    public boolean push(T t) {
       //创建新节点
        Node newNode = new Node(t,null);
        if(top == null){ //判断栈顶是否为空
            top = newNode;
        }else{
            newNode.next = top;
            top = newNode;
        }
        currentSize ++;
        return true;
    }

    @Override
    public T pop() {
        if(isEmpty()){
            System.out.println("栈已为空");
        }
         T result = top.t;
         top= top.next;
        return result;
    }

    @Override
    public T peek() {
        if(isEmpty()){
            System.out.println("栈已为空");
        }
        return top.t;
    }

    @Override
    public int getSize() {
        return currentSize;
    }

    @Override
    public boolean isEmpty() {
        return currentSize==0;
    }
}
