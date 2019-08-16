package FactoryAndAgency.SingleTon;

//单例模式:一个类只能实例化一个对象
/*写法：1.构造方法私有化
       2.公开的静态方法提供实例化对象
       3.私有的静态属性类型，是单利模式
*/

/*饿汉式  一上来就new
class SingletonPattern {
    private final static SingletonPattern instance = new SingletonPattern();

    private SingletonPattern() {
        //private构造
    }
    public static SingletonPattern getInstance() {
        return instance;
    }
}

public class SingleTon {
    public static void main(String[] args) {
        SingletonPattern singletonPattern1 = null;
        singletonPattern1 = SingletonPattern.getInstance();
        SingletonPattern singletonPattern2 = null;
        singletonPattern2 = SingletonPattern.getInstance();
        System.out.println(singletonPattern1 == singletonPattern2); //判断是否只创建了一个对象
    }
}
*/

//懒汉式  存在线程安全问题 所以不太用

/*
class SingletonPattern{
    private  static SingletonPattern instance;//= new SingletonPattern();
    private SingletonPattern(){ //私有的构造方法
         }
    public static SingletonPattern getInstance(){
        if (instance == null){
            instance = new SingletonPattern();
        }
        return instance;
    }
}
public class SingleTon{
    public static void main(String[] args) {
        SingletonPattern singletonPattern1 = null;
        singletonPattern1 = SingletonPattern.getInstance();
        SingletonPattern singletonPattern2 = null;
        singletonPattern2 = SingletonPattern.getInstance();
        System.out.println(singletonPattern1==singletonPattern2);
    }
}*/

//改进懒汉式 解决线程安全问题 加双重锁
class SingletonPattern{
    private  static volatile SingletonPattern instance;
    private SingletonPattern(){
    }
    public static SingletonPattern getInstance(){
        if (instance == null){
            synchronized (SingletonPattern.class){
                if(instance == null ){
                    instance = new SingletonPattern();
                }
            }
        }
        return instance;
    }
}
public class SingleTon{
    public static void main(String[] args) {
        SingletonPattern singletonPattern1 = null;
        singletonPattern1 = SingletonPattern.getInstance();
        SingletonPattern singletonPattern2 = null;
        singletonPattern2 = SingletonPattern.getInstance();
        System.out.println(singletonPattern1==singletonPattern2);
    }
}