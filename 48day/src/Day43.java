import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CousreTest
 * @Package : PACKAGE_NAME
 * @createTime : 2022/11/14 8:42
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class Day43 {

    static int n;
    static int m;
    static List<String> list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            n = sc.nextInt();
            m = sc.nextInt();
            list = new ArrayList<>();
            dfs(0, 0, "");
            for(String s:list){
                System.out.println(s);
            }
        }
    }

    private static void dfs(int begin, int sum, String str) {
        if (sum == m) {
            list.add(new String(str.trim()));
            return;
        }
        if (sum > m) {
            return;
        }
        for (int i = begin; i < n; i++) {
            dfs(i + 1, sum + i + 1, str + (i + 1) + " ");
        }
    }

}
