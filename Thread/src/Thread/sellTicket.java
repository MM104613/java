package Thread;

class Ticket implements Runnable {
    private int ticket = 20000;

    @Override
    public void run() {
        for (int i = 0; i < 20000; i++) {
            //同步代码块：synchronized(锁的对象){//此处代码在任意一个时刻只能有一个线程进入}
            /*synchronized (this) {
                if (ticket > 0) {
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "还剩下" + ticket-- + "票");
                }
            }*/
             sellTicket();
        }
    }
    //同步方法：直接在方法声明上使用synchronized,此时表示同步方法在任意时刻只能有一个线程进入
     public synchronized void sellTicket(){
            if(ticket > 0){
                System.out.println(Thread.currentThread().getName()+"还剩下"+ticket--+"票");

        }
    }
}

public class sellTicket {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        Thread thread1 = new Thread(ticket, "黄牛A");
        Thread thread2 = new Thread(ticket, "黄牛B");
        Thread thread3 = new Thread(ticket, "黄牛C");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
