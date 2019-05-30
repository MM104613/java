package Exer524;

import java.util.Scanner;
public class Test{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int[] num = new int[4];
        for(int i =0; i < num.length;i++ ){
            num[i] = scanner.nextInt();

        }
        int a=(num[0]+num[2])/2;
        int b =(num[1]+num[3])/2;
        int c= num[3]-b;
        System.out.println(a+"、"+b+"、"+c+"、");
       /* System.out.println(b);
        System.out.println(c);*/
    }
}