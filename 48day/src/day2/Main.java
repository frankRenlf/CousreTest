package day2;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CousreTest
 * @Package : day2
 * @createTime : 2022/9/7 11:05
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            int len = s.length();
            int end = len - 1;
            StringBuffer ret = new StringBuffer();
            while (end >= 0) {
                int cur = end;
                while (cur >= 0 && s.charAt(cur) != ' ') {
                    cur--;
                }
                ret.append(s.substring(cur + 1, end + 1));
                while (cur >= 0 && s.charAt(cur) == ' ') {
                    ret.append(s.charAt(cur));
                    cur--;
                }
                end = cur;
            }
            System.out.println(ret);
        }
    }

    public static void main1(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt(); //长度给n+1防止越界
            int[] array = new int[n + 1];
            for (int i = 0; i < n; i++) {
                array[i] = sc.nextInt();
            }
            int i = 0;
            int count = 0;
            while (i < n) { //进入非递减子序列
                if (array[i] < array[i + 1]) {
                    while (i < n && array[i] <= array[i + 1]) {
                        i++;
                    }
                    count++;
                    i++;
                } else if (array[i] == array[i + 1]) {
                    i++;
                } else {
                    while (i < n && array[i] >= array[i + 1]) {
                        i++;
                    }
                    count++;
                    i++;
                }
            }
            System.out.println(count);
        }
    }


}
