package Array;

import java.util.Arrays;

public class ArrayImp<T> implements Sequence<T> {
    private static final int DEFAULT = 10;
    private static final int MAX_SIZE = Integer.MAX_VALUE - 8;
    private int size;
    private T[] array;

    public ArrayImp() {
        array = (T[]) new Object[DEFAULT];
    }

    @Override
    public void add(T num) {
            ensureArray(size+1);
            array[size++] = num;
    }
    private   void ensureArray(int minCap){
        if(minCap < array.length ){
            grow(minCap);
        }
    }
    private void grow(int minCap){
        int oldCap = array.length;
        int newCap = oldCap << 2;
        if(newCap < minCap){
            newCap = minCap;
        }
        if(newCap > MAX_SIZE){
            throw new ArrayIndexOutOfBoundsException("数组过大");
        }
        array = Arrays.copyOf(array,newCap);
    }
    @Override
    public T remove(int index) {
       checkIndex(index); //判断下标是否存在
        T oldIndex =  array[index];
        int moveSize = size - index -1;
        if(moveSize > 0){
            System.arraycopy(array,index+1,array,index,moveSize);
        }
        array[--size] = null;
        return oldIndex;
    }
      //判断查找的数是否存在
    private void checkIndex(int  index) {
        if(size < index){
            System.out.println("查找的数下标不存在！");
        }
    }


    @Override
    public T set(int index, T newNum) {
        checkIndex(index);
        T oldNum = array[index];
        array[index] = newNum;
        return oldNum;
    }

    @Override
    public boolean contains(T num) {
        if(num == null){  //判断列表里的空元素
            for(int i = 0; i < array.length ; i++){
                if(num == null){
                    return true;
                }
            }
        }else {
            for(int i = 0; i < array.length; i++){
               if(array[i].equals(num)){
                   return true;
               }
            }
        }
        return false;
    }

    @Override
    public int size() {

        return size;
    }

    @Override
    public void clear() {
        for (int i= 0; i < array.length;i++){
          array[i] = null;
        }
        size = 0;
    }

    @Override
    public T[] toArray() {

        return Arrays.copyOf(array,size);
    }
}
