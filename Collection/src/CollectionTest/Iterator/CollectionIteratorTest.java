package CollectionTest.Iterator;
/*Collection的输出：
1.使用Iterator迭代器输出
  Iterator（Collection的迭代器接口，专门用来输出Collection接口内容）
  Iterator<E> iterator(); 取得该Collection接口对象的迭代器
标准格式:
  while(iterator){
   E e = iterator.next();
  }
两个方法：
  boolean hasNext();判断当前集合是否还有未遍历的元素
  E next();取得当前元素
2.foreach:语法糖（只存在于代码编译阶段）
  Collection接口能采用foreach输出的本质在于，所有子类都实现了Iterator
3.ListIterator(双向迭代输出-只有List接口有)
  boolean hasPrevious();
  E previous();
要想使用从后向前输出，必须先从签到后输出一次
4.Enumeration(枚举输出-只有Vector及其子类Stack才有)   (了解即可)
 boolean hashMoreElements();
 E nextElements();

 快速失败策略（fail-fast）  保证集合在多线程场景下读到正确的值
   java.util.ConcurrentModificationException
   在迭代输出集合时，并发修改了集合的结构
   protected transient int modCount=0;//记录当前集合被修改（add、remove等方法）的次数
在迭代器内部：
  int expectedModCount = modCount; //取得集合迭代器的modCount值
    final void checkForComodification() {
     if (modCount != expectedModCount)
      throw new ConcurrentModificationException();
   }
什么是快速失败：优先考虑异常情况，当异常情况发生时，直接向用户抛出异常，程序终止
所以在java.util.的集合类大多都采用此策略（ArrayList、Vector、LinkedList、HashSet）读写都在同一个副本中

如何避免ConcurrentModificationException
1.迭代输出的时候，不要修改集合内容
2.使用迭代器的修改方法 iterator.remove(str)而不是list.remove(str);

fail-safe
java.util.concurrent:CopyOnWriterArrayList/concurrentHashMap
CopyOnWriterArrayList采用读写分离，所有的读为异步操作，写为同步操作，且读写不在一个副本
*/
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class CollectionIteratorTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("JAVA");
        list.add("Hello");
        list.add("world");
        //1.迭代器输出
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            String str = iterator.next();
            if(str.equals("JAVA"))
                list.remove(str);
            System.out.println(str);
        }
        //2.foreach输出
     /*for(String str : list)
         System.out.print(str+"、");
    }*/
     //3.ListIterator(双向迭代输出-只有List接口有)
        /*ListIterator<String> listIterator = list.listIterator();
        while(listIterator.hasNext()){
            String str = listIterator.next();
            System.out.println(str);
        }
        System.out.println("------");
        while(listIterator.hasPrevious()){
            String str = listIterator.previous();
            System.out.print(str+"、");
        }*/
    }
}
