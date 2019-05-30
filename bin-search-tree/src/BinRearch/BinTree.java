package BinRearch;

public interface BinTree<E> {
    void add(E e);

    boolean contain(E e);

    E getMax();
    E getMin();
    boolean remove();
    E removeMax();
    E removeMin();
    //前序遍历
    void preOrder();
    void inOrder();
    void postOrder();
    int size();
    void levelOrder(); //层序遍历
}
