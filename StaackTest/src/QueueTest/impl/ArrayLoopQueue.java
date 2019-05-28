package QueueTest.impl;
import QueueTest.Queue;
//基于数组的环形队列
public class ArrayLoopQueue<E> implements Queue<E> {
    private Object[] elements;//存放元素的数组
    private int tail; //尾指针
    private int head;//头指针
    private int size;//队列当前个数
    private int maxSize;//数组最大值

    public ArrayLoopQueue(int maxSize) {
        this.maxSize = maxSize;
        elements = new Object[maxSize+1];
    }

    @Override
    public void enQueue(E e) {
        if((tail+1)%elements.length == head){
            System.out.println("栈已满");
            throw new ArrayIndexOutOfBoundsException();
        }
        elements[tail] = e;
        tail = (tail+1)%elements.length;
        size++;
    }

    @Override
    public E deQueue() {
        if(isEmpty()){
            System.out.println("栈已为空");
            throw new NullPointerException();
        }
        E result = (E) elements[head];
        head= (head+1)%elements.length;
        size--;
        return result;

    }

    @Override
    public E peek() {
        if(isEmpty()){
            System.out.println("栈已为空");
            throw new NullPointerException();
        }
        return (E) elements[head];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return tail == head;
    }
}
