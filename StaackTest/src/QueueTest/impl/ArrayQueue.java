package QueueTest.impl;

import QueueTest.Queue;

public class ArrayQueue<E> implements Queue<E> {
    private Object[] elements; // 存放元素的数组
    private int maxSize; //最大值
    private int tail;
    private int head;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        elements = new Object[maxSize];
    }

    @Override
    public void enQueue(E e) {
        //判断队伍是否已满
        if (tail == maxSize) {
            if (head == 0) {
                System.out.println("队列已满");
                throw new ArrayIndexOutOfBoundsException();
            }else{  //数据的搬移
                for(int i = head; i<tail; i ++){
                    elements[i - head ] = elements[i];
                }
                //更新头尾指针
                tail = tail - head;
                head = 0;
            }
        }
        elements[tail++] = e;
    }

    @Override
    public E deQueue() {
        if (head == tail) {
            System.out.println("队列已为空");
            throw new NullPointerException();
        }
        E result = (E) elements[head++];
        return result;
    }

    @Override
    public E peek() {
        if (head == tail) {
            System.out.println("队列已为空");
            throw new NullPointerException();
        }
        E result = (E) elements[head];
        return result;
    }

    @Override
    public int getSize() {
        return tail - head;
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }
}
