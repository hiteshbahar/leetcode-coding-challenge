import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Rubrik2 {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int v) {
            val = v;
            left = null;
            right = null;
        }
    }
    /**
     * Insert a node in a complete binary tree.
     * 
     * The tree uses linked representation.
     * If we represent the tree in an array,
     * insert would be very efficient because we
     * know the relations between root and children. 
     * 
     * In order to create the complete binary tree, 
     * we need to keep track of the nodes in level order traversal
     * (because everytime when we insert, we are only given the root of the node), 
     * which can be done in a queue, such that the next node to be
     * inserted lies in the leftmost position.
     * @param root
     * @param newNode
     */
    public TreeNode insertNodeInCompleteTree(TreeNode root, TreeNode newNode) {
        // if the tree is empty, initialize the tree with newNode.
        if (root == null) {
            return new TreeNode(newNode.val);
        }
        // else get the front of the queue
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();    // size of the queue, control current level
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                // if the left child of this front node doesn't exist
                // set the left child as new node.
                if (curr.left == null) {
                    curr.left = new TreeNode(newNode.val);
                    return root;
                } else {
                    queue.offer(curr.left);
                }
                // else if the right child of this node doesn't exist,
                // set the right child as the new node.   
                if (curr.right == null) {
                    curr.right = new TreeNode(newNode.val);
                    return root;
                } else {
                    // if the front node has both left child and right child, dequeue it.
                    queue.offer(curr.right);
                }
            }
        }
        return null;
    }
    /**
     * helper function to check the insert function
     * @param root
     * @return
     */
    private List<List<Integer>> levelOrderTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                list.add(curr.val);
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            result.add(list);
        }
        return result;
    }
    public static void main(String[] args) {
        Rubrik2 r = new Rubrik2();
        TreeNode root = null;
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        for (int i = 0; i < nums.length; i++) {
            root = r.insertNodeInCompleteTree(root, r.new TreeNode(nums[i]));
        }
        System.out.println(r.levelOrderTraversal(root));
    }

}
