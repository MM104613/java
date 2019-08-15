package SevenSort.InsertSort;
//二分排序
public class BinInsertSort {
    public static void  BinInsert(int arr[]){
        int n = arr.length;
        if(n <= 1){
            return;
        }else{
            int low,mid,high,j;
            for(int i = 1;i < n;i++){
               int values = arr[i];//未排序第一个数
               low = 0;
               high = i-1;
               while(low <= high){
                   mid = (low + high)/2;
                   if(arr[mid] < values){
                       low = mid+1;
                   }else {
                       high = mid - 1;
                   }
               }
               for(j = i-1; j >high;j--){
                    arr[j+1] = arr[j];
               }
               arr[j+1] = values;
            }
        }
    }
}
