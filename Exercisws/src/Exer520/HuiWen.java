package Exer520;

import java.util.Scanner;

public class HuiWen {
    private static boolean isHuiWen(String str) {
        int i = 0;
        int j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        //输入字符串A、B
        //将字符串B插入字符串A
        //判断是否为回文
        Scanner scanner = new Scanner(System.in);
        String strA = scanner.nextLine();
        String strB = scanner.nextLine();
        int count = 0;
        for (int i = 0; i <= strA.length(); i++) {
            StringBuffer sb = new StringBuffer(strA);
            sb.insert(i, strB);
            if (isHuiWen(sb.toString())) {
                count++;
            }
        }
        System.out.println(count);
    }


}
