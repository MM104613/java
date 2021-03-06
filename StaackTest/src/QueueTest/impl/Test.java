package QueueTest.impl;

import QueueTest.Queue;

public class Test {
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayLoopQueue<>(5);
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);
        queue.enQueue(5);
        System.out.println(queue.deQueue());
        System.out.println(queue.getSize());
        queue.enQueue(6);
        System.out.println(queue.getSize());
        System.out.println(queue.deQueue());
        System.out.println(queue.peek());
        System.out.println(queue.getSize());
    }
}
