package MyStackTest.Impl;
import MyStackTest.Stack;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayStack<T> implements Stack<T> {
    private  Object elements[];//存放定数据
    private  int maxSize; //栈的大小 最多存放的元素个数
    private  int currentSize; // 栈中存放当前个数

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        elements = new Object[maxSize]; //数组初始化
    }

    @Override
    //入栈
    public boolean push(T t) {
        if(currentSize == maxSize){
            //扩容
            int oldSize = maxSize;
            int newSize = oldSize << 1;
            if(newSize+8 > Integer.MAX_VALUE){
                System.out.println("栈太大了");
                return false;
            }
            maxSize = newSize;
            elements= Arrays.copyOf(elements,maxSize);
        }
            elements[currentSize]=t;
             currentSize++  ;
            return true;


    }

    @Override
    //出栈
    public T pop() {
        if(isEmpty()){
            System.out.println("栈已为空");
            return null;
        }
        return (T) elements[--currentSize];
    }

    @Override
    //求栈顶元素
    public T peek() {
        if(isEmpty()){
            System.out.println("当前栈为空");
        }
        return (T) elements[currentSize -1];
    }

    @Override
    //返回当前栈中个数
    public int getSize() {
        return currentSize;
    }

    @Override
    //栈是否为空
    public boolean isEmpty() {
        return currentSize==0;
    }
}
