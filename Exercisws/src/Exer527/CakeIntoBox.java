package Exer527;

import java.util.Scanner;

//放蛋糕 两个蛋糕之间的距离不能等于2
public class CakeIntoBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int  length = scanner.nextInt();
        int  width = scanner.nextInt();
        int cake;
        if(length % 4 == 0 || width % 4 ==0){
            cake = length*width /2 ;
        }
        else if(length%2==0 && width %2 ==0){
            cake = length*width /2 +2;
        }
        else{
            cake = length*width/2+1;
        }
        System.out.println(cake);
    }
}
