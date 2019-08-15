package SevenSort.FastSort;

public class FastSort {
    public static void Fast(int[] arr) {
        int n = arr.length;
        if(n <= 1 ){
            return;
        }
        quickSortInternal(arr,0,n-1);
    }
    public static void quickSortInternal(int[] arr,int l,int r){
        if(r <= l)
            return;
        int q = partition(arr,l,r);
        quickSortInternal(arr,l,q-1);
        quickSortInternal(arr,q+1,r);
    }
    public static int partition(int[] arr,int l,int r){
        int values = arr[l];
        int j = l;
        int i =l+1;
        for(;i <= r;i++){
            if(arr[i] < values){
                Swap(arr,i,j+1);
                j++;
            }
        }
        Swap(arr,l,j);
        return j;
    }
    public static void Swap(int[] arr,int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
