package Exer530;

import java.util.Scanner;
public class Test{
    public static void main(){
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[10];
        for(int i = 0; i <10; i++){
            arr[i]=scanner.nextInt();
        }
        for(int i = 1;i < 10;i++){
            if(arr[i] != 0){
                System.out.println(i);
                arr[i]--;
                break;
            }
        }
        while(arr[0] != 0){
            System.out.println(0);
            arr[0]--;
        }
        for(int i = 1; i< 10;i++){
            while(arr[i] != 0){
                System.out.println(i);
                arr[i]--;
            }
        }
    }
}
