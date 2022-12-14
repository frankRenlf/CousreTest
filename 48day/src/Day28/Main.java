package Day28;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CousreTest
 * @Package : Day28
 * @createTime : 2022/10/20 20:22
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int sum = 0;
            int acquire = 0;
            if (n==0){
                break;
            }
            long startNum=(long)Math.pow(5,n)-4;//一开始的桃子总数
            long oldMonkey=(long) Math.pow(4,n)+n-4;//最后老猴子能分到的桃子树
            System.out.print(startNum+" "+oldMonkey);
            System.out.println();
        }
    }

    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int[] arr = new int[sc.nextInt()];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();
            }
            int l = sc.nextInt() - 1, r = sc.nextInt() - 1;
            while (l < r) {
                int tmp = arr[l];
                arr[l] = arr[r];
                arr[r] = tmp;
                l++;
                r--;
            }
            for (int n : arr) {
                System.out.print(n + " ");
            }
        }
    }

}
