package day4;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CousreTest
 * @Package : day4
 * @createTime : 2022/9/7 18:52
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            StringBuffer ret = new StringBuffer();
            String[] arr = new String[]{"A", "B", "C", "D", "E", "F"};
            String pn = "";
            if (m < 0) {
                pn = "-";
                m = -m;
            } else if (m == 0) {
                System.out.println(0);
                continue;
            }
            while (m > 0) {
                int key = m % n;
                ret.insert(0, key >= 10 ? arr[key - 10] : key);
                m /= n;
            }
            ret.insert(0, pn);
            System.out.println(ret);
        }
    }

    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int[] arr = new int[4];
            for (int i = 0; i < 4; i++) {
                arr[i] = sc.nextInt();
            }
            int[] ret = new int[3];
            ret[0] = (arr[0] + arr[2]) / 2;
            ret[1] = (arr[2] - arr[0]) / 2;
            ret[2] = (arr[3] - arr[1]) / 2;
            if (arr[3] - ret[2] != ret[1]) {
                System.out.println("No");
            } else {
                for (int x : ret) {
                    System.out.print(x + " ");
                }
            }
        }
    }

}
