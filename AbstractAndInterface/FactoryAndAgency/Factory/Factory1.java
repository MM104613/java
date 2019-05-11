package FactoryAndAgency.Factory;
//缺点：每当有新商品产生，消费者都需要重新安装客服端，才能买电脑
interface Computer{
    public abstract  void printComputer(); //抽象方法
}
class MacBookProComputer implements Computer{   //子类实现接口
    public void printComputer(){                      //子类覆写抽象方法
        System.out.println("这是一个Mac笔记本电脑");
    }
}
class SurfaceBookComputer implements  Computer{
    public void printComputer() {
        System.out.println("这是一个Surface笔记本电脑");
    }
}
public class Factory1 {
    public void buyComputer(Computer computer){
        computer.printComputer();
    }
    public static void main(String[] args) {
        Factory1 consumer = new Factory1();
      consumer.buyComputer(new MacBookProComputer());
    }
}
