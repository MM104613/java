package ThreadPool;import sun.security.krb5.internal.Ticket;import java.util.concurrent.*;
/*创建线程的方式——推荐使用线程池来创建线程
线程池的核心两大接口
ExecutorService:普通线程
        —void execute(Runnable command);
        —<T>Future<T>submit(Callable<T> task || Runnable);
ScheduledExecutorService:定时线程池
ScheduleFuture<?>scheduleAtFixedRate(Runnable command, long initialDelay,long period, TimeUnit unit);
线程池的一个核心类：
ThreadPoolExecutor:ExecutorService的子类
ThreadPoolExecutor（int corePoolSize, int maximumPoolSize , long KeepAliveTime, TimeUnit unit,
                    BlockingQueue<Runnable> workQueue, RejectExecutionHandler handler）

线程池的工作流程
当一个任务提交给线程池时，
1.首先判断核心池的线程数量是否达到corePoolSize,若未达到，线程池创建新的线程执行任务并将其置入核心池中。否则，判断核心池
  是否有空闲线程，若有，分配任务执行，否则进入步骤2
2.判断当前线程池中线程数量有没有达到线程池的最大数量（maximumPoolSize）,若没有，创建新的线程执行任务并将其置入线程池中，
  否则，进入步骤3
3.判断阻塞队列是否已满，若未满，将任务置入阻塞队列中等待调度。否则，进去步骤4
4.调用相应的拒绝策略打回任务（有四种拒绝策略，默认为抛出异常给用户AbortPolicy）

FutureTask：可以保证多线程场景下，任务只会被一个线程执行一次，其他的线程不在执行此任务
Future接口中的get方法会阻塞当前线程直到取得Callable的返回值

线程池
核心线程池 corePoolSize
最大线程池 maximumPoolSize
阻塞队列 4个
1.ArrayBlockingQueue:基于数组的有界阻塞队列
2.LinkedBlockingQueue:基于链表的无界阻塞队列（内置线程池FixedThreadPool,SingThreadPool都采用此队列）
3.SynchronousQueue:一个不存储元素的无界阻塞队列（一个元素的插入操作必须要等待同时又一个元素的删除操作，否则插入操作就一直阻塞
 内置线程池CachedThreadPool就采用此队列）
4.PriorityBlockingQueue:基于优先级的阻塞队列
拒绝策略

线程中的线程被包装为Worker工作线程，具备可重复执行任务的能力

关闭线程：shutdown()

合理配置线程池：配置核心池以及最大线程池的数量
1.CPU密集型任务（大数运算）：NCPU+1
2.IO密集型任务（读写文件）：2*NCPU
*/
class CallableTest implements Callable<String>{
    private int ticket = 20;
    @Override
    public String call() throws Exception {
        for(int i = 0; i < 20; i++){
            if(ticket < 0){
                System.out.println(Thread.currentThread().getName()+"还剩下"+ticket--+"票");
            }
    }
    return Thread.currentThread().getName()+"票卖完了";
    }
}
public class ExecutorTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = new ThreadPoolExecutor(2,3,
                60, TimeUnit.SECONDS,new LinkedBlockingQueue<>());
        CallableTest callableTest =new CallableTest();
        for(int i = 0; i < 5; i++){
           // executorService.submit(callableTest);线程提交
             Future<String> submit = executorService.submit(callableTest);
            System.out.println(submit.get());
        }
        executorService.shutdown();   //线程关闭
    }
}

