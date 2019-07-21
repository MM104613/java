package CollectionTest.Set;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
/*
-Set
  -HashSet(无序存储,允许放null)
底层实现：哈希表+红黑树（JDK1.8之后） 之前只有哈希表
重复元素判断：
HashSet使用equals()与hashCode()共同来判断元素是否重复
    equals：判断两个对象的属性是否相同
    hashCode:对象在内存中的地址根据Hash算法转为int
a.equals相同，hashCode一定相同
b.hashCode相同，equals不一定相同（因为算法可能不同）
*/
/*
public class HashSetTest {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("A");
        set.add("b");
        set.add("C");
        set.add("b");
        set.add(null);
        System.out.println(set);
    }
}
*/

class Person1{
    private Integer age;
    private String  name;

    public Person1(Integer age, String name) {
        this.age = age;
        this.name = name;
    }
    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(!(obj instanceof Person1))
            return false;
        Person1 per = (Person1)obj;
        return this.age.equals(per.age)
                && this.name.equals(per.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name,age);
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
        return "Person1{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }


}

public class HashSetTest {
    public static void main(String[] args) {
        Set<Person1> set = new HashSet<>();
        set.add(new Person1(18,"张三"));
        set.add(new Person1(20,"李四"));
        set.add(new Person1(20,"李四"));
        set.add(new Person1(25,"王五"));
        System.out.println(set);



    }
}