package Exer530;

import java.util.Scanner;

public class Robot {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        int length = scanner.nextInt();
        int width= scanner.nextInt();
        System.out.println(countWays(length,width));
    }

    private static int countWays(int x, int y) {
        if((x+y)>12){
            return 0;
        }
        if(x==1||y==1){
            return 1;
        }
        return countWays(x-1,y)+countWays(x,y-1);
    }
}
