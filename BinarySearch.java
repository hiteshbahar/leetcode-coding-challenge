/**
 * Given a non-empty binary search tree and a target value
 * find the value in the BST that is closest to the target.
 * @author xinwang
 *
 */
public class BinarySearch {
    int goal;
    double min = Double.MAX_VALUE;
    
    public class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int value) {
            val = value;
            left = null;
            right = null;
        }
    }
    public int closestValue(TreeNode root, double target) {
        searchHelper(root, target);
        return goal;
    }
    private void searchHelper(TreeNode root, double target) {
        if (root == null) {
            return;
        }
        if (Math.abs(root.val - target) < min) {
            min = Math.abs(root.val - target);
            goal = root.val;
        }
        if (target < root.val) {
            searchHelper(root.left, target);
        } else {
            searchHelper(root.right, target);
        }
    }
}
