package SevenSort.Test;

import SevenSort.BubbleSort.BubbleSort;
import SevenSort.FastSort.FastSort;
import SevenSort.SelectSort.SelectSort;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
        int[] data = makeData(50,50);
       // BubbleSort.Bubble(data);冒泡排序
        //SelectSort.Select(data);选择排序
        FastSort.Fast(data);
        print(data);
    }
    public static int[] makeData(int size,int range){
        int[] arr = new int[size];
        Random random = new Random();
        for(int i =0;i < size;i++){
            arr[i] = random.nextInt(range);
        }
        return arr;
    }
    public static void print(int[] arr){
        for(int n : arr){
            System.out.print(n+"、");
        }
    }
}
