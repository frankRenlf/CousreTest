package Day15;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CousreTest
 * @Package : Day15
 * @createTime : 2022/9/28 10:47
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            int cnt = cal(arr, 0, n, 0, 1);
            System.out.println(cnt);
        }
    }

    private static int cal(int[] arr, int start, int end, int sum, int mul) {
        int count = 0;
        for (int i = start; i < end; i++) {
            if (i > start && arr[i] == arr[i - 1]) continue;
            sum += arr[i];
            mul *= arr[i];
            if (sum > mul) {
                count = count + 1 + cal(arr, i + 1, end, sum, mul);
            } else if (arr[i] == 1) {
                count = count + cal(arr, i + 1, end, sum, mul);
            } else {
                break;
            }
            sum -= arr[i];
            mul /= arr[i];
        }
        return count;
    }

    public int getKthMagicNumber(int k) {
        int[] numList = new int[k + 1];
        int p3 = 0, p5 = 0, p7 = 0;
        numList[0] = 1;
        for (int i = 1; i < k; i++) {
            numList[i] = Math.min(Math.min(numList[p3] * 3, numList[p5] * 5), numList[p7] * 7);
            if (numList[i] == numList[p3] * 3) p3++;
            if (numList[i] == numList[p5] * 5) p5++;
            if (numList[i] == numList[p7] * 7) p7++;
        }
        return numList[k - 1];
    }


}
