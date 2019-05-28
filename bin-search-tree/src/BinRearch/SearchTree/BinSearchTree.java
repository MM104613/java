package BinRearch.SearchTree;

import BinRearch.BinTree;

public class BinSearchTree<E extends Comparable<E>> implements BinTree<E> {
    class Node {
        E data;
        private Node left;
        private Node right;

        public Node(E data) {
            this.data = data;
        }
    }

    private int size;
    private Node root;

    @Override
    public void add(E e) {
        if (root == null) {
            Node node = new Node(e);
            root = node;
        }
        add(root, e);
        size++;
    }

    private void add(Node node, E e) {
        if (e.compareTo(root.data)==0) {
            return;
        }else if(e.compareTo(node.data) < 0 && node.left == null){
            Node newNode = new Node(e);
            node.left=newNode;
        }else if(e.compareTo(node.data) > 0 && node.right == null){
            Node newNode = new Node(e);
            node.right=newNode;
        }
        if(e.compareTo(node.data) < 0){
          add(node.left, e);
        }if(e.compareTo(node.data) > 0){
          add(node.right, e);
        }

    }

    @Override
    public boolean contain(E e) {
        return false;
    }

    @Override
    public E getMax() {
        return null;
    }

    @Override
    public E getMin() {
        return null;
    }

    @Override
    public boolean remove() {
        return false;
    }

    @Override
    public E removeMax() {
        return null;
    }

    @Override
    public E removeMin() {
        return null;
    }

    @Override
    public void preOrder() {

    }

    @Override
    public void inOrder() {

    }

    @Override
    public void postOrder() {

    }

    @Override
    public int size() {
        return size;
    }
}