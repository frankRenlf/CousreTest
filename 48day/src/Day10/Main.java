package Day10;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.Locale;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CousreTest
 * @Package : Day10
 * @createTime : 2022/9/22 10:51
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            int pl, pa, pn, ps, pr;
            int ca = 0, cn = 0, cs = 0;
            int len = s.length();
            pl = len <= 4 ? 5 : (len <= 7 ? 10 : 25);
            int small = 0, big = 0;
            for (int i = 0; i < len; i++) {
                char c = s.charAt(i);
                if (Character.isDigit(c)) {
                    cn++;
                } else if (Character.isAlphabetic(c)) {
                    ca++;
                    if (c >= 65 && c <= 90)
                        big++;
                    else if (c >= 97 && c <= 122)
                        small++;
                } else {
                    cs++;
                }
            }
            if (ca != 0) {
                pa = big > 0 && small > 0 ? 20 : 10;
            } else {
                pa = 0;
            }
            if (cn != 0) {
                pn = cn == 1 ? 10 : 20;
            } else {
                pn = 0;
            }
            if (cs != 0) {
                ps = cs == 1 ? 10 : 25;
            } else {
                ps = 0;
            }
            if (pa == 20 && pn > 0 && ps > 0) {
                pr = 5;
            } else if (pa > 0 && pn > 0 && ps > 0) {
                pr = 3;
            } else if (pa > 0 && pn > 0) {
                pr = 2;
            } else {
                pr = 0;
            }
            int sum = pl + pa + pn + ps + pr;
            String RET;
            if (sum >= 90) {
                RET = "VERY_SECURE";
            } else if (sum >= 80) {
                RET = "SECURE";
            } else if (sum >= 70) {
                RET = "VERY_STRONG";
            } else if (sum >= 60) {
                RET = "STRONG";
            } else if (sum >= 50) {
                RET = "AVERAGE";
            } else if (sum >= 25) {
                RET = "WEAK";
            } else {
                RET = "VERY_WEAK";
            }
            System.out.println(RET);
        }
    }

    public boolean checkWon(int[][] board) {
        // write code here
        int n = board.length, m = board[0].length;
        for (int i = 0; i < n; i++) {
            int j = 0;
            for (; j < m; j++) {
                if (board[i][j] != 1) {
                    break;
                }
            }
            if (j == m) return true;
        }
        for (int i = 0; i < m; i++) {
            int j = 0;
            for (; j < n; j++) {
                if (board[j][i] != 1) {
                    break;
                }
            }
            if (j == n) return true;
        }
        int i = 0;
        for (; i < n; i++) {
            if (board[i][i] != 1) break;
        }
        if (i == n) return true;
        int j = 0;
        for (; j < n; j++) {
            if (board[n - 1 - j][j] != 1) break;
        }
        return j == n;
    }

}
