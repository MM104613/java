package Thread;
/*线程停止
1.设置标志位(无法处理线程阻塞时停止的问题)
 */
class ThreadShutdown implements Runnable{
    private  boolean flag = true;
    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
      int i = 0;
     while(flag){
         try {
             Thread.sleep(200);
             boolean bool = Thread.currentThread().isInterrupted(); //3.a检测当前线程状态是否为中断状态
             if(bool){
                 System.out.println("线程已被置为中断状态");
                 return;
             }
             System.out.println("当前线程状态为："+bool);
             System.out.println(Thread.currentThread().getName()+","+i++);
         } catch (InterruptedException e) {
             System.out.println("抛出中断异常");
             return;
         }

     }
        System.out.println("线程停止");
    }
}
public class ThreadStop {
    public static void main(String[] args) throws InterruptedException {
      ThreadShutdown threadShutdowns = new ThreadShutdown();
      Thread thread = new Thread(threadShutdowns);
      thread.start();
      Thread.sleep(1000);
     // threadShutdowns.setFlag(false);  //1.
      //thread.stop(); //2.
        thread.interrupt();//3.
    }
}

/*2.调用Thread类提供的stop方法 强行关闭线程
    本方法已经不推荐使用了，因为会产生不完整数据
 */

/*3.调用Thread类提供的interrupt()方法
    a.若线程中没有使用类似sleep/wait/join时，
    调用此线程对象的interrupt方法并不会真正中断线程，只是简单的将线程的状态置为interrupt而已，我们可以根据此状态
    进一步确定如何处理线程。
    Thread类提供的isInterrupt()可以检测当前线程状态是否为中断状态.
    b.若线程中调用了阻塞线程方法如：
      sleep() wait() join()
      此时再调用线程的interrupt时会抛出InterruptedException,同时将线程状态还原（isInterrupted = false）
 */