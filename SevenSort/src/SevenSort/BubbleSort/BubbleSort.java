package SevenSort.BubbleSort;

import SevenSort.InsertSort.InsertSort;

//冒泡排序 O(n^2) O(1) 稳定
/*
思想：两两交换
时间复杂度： 1.若数字有序 最好时间复杂度：O(n)
            2.若无序   最坏时间复杂度：O(n^2)

优化：若数组已经有序
设置标志位
  * */
public class BubbleSort {
    public static void Bubble(int[] arr) {
        boolean flag =false;
        int n = arr.length;
        if (n <= 1) {  //数组中没有元素
            return;
        } else {
            for (int i = 0; i < n; i++) {  //控制趟数
                for (int j = 0; j < n - 1 - i; j++) { //控制每趟的交换次数
                    if (arr[j] > arr[j + 1]) {
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                        flag = true;
                    }
                }
                if(!flag)
                    break;
            }

        }
    }
}


