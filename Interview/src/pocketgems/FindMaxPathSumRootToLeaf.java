package pocketgems;

import java.util.Arrays;

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

    public int findMax(Node root, int[] arr) {
        int[] res = new int[1];
        int[] path = new int[10];
        findMaxRootToLeaf(root, res, path,0, arr, 0);
        return res[0];
    }

    public void findMaxRootToLeaf(Node root, int[] res, int[] path, int index, int[] arr, int currSum) {
        if (root == null) {
            return;
        }
        path[index++] = root.val;
        currSum = root.val + currSum;
        // reach leaf
        if (root.left == null && root.right == null) {
            if (currSum > res[0]) {
                res[0] = currSum;
                arr = Arrays.copyOf(path, index);
            }
            res[0] = Math.max(currSum, res[0]);
        }
        findMaxRootToLeaf(root.left, res, path, index, arr, currSum);
        findMaxRootToLeaf(root.right, res, path, index, arr, currSum);
    }
    public static void main (String[] args) {
        FindMaxPathSumRootToLeaf p = new FindMaxPathSumRootToLeaf();
        Node root = p.new Node(10);
        root.left = p.new Node(-2);
        root.right = p.new Node(7);
        root.left.left = p.new Node(8);
        root.left.right = p.new Node(-4);
        int[] arr = new int[10];
        int maxSum = p.findMax(root, arr);
        System.out.println("the maximum is " + maxSum);
        System.out.println("the maximum path is " + Arrays.toString(arr));
    }
}
