package Interface;//子类可以实现多个接口
//JDK8之前接口定义1.全局常量 和2.抽象方法
/*interface IMessage{
    public static final String MGS="i am a biter";  //全局常量
    public abstract void print();   //抽象方法
}

interface INews{
    public abstract String getNews(); //抽象方法
}
class MessageImpl implements IMessage,INews{
         public void print(){
             System.out.println("1"+IMessage.MGS);
         }
         public String getNews(){
             return IMessage.MGS;
         }
        }
public class Interface {
    public static void main(String[] args) {
        IMessage imessage = new MessageImpl();//向上转型实例化对象
        imessage.print();  //调用被子类覆写过的方法
        INews iNews = (INews) imessage;
        System.out.println(iNews.getNews());
    }
}*/

//JDK8之后 接口新增 两种(一般不要用这两个)
//1.default定义的普通方法
/*interface IMessage{
    public static final String MGS="i am a biter";  //全局常量
    public abstract void print(); //抽象方法
    public default void fun(){  //追加普通方法了，就有了方法体
        System.out.println("JDK8之后default定义的普通方法");
    }
}
class Message implements IMessage{
    @Override
    public void print() {
        System.out.println("覆写接口的抽象方法");
    }
}
public class Interface {
    public static void main(String[] args) {
      IMessage iMessage=new Message();
      iMessage.print();
      iMessage.fun();
    }
}*/

//2.static定义的静态方法
interface IMessage{
    public static final String MGS="i am a biter"; //全局常量
    public abstract void print();//抽象方法
    public static IMessage getInstance(){// static修饰 与对象无关，通过接口名称直接调用
        return new Message();
        }
    }
class Message implements IMessage{
    @Override
    public void print() {
        System.out.println("覆写接口的抽象方法");
    }
}

public class Interface {
    public static void main(String[] args) {
        IMessage iMessage =  IMessage.getInstance(); //直接调用
        iMessage.print();
     }
}