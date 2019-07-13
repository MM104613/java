package Thread;
//生产者消费者模型
import java.util.ArrayList;
import java.util.List;

class Goods {
    private String goodsName;
    private int count;
    private int maxCount;

    public Goods(int maxCount) {
        this.maxCount = maxCount;
    }

    public synchronized void set(String goodsName) {
      while (count == maxCount) {
            System.out.println("还有商品，等待卖出");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        this.goodsName = goodsName;
        count++;
        System.out.println(Thread.currentThread().getName() + "生产" + this);
        this.notifyAll();//唤醒消费者
    }

    public synchronized void get() {
        while (count == 0) {
            System.out.println("没有商品，等待生产");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        count--;
        System.out.println(Thread.currentThread().getName() + "消费" + this);
        this.notifyAll();//唤醒生产者
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goodsName='" + goodsName + '\'' +
                ", count=" + count +
                '}';
    }
}

class Producer implements Runnable {
    private Goods goods;

    public Producer(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
       while(true){
           this.goods.set("小黑瓶");
       }
    }
}

class Consumer implements Runnable {
    private Goods goods;

    public Consumer(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {

        while(true){
            this.goods.get();
        }
    }
}

public class CPTest {
    public static void main(String[] args) throws InterruptedException {
        Goods goods = new Goods(10);
        Producer producer = new Producer(goods);
        Consumer consumer = new Consumer(goods);
        List<Thread> list = new ArrayList<>();
        //产生20个生产者
        for (int i = 0; i < 20; i++)
            list.add(new Thread(producer, "生产者" + (i + 1)));
        //产生30个消费者
        for (int i = 0; i < 30; i++)
            list.add(new Thread(consumer, "消费者" + (i + 1)));
         //启动所有生产、消费者
        for (Thread thread :list)
            thread.start();
    }
}
