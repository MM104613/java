package Interface;//子类可以实现多个接口
interface IMessage{
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
}
