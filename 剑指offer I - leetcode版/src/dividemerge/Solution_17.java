package dividemerge;

import java.util.ArrayList;
import java.util.List;

/**
 * n位数字打印
 * 1~10^n
 */
public class Solution_17 {

    int[] res;
    int n, start, count = 0, nine = 0;
    char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    StringBuffer buffer = new StringBuffer();

    public static void main(String[] args) {
        // 大数越界问题
        // new Solution_17().printNumbers1(7);
        new Solution_17().print(6);

    }

    public int[] printNumbers1(int n) {
        int max = (int) Math.pow(10, n) - 1;
        res = new int[max];
        for (int i = 0; i < max; i++) {
            res[i] = i + 1;
            System.out.println(res[i]);
        }
        return res;
    }

    public int[] printNumbers(int n) {
        this.n = n;
        int max = (int) Math.pow(10, n) - 1;
        res = new int[max];
        // 固定高位
        dfs(1, 0);
        // 低位匹配0-9
        return res;
    }

    private StringBuilder s = new StringBuilder();
    private List<String> ans = new ArrayList<>();

    public List<String> print(int n) {
        for (int i = 1; i <= n; ++i) {
            dfs(0, i);
        }
        return ans;
    }

    private void dfs(int i, int j) {
        if (i == j) {
            System.out.println(s.toString());
            ans.add(s.toString());
            return;
        }
        int k = i > 0 ? 0 : 1;
        for (; k < 10; ++k) {
            s.append(k);
            dfs(i + 1, j);
            s.deleteCharAt(s.length() - 1);
        }
    }
}
