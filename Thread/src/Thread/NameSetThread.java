package Thread;
/*线程的名字方法
1.通过Thread.currentThread()获取执行当前代码的线程
2.Java的main方法，程序的入口，它也在线程中执行，线程名：main
3.线程是Java应用的成型执行的最小单元
4.创建线程时，如果不指定线程Thread-index(0,1,2...)创建线程时通过构造方法，或setName设置线程名称
**/
class NameThread implements Runnable{
    @Override
    public void run() {
      for(int i = 0 ;i < 10;i++){
          System.out.println(Thread.currentThread().getName()+"、i="+i);
      }
    }
}
public class NameSetThread {
    public static void main(String[] args) {
        Runnable runnable = new NameThread(); //向上转型
        Thread thread1 = new Thread(runnable,"线程A"); //后面直接设置名字
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);  //没有设置线程名字，则是系统默认从 Thread-(0,1,2...)
        thread2.setName("线程B");//调用setName()设置名字
        thread1.start();
        thread2.start();
        thread3.start();

    }
}
