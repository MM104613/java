package CollectionTest.List;
import java.util.ArrayList;
import java.util.List;
/*
List常用方法：
根据下标返回元素：public E get(int index)
根据下标修改元素，返回修改前的元素：public E set(int index,E element)
List集合中添加自定义类时，用contains()、remove()方法需要覆写equals方法支持
 */
class Person{
    private Integer age;
    private String Name;

    public Person(int age, String name) {
        this.age = age;
        Name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return Name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", Name='" + Name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {   //覆写equals方法
        if(this == obj)
        return true;
        if(!(obj instanceof Person))
            return false;
        Person person = (Person) obj;
        return this.age.equals(person.age)
                && this.Name.equals(person.Name);
    }
}
public class ListTest {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        Person person1 = new Person(21,"老马");
        Person person2 = new Person(22,"小马");
        Person person3 = new Person(23,"中马");
        people.add(person1);
        people.add(person2);
        people.add(person3);
        System.out.println(people.contains(new Person(21,"老马"))); //没有覆写equals方法
        System.out.println(people.remove(new Person(22,"小马")));   //就没办法查找与删除

    }
}
