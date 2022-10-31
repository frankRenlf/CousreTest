package Day31;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CousreTest
 * @Package : Day31
 * @createTime : 2022/10/31 11:09
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */

import java.util.Scanner;

public class Main {
    //传入 年 月  日 通过蔡勒公式计算当前星期几-->作为参考
    public static int day_of_week(int year, int month, int day) {
        if (month == 1 || month == 2) {
            //如果是1月或者2月 看做 13月和14月 并且年份 -1
            month += 12;
            year -= 1;
        }
        int century = year / 100;//2064 -- > 20世纪
        year = year % 100;// 2064 --> 64
        //带入公式 求 当前给定 年月日 是星期几
        int week = century / 4 - 2 * century + year + year / 4 + (13 * (month + 1)) / 5 + day - 1;
        week = (week % 7 + 7) % 7;//注意对负数的取模运算！如 -12 % 7 不是星期五 而是 星期二
        //week = 0 星期天 week =1 星期1
        if (week == 0) {
            week = 7;
        }
        return week;
    }

    public static int day_of_demand(int year, int month, int count, int d_of_week) {
        //计算 本月 1号 是星期几 --> 作为参考
        int week = day_of_week(year, month, 1);
        // 根据 公式 (所求星期数 + 7 - 1号星期数) % 7 + 1 求出 号数
        return 1 + (count - 1) * 7 + (7 + d_of_week - week) % 7;

    }

    //5月的最后一个星期一
    //根据 6 月 1 日 星期 w,求五月的最后一个星期一
    public static int m(int year) {
        int week = day_of_week(year, 6, 1);
        int day = (week == 1 ? 7 : week - 1);
        return 32 - day;
    }

    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int year = sc.nextInt();
            //元旦
            System.out.printf("%d-01-01\n", year);
            //一月的第三个星期一:马丁·路德 金纪念日
            System.out.printf("%d-01-%02d\n", year, day_of_demand(year, 1, 3, 1));
            //2月的第三个星期一：总统节
            System.out.printf("%d-02-%02d\n", year, day_of_demand(year, 2, 3, 1));
            // 5月的最后一个星期一：阵亡将士纪念日
            System.out.printf("%d-05-%02d\n", year, m(year));
            //7月4日：美国国庆
            System.out.printf("%d-07-04\n", year);
            //9月的第一个星期一：劳动节
            System.out.printf("%d-09-%02d\n", year, day_of_demand(year, 9, 1, 1));
            //11月的第四个星期四：感恩节
            System.out.printf("%d-11-%02d\n", year, day_of_demand(year, 11, 4, 4));
            //12月25日：圣诞节
            System.out.printf("%d-12-25\n", year);
            System.out.println();

        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder result = new StringBuilder();
        while (sc.hasNext()) {
            int num = sc.nextInt();
            int count = 0;
            result.append(num).append(" ").append("=");
            int j = num;
            for (int i = 2;i<=Math.sqrt(j);i++) {
                while (num % i == 0) {
                    result.append(" ").append(i).append(" ").append("*");
                    num = num/i;
                    count++;
                }
                if (num == 1) break;
            }
            if (num != 1) result.append(" ").append(num);
            if (result.charAt(result.length()-1) == '*') {
                result.deleteCharAt(result.length()-1);
                result.deleteCharAt(result.length()-1);
            }
            System.out.println(result);
            result.setLength(0);
        }
    }
}
