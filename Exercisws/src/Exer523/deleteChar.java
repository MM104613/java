package Exer523;

import java.util.Scanner;

public class deleteChar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        StringBuilder sb = new StringBuilder(str1);
        for (int i = 0; i < str2.length(); i++) {
            for (int j = 0; j < sb.length(); j++) {
                if (sb.charAt(j) == str2.charAt(i)) {
                    sb.deleteCharAt(j);
                }
            }

        }
        System.out.println(sb);
    }
}