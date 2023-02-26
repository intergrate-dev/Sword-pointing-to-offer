package searchrecall;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 机器人的运动范围
 * 
 */
class Solution_13 {
    
    public static void main(String[] args) {
        movingCount(3, 2, 2);
        movingCount1(3, 2, 2);
    }
    public static int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;
        int ans = 0;
        Queue<int[]> queue = new LinkedList();

        queue.offer(new int[]{0, 0});
        int[] x = {1, -1, 0, 0};
        int[] y = {0, 0, 1, -1};
        while (!queue.isEmpty()) {
            int size = queue.size();
            ans += size;
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                for (int K = 0; K < 4; K++) {
                    int newX = poll[0] + x[K];
                    int newY = poll[1] + y[K];
                    if (newX >= 0 && newX < m && newY >= 0 && newY < n && !visited[newX][newY]) {
                        visited[newX][newY] = true;
                        int num = 0;
                        int temp = newX;
                        while (temp != 0) {
                            num += temp % 10;
                            temp = temp / 10;
                        }
                        temp = newY;
                        while (temp != 0) {
                            num += temp % 10;
                            temp = temp / 10;
                        }
                        if (num <= k) {
                            queue.offer(new int[]{newX, newY});
                        }

                    }
                }
            }
        }
        System.out.println("ans: " + ans);
        return ans;
    }

    public static int movingCount1(int m, int n, int k) {
        boolean [][] flags = new boolean[m][n];
        int ans = dsf(0, 0, m, n, k, flags);
        System.out.println("ans1: " + ans);
        return ans;
    }
    
    public static int dsf(int i, int j, int m, int n, int k, boolean[][] flag){
        if(i>=m || j>=n || k<sum(i)+sum(j) || flag[i][j]){
            return 0;
        }
        flag[i][j] =true;
        return 1 + dsf(i+1, j, m, n , k ,flag) + dsf(i, j+1,m, n, k, flag);
    }

    public static int sum(int i){
        int s = 0;
        while(i >0){
            s += i % 10;
            i = i /10;
        }
        return s;
    }
}