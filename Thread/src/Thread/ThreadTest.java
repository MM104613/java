package Thread;
//无论使用哪种方式创建线程，启动线程一律使用Thread类提供的start（）方法

//多线程的创建
//1.继承Thread类，而后覆写run（）方法
//一个线程的start（）方法只能被调用一次，执行多次会抛出IllegalThreadStateException

/*class MyThread extends Thread {
    private String title;

    public MyThread(String title) {
        this.title = title;
    }
    public void run() {  //放每个线程的子任务
        for (int i = 0; i < 10; i++) {
            System.out.println(this.title+"、i="+i);
        }
    }
}

public class ThreadTest {
    public static void main(String[] args) {
     MyThread myThread1 = new MyThread("thread1");
     MyThread myThread2 = new MyThread("thread2");
     MyThread myThread3 = new MyThread("thread3");
     myThread1.start();
     myThread2.start();
     myThread3.start();
    }
}*/

class MyThread extends Thread {
    private String title;
    private int ticket = 20;

    public MyThread(String title) {
        this.title = title;
    }

    public void run() {  //放每个线程的子任务
        while (ticket > 0) {
            System.out.println("当前线程为"+title+"，还剩下"+ticket--+"票");
        }
    }
}

public class ThreadTest {
    public static void main(String[] args) {
        MyThread myThread1 = new MyThread("黄牛A");
        MyThread myThread2 = new MyThread("黄牛B");
        MyThread myThread3 = new MyThread("黄牛C");
        myThread1.start();
        myThread2.start();
        myThread3.start();
    }
}