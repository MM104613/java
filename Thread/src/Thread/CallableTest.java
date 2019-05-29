package Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

//线程的创建
//3.实现Callable接口，而后覆写call<v>方法
// 有返回值
class MyCallable implements Callable<String> {
    private int ticket = 20;
    @Override
    public String call() throws Exception {
        while (ticket > 0) {
            System.out.println("当前线程为："+Thread.currentThread().getName()+
                                 "还剩下"+ticket--+"票");
        }
        return "票卖完了~ 客观明天再来";
    }
}

public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //产生Callable对象
        MyCallable myCallable = new MyCallable();
        //产生FutureTask对象
        FutureTask futureTask = new FutureTask(myCallable);
        Thread thread = new Thread(futureTask);
        thread.start();
        System.out.println(futureTask.get());   //接收Callable接口的返回值是Future中get()方法
    }
}
