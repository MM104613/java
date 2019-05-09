package myForeach;
//foreach只用于数组、类集内容的取得， 不能修改原数组、类集的内容
public class myForeach {
    public static void main(String[] args) {
        int[] data = new int[]{1,5,6,9,8,2,7,57,6,26,88};
        /*for(int i = 0 ; i< data.length ; i++){
            System.out.print(data[i]+"、");  //通过循环索引下标
        }*/
        for(int i :data){ //将数组中每一个元素赋值给i
            System.out.print(i+"、");
        }
    }
}
