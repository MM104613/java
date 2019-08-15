package SevenSort.SelectSort;
//选择排序O(n^2) 不稳定
/*
思想：
选择排序就像插入排序一样也分已排序区间与未排序区间
默认第一个数为最小数，第一次遍历找到最小数，若不是第一个数，则和第一个数交换，以此类推 完成排序*/
public class SelectSort {
    public static void Select(int[] arr){
        int n = arr.length;
        if(n <= 1){
            return;
        }else {
            for(int i =0;i < n-1 ;i++ ){
                int minIndex = i;//默认第一个数为最小数
                for(int j = i+1; j < n;j++){
                    if(arr[j] < arr[minIndex]){
                        minIndex = j;
                    }
                }
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] =temp;
            }
        }
    }
}
