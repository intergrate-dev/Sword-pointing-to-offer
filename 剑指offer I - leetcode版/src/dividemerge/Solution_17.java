package dividemerge;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import common.Drawing;
import common.TreeNode;

public class Solution_17 {

    HashMap<Integer, Integer> inordertIndexMap = new HashMap();
    int[] preorder;
    int[] inorder;

    /**
     * 打印从 1 到最大的 n 位数
     * 输入n, 按顺序打印出从 1 到最大的 n 位十进制数 (3 >> 1-999)
     * 
     * [3,9,20,15,7]
     * [9,3,15,20,7]
     *
     * [3,9,#,#,20,15,#,#,7,#,#]
     * 
     * @param args args
     */
    int[] res;
    int nine = 0, count = 0, start, n;
    char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public int[] printNumbers(int n) {
        this.n = n;
        res = new int[(int)Math.pow(10, n) - 1];
        num = new char[n];
        start = n - 1;
        dfs(0);
        return res;
    }

    void dfs(int x) {
        if(x == n) {
            // 取低位非0位数值（009 -- start为2， 010 -- start为1）
            String s = String.valueOf(num).substring(start);
            if(!s.equals("0")) res[count++] = Integer.parseInt(s); System.out.println(s);
            // 最后一位为9的时候，如009，下一轮进到010，此时满足该条件，且左边0要减少一位
            if(n - start == nine) start--;
            return;
        }
        for(char i : loop) {
            if(i == '9') nine++;
            num[x] = i;
            dfs(x + 1);
        }
        // 进下一轮前恢复
        nine--;
    }

    public static void main(String[] args) {
        int[] numbers = new Solution_17().printNumbers(3);
        System.out.println(numbers[numbers.length-1]);

        /* String numbers = new Solution_17().printNumbers(3);
        System.out.println(numbers); */
    }

    /* StringBuilder res;
    int count = 0, n;
    char[] num, loop = {'0', '1'};
    public String printNumbers(int n) {
        this.n = n;
        res = new StringBuilder(); // 数字字符串集
        num = new char[n]; // 定义长度为 n 的字符列表
        dfs(0); // 开启全排列递归
        res.deleteCharAt(res.length() - 1); // 删除最后多余的逗号
        return res.toString(); // 转化为字符串并返回
    }
    void dfs(int x) {
        if(x == n) { // 终止条件：已固定完所有位
            res.append(String.valueOf(num) + ","); // 拼接 num 并添加至 res 尾部，使用逗号隔开
            System.out.println("res: " + res.toString());
            return;
        }
        for(char i : loop) { // 遍历 ‘0‘ - ’9‘
            num[x] = i; // 固定第 x 位为 i
            System.out.println("num[x]: " + i);
            dfs(x + 1); // 开启固定第 x + 1 位
            System.out.println("dfs >> x + 1");
        }
    } */

}
