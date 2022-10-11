package Day19;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CousreTest
 * @Package : Day19
 * @createTime : 2022/10/11 15:57
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s1 = sc.nextLine();

            String s2 = sc.nextLine();
            if (s1.length() <= s2.length()) find(s1, s2);
            else find(s2, s1);
        }
    }

    public static void longString(String str1, String str2) {
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        int len1 = arr1.length;
        int len2 = arr2.length;
        //定义最大长度maxLen ，开始下标start
        int maxLen = 0;//最长子串的长度
        int start = 0;//最长子串的起始位置
        int[][] maxSubLen = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                //如果第i个字符与第j个字符相等，则进行累加
                if (arr1[i - 1] == arr2[j - 1]) {
                    maxSubLen[i][j] = maxSubLen[i - 1][j - 1] + 1;
                    //更新
                    if (maxLen < maxSubLen[i][j]) {
                        maxLen = maxSubLen[i][j];
                        start = i - maxLen;
                    }
                }
            }
        }
        System.out.println(str1.substring(start, start + maxLen));

    }

    private static void find(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        int[][] dp = new int[l1 + 1][l2 + 2];
        int maxLen = 0;
        int start = 0;
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (maxLen < dp[i][j]) {
                        maxLen = dp[i][j];
                        start = i - maxLen;
                    }
                }
            }
        }
        System.out.println(s1.substring(start, start + maxLen));
    }

    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            if (n == 0) break;
            int sum = 0;
            int cur = 0;
            int tail = 0;
            while (n != 0) {
                cur = n + tail;
                tail = cur % 3;
                n = cur / 3;
                sum += n;
            }
            sum += tail == 2 ? 1 : 0;
            System.out.println(sum);
        }
    }

}
