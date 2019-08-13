package SevenSort.InsertSort;
//插入排序  原地算法  稳定  O(n^2)
/*
思想：分成两个区域
        已排序                      未排序
默认第一个数为已排序区                第二个数到最后一个数为未排序区
将已排序区的数倒着遍历 若碰到未排序区的数小于将已排序区的数向后移动 将数插入其中
*/
public class InsertSort {
    public void Insert(int arr[]){
       int n = arr.length;
       if(n <= 1){ //若数组中只有一个元素
           return;
       }else{
           for(int i =1; i < n;i++){
               int values = arr[i];
               int j = i-1;
               for(; j >= 0; j--){
                   if(arr[j] > values){
                       arr[j+1] = arr[j];
                   }else{
                       break;
                   }
               }
               arr[j+1] = values;
           }
           System.out.print("插入排序：");
           for(int a =0; a< n; a++){
               System.out.print(+arr[a]+"、");
           }
       }
    }
}
