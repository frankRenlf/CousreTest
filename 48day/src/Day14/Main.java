package Day14;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CousreTest
 * @Package : Day14
 * @createTime : 2022/9/27 10:28
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int num = in.nextInt();
            int[] check = new int[num];
            for (int i = 0; i < num; i++) {
                check[i] = in.nextInt();
            }
            Arrays.sort(check);//对数组进行排序，方便后面递归操作和剪枝
            int tmp = luckyBox(check, num, 0, 0, 1);//表示从当前数组0下标开始，初始和为0，积为1
            System.out.println(tmp);
        }
    }

    public static int luckyBox(int[] check, int num, int start, int sum, int mul) {//递归函数
        int count = 0;
        for (int i = start; i < num; i++) {
            sum += check[i];
            mul *= check[i];
            if (sum > mul) {//当前条件满足幸运盒子要求
                count = count + 1 + luckyBox(check, num, i + 1, sum, mul);//当前计数器加一并且继续递归探索接下来的元素
            } else if (check[i] == 1) {//1与任何数的和都大于积，虽然不能将1加入到幸运盒子中但可以继续递归探索
                count = count + luckyBox(check, num, i + 1, sum, mul);
            } else {//递归结束条件
                break;
            }
            sum -= check[i];//回溯
            mul /= check[i];
            while (i < num - 1 && check[i] == check[i + 1]) {//题目要求：相同数字的球被视为一样的情况
                i++;
            }
        }
        System.out.println(start + ":" + count);
        return count;
    }


    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int y = sc.nextInt();
            int m = sc.nextInt();
            int d = sc.nextInt();
            int day = outDay(y, m, d);
            System.out.println(day);
        }
    }

    //计算日期到天数转换
    private static int outDay(int y, int m, int d) {
        int[] day = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};//每月的天数
        if (y % 4 == 0 && y % 100 != 0 || y % 400 == 0) {
            day[1] = 29;//闰年二月为29天
        }
        if (y <= 0 || m <= 0 || m > 12 || d <= 0 || d > day[m - 1]) {
            return -1;//不合法的日期
        }
        int sum = 0;
        for (int i = 0; i < m - 1; i++) {
            sum += day[i];//月份之前的天数
        }
        return sum + d;//加上天数
    }

}
