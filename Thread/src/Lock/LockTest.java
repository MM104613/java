package Lock; //LOCK是个接口 必须有子类
/**
Lock-JDK1.5-基于Java语言层面实现的线程“锁”
产生背景:死锁
 破坏不可抢占：lock接口下的三个重要方法
1.响应中断： void lockInterruptibly()
2.支持超时： boolean tryLock(Long time , TimeUnit unit)
3.非阻塞式获取锁 线程若获取不到锁，线程直接退出 boolean tryLock()
 lock体系使用格式
 try{
  //加锁  lock.lock();
 }finally{
 //解锁  lock.unlock();
 }

Condition:Lock体系的线程通信方式，类比Object wait与notify

 await():释放lock锁，将线程置入等待队列阻塞
 signal():随机唤醒一个处于等待状态的线程
 signalAll():唤醒所有等待线程
 */
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Task implements Runnable{
    private int ticket =1000;
    private Lock ticketLock = new ReentrantLock();
    @Override
    public void run() {
    for(int i = 0 ;i< 1000 ;i++ ){
       //需要上锁
        try{
            //等同于synchronized(this)
            ticketLock.lock();
            if(ticket > 0){
                System.out.println(Thread.currentThread().getName()+"还剩下"+ticket--+"票");
            }
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        finally {
             ticketLock.unlock();
        }
    }
    }
}
public class LockTest {
    public static void main(String[] args) {
         Task task = new Task();
         Thread thread1 = new Thread(task);
         Thread thread2 = new Thread(task);
         Thread thread3 = new Thread(task);
         thread1.start();
         thread2.start();
         thread3.start();
    }
}
