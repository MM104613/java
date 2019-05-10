package Fanxing;
/*class Point{
    private Object x;
    private Object y;
    public void setX(Object x){

        this.x = x;
    }
    public Object getX(){
        return x;
    }
    public void setY(Object y){
        this.y= y;
    }
    public Object getY(){
        return y;
    }
}
public class Fan {
    public static void main(String[] args) {
        Point point = new Point();
        point.setX(10);  //int
        point.setY("20"); // String
     //由于设置错误会出现ClassCastException异常   所以引入泛型
        String  x=(String) point.getX();
        String y = (String)point.getY();
        System.out.println("x="+x+",y="+y);
    }
}*/

//泛型:定义时类型不确定，只有在具体使用时才能确定   作用于：类、方法
/*1.泛型类   2.泛型方法   3.泛型接口*/  //必须是包装类 eg:String 或者 Integer
//泛型类
/*class Point<T>{
    private T x;
    private T y;
    public void setX(T x){

        this.x = x;
    }
    public T getX(){
        return x;
    }
    public void setY(T  y){
        this.y= y;
    }
    public T getY(){
        return y;
    }
}
public class Fan {
    public static void main(String[] args) {
       Point<String> point = new Point<String>();
       Point<Integer> point1 = new Point<Integer>();
       point.setX("dong");
        point1.setY(2);
        String x=point.getX();
       Integer y=point1.getY();
        System.out.println("x="+x+",y="+y);
    }
}*/

//泛型方法
/*class Test<T>{
    public void tests(T t){
        System.out.println(t);
    }
    public <E> E point(E e){  //T 1.泛型方法的定义 2.有返回值，返回值类型T 3.参数类型是
        return e;
    }
}
public class Fan {
    public static void main(String[] args) {
        Test<String> test=new Test<>();
        test.tests("hello");
        Integer integer=test.point(20);
        System.out.println(integer);
    }
}*/

//泛型接口
//两类：1.保留泛型 2.子类确定好类型
/*interface IMessage<T>{
    public abstract void print(T t);
}
class Message<T> implements IMessage<T>{   //子类在实现泛型接口时保留泛型 ， 注意有两个T
    public void print(T t){
        System.out.println(t);
    }
}
public class Fan {
    public static void main(String[] args) {
        IMessage<String> iMessage=new Message();//向上转型
        iMessage.print("hello");
    }
}*/

interface IMessage<T>{
    public abstract void print(T t);
}
class Message implements IMessage<String>{   //子类在实现泛型接口时就确定好类型
    public void print(String  t){
        System.out.println(t);
    }
}
public class Fan {
    public static void main(String[] args) {
        IMessage<String> iMessage=new Message();//向上转型
        iMessage.print("hello");
    }
}

