package EveryDay;
class MyThread extends Thread{
    private String str;
    private int i = 5 ;

    public MyThread(String str) {
        this.str = str;
    }

    public void run(){
        while(i >0){
            System.out.println(str+"，不要和你姐王了！");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i--;
        }
    }
}
public class Every527 {
    public static void main(String[] args) throws InterruptedException {
     MyThread thread = new MyThread("马君娜");
     thread.start();
     Thread.sleep(5000);
     System.out.println("因为不会赢得!!!!!");
    }
}