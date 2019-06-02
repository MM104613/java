package Exer530;
import java.util.Scanner;
public class Main{
public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int a=0,b=0,i=0;
        while(b < num){
        a =Finb(i);
        b = Finb(i+1);
        i++;
        }
        int c= num-a;
        int d= b-num;
        if(c>d){
        System.out.println(d);
        }else{
        System.out.println(c);
        }
}
private static int Finb(int i){
        if(i<=1 ){
        return 1;
        }
        return Finb(i-1)+Finb(i-2);
        }
}
