package Day17;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CousreTest
 * @Package : Day17
 * @createTime : 2022/9/29 19:57
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            String c = sc.nextLine();
            int cnt = 0;
            for(char x:s.toCharArray()){
                if(Character.toLowerCase(x)==Character.toLowerCase(c.charAt(0))){
                    cnt++;
                }
            }
            System.out.println(cnt);
        }

    }
    static int[] select = new int[]{-2, -1, 0};

    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int x = sc.nextInt();
            if (x > 2) {
                int row = 2 * x - 1;
                int[][] t = new int[x][row];

                for (int j = 0; j < x; j++) {//遍历行赋值
                    for (int i = 0; i < row; i++) {//遍历列赋值

                        if (j == 0) {//给第0行赋值
                            if (i == x - 1) {
                                t[j][i] = 1;
                            } else {
                                t[j][i] = 0;
                            }
                        } else {

                            if (i == 0) {//第一列
                                t[j][i] = t[j - 1][i] + t[j - 1][i + 1];
                            } else if (i == row - 1) {//最后一列
                                t[j][i] = t[j - 1][i - 1] + t[j - 1][i];
                            } else {
                                t[j][i] = t[j - 1][i - 1] + t[j - 1][i] + t[j - 1][i + 1];
                            }

                        }
                        //--------

                    }
                }

                for (int i = 0; i < row; i++) {//遍历出第一个出现的偶数
                    if (t[x - 1][i] % 2 == 0) {
                        System.out.println(i + 1);
                    }
                }
            }
            System.out.println(-1);
        }
    }

}
