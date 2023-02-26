package dividemerge;

import java.util.HashMap;
import java.util.Map;

import common.TreeNode;

/**
 * "二叉搜索树" 的后序遍历序列
 * 
 * 判断该数组是不是某二叉搜索树的后序遍历结果
 * 
 * 二叉搜索树定义： 左子树中所有节点的值 < 根节点的值；右子树中所有节点的值  > 根节点的值；
 *                  其左、右子树也分别为二叉搜索树。
 * 
 */
public class Solution_33 {

    public static void main(String[] args) {
        /* TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(7); 

        int[] arr = {1,3,2,7,4,6,5};
        boolean res = isPostOrder(root, arr);
        System.out.println(res);*/

        int[] arr = {4, 8, 6, 12, 16, 14, 10};
        new Solution_33().verifyPostorder(arr);
    }


    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }
    
    boolean recur(int[] postorder, int i, int j) {
        if(i >= j) return true;
        int p = i;
        // 左半区小于根节点
        while(postorder[p] < postorder[j]) p++;
        // 找到第一个 大于根节点值的位置
        int m = p;
        // 右半区大于根节点
        while(postorder[p] > postorder[j]) p++;
        return p == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
    }


    /* private static boolean isPostOrder(TreeNode root, int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        return search(root, map);
    } */

    /* private static boolean search(TreeNode root, Map<Integer, Integer> map) {
        if (root.left != null && root.right != null) {
            if (map.get(root.right.val) < map.get(root.val) && map.get(root.left.val) < map.get(root.right.val)) {
                search(root.left, map);
                search(root.right, map);
            } else{
                return false;
            }
        } else if (root.left != null) {
            if (map.get(root.left.val) < map.get(root.val)) {
                search(root.left, map);
            } else{
                return false;
            }
        } else if (root.right != null) {
            if (map.get(root.right.val) < map.get(root.val)) {
                search(root.right, map);
            } else{
                return false;
            }
        }
        return true;
    } */
}
