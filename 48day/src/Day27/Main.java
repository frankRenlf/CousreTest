package Day27;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CousreTest
 * @Package : Day27
 * @createTime : 2022/10/19 11:03
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class Main {
    public int Add(int num1, int num2) {
        while (num2 != 0) {
            int tmp = num1 ^ num2;
            num2 = (num1 & num2) << 1;
            num1 = tmp;
            // 101 100
            // 001 1000
            // 1001
        }
        return num1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            double a = in.nextDouble();
            double b = in.nextDouble();
            double c = in.nextDouble();
            if(a+b>c && a+c>b && b+c>a){
                System.out.println("Yes");
            }else {
                System.out.println("No");
            }
        }
    }

}
