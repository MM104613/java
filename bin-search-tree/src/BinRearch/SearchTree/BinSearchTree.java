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
    /*public void add(E e) {
        add(root, e);
    }
    private Node add(Node node, E e) {
        return node;
    }
*/
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
        if(root == null)
            throw new IllegalArgumentException("搜索树为空");
            Node maxNode = getMaxNode(root);
            return maxNode.data;
    }
    private Node getMaxNode(Node node){
        if(node.right == null){
            return node;
        }
        return getMaxNode(node.right);
    }

    @Override
    public E getMin() {
        if(root == null)
            throw new IllegalArgumentException("搜素树为空");
            Node minNode = getMinNode(root);
            return minNode.data;
            }
    private Node getMinNode(Node node){
        if(node.left == null){
            return node;
        }
        return getMinNode(node.left);
    }

     //删除任意元素
    @Override
    public void remove(E e) {
         root = removeNode(root,e);
    }
    private Node removeNode(Node node, E e){
        if(node == null){
            return null;
        }
        if(e.compareTo(node.data)<0){
            node.left = removeNode(node.left,e);
        }
        if(e.compareTo(node.data)>0){
            node.right=removeNode(node.right,e);
        }else{ //要删除的节点只有左孩子
            if(node.left != null && node.right == null){
                Node leftResult = node.left;
                node.left =null;
                size --;
                return leftResult;
            }//要删除的数只有右孩子
            if(node.right != null && node.left==null){
                Node rightResult = node.right;
                node.right = null;
                size --;
                return rightResult;
            }//要删除的数左孩子右孩子都有
            //找到前驱或者后继节点
            if(node.right != null && node.left != null){
             Node preNode = getMaxNode(node.left);
             preNode.right = node.right;
             preNode.left=removeMaxNode(node.left);
             node.left=node.right=null;
             size --;
            }
        }
        return node;
    }


    @Override
    public E removeMax() {
        E result = getMax();
        root = removeMaxNode(root);
        return result;
    }
    private Node removeMaxNode(Node node){
        if(node.right == null){
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMaxNode(node.right);
        return node ;
    }

    @Override
    public E removeMin() {
        E result = getMin();
        root = removeMinNode(root);
        return result;
    }
    private Node removeMinNode(Node node){
        if(node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMinNode(node.left);
        return node;
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
    }

    @Override
    public void postOrder() {
        postOrder(root);
    }
    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.data);
    }

    @Override
    public int size() {
        return size;
    }
 //层序遍历
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