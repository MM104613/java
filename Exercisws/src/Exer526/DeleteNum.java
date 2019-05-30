package Exer526;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DeleteNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int  length = scanner.nextInt();
            Queue list = new LinkedList();
            if(length> 1000){
                length = 999;
            }
            for(int i = 0 ; i < length ; i++){
                list.offer(i);
            }
            while(list.size()!=1){
                for(int j = 0;j<2;j++){
                    list.offer(list.poll());
                }
                list.poll();
            }
            System.out.println(list.poll());
        }
    }
}
