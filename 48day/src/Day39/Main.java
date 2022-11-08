package Day39;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CousreTest
 * @Package : Day39
 * @createTime : 2022/11/8 21:25
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class Main {

    private static int process(String str1, String str2, int len1, int len2) {
        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();
        long res = 0;
        for (int i = len1; i <= len2; i++) {
            char a = ch1[0];
            char b = ch2[0];
            res += (long) Math.pow(26, i - 1) * (b - a);
            long suma = 0;
            long sumb = 0;
            for (int j = 1; j < ch1.length; j++)// 找到比ch1剩余字符串小的字符串个数
            {
                suma = suma + (ch1[j] - 'a') * (long) Math.pow(26, i - 1 - j);
            }
            for (int j = 1; j < ch2.length; j++)// 找到比ch2剩余字符串小的字符串个数
            {
                sumb = sumb + (ch2[j] - 'a') * (long) Math.pow(26, i - 1 - j);
            }
            res = res + sumb - suma;
        }
        res--;
        res = res % 1000007;
        return (int) res;
    }

    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s1 = sc.next(), s2 = sc.next();
            int len1 = sc.nextInt(), len2 = sc.nextInt();
            int ret = process(s1, s2, len1, len2);
            System.out.println(ret);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            char[] s1 = sc.next().toCharArray(), s2 = sc.next().toCharArray();
            int m = s1.length, n = s2.length;
            int[][] dp = new int[m + 1][n + 1];
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (s1[i - 1] == s2[j - 1]) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
            System.out.println(dp[m][n]);
        }
    }

}
