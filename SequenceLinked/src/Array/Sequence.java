package Array;

public interface Sequence<T> {
    //添加元素
    void add(T num);
    //删除元素
    T remove(int index);
    //修改元素
    T set(int index , T newNum);
    //查找元素
   boolean contains(T num);
    //查看大小
    int size();
    //清空
    void clear();
    //转为数组
    T[] toArray();
}
