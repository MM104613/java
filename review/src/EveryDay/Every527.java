package EveryDay;

public class Every527 {
    private static int x = 100;

    public static void main(String[] args) {
        Every527 hs1 = new Every527();
        hs1.x++;
        Every527 hs2 = new Every527();
        hs2.x++;
        hs1=new Every527();
        hs1.x++;
        Every527.x--;
        System.out.println( "x=" +x);
    }
}