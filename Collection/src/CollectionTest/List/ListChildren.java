package CollectionTest.List;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/*List接口下有三个常用子类
-ArrayList:底层数组实现
-Vector:底层数组实现
-LinkedList:底层双向链表实现

ArrayList、Vector、LinkedList关系与区别
ArrayList:JOK1.2
1.初始化策略：Lazy-load(懒加载策略)只有当Array对象第一次被使用add时，内部的数组才会被初始化为长度为10的数组
2.扩容：每次扩容为原先数组的1.5倍
3.线程安全性：线程不安全

Vector:JDK1.0(使用较少,效率低:因为Synchronized的同步方法锁的是整个Vector对象，其他方法全锁住，其他线程全阻塞)
1.初始化策略：当产生Vector对象时内部数组就产生初始化大小为10的数组
2.扩容：每次扩容为原先数组的2倍
3.线程安全性：线程安全
4.特殊:JDK内置的stack（栈）继承Vector

LinkedList:JDK1.2
1.基于双向链表的动态数组
2.线程安全性：线程不安全
3.特殊：JDK中Queue的一个子类
*/
public class ListChildren {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(1);
    }
}
