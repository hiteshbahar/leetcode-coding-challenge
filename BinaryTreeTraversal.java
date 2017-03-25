import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int v) {
            val = v;
        }
    }
    /* leetcode: 102
     * BFS: always need a queue.
     * while loop in the codes is to track the level
     * for loop to add nodes of the next level.
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int numNodes = queue.size();
            List<Integer> subList = new ArrayList<Integer>();
            for (int i = 0; i < numNodes; i++) {
                TreeNode curr = queue.peek();
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
                subList.add(queue.poll().val);
            }
            result.add(subList);
        }
        return result;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        BinaryTreeTraversal btt = new BinaryTreeTraversal();
        TreeNode root = btt.new TreeNode(3);
        root.left = btt.new TreeNode(9);
        root.right = btt.new TreeNode(20);
        root.right.left = btt.new TreeNode(15);
        root.right.right = btt.new TreeNode(7);
        System.out.println(btt.levelOrder(root));
    }

}
