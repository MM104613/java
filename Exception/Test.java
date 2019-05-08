//  异常分为 Error 和 Exception
//  Error 和 RuntimeException是非受查异常   非受查异常可以不用捕获
// 其他一切都是受查异常 受查异常是必须捕获的

/*public class Test {
    public static void main(String[] args) {
        System.out.println("1.开始运算");
       try{
           System.out.println("2.进行运算"+10/0);
        }catch(ArithmeticException e){// e表示抛出来的异常对象

           e.printStackTrace();//  printStackTrace()打印异常的信息
       }finally {                   // 如果try catch调用System.exit() 则finally不执行
           System.out.println("Finally不管是否产生异常，都执行此语句");
       }
        System.out.println("3.运算结束");
    }
}*/

/*
public class Test{
    public static void main(String[] args) {

         System.out.println("1.开始运算");
       try {
           int x = Integer.parseInt(args[0]);   //数组可能越界  分母不对  给的数转不成整数
           int y = Integer.parseInt(args[1]);
           System.out.println("2.进行数据运算"+x/y);
       }catch(ArrayIndexOutOfBoundsException e ){  //数组越界异常
           e.printStackTrace();
       }catch(NumberFormatException e){ //给的数不能成整
           e.printStackTrace();
        }catch(ArithmeticException e){  //分母不对
           e.printStackTrace();
       } finally {
           System.out.println("不管是否有异常都会执行此语句");
       }
        System.out.println("3.数学运算结束");
    }
}*/
public class Test{
    public static void main(String[] args) {

        System.out.println("1.开始运算");
        try {
            int x = Integer.parseInt(args[0]);   //数组可能越界  分母不对  给的数转不成整数
            int y = Integer.parseInt(args[1]);
            System.out.println("2.进行数据运算"+x/y);
        }catch(ArrayIndexOutOfBoundsException |NumberFormatException |ArithmeticException e ){  //数组越界异常
            e.printStackTrace();  //jdk8之后优化   简化了多个catch
        }finally{

            System.out.println("不管是否有异常都会执行此语句");
        }
        System.out.println("3.数学运算结束");
    }
}