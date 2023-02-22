package common;

public class DrawNode{
    protected int val;
    protected DrawNode left;
    protected DrawNode right;
    public DrawNode() {}
    public DrawNode(int val) {
        this.val = val;
    }
    public DrawNode(int val, DrawNode left, DrawNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
