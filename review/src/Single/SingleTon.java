package Single;

import java.util.concurrent.SynchronousQueue;

public class SingleTon {
    //饿汉模式  一上来就new
    private final static SingleTon singleton = new SingleTon();
    private SingleTon() { }
    public static SingleTon getSingleton(){
        return singleton;
    }
}

//懒汉
class SingleTonLazy{
    private  static volatile SingleTonLazy s = null;
    private SingleTonLazy(){}
    public static SingleTonLazy getSingletonLazy(){
        if(s ==null){
            synchronized(SingleTonLazy.class){
                if(s == null){
                    s = new SingleTonLazy();
                }
            }
        }
        return s;
    }

}
