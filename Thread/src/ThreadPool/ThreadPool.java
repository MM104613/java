package ThreadPool;
/*创建线程的方式——推荐使用线程池来创建线程
线程池的核心两大接口
ExecutorService:普通线程
        —void execute(Runnable command);
        —<T>Future<T>submit(Callable<T> task || Runnable);
ScheduledExecutorService:定时线程池
ScheduleFuture<?>scheduleAtFixedRate(Runnable command, long initialDelay,long period, TimeUnit unit);
线程池的一个核心类：
ThreadPoolExecutor:ExecutorService的子类
ThreadPoolExecutor（int corePoolSize, int maximumPoolSize , long KeepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, RejectExecutionHandler handler）

线程池的工作流程
当一个任务提交给线程池时，
1.首先判断核心池的线程数量是否达到corePoolSize,若未达到，线程池创建新的线程执行任务并将其置入核心池中。否则，判断核心池
  是否有空闲线程，若有，分配任务执行，否则进入步骤2
2.判断当前线程池中线程数量有没有达到线程池的最大数量（maximumPoolSize）,若没有，创建新的线程执行任务并将其置入线程池中，否则，进入步骤3
3.判断阻塞队列是否已满，若未满，将任务置入阻塞队列中等待调度。否则，进去步骤4
4.调用相应的拒绝策略打回任务（有四种拒绝策略，默认为抛出异常给用户AbortPolicy）

核心线程池
最大线程池
阻塞队列
打回cel
*/
public class ThreadPool {
}
