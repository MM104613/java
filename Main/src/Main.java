import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        ArrayList<Integer> w = new ArrayList<>();
        if (n < 0 && n >100000 || w.size()<0 &&w.size() > 100000) {
            System.out.println("出错了");
        }
        for (int i = 0; i < n; i++) {
            w.add(s.nextInt());
        }
        int sum =0;
        int f =0;
        ArrayList<Integer> b = new ArrayList<>();
        for(int j =1 ; j <= n ; j++){
            for(int i = j-1; i < n ;i++){
                sum +=w.get(i);
            }
            int min = Collections.min(w);
            f = min * sum;
            b.add(f);
            b.remove(j-1);
        }
        int c= Collections.max(b);
        System.out.println(c);
    }
}

