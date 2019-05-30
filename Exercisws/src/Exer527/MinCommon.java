package Exer527;

import java.util.Scanner;
//求两个数最小公倍数
public class MinCommon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b= scanner.nextInt();
        int c ,d;
        d= a*b;
        while(b!=0){
            c = a % b;
            a = b ;
            b = c;
        }
        System.out.println(d/a);
    }
}
