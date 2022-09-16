package day6;

import javax.management.ObjectName;
import java.util.Scanner;

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
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int m = sc.nextInt(), n = sc.nextInt();
            int evenICount = (n / 4) * 2 + (Math.min(n % 4, 2));
            int oddICount = ((n - 2) / 4) * 2 + (Math.min((n - 2) % 4, 2));
            int ans = m / 4 * (evenICount + oddICount) * 2;
            if(m % 4 > 0) ans += evenICount;
            if(m % 4 > 1) ans += evenICount;
            if(m % 4 > 2) ans += oddICount;
            System.out.println(ans);
        }
    }
}
