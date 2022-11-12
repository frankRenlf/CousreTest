package Day42;


/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CousreTest
 * @Package : Day42
 * @createTime : 2022/11/12 16:17
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
import java.util.*;

// 设一个类，记录走到某一个位置的X和Y坐标，以及到当前位置所走的步数
class Position {
    public int x;
    public int y;
    public int steps; // 记录当前位置所走的步数

    public Position(int x, int y, int steps) {
        this.x = x;
        this.y = y;
        this.steps = steps;
    }
}


public class Main {
    // 思想是广度优先遍历思想
    public static int getShortPath(String[] map, int m, int n) {
        // 走每一步都要确定是向下，还是右，左，上，所以设一个二维数组，记录向每一个方向，所需的
        // 的坐标变化
        int[][] direction = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
        // 设一个队列，用来记录每走一步的当前 下右左上的位置（就是上面设的Position类）
        Queue<Position> pos = new LinkedList<>();
        // 初始化一个位置类，也就是入口，坐标是（0，1），步数是0
        Position position = new Position(0, 1, 0);
        // 初始化一个位置类，也就是出口，坐标是（9，8），步数是0（这个步数没影响）
        Position out = new Position(9, 8, 0);
        // 把入口位置加入队列
        pos.offer(position);
        // 设一个二维数组，用来记录已经走过的位置，比如上面的位置，走过的就不要再走了
        boolean[][] flag = new boolean[m][n];
        // 当队列不为空时，表示它一直在寻找出口
        while (!pos.isEmpty()) {
            // 将最先加入的位置，从队列中取出来，首次取的时候，只有入口位置
            Position cur = pos.poll();
            // 每次从队列中取出一个位置，就表示当前位置被走了，所以要同步标记
            flag[cur.x][cur.y] = true;
            // 广度优先遍历，是依次把当前位置的 下右左上位置放入队列，按照先进先出原则，
            // 它取的时候，也是把一个位置的 下右左上 全取出来遍历，把这四个方向遍历完，
            // 视为走了一层，而在遍历每一层的时候，它都要确定有没有出口位置
            if (cur.x == out.x && cur.y == out.y) {
                // 如果发现遍历某个位置的一层时，有与出口相同的位置，那说明我们就找到了
                // 最短距离，不再遍历，返回步数
                return cur.steps;
            }
            // 从入口开始，每到一个位置，就先把它的 下右左上位置 放入队列，但是
            // 要判断，四个方向的位置是通路而不是墙，只把通路加入到队列中，而且，
            // 这个通路没有被走过
            for (int i = 0; i < direction.length; i++) {
                // 设一个新的位置类，记录当前位置的四个周边位置，i=0 ，表示当前位置
                // 的下面位置，要给它的X+1，Y+0，才能得到下面位置，同时步数加 1
                Position next = new Position(cur.x + direction[i][0],
                        cur.y + direction[i][1], cur.steps + 1);
                // 每获得当前位置的一个周边位置，就要确保这个 新位置，没有越界，是通路，并且
                // 没有被走过
                if (next.x >= 0 && next.x < m && next.y >= 0 && next.y < n &&
                        map[next.x].charAt(next.y) == '.' && !flag[next.x][next.y]) {
                    pos.offer(next);
                }
            }
        }
        // 如果遍历完队列，也没有找到出口，表示迷宫无出路，返回0
        return 0;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String[] map = new String[10];
            for (int i = 0; i < 10; i++) {
                map[i] = scan.next();
            }
            System.out.println(getShortPath(map, 10, 10));
        }
    }

    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            StringBuffer stringBuffer = new StringBuffer();
            for (char c : s.toCharArray()) {
                if (Character.isDigit(c)) {
                    stringBuffer.append(c);
                }
            }
            System.out.println(stringBuffer);
        }
    }

}
