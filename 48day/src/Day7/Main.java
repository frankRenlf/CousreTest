package Day7;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CousreTest
 * @Package : Day7
 * @createTime : 2022/9/19 11:48
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class Main {

    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int pre = 0;
            int cur = 1;
            while (cur < n) {
                int next = pre + cur;
                pre = cur;
                cur = next;
            }
            System.out.println(Math.min(cur - n, n - pre));
        }
    }

    public boolean chkParenthesis(String A, int n) {
        // write code here
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            char c = A.charAt(i);
            if (c == ')' && !stack.isEmpty()) {
                stack.pop();
            } else if (c == '(') {
                stack.push(c);
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    static Main main = new Main();

    public static void main(String[] args) {
//        System.out.println(main.chkParenthesis("())()", 5));
        System.out.println(Math.round(11.5));
    }

}
