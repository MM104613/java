import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class MyCallable implements Callable<String> {
    private int ticket = 20 ;
    @Override
    public String  call() throws Exception {
        while(ticket > 0){
            System.out.println(Thread.currentThread().getName()+"还剩下"+ticket--+"票");
    }
    return "票卖完了";
   }
}
public  class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
      MyCallable myCallable = new MyCallable();
        FutureTask futureTask = new FutureTask(myCallable);
        Thread thread = new Thread(futureTask);
        thread.start();
        System.out.println(futureTask.get());
    }
}
