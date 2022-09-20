package Day8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CousreTest
 * @Package : Day8
 * @createTime : 2022/9/20 10:39
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class Main {
    public static boolean lexicographically(String[] str) {
        boolean ret = true;
        for (int i = 0; i < str.length - 1; i++) {
            if (str[i].compareTo(str[i + 1]) > 0) {
                return false;
            }
        }
        return ret;
    }

    public static boolean length(String[] str) {
        boolean ret = true;
        for (int i = 0; i < str.length - 1; i++) {
            if (str[i].length() > str[i + 1].length()) {
                return false;
            }
        }
        return ret;
    }

    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            //因为输入的n后面还有一个回车，in.nextLine()会读取为一行；
            in.nextLine();
            String[] str = new String[n];
            for (int i = 0; i < n; i++) {
                str[i] = in.nextLine();
            }
            if (length(str) && lexicographically(str)) {
                System.out.println("both");
            } else if (length(str)) {
                System.out.println("lengths");
            } else if (lexicographically(str)) {
                System.out.println("lexicographically");
            } else {
                System.out.println("none");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int a = sc.nextInt(), b = sc.nextInt();
            System.out.println((a / cal(a, b)) * b);
        }
    }

    private static int cal(int a, int b) {
        return b == 0 ? a : cal(b, a % b);
    }
}
