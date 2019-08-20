package SevenSort.FastSort;
//快速排序-单路快排
/*
思想： 6   4    9     3     2    5    8
   values  i
      j
*/
public class FastSort {
    public static void Fast(int[] arr) {
       int n = arr.length;
       if(n <= 1)
           return;
       quickSortInternal(arr,0,n-1);//快排内部
    }
    public static void quickSortInternal(int[] arr,int l,int r){
        if(r <= l)  //右边大于等于左边返回
            return;
        int q = partition(arr,l,r);
        quickSortInternal(arr,l,q-1); //递归左边
        quickSortInternal(arr,q+1,r); //递归右边
    }
    public static int partition(int[] arr,int l, int r){
        int randomNum = (int) (Math.random()*(r-l+1)+l);//任意取一个随机数
        Swap(arr,l,randomNum);//将取到的随机数与第一个值交换
        int values = arr[l]; //最左边第一个数
        int j = l; //第一个数下标
        int i = l+1; //第二个数下标
        for(;i <= r;i++){
            if(arr[i] < values){ //若此数比基准数小 和j+1交换
                Swap(arr,i,j+1);
                j++;
            }
        }
        Swap(arr,j,l);
        return j;
    }
    public static void Swap(int[] arr,int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
     }


}
