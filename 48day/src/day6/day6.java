package day6;

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
        char[] arr = str.toCharArray();
        int key = 1;
        int ret = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == 0 && arr[i] == '-') key = -1;
            else if (i == 0&&arr[i] == '+') {
            } else {
                return -1;
            }
            if (!Character.isDigit(arr[i])) {
                return -1;
            }
            ret *= 10;
            ret += arr[i];
        }
        return ret * key;
    }

    static day6 d6 = new day6();

    public static void main(String[] args) {
        System.out.println(d6.StrToInt("-1234"));
    }
}
