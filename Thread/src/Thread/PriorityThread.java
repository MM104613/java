package Thread;

import java.io.PrintStream;

/*线程优先级：线程的优先级越高越有可能先执行，仅仅是有可能
1.设置优先级 setPriority()   最高优先级：MAX_PRIORITY 10 中等：NORM_PRIORITY 5 最低：MIN_PRIORITY 1
2.取得优先级 getPriority()
*/
/*class PriThread implements Runnable{

    @Override
    public void run() {
        for(int i =0 ;i< 3;i++){
            System.out.println(Thread.currentThread().getName()+",i="+i);
        }
    }
}
public class PriorityThread {
    public static void main(String[] args) {
        PriThread priThread =new PriThread();
        Thread thread1 = new Thread(priThread,"线程1");
        Thread thread2 = new Thread(priThread,"线程2");
        Thread thread3 = new Thread(priThread,"线程3");
        thread1.setPriority(Thread.MAX_PRIORITY);
        thread2.setPriority(Thread.NORM_PRIORITY);
        thread3.setPriority(Thread.MIN_PRIORITY);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}*/

//主线程的优先级为5
class PriThread implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"优先级为："+Thread.currentThread().getPriority());
    }
}
public class PriorityThread {
    public static void main(String[] args) {
        PriThread priThread = new PriThread();                 //线程的继承性：若在一个线程中创建了子线程，
        Thread thread1 = new Thread(priThread,"子线程A");// 默认子线程与父线程的优先级相同
        System.out.println(Thread.currentThread().getName()+"优先级为:"
                +Thread.currentThread().getPriority());
        thread1.start();
    }
}