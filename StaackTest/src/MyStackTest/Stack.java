package MyStackTest;

public interface Stack<T> {
    //入栈
    boolean push(T t);
    //出栈
    T pop();
    //栈顶元素
    T peek();
    //当前栈中元素个数
    int getSize();
    //是否为空
    boolean isEmpty();
}
