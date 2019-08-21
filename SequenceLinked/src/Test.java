import Array.ArrayImp;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        ArrayImp<Integer> arr = new ArrayImp();
        arr.add(5);
        arr.add(6);
        arr.add(7);
        arr.add(4);
        arr.add(3);
        Object[] data = arr.toArray();
       /* for(Object num : data){
            System.out.print(num+"、");
        }*/
        System.out.println(arr.size());
        System.out.println(arr.remove(0));
        System.out.println(arr.contains(7));
    }
}
