import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import common.DrawNode;
import common.Drawing;
import common.PrintTree;
import common.TreeNode;

public class Solution_37 {

    public static void main(String[] args) {
        // [1,2,3,null,null,4,5]
        TreeNode root = new TreeNode(1);
        TreeNode subL = new TreeNode(2);
        TreeNode subR = new TreeNode(3);
        root.left = subL;
        root.right = subR;
        subL.left = null;
        subL.right = null;
        subR.left = new TreeNode(4);
        subR.right = new TreeNode(5);
        Solution_37 inst = new Solution_37();
        String r1 = inst.serialize(root);
        System.out.println(r1);
        TreeNode tn = inst.deserialize(r1);
        // new PrintTree().print(tn);
        Drawing d = new Drawing();
        //先构建一颗二叉树
        //调用入口方法画图
        try {
            d.drawEntrance(root);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }
        return String.valueOf(root.val) + "," + serialize(root.left) + "," + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strs = data.split(",");
        Queue<String> queue = new LinkedList<>(Arrays.asList(strs));
        return dfs(queue);
    }

    public TreeNode dfs(Queue<String> queue) {
        if (queue.isEmpty()) {
            return null;
        }
        String root = queue.poll();
        if (root.equals("#")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(root));
        node.left = dfs(queue);
        node.right = dfs(queue);
        return node;
    }

    

}
