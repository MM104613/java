package BinRearch.SearchTree;

public class Test {
    public static void main(String[] args) {
        BinSearchTree<Integer> b = new BinSearchTree<>();
        b.add(5);
        b.add(8);
        b.add(9);
        b.add(1);
        b.add(3);
        b.add(7);
        b.add(5);
        System.out.println(b.contain(7));
    }
}
