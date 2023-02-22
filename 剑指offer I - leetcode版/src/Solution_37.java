import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_37 {

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

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
