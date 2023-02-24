

import com.huawei.operationcenter.trainning.common.Drawing;
import com.huawei.operationcenter.trainning.common.TreeNode;

import java.io.IOException;
import java.util.HashMap;

public class Solution_07 {

    HashMap<Integer, Integer> inordertIndexMap = new HashMap();
    int[] preorder;
    int[] inorder;

    /**
     * [3,9,20,15,7]
     * [9,3,15,20,7]
     *
     * [3,9,#,#,20,15,#,#,7,#,#]
     * @param args args
     */
    public static void main(String[] args) {
        int[] preoder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode treeNode = new Solution_07().buildTree(preoder, inorder);
        Drawing d = new Drawing();
        //先构建一颗二叉树
        //调用入口方法画图
        try {
            d.drawEntrance(treeNode);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        if (n == 0) {
            return null;
        }
        this.preorder = preorder;
        this.inorder = inorder;

        for (int i = 0; i < n; i++) {
            inordertIndexMap.put(inorder[i], i);
        }
        return build(0, n - 1, 0, n - 1);

    }

    public TreeNode build(int pStart, int pEnd, int iStart, int iEnd) {
        if (pStart > pEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[pStart]);
        int index = inordertIndexMap.get(root.val);
        int leftLen = index - iStart;
        root.left = build(pStart + 1, pStart + leftLen, iStart, index - 1);
        root.right = build(pStart + leftLen + 1, pEnd, index + 1, iEnd);
        return root;
    }

}
