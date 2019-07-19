package CollectionTest.List;
import java.util.ArrayList;
import java.util.List;
/*
List常用方法：
根据下标返回元素：public E get(int index)
根据下标修改元素，返回修改前的元素：public E set(int index,E element)
 */
public class ListTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(5);
        list.add(7);
        list.add(1);
        System.out.println(list);

    }
}
