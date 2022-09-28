package Day15;

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
