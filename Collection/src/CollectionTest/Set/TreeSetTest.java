package CollectionTest.Set;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/*
-Set
  -HashSet(无序存储,允许放null)
  -TreeSet（有序存储，按照升序存储，不允许放null）
    底层实现：红黑树
排序判断
自定义类要使用TreeSet前提是：
1.要么自定义类自己实现Comparable接口并且覆写compareTo()方法     (内部排序)
2.要么从外部传入一个该类的比较器对象实现Comparator接口           （外部排序）

重复元素判断
TreeSet根据比较接口的返回值来判断两个元素是否重复
*/

/*public class TreeSetTest {
    public static void main(String[] args) {
        Set<String> set = new TreeSet<>();
        set.add("A");
        set.add("b");
        set.add("C");
        set.add("b");
        set.add(null); //TreeSet不允许放null
        System.out.println(set);

    }
}*/

class Person /*implements Comparable<Person>*/{
    private Integer age;
    private String  name;

    public Person(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

   /* @Override
    public int compareTo(Person o) {
        if(this.age > o.age)
            return 1;
        else if(this.age < o.age)
            return -1;
        return 0;
    }*/
}
class PersonAgeSec implements Comparator<Person>{  // 升序排序
    @Override
    public int compare(Person o1, Person o2) {
        if(o1.getAge() < o2.getAge())
            return -1;
        if(o1.getAge() > o2.getAge())
            return 1;
        return 0;
    }
}
class PersonAgeDesc implements Comparator<Person>{  // 升序排序

    @Override
    public int compare(Person o1, Person o2) {
        if(o1.getAge() < o2.getAge())
            return 1;
        if(o1.getAge() > o2.getAge())
            return -1;
        return 0;
    }
}
public class TreeSetTest {
    public static void main(String[] args) {
        PersonAgeSec personAgeSec = new PersonAgeSec();  //升序
        PersonAgeDesc personAgeDesc = new PersonAgeDesc();//降序
        Set<Person> set = new TreeSet<>(personAgeSec);
        Set<Person> set1 = new TreeSet<>(personAgeDesc);
        set.add(new Person(18,"张三"));
        set.add(new Person(20,"李四"));
        set.add(new Person(18,"张三"));
        System.out.println(set);
    }
}