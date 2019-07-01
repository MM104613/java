package Heap;

import java.util.Comparator;

public class BinHeap<E> {
    private int size;
    private int[] elements;
    private int initial =10;
    private Comparator<E> comparator;
    public  BinHeap(){
        this(10,null);
    }
    public  BinHeap(int initial){
         this(initial,null);
    }
    public  BinHeap(int initial,Comparator<E> comparator){
        elements = new int[initial];
    }
    public int getSize(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public int leftChild(int index){
        return index * 2 +1;
    }
    public int rightChild(int index){
        return index *2 +2;
    }
    public int parent(int index){
        return (index -1 )/2;
    }

}
