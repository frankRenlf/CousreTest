package Day26;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CousreTest
 * @Package : Day26
 * @createTime : 2022/10/18 15:22
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class Main {

    public int jumpFloorII(int number) {
        // write code here
        int[] dp = new int[number + 1];
        Arrays.fill(dp, 1);
        for (int i = 0; i <= number; i++) {
            for (int j = 1; j <= number; j++) {
                if (i + j <= number) {
                    dp[i + j] += dp[i];
                } else {
                    break;
                }
            }
        }
        return dp[number];
    }

}
