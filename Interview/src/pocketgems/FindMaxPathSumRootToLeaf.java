package pocketgems;

/**
 * Created by xwang on 6/25/17.
 */
public class FindMaxPathSumRootToLeaf {
    class Node {
        int val;
        Node left, right;
        Node(int v) {
            val = v;
            left = null;
            right = null;
        }
    }

    public int findMax(Node root) {
        int[] res = new int[1];
        findMaxRootToLeaf(root, res, 0);
        return res[0];
    }

    public void findMaxRootToLeaf(Node root, int[] res, int currSum) {
        if (root == null) {
            return;
        }
        currSum = root.val + currSum;
        // reach leaf
        if (root.left == null && root.right == null) {
            res[0] = Math.max(currSum, res[0]);
        }
        findMaxRootToLeaf(root.left, res, currSum);
        findMaxRootToLeaf(root.right, res, currSum);
    }
    public static void main (String[] args) {
        FindMaxPathSumRootToLeaf p = new FindMaxPathSumRootToLeaf();
        Node root = p.new Node(10);
        root.left = p.new Node(-2);
        root.right = p.new Node(7);
        root.left.left = p.new Node(8);
        root.left.right = p.new Node(-4);
        System.out.println("the maximum is " + p.findMax(root));
    }
}
