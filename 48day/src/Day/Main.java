package Day;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CousreTest
 * @Package : Day
 * @createTime : 2022/9/23 20:59
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
//abstract interface a{
//
//}
public abstract class Main {
//    public void test(int a){
//
//    }
//    public int test(int a){
//
//    }
    public int a =1;
    public void method(){

    }
    public abstract int method(int a);

    public static void main(String[] args) {
//        String s1 = "hello";
//        String s2 = "hel" +"lo";
//        System.out.println(s1==s2);
        byte b1 = 127;
        b1++;
        System.out.println(b1);
    }

    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            for (int i = 2; i < n - 1; i++) {
                int j = 2;
                double end = Math.sqrt(i);
                for (; j <= end; j++) {
                    if (i % j == 0) break;
                }
                if (j > end) list.add(i);
            }
//            System.out.println(list);
            int left = 0, right = list.size() - 1;
            int[] ret = new int[]{list.get(left), list.get(right)};
            while (left <= right) {
                int lv = list.get(left), rv = list.get(right);
                int sum = lv + rv;
                if (sum > n) {
                    right--;
                } else if (sum < n) {
                    left++;
                } else {
//                    if (rv - lv < ret[1] - ret[0]) {
                        ret[0] = lv;
                        ret[1] = rv;
//                    }
                    left++;
                    right--;
                }
            }
            System.out.println(ret[0]);
            System.out.println(ret[1]);
        }
    }


    public int binInsert(int n, int m, int j, int i) {
        // write code here
        m <<= j;
        return n ^ m;
    }

}
