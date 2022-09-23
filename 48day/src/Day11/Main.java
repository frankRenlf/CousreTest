package Day11;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CousreTest
 * @Package : Day11
 * @createTime : 2022/9/23 10:42
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class Main {

    public int getLCA(int a, int b) {
        //每次都让较大的节点先找父节点,
        // 直到 a和b相遇!就是公共节点!
        while (a != b) {
            if (a > b) {
                a /= 2;
            } else {
                b /= 2;
            }
        }
        return a;
    }

}
