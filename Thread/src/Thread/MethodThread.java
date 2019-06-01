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
    public static void main(String[] args) {
     Runnable runnable = new Sleep();
     Thread thread1 = new Thread(runnable);
     Thread thread2 = new Thread(runnable);
     Thread thread3 = new Thread(runnable);
     thread1.start();
     thread2.start();
     thread3.start();
    }
}
