package Day29;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CousreTest
 * @Package : Day29
 * @createTime : 2022/10/20 20:48
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class Main {

    public int getFirstUnFormedNum(int[] arr) {
        // 全是正数的 arr
        // i 代表物品
        // j 代表背包容量
        // 目地: 找出数组中最小不可能组成和
        //       ==> 找出最小不能被填满的背包

        // 1. 得到最大最小值
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max += arr[i];
            if (min > arr[i]) {
                min = arr[i];
            }
        }

        // 2. 定义 dp 数组
        boolean[] dp = new boolean[max + 1];
        // 初始化
        dp[0] = true;

        // 3. 递推过程
        for (int i = 0; i < arr.length; i++) {
            for (int j = max; j >= arr[i]; j--) {
                // 当 j == arr[i] 的时候, j - arr[i] 代表自己能够到达的下标 2-2 = 0
                // 第一个为 T 的是 3, 当 j == 3 的时候, j - arr[i] = 0;
                // 第二个位 T 的是 5, 当 j == 5 的时候, j - arr[i] = 3;
                // 第三个为 T 的是 2, 当 j == 2 的时候, j - arr[i] = 0;
                // 第四个为 T 的是 9, 当 j == 9 的时候, j - arr[i] = 5;
                // 第五个为 T 的是 7, 但 j == 7 的时候, j - arr[i] = 3;
                // 第六个为 T 的是 6, 当 j == 6 的时候, j - arr[i] = 2;
                // 第七个为 T 的是 4, 当 j == 4 的时候, j - arr[i] = 0;
                dp[j] = dp[j - arr[i]] || dp[j];
                // dp[j-arr[i]] 代表 "拿" 当前数字
                // dp[j] 代表不拿当前数字 比如 5 的时候, dp[5] || dp[5-1] 原来 dp[5] 是 T dp[1] 是 F, 所以这个时候 "不拿"
            }
        }

        // 打印数组
        System.out.println(Arrays.toString(dp));

        // 4. 查询结果
        for (int i = min; i < dp.length; i++) {
            if (!dp[i]) {
                return i;
            }
        }
        return max + 1;
    }


}
