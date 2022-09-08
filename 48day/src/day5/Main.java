package day5;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CousreTest
 * @Package : day5
 * @createTime : 2022/9/8 22:51
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            int len = nums.length;
            int pre = nums[0];
            int max = nums[0];
            for (int i = 1; i < len; i++) {
                pre = Math.max(pre + nums[i], nums[i]);
                max = Math.max(max, pre);
            }
            System.out.println(max);
//            long[] dp = new long[n];
//            dp[0] = nums[0];
//            for (int i = 1; i < n; i++) {
//                dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
//            }
//            System.out.println(dp[n - 1]);
        }
    }

    // abaa ab
    // acc a
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str1 = scanner.nextLine();
            String str2 = scanner.nextLine();
            insert(str1, str2);
        }
    }

    //将Str2拼接到str1，判断回文串的个数
    private static void insert(String str1, String str2) {
        int count = 0;
        for (int i = 0; i < str1.length() + 1; i++) {
            //分隔字符串
            String a = str1.substring(0, i);
            String b = str1.substring(i, str1.length());
            //拼接str2到str1中
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(a);
            stringBuilder.append(str2);
            stringBuilder.append(b);
            //判断是否回文
            if (palindrome(stringBuilder.toString())) {
                count++;
            }
        }
        System.out.println(count);
    }

    //判断是否是回文串
    private static boolean palindrome(String str) {
        char[] array = str.toCharArray();
        int i = 0;//第一个字母下标
        int j = array.length - 1;//最后一个字母下标
        while (i < j) {
            if (array[i] != array[j]) {
                return false;
            }
            //走到这说明第一个和最后一个字母相同，继续判断
            i++;//i往后走一步
            j--;//j往前走一步
        }
        return true;
    }
}

