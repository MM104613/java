package Lock;
/*面试：Java中实现线程""锁的方式：synchronized 与 Lock
synchronized 与 Lock的关系
1.都是对象锁，都支持可重入锁
2.Lock可以实现synchronized不具备的特性，如响应中断，支持超时，非阻塞的获取锁，公平锁，共享锁（读写锁，ReentrantReadWriterLock）
      读写锁-共享锁的一种实现
      读锁共享：多个线程可以同时拿到读锁进行访问，当线程拿到写锁开始工作时，所有读线程全部阻塞
      写锁独占：任意一个时刻，只有一个线程可以拿到写锁
   读读-不互斥
   读写、写写-互斥
3.Lock体系的Condition队列可以有多个（区分于synchronized只有一个等待队列）
 可以进一步提高效率，减少线程阻塞与唤醒带来的开销（唤醒了不该唤醒的线程）
  获取一个lock锁的condition队列  lock.condition():产生一个新的的Condition队列
4.到底用synchronized还是Lock?
  1.若无特殊的应用场景，推荐使用synchronized，其使用方便(隐式的加减锁)，并且由于synchronized是JVM层面的实现，在之后的JDK
    还有对其优化的空间
  2.若要使用公平锁、读写锁、超时获取锁等特殊场景，才会考虑使用Lock
**/
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//超时 自动退出
class TaskTime implements Runnable{
    private Lock lock = new ReentrantLock();      //若想让Lock是公平锁 在ReentrantLock(true) 传入true即可
    @Override
    public void run() {
        try {
            if (lock.tryLock(1,TimeUnit.SECONDS)){
                System.out.println(Thread.currentThread().getName()+"获取锁成功");
                Thread.sleep(3000);
            }else{
                System.out.println(Thread.currentThread().getName()+"获取锁失败");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
public class LockTime {
    public static void main(String[] args) {
        TaskTime taskTime = new TaskTime();
        Thread thread1 = new Thread(taskTime,"线程A");
        Thread thread2 = new Thread(taskTime,"线程B");
        thread1.start();
        thread2.start();
    }
}
