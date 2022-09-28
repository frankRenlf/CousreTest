package Day16;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CousreTest
 * @Package : Day16
 * @createTime : 2022/9/28 20:10
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class Main {

    public static void main(String[] agrs) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            // 1. 排除掉王炸的情况
            String oriStr = sc.nextLine();                  // 读入原始字符串，找joker JOKER
            if (oriStr.contains("joker JOKER")) {
                System.out.println("joker JOKER");
                continue;
            }

            // 2. 排除掉两手牌长度不等的情况：要么一手4炸一手普通牌，要么两手普通牌但是牌型不符要ERROR
            String[] card1 = oriStr.split("-")[0].split(" ");
            String[] card2 = oriStr.split("-")[1].split(" ");
            if (card1.length != card2.length) {
                String[] pointer = card1.length == 4 ? card1 : null;  // 检查有没有一手牌的长度为4
                pointer = card2.length == 4 ? card2 : pointer;
                if (pointer == null)    // 长度不等，且没有4炸，必然ERROR
                    System.out.println("ERROR");
                else                    // 有4炸则输出4炸
                    System.out.println(String.join(" ", pointer));
                continue;
            }

            // 3. 只剩下两手普通牌和两手4炸的情况，只需要比较第一张牌
            String order = "345678910JQKA2jokerJOKER";
            if (order.indexOf(card1[0]) < order.indexOf(card2[0]))
                System.out.println(String.join(" ", card2));
            else
                System.out.println(String.join(" ", card1));
        }
    }

    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int ret = calPerfect(n);
            System.out.println(ret);
        }
    }

    private static int calPerfect(int n) {
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            int end = i / 2;
            while (end != 0) {
                if (i % end == 0) sum += end;
                end--;
            }
            cnt += sum == i ? 1 : 0;
        }
        return cnt;
    }
}
