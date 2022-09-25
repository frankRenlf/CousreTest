package Day13;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CousreTest
 * @Package : Day13
 * @createTime : 2022/9/25 22:46
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] dp = new int[2 * m];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[n] = 0;
            for (int i = n; i <= m; i++) {
                if (dp[i] != Integer.MAX_VALUE) {
                    jump(dp, i);
                }
            }
            if (dp[m] != Integer.MAX_VALUE) {
                System.out.println(dp[m]);
            } else {
                System.out.println(-1);
            }
//            System.out.println(Arrays.toString(dp));
        }
    }

    private static void jump(int[] dp, int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                dp[n + i] = Math.min(dp[n + i], dp[n] + 1);
                dp[n + (n / i)] = Math.min(dp[n + (n / i)], dp[n] + 1);
            }
        }
    }

    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
//如果碰到双引号，我们就需要i++直到找到下一个双引号
            if (str.charAt(i) == '"') {
                do {
                    i++;
                } while (str.charAt(i) != '"');
            }
            if (str.charAt(i) == ' ') {
                count++;
            }
        }
        System.out.println(count + 1);
        int flag = 1;
        for (int i = 0; i < str.length(); i++) {
//遇到第一个双引号，flag变为0，
//遇到第二个双引号结束后flag重新变为1
//只要在打印双引号中的内容的时候flag的值始终为0
            if (str.charAt(i) == '"') {
                flag ^= 1;
            }
            //除了双引号和特殊空格以外的字符都要打印
            if (str.charAt(i) != ' ' && str.charAt(i) != '"') {
                System.out.print(str.charAt(i));
            }
//双引号中的空格需要打印
            if (str.charAt(i) == ' ' && flag == 0) {
                System.out.print(str.charAt(i));
            }
            //双引号外碰到空格，需要换行
            if (str.charAt(i) == ' ' && flag == 1) {
                System.out.println();
            }
        }
    }


}
