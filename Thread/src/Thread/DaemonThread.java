package Thread;
/*线程分为守护线程、用户线程
  守护线程：为陪伴线程，只要JVM中存在有任何一个用户线程没有终止，守护线程就一直工作
  默认创建的线程都是用户线程，包括主线程
  通过setDaemon(true)将线程对象设置为守护线程
  判断是否是守护线程用isDaemon()返回true则是守护线程，反之，是用户线程
 */
class DaemonTest implements Runnable{

    @Override
    public void run() {
     while(true){
         System.out.println("当前线程是否为守护线程："+Thread.currentThread().isDaemon());
         try {
             Thread.sleep(2000);
         } catch (InterruptedException e) {
             System.out.println("当前线程是否为守护线程："+Thread.currentThread().isDaemon());
             System.out.println("线程被终止");
             return;
         }
     }
    }
}
public class DaemonThread {
    public static void main(String[] args) throws InterruptedException {
       DaemonTest daemonTest = new DaemonTest();
       Thread thread1 = new Thread(daemonTest);
       Thread thread2 = new Thread(daemonTest);
       thread1.setDaemon(true);
       thread1.start();
       thread2.start();
       Thread.sleep(3000);
       thread2.interrupt();
       Thread.sleep(5000);
        System.out.println("代码结束");
    }
}
