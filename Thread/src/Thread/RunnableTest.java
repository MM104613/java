package Thread;

//线程创建
//2.实现Runnable()接口，而后覆写run()方法
//Java中Tread类本身也实现了runnable接口，与用户自定义的线程类共同组成代理设计模式，其中Tread类实现辅助操作
//包括线程的资源调度等任务，自定义线程完成真实业务
/*
class MyRunnable implements Runnable {
    private String title;

    public MyRunnable(String title) {
        this.title = title;
    }

    @Override
    public void run() { //此方法放每个线程需要执行的任务
        for (int i = 0; i < 10; i++) {
            System.out.println("当前线程为" + title + "，" + i);
        }
    }
}

public class RunnableTest {
    public static void main(String[] args) {
        MyThread mt1 = new MyThread("子线程1");
        MyThread mt2 = new MyThread("子线程2");
        MyThread mt3 = new MyThread("子线程3");
        Thread thread1 = new Thread(mt1);
        Thread thread2 = new Thread(mt2);
        Thread thread3 = new Thread(mt3);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
*/

class MyRunnable implements Runnable {
    private int ticket = 20;

    @Override
    public void run() { //此方法放每个线程需要执行的任务
        while (ticket > 0) {
            System.out.println("当前线程" + Thread.currentThread().getName() + "票");
        }
    }
}

public class RunnableTest {
    public static void main(String[] args) {
        MyThread mt1 = new MyThread("黄牛A");
        // MyThread mt2 = new MyThread("子线程2");
        // MyThread mt3 = new MyThread("子线程3");
        Thread thread1 = new Thread(mt1);
        Thread thread2 = new Thread(mt1);
        Thread thread3 = new Thread(mt1);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

//总结: Thread与Runnable的区别
//1.继承Tread类有单继承局限，相对而言实现Runnable接口更加灵活
// 并且Tread类本身也实现了Runnable接口辅助真实线程类
//2.实现Runnable接口可以更好的实现程序共享的概念（Tread类也可以，稍微麻烦点）