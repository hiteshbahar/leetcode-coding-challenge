package amazon;

import java.util.*;

public class NodesDistance {

    public static void main(String[] args) {
        // get distance between two nodes in bst
        int[] values = {5,6,3,1,2,4};
        System.out.println(bstDistance(values, 6, 2, 4));

    }


    /**
     * Given a list of n unique integers, construct a BST by inserting each integer in the given order without rebalancing
     * the tree.
     * Return the distance between the two given nodes. Return -1 if node1 or node2 is not present in the bst
     * @param values an array of node values for the bst
     * @param n the number of nodes in the bst
     * @param node1
     * @param node2
     * @return
     */
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int v) {
            val = v;
            left = null;
            right = null;
        }
    }
    public static int bstDistance(int[] values, int n, int node1, int node2) {
        // Build the tree
        TreeNode root = new TreeNode(values[0]);
        Set<Integer> set = new HashSet<>();
        set.add(values[0]);
        for (int i = 1; i < n; i++) {
            root = insertBST(root, values[i]);
            set.add(values[i]);
        }
        if (!set.contains(node1) || !set.contains(node2)) {
            return -1;
        }
        // find LCA of the two nodes
        TreeNode lca = findLCA(root, node1, node2);
        if (lca == null) {
            return -1;
        }
        return getDepth(lca, node1) + getDepth(lca, node2);
    }
    public static TreeNode insertBST(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
            return root;
        }
        if (val < root.val) {
            root.left = insertBST(root.left, val);
        } else {
            root.right = insertBST(root.right, val);
        }
        return root;
    }
    public static TreeNode findLCA(TreeNode root, int node1, int node2) {
        while (root != null) {
            if (node1 < root.val && node2 < root.val) {
                root = root.left;
            } else if (node1 > root.val && node2 > root.val) {
                root = root.right;
            } else {
                return root;
            }
        }
        return null;
    }
    public static int getDepth(TreeNode root, int v) {
        if (root == null) {
            return -1;
        }
        if (root.val == v) {
            return 0;
        }
        if (root.val > v) {
            return 1 + getDepth(root.left, v);
        } else {
            return 1 + getDepth(root.right, v);
        }
    }

}