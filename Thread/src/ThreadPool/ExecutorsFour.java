package ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/*内置的四大线程池  Executors-线程池的工具类
1.固定大小线程池
Executors.newFixedThreadPool(int nThread)
return new ThreadPoolExecutor(nThreads,nThread,0L,TimeUnit.MILLISECONDS,
                                   new LinkedBlockingQueue<Runnable>());
2.单线程池-只有一个线程
当多线程场景下需要让任务串行进行
Executors.newSingleThreadExecutor()
new ThreadPoolExecutor(1,1,0L，TimeUnit.MILLISECONDS,
                         new LinkedBlockingQueue<Runnable>());
3.缓存线程池
适用于负载较轻的服务器，或执行很多短期的异步任务
Executors.newCachedThreadPool()
return new ThreadPoolExecutor(0,Integer.MAX_VALUE,60L,TimeUnit.SECONDS,
                              new SynchronousQueue<Runnable>());
当任务提交速度 > 线程执行速度, 会不断创建新线程（有可能无限创建线程将内存写满）
当任务提交速度 < 线程执行速度, 只会创建若干个有限线程
4.定时调度池
Executors.newScheduleThreadPool(int nThread);
new ScheduleThreadPoolExecutor(corePoolSize);
(1)executorService.schedule(Runnable command,long delay,TimeUnit.unit);
延迟delay个时间单元后创建nThread个线程执行command任务

(2)scheduleAtFixedRate(Runnable command,long initialDelay,long period,TimeUnit.unit);
延迟delay个单元后每隔period时间单元就执行一次command任务
*/
class RunnableTest implements Runnable{
    @Override
    public void run() {
        for(int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName()+"、"+i);
        }
    }
}
public class ExecutorsFour {
    public static void main(String[] args) {
       // ExecutorService executorService = Executors.newFixedThreadPool(3);      固定大小线程池
       // ExecutorService executorService = Executors.newSingleThreadExecutor();  单线程池
       // ExecutorService executorService = Executors.newCachedThreadPool();      缓存线程池
        ScheduledExecutorService executorService =
                Executors.newScheduledThreadPool(3);  //定时调度池
        for (int i =0; i < 5; i++){
       //      executorService.submit(new RunnableTest());  固定、单线程、缓存线程
       //     executorService.schedule(new RunnableTest(),2,TimeUnit.SECONDS); 定时调度池（1）
            executorService.scheduleAtFixedRate(new RunnableTest(),2,3,TimeUnit.SECONDS);
        }
        // executorService.shutdown();
    }
}
