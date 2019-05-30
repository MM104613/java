package Exer523;

import java.util.Scanner;
public class buyApple{
    public static void main(String[] args){
        //输入一个数
        //首先是否能被8整除，可以整除输出数
        //不能整除
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int result;
        int a,b,sum;
        if(num % 2 ==0){
            if(num%8 == 0){
                result = num/8;
                System.out.print(result);
            }else{
                result= num%8;
                a = num/8;
                if(result%6 == 0){
                    b=result/6;
                    sum=a+b;
                    System.out.print(sum);
                }else{
                    for(int i =1; i < num ; i++){
                        a=a-1;
                        result = a*8;
                        b=num-result;
                        if(b%6==0){
                            int c;
                            c=b/6;
                            sum=a+c;
                            System.out.print(sum);
                            break;
                        }
                    }
                }
            }
        }else{
            System.out.print(-1);
        }
    }
}