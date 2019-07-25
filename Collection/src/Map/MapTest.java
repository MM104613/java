package Map;

import com.sun.javafx.collections.MappingChange;
/*Map:K,V 保存一对对象的最大父接口
键值对（key唯一，当key值重复时，覆盖value值）
put(E key,V values)
get(E key):当key不存在时，返回null

Set<V>keySet()：取得map中的所有key值
Collection<V> values():取得map中的所有values值

关于null
HashMap:key与values均可为null；JDK1.2，线程不安全，哈希表+红黑树（JDK8）采用懒加载，采用异步处理，性能较高
TreeMap:key不允许为null,values可以为null；JDK1.2，线程不安全，红黑树
HashTable: key与values均不为null；JDK1.0，线程安全，基于哈希表，
          0产生对象时初始化内部哈希表（默认大小为16）采用synchronized同步方法，性能很低（读读互斥）
Map集合输出
Map.Entry接口 保存一个对象
*/
import javax.swing.text.html.HTMLDocument;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapTest {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"hello");
        map.put(2,"JAVA");
        map.put(3,"hello");
        map.put(4,"world");
        //map --> set
        Set<Map.Entry<Integer,String>> set = map.entrySet();
        Iterator<Map.Entry<Integer,String>> iterator = set.iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer,String> entry = iterator.next();
            System.out.println(entry.getKey()+"="+entry.getValue());
        }
    }
}
