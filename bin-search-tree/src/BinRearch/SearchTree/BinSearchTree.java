package BinRearch.SearchTree;

import BinRearch.BinTree;

import java.util.LinkedList;
import java.util.Queue;

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
    /*public void add(E e) {
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

    }*/
    public void add(E e) {
        add(root, e);
    }

    private Node add(Node node, E e) {
        return node;
    }

    @Override
    public boolean contain(E e) {
        if (root == null) {
            return false;
        }
        return contain(root, e);
    }

    private boolean contain(Node node, E e) {
        if (e.compareTo(node.data) == 0) {
            return true;
        } else if (e.compareTo(node.data) < 0) {
            return contain(node.left, e);
        } else if (e.compareTo(node.data) > 0) {
            return contain(node.right, e);
        }
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
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.data);
        preOrder(node.left);
        preOrder(node.right);
    }

    @Override
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.data);
        inOrder(node.right);
        System.out.println(node.data);
    }

    @Override
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        preOrder(node.left);
        preOrder(node.right);
        System.out.println(node.data);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void levelOrder() {
        Queue<Node> queue = new LinkedList<>();
        if (root == null) {
            return;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
          Node node = queue.poll();
            System.out.println(node.data);
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
        }
    }

}