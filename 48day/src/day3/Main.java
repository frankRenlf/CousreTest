package day3;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CousreTest
 * @Package : day3
 * @createTime : 2022/9/7 14:01
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
//public class ret {
//
//}
public class Main {

    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "hel" + new String("lo");
        System.out.println(s1 == s2);
    }

    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            int[] ret = new int[2];
            int index = 0;
            for (int i = 0; i < s.length(); ) {
                if (Character.isDigit(s.charAt(i))) {
                    index = i;
                    while (i < s.length() && Character.isDigit(s.charAt(i))) {
                        i++;
                    }
                    if (i - index > ret[1] - ret[0]) {
                        ret[0] = index;
                        ret[1] = i;
                    }
                } else {
                    i++;
                }
            }
            System.out.println(s.substring(ret[0], ret[1]));
        }
    }

    public int MoreThanHalfNum_Solution(int[] array) throws Exception {
        int count = 0;
        int key = 0;
        for (int x : array) {
            if (count == 0) {
                key = x;
            }
            count += x == key ? 1 : -1;
        }
//        if(key>10)throw new Exception("123");
        return key;
    }

//    static Main main = new Main();

}
