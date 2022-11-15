package Day44;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CousreTest
 * @Package : Day44
 * @createTime : 2022/11/15 9:32
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            StringBuilder ret = new StringBuilder();
            int j, i;
            for (j = 0, i = 1; i < s.length(); i++) {
                if (s.charAt(i) == '_') {
                    String tmp = s.substring(j, i);
                    if (j != 0) {
                        ret.append(tmp.substring(0, 1).toUpperCase())
                                .append(tmp.substring(1));
                    } else {
                        ret.append(tmp);
                    }
                    j = i + 1;
                }
            }
            String tmp = s.substring(j, i);
            ret.append(tmp.substring(0, 1).toUpperCase())
                    .append(tmp.substring(1));
            System.out.println(ret);
        }
    }

}
