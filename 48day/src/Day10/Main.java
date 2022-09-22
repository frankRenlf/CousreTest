package Day10;

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
