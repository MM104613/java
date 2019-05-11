package Agency;
//代理设计模式
interface ISubject{
    public abstract void buyComputer();
}
class RealSubject implements ISubject{
    public void buyComputer(){
        System.out.println("买一台电脑");
    }
}
//class ProxySubject implements ISubject{
    
//}
public class MyAgency {
    public static void main(String[] args) {

    }
}