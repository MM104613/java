package Thread;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ThreadMK {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"Hello");
        map.put(2,"JAVA");
        map.put(3,"Hello");
        map.put(4,"world");
       /* System.out.println(map.get(3));
        Set<Integer> keySet = map.keySet();
        Iterator<Integer> iterator =keySet.iterator();
        while(iterator.hasNext()){
            Integer i = iterator.next();
            System.out.println(i+"="+map.get(i));
        }*/
       Set<Map.Entry<Integer,String>> set = map.entrySet();
       Iterator<Map.Entry<Integer,String>> iterator = set.iterator();
       while(iterator.hasNext()){
           Map.Entry<Integer,String> entry= iterator.next();
           System.out.println(entry.getKey()+"="+entry.getValue());
       }
    }
}
