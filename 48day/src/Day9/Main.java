package Day9;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CousreTest
 * @Package : Day9
 * @createTime : 2022/9/21 10:30
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */

class Person{
    String p = "111";

    public Person(String p) {
        this.p = p;
    }
}

class child extends Person{
    String n = "abc";
    public child(String p, String n) {
        super(p);
        n.toUpperCase();
        this.n = n;
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt() + 1, m = sc.nextInt() + 1;
            int[][] dp = new int[m][n];
            for (int i = 0; i < n; i++) {
                dp[0][i] = 1;
            }
            for (int i = 1; i < m; i++) {
                dp[i][0] = 1;
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] + dp[i][j - 1]);
                }
            }
            System.out.println(dp[m - 1][n - 1]);
        }
    }

    public int addAB(int A, int B) {
        // write code here
        if (B == 0) {
            return A;
        }
        while (B != 0) {
            int sum = A ^ B;
            int carray = (A & B) << 1;
            A = sum;
            B = carray;
        }
        return A;
    }
}
