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


    static int ret = 0;

    public static void main(String[] args) {
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
