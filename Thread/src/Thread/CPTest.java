package Thread;
class Goods{
    private String goodsName;
    private int count;
    public synchronized void set(String goodsName) {
        if(count == 1){
            System.out.println("还有商品，等待卖出");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        this.goodsName = goodsName;
        count++;
        System.out.println(Thread.currentThread().getName()+"生产"+this);
        this.notify();//唤醒消费者
    }
    public synchronized void get(){
       if(count ==0){
            System.out.println("没有商品，等待生产");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        count--;
        System.out.println(Thread.currentThread().getName()+"消费"+this);
        this.notify();//唤醒生产者
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goodsName='" + goodsName + '\'' +
                ", count=" + count +
                '}';
    }
}
class Producer implements Runnable{
    private Goods goods;
    public Producer(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
         this.goods.set("小黑瓶");
    }
}
class Consumer implements Runnable{
    private  Goods goods;

    public Consumer(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
        this.goods.get();
    }
}
public class CPTest {
    public static void main(String[] args) throws InterruptedException {
        Goods goods = new Goods();
        Producer producer =new Producer(goods);
        Consumer consumer =new Consumer(goods);
        Thread producerThread1 = new Thread(producer,"生产者1");
        Thread consumerThread1 = new Thread(consumer,"消费者1");
        consumerThread1.start();
        Thread.sleep(1000);
        producerThread1.start();

    }
}
