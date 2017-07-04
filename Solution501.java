
public class Solution501 {
    public class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) {
            val = v;
        }
    }
    private static TreeNode prev;
    private int maxCount;
    private int currCount;
    private static int modeCount;
    private static int[] mode;
    public int[] findMode(TreeNode root) {
        // traverse once to get the mode count.
        traverse(root);
        mode = new int[modeCount];
        currCount = 0;
        modeCount = 0;
        traverse(root);
        return mode;
    }
    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.left);
        currCount = prev.val == root.val ? currCount + 1 : 1;
        if (currCount > maxCount) {
            maxCount = currCount;
            modeCount = 1;
        } else if (currCount == maxCount) {
            // won't work in the first time because the mode is null
            // in the second traverse, the mode is not null
            if (mode != null) {
                mode[modeCount] = root.val;
            }
            modeCount++;
        }
        prev = root;
        traverse(root.right);
    }
    public static void main(String args[]) {
        Solution501 s = new Solution501();
        TreeNode root = s.new TreeNode(1);
        root.right = s.new TreeNode(2);
        root.right.left = s.new TreeNode(2);
        root.right.right = s.new TreeNode(3);
        root.right.right.left = s.new TreeNode(3);
        prev = root;
        s.findMode(root);
        System.out.println(modeCount);
        for (int i = 0; i < mode.length; i++) {
            System.out.println(mode[i]);
        }
    }
}
