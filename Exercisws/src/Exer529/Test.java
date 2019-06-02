package Exer529;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num = scanner.nextDouble();
        num = fac(num);
        int result = find(num);
        System.out.println(result);
    }

    private static int find(double a) {
        if (a <= 1) {

            return 0;

        }

        int cnt = 0;

        while (a > 0) {

            cnt += a / 5;

            a /= 5;

        }

        return cnt;


    }

    private static double fac(double n) {

        if (n == 1) {
            return 1;
        }
        return (int) (n * fac(n - 1));
    }
}


