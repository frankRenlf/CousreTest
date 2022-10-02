package Day18;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;


/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CousreTest
 * @Package : Day18
 * @createTime : 2022/9/30 21:25
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class Main {

    public static boolean legal(char c) {
        return c >= '0' && c <= '9' || c >= 'a' && c <= 'z';
    }

    public static boolean match(String regex, String str) {
        int m = str.length();
        int n = regex.length();
        char[] strs = str.toCharArray();
        char[] regexs = regex.toCharArray();
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for (int i = 0; i < m; i++) {
            if (Character.isLetter(strs[i])) strs[i] = Character.toLowerCase(strs[i]);
        }
        for (int i = 1; i <= n; i++) {
            if (regexs[i - 1] == '*') dp[i][0] = dp[i - 1][0];
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (!legal(strs[j - 1])) {
//                    如果是特殊字符，必须这个值相等才能匹配上，否则直接为false
                    if (regexs[i - 1] == strs[j - 1]) dp[i][j] = dp[i - 1][j - 1];
                    continue;
                }
                char c = strs[j - 1];
//                如果不是特殊字符，是*的情况则只要dp[i-1][j]||dp[i-1][j-1]||dp[i][j-1]=true都能匹配上
                if (regexs[i - 1] == '*') dp[i][j] = dp[i - 1][j] || dp[i - 1][j - 1] || dp[i][j - 1];
//                如果不是特殊字符，是？或相等的情况只要dp[i-1][j-1]=true就能匹配上
                else if (regexs[i - 1] == '?' || Character.toLowerCase(regexs[i - 1]) == c) dp[i][j] = dp[i - 1][j - 1];

            }
        }
        return dp[m][n];
    }


    public static boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; ++i) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = true;
            } else {
                break;
            }
        }
        for (int i = 1; i <= m; ++i) {
            char x = s.charAt(i - 1);
            for (int j = 1; j <= n; ++j) {
                if (!legal(x)) {
//                    如果是特殊字符，必须这个值相等才能匹配上，否则直接为false
                    if (p.charAt(j - 1) == x) dp[i][j] = dp[i - 1][j - 1];
                    continue;
                }
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j] || dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Build the graph
        int mat[][] = new int[n][n];
        for (int flight[] : flights) {
            mat[flight[0]][flight[1]] = flight[2];
        }

        // min heap: {(vertex, cost, stops), ...}
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((e1, e2) -> e1[1] - e2[1]);

        // costs[i]: min cost from src to vertex i
        // stops[i]: number of stops of the corresponding cheapest cost for vertex i
        int costs[] = new int[n];
        int stops[] = new int[n];
        Arrays.fill(costs, Integer.MAX_VALUE);

        // Dijkstra Algorithm within k
        minHeap.offer(new int[]{src, 0, k});
        while (!minHeap.isEmpty()) {
            int elem[] = minHeap.poll();
            int vertex = elem[0], cost = elem[1], stop = elem[2];

            if (vertex == dst) {
                return cost;
            } else if (stop < 0) {
                continue;
            }

            for (int i = 0; i < n; ++i) {
                if (mat[vertex][i] > 0) {
                    int costI = costs[i], costVI = mat[vertex][i];
                    if (cost + costVI < costI) {
                        minHeap.offer(new int[]{i, costVI + cost, stop - 1});
                        costs[i] = costVI + cost;
                        stops[i] = stop - 1;
                    } else if (stops[i] < stop - 1) {
                        minHeap.offer(new int[]{i, costVI + cost, stop - 1});
                    }
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s1 = sc.nextLine().toLowerCase();
            String s2 = sc.nextLine().toLowerCase();
            System.out.println(isMatch(s2, s1));
        }
    }

    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] dp = new int[n + 1];
            dp[1] = dp[2] = 1;
            for (int i = 3; i <= n; i++) {
                dp[i] = dp[i - 2] + dp[i - 1];
            }
            System.out.println(dp[n]);
        }
    }

}
