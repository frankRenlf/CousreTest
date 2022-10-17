package Day25;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CousreTest
 * @Package : Day25
 * @createTime : 2022/10/17 16:09
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String  string=scanner.nextLine();
            char[] arr=string.toCharArray();
            int sum=0;
            for (int i = 0; i < string.length() ; i++) {
                sum+=(arr[i]-'0');//计算字符串的各位之和
            }
            System.out.println(numRoot(sum));
        }
    }
    private static int numRoot(int n){
        int sum=0;
        while (n>0){//判断n是否是一个 一位数
            //若n不是一位数，则计算它的各位之和
            int n1=n%10;
            sum+=n1;
            n/=10;
        }
        if (sum/10>0){//判断各位之和是否是一个 个位数
            //若不是，继续求它的树根
            return numRoot(sum);
        }
        //否则结束计算
        return sum;
    }
}

