//Lambda表达式（函数式编程） 初见
/*@FunctionalInterface    //注解， 只用于检测当前接口中是否只有一个抽象方法
interface IMessage{
    public abstract void print();   // 若用Lambda表达式，接口中只能有一个抽象方法
}
public class MyLambda {
    public static void main(String[] args) {
       *//* IMessage iMessage=new IMessage() {
            @Override
            public void print() {
                System.out.println("匿名内部类");
            }
        };*//*
       // ()相当于print()的括号，  ->相当于implements
        // Lambda表达式中括号只有一个， 所以接口中的抽象方法也只能有一个， 不然括号不知道是谁的了
       IMessage iMessage =() -> System.out.println("Lambda表达式相当于匿名内部类的简化形式");
        iMessage.print();
    }
        }*/


//Lambda表达式单行与多行，有无返回值
//1.2.
/*
@FunctionalInterface
interface IMessage{
    public abstract void print();
}
public class MyLambda {
    public static void main(String[] args) {
    //  IMessage iMessage = ()-> System.out.println("1.单行代码时，直接写出");
        IMessage iMessage = () ->{
            System.out.println("2.多行代码时");
            System.out.println("需要代码块{}");
        };
      iMessage.print();
    }
}*/

//3.单行有返回值
/*@FunctionalInterface
interface IMessage{
    public abstract int add(int x,int y);
}
public class MyLambda {
    public static void main(String[] args) {
        IMessage iMessage = (p1,p2)->p1+p2;  //单行语句，return可以省略
        System.out.println(iMessage.add(10,20));
    }
}*/


//4.多行有返回值
@FunctionalInterface
interface IMessage{
    public abstract int add(int x,int y);
}
public class MyLambda {
    public static void main(String[] args) {
        IMessage iMessage = (r1,r2)->{
            r1=10;
            r2=20;
        return r1+r2;};  //多行语句，return不可以省略
        System.out.println(iMessage.add(10,20));
    }
}