import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CousreTest
 * @Package : PACKAGE_NAME
 * @createTime : 2022/9/4 20:32
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine(), s2 = sc.nextLine();
        Set<Character> set = new TreeSet<>();
        for (char x : s2.toCharArray()) {
            set.add(x);
        }
        StringBuffer ret = new StringBuffer();
        for (int i = 0; i < s1.length(); i++) {
            if (set.contains(s1.charAt(i))) {
                continue;
            }
            ret.append(s1.charAt(i));
        }
        System.out.println(ret);
    }

    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] teams = new int[3 * n];
        for (int i = 0; i < teams.length; i++) {
            teams[i] = sc.nextInt();
        }
        Arrays.sort(teams);
        int sum = 0;
        for (int j = 0; j < n; j++) {
            sum += teams[teams.length - 2 * (j + 1)];
        }
        System.out.println(sum);
    }
}
