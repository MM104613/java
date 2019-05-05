//package Interface;
//一个子类要实现接口有需要继承抽象类时，先继承后实现接口

/*interface IMessage {
    public void print(); // 接口中可以省略abstract
}

abstract class News {
    public abstract void getNews(); //抽象类中不能省略abstract,否则就是普通方法
}

class MessageImpl extends News implements IMessage {
    @Override
    public void print() {
        System.out.println("i am a biter1");
    }

    @Override
    public void getNews() {
        System.out.println("i am a biter2");
    }
}

public class ChildrenExtendsImplements {
    public static void main(String[] args) {
        IMessage I = new MessageImpl();
        I.print();
        News n = (News)I;
        n.getNews();
    }
}*/
//抽象类可以使用implements实现多个接口，但接口不能继承抽象类
package Interface;
interface A{
    public void print();
}
abstract class B implements A{
     public  abstract  void getNews();
}
class C extends B{
    public void print(){
        System.out.println("mjy is pig");
    }
    public void getNews(){
        System.out.println("mjy is pig");
    }
}
public class ChildrenExtendsImplements {
    public static void main(String[] args) {
        A a = new C();
        a.print();
        B b =(B)a;
        b.getNews();
    }
}