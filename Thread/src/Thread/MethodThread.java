package Thread;
/*线程方法
1.sleep()线程休眠 （不会释放锁） 线程暂缓执行一下，等到了预计时间之后再回复执行
  线程休眠会立即交出cpu,让cpu去执行其他的任务
**/
class Sleep implements  Runnable{

    @Override
    public void run() {
       for(int i = 0 ; i < 1000;i++){
           try {
               Thread.sleep(1000);
               System.out.println(Thread.currentThread().getName()+"、i="+i);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
    }
}
public class MethodThread {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("主线程开始");  //3.一定是最先执行的
        Runnable runnable = new yield();
     Thread thread1 = new Thread(runnable);
     Thread thread2 = new Thread(runnable);
     Thread thread3 = new Thread(runnable);
     thread1.start();
     //thread2.start();
     //thread3.start();
        thread1.join(); //3.在那个线程中调用，哪个线程阻塞等待
        System.out.println("主线程执行完毕"); //3.与其他三个子线程并行执行
    }
}

/*2.yield()线程让步  (不会释放锁)
    只能让拥有相同优先级的线程获取cpu，当前线程不会立即交出cpu，交出时间由系统调度
 */
class yield implements Runnable{

    @Override
    public void run() {
        for(int i = 0;i<3 ;i++){
            Thread.yield();
            System.out.println(Thread.currentThread().getName()+"、i ="+i);
        }
    }
}
/*3.join()线程等待    会释放锁
    若一个线程1需要等待另一个线程2执行完毕之后，再恢复执行，可以在线程1中调用线程2的join(在哪个线程中调用，哪个线程阻塞，
    等等待线程执行完毕再恢复执行)


 */