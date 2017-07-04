public class Solution270 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public class Result {
        double dist;
        int val;
        Result(double d, int v) {
            dist = d;
            val = v;
        }
    }
    public int closestValue(TreeNode root, double target) {
        Result result = new Result(Double.MAX_VALUE, root.val);
        findClosestValue(root, target, result);
        return result.val;
    }
    public void findClosestValue(TreeNode root, double target, Result result) {
        if (root == null) {
            return;
        }
        double diff = root.val - target;
        if (Math.abs(diff) < result.dist) {
            result.dist = Math.abs(diff);
            result.val = root.val;
        }
        if (target < root.val) {
            findClosestValue(root.left, target, result);
        } else if (target > root.val) {
            findClosestValue(root.right, target, result);
        } else {
            return;
        }
    }
    public static void main(String args[]) {
        Solution270 s = new Solution270();
        TreeNode root = s.new TreeNode(1500000000);
        root.left = s.new TreeNode(1400000000);
        int diff = s.closestValue(root, -1500000000.0);
        System.out.println(diff);

    }
}