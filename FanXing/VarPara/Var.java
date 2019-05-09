package VarPara;
//可变参数
public class Var {
    public static void main(String[] args) {
        System.out.println(add("hello"));  //也可以不传数组
       System.out.println(add("hello",1,2,5,6,99));  //简化
        System.out.println(add("hello",new int[]{1,56,8,9,2,8,82}));
    }
    //如果传递多类参数，可变参数一定要放在最后 ,并且只能设置一个可变参数
    public static int add(String str ,int ... data){  //本身还是一个数组
        int result=0;
        for(int i = 0;i<data.length;i++){
            result += data[i];
        }
        return result;
    }
}
