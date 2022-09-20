package Day8;

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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            String[] subs = new String[n];
            boolean lex = true, len = true;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                subs[i] = sc.nextLine();
                min = Math.min(min, subs[i].length());
                if (i > 0) {
                    if (subs[i].length() < subs[i - 1].length()) len = false;
                }
            }
//            for (int i = 0; i < min; i++) {
//                for (int j = 1; j < n; j++) {
//                    if (subs[j - 1].charAt(i) > subs[j].charAt(i)) {
//                        lex = false;
//                        break;
//                    }
//                }
//            }
//            if (lex && len) System.out.println("both");
//            else if (lex) {
//                System.out.println("lexicographically");
//            } else if (len) {
//                System.out.println("length");
//            } else {
//                System.out.println("none");
//            }
        }
    }

}
