package Day45;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CousreTest
 * @Package : Day45
 * @createTime : 2022/11/16 21:49
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {

        }
    }

    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String a = sc.next();
            String b = sc.next();
            int[] arr = new int[26];
            for (char s : a.toCharArray()) {
                arr[s - 'A']++;
            }
            boolean k = true;
            for (char s : b.toCharArray()) {
                arr[s - 'A']--;
                if (arr[s - 'A'] < 0) {
                    k = false;
                    break;
                }
            }
            if (k) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

}
