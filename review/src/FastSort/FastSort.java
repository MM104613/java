package FastSort;

class FastTest{
    public void Fast(int[] arr){
        int n = arr.length;
        if(n <= 1)
            return;
        QuickSortInternal(arr,0,n-1);
    }

    private void QuickSortInternal(int[] arr, int l, int r) {
        if(r <= l)
            return;
        int q = partition(arr,l,r);
        QuickSortInternal(arr,0,q-1);
        QuickSortInternal(arr,q+1,r);
    }

    private int partition(int[] arr, int l, int r) {
        int values = arr[l];
        int i = l+1;
        int j= r;
        while(true){
           while(i <= r && arr[i]< values){
                i++;
            }
            while(j >= l+1 && arr[j] > values){
               j--;
            }
            if(i > j){
               break;
            }
         Swap(arr,i,j);
           i++;
           j--;
        }
        Swap(arr,l,j);
        return j;
}
    private void Swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}


public class FastSort {
    public static void main(String[] args) {
       int [] arr = new int []{6,8,5,3,4,9,7,1,2};
      FastTest fastTest = new FastTest();
      fastTest.Fast(arr);
      for(int i =0; i < arr.length;i++){
          System.out.print(arr[i]+"、");
      }
    }
}
