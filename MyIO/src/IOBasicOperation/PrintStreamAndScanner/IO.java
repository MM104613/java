package IOBasicOperation.PrintStreamAndScanner;
import java.io.*;
import java.util.Scanner;
//打印流与scanner

//输出就用打印流
/*public class IO {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\62424\\Desktop\\hello.txt");
        PrintStream printStream = new PrintStream(file);
        printStream.print("hello word");
        printStream.print("马君安");
        printStream.print(20.2);
        printStream.close();
    }
}*/

//输入就用scanner
/*public class IO {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("C:\\Users\\62424\\Desktop\\hello.txt");
        Scanner scanner = new Scanner(file);
        while(scanner.hasNext()){  //判断是否有指定类型
            String str = scanner.next(); //取得类型
            System.out.println(str);
        }

    }
}*/

//序列化 ：将数据中保存的对象变为二进制数据形式进行传输
//使用序列化 实现Serializable接口
/*class Person implements Serializable{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
public class IO {
    public static void main(String[] args) throws IOException {
        Person person = new Person("张三",20);
        File file = new File("C:\\Users\\62424\\Desktop\\hello.txt");
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
        out.writeObject(person);
        out.close();
    }
}*/

//反序列化
public class IO {
    public static void main(String[] args) throws Exception {
        File file = new File("C:\\Users\\62424\\Desktop\\hello.txt");
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
        System.out.println(in.readObject());
        in.close();
    }
}








