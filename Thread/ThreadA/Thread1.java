package ThreadA;
class MyThread extends Thread{
    private String title;
    public MyThread(String title){
        this.title=title;
    }
    public void run(){
        for(int i = 0 ; i<10;i++){
            System.out.println(this.title+"i="+i);
        }
    }
}
public class Thread1 {
    public static void main(String[] args) {
        MyThread myThread1=new MyThread("132");
        MyThread myThread2=new MyThread("162");
        MyThread myThread3=new MyThread("152");
        myThread1.start();
        myThread2.start();
        myThread3.start();
    }
}

