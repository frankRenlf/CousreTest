package Day21;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CousreTest
 * @Package : Day21
 * @createTime : 2022/10/12 19:49
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            //1.开始输入
            int num = scan.nextInt();// num组数据
            //2.单独处理每一组数据
            while(num > 0){
                //3.首先把n和k拿出来
                int n = scan.nextInt();
                int k =  scan.nextInt();
                //4.设置一个数组，用来放2*n张牌
                int[] arr = new int[2*n];
                for(int i = 0;i < 2*n;i++){
                    int tmp = i;//用tmp先标记牌的首次位置，然后最后表示k次之后的位置
                    for(int j = 0;j < k;j++){//每一张牌都是有规律的变k次
                        if(tmp < n){
                            tmp = 2*tmp;
                        }else{
                            tmp = 2*(tmp-n+1)-1;
                        }
                    }
                    arr[tmp] = scan.nextInt();
                }
                //5.经过循环之后一组数据就已经放好了，现在要输出，输出的时候有空格
                System.out.print(arr[0]);
                for(int i = 1;i < 2*n;i++){
                    System.out.print(" "+arr[i]);
                }
                //6.一组数据输完要进行换行
                System.out.println();
                //7.开始进行下一组数据的处理，num代表的是组数，那么就num--;
                num--;
            }
        }
    }

    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for (int i = 0; i < num; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[2 * n];
            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
            }
            int[] tmp = new int[2 * n];
            for (int x = 0; x < k; x++) {
                tmp = change(arr);
            }
            for (int e : tmp) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }

    private static int[] change(int[] arr) {
        int len = arr.length;
        int[] ret = new int[len];
        int pos = 0;
        int sub = len / 2;
        for (int i = 0; i < len; i += 2) {
            ret[i] = arr[pos];
            ret[i + 1] = arr[pos + sub];
            pos++;
        }
        return ret;
    }

}
