package StringType;
//String类中 == 和 equals
//  1. == 比较的是对象所保存的地址
//  2. equals 比较的是对象的内容
public class Test {
    public static void main(String[] args) {
        String str = "hello";
      String str1=new String("hello");
        System.out.println("hello".equals(str));
    }
}