package Day37;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CousreTest
 * @Package : Day37
 * @createTime : 2022/11/7 10:37
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n= sc.nextInt();
            String[] arr=new String[n];
            for (int i = 0; i < n; i++) {
                arr[i]=sc.next();
            }
            Arrays.sort(arr);
            boolean[] flag=new boolean[n];
            for (int i = 0; i < n-1; i++) {
                if (arr[i].equals(arr[i+1]) || // 两个字符串相等
                        arr[i+1].contains(arr[i])&&arr[i+1].charAt(arr[i].length()) == '/'){
                    flag[i]=true;
                }
            }
            for (int i = 0; i < n; i++) {
                if (!flag[i]){
                    System.out.println("mkdir -p "+arr[i]);
                }
            }
            System.out.println();
        }
    }

    public static String[] arraySort(String[] input) {
        for (int i = 0; i < input.length - 1; i++) {
            for (int j = 0; j < input.length - i - 1; j++) {
                if (isBiggerThan(input[j], input[j + 1])) {
                    String temp = input[j];
                    input[j] = input[j + 1];
                    input[j + 1] = temp;
                }
            }
        }
        return input;
    }

    /*如果first大于second，则返回true，否则返回false
     *
     */
    private static boolean isBiggerThan(String first, String second) {
        if (first == null || second == null || "".equals(first) || "".equals(second)) {
            System.out.println("字符串不能为空！");
            return false;
        }
        char[] arrayfirst = first.toCharArray();
        char[] arraysecond = second.toCharArray();
        int minSize = Math.min(arrayfirst.length, arraysecond.length);
        for (int i = 0; i < minSize; i++) {
            if ((int) arrayfirst[i] > (int) arraysecond[i]) {
                return true;
            } else if ((int) arrayfirst[i] < (int) arraysecond[i]) {
                return false;
            }
        }
        if (arrayfirst.length > arraysecond.length) {
            return true;
        } else {
            return false;
        }
    }

    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            String tmp = sc.nextLine();
            String[] list = new String[n];
            for (int i = 0; i < n; i++) {
                list[i] = sc.nextLine();
            }
            list = arraySort(list);
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (list[j].contains(list[i])) {
                        list[i] = "0";
                    }
                }
            }
            for (String s : list) {
                if (!Objects.equals(s, "0")) {
                    System.out.println("mkdir -p " + s);
                }
            }
        }
    }

    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            String tmp = sc.nextLine();
            Set<String> set = new HashSet<>();
            String[] strings = new String[n];
            for (int i = 0; i < n; i++) {
                strings[i] = sc.nextLine();
            }
            int ret = 0;
            for (String s : strings) {
                String[] ss = s.split(" ");
                if (set.contains(ss[0])) {
                    set.remove(ss[0]);
                } else {
                    set.add(ss[0]);
                }
                ret = Math.max(ret, set.size());
            }
            System.out.println(ret);
        }
    }

}
