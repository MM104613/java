
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            char[] chars = scanner.next().toCharArray();
            StringBuffer sb = new StringBuffer();
            Set<Character> s = new HashSet<>();
            for(int i =0;i <chars.length;i++ ){
                if(s.add(chars[i])){
                    sb.append(chars[i]);
                }

            }
            System.out.println(sb.toString());
        }
    }

}