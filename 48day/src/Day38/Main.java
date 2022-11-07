package Day38;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CousreTest
 * @Package : Day38
 * @createTime : 2022/11/7 19:01
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
            int k = sc.nextInt();
            int[][] arr = new int[n][m];
            String tmp = sc.nextLine();
            for (int i = 0; i < k; i++) {
                int x = sc.nextInt(), y = sc.nextInt();
                arr[x - 1][y - 1] = 1;
            }
            int[][] ret = new int[n][m];
            for (int i = 0; i < n; i++) {
                ret[i][0] = 1;
            }
            for (int i = 0; i < m; i++) {
                ret[0][i] = 1;
            }
            double div = 0.0;
            for (int i = 1; i < n; i++) {
                for (int j = 1; j < m; j++) {
                    ret[i][j] = ret[i - 1][j] + ret[i][j - 1];
                    if (arr[i - 1][j] == 1) {
                        div += ret[i - 1][j];
                    }
                    if (arr[i][j - 1] == 1) {
                        div += ret[i - 1][j];
                    }
                }
            }
            if (arr[n - 1][m - 1] == 1 || arr[0][0] == 1) div = ret[n - 1][m - 1];
            System.out.printf("%.2f%n", div / ret[n - 1][m - 1]);
        }
    }

    static int ret = 0;

    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            String tmp = sc.nextLine();
            char[][] arr = new char[m][n];
            int x = 0, y = 0;
            for (int i = 0; i < m; i++) {
                tmp = sc.nextLine();
                for (int j = 0; j < n; j++) {
                    arr[i][j] = tmp.charAt(j);
                    if (arr[i][j] == '@') {
                        x = i;
                        y = j;
                        arr[i][j] = '.';
                    }
                }
            }
            findPath(arr, x, y, m, n);
            System.out.println(ret);
            ret = 0;
        }
    }

    private static void findPath(char[][] arr, int x, int y, int m, int n) {
        if (x < 0 || y < 0 || x >= m || y >= n || arr[x][y] != '.') {
            return;
        }
        ret++;
        arr[x][y] = '#';

        findPath(arr, x + 1, y, m, n);
        findPath(arr, x, y - 1, m, n);
        findPath(arr, x - 1, y, m, n);
        findPath(arr, x, y + 1, m, n);
    }

}
