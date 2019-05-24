package Exer521;

import java.util.Scanner;
//输入一串字符串包含数字与字母
//取出数字串

public class FindLongNumber {
    public static void main(String[] args) {
        //输入一串字符串包含数字与字母
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
        String str1 = scanner.nextLine();
         int end= 0 ,count = 0 ,max=0; //尾部  计数 数的最大值
         for(int i = 0; i<str1.length();i++ ){
             if(str1.charAt(i)>='0' && str1.charAt(i)<='9'){ //0到9之间
                 count ++;   //计数器+1
                 if(count > max){//如果计数的大于最大
                     max = count;
                     end = i;
                 }
             }else{
                 count = 0;//重新开始下一轮计数
             }
         }
         //字符串的截取
            System.out.println(str1.substring(end - max +1, end+1));
        }


    }
}
