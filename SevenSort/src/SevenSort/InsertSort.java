package SevenSort;
//插入排序
/*
思想：分成两个区域
        已排序                      未排序
默认第一个数为已排序区                第二个数到最后一个数为未排序区

*/
public class InsertSort {
    public void Insert(int arr[]){
        int n = arr.length;
        if( n <= 1){ //若只有一个值，直接返回
            return;
        }else{
            for(int i = 1;i < n;i++){
                int values = arr[i];  //从第二个值开始比较
                int j = i-1;
                for(;j <= 0;j--){
                    if(arr[j] > values){
                     arr[j+1] = arr[j];
                    }else{
                        break;
                    }
                }
                 arr[j+1] = values;
            }
            System.out.print("插入排序：");
            for(int num =0; num< arr.length;num++){
                System.out.print(arr[num]+"、");
            }
        }
    }
}
