package day6;

import javax.management.ObjectName;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CousreTest
 * @Package : day6
 * @createTime : 2022/9/16 19:42
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class day6 {

    public int StrToInt(String str) {
        if (str == null || str.length() == 0) return -1;
        char[] arr = str.toCharArray();
        int key = 1;
        int i = 0;
        if (arr[0] == '-') {
            key = -1;
            i = 1;
        } else if (arr[0] == '+') {
            i = 1;
        }
        int ret = 0;
        for (; i < arr.length; i++) {
            if (!Character.isDigit(arr[i])) {
                return 0;
            }
            ret *= 10;
            ret += arr[i] - '0';
//            if (ret >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
        }
        return ret * key;
    }

    static day6 d6 = new day6();

    public static void main(String[] args) {
        System.out.println(d6.StrToInt("-1234"));
    }
}
