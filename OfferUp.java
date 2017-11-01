import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class OfferUp {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int v) {
            val = v;
            left = null;
            right = null;
        }
    }
    public List<List<Integer>> levelOrderBFS(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int numNodes = queue.size();
            List<Integer> subList = new ArrayList<Integer>();
            for (int i = 0; i < numNodes; i++) {
                TreeNode curr = queue.poll();
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
               if (curr.right != null) {
                   queue.offer(curr.right);
               }
               subList.add(curr.val);
            }
            result.add(subList);
        }
        return result;
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        levelOrderDFS(result, root, 0);
        return result;
    }
    private void levelOrderDFS(List<List<Integer>> result, TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (result.size() < depth + 1) {
            result.add(new ArrayList<Integer>());
        }
        result.get(depth).add(root.val);
        levelOrderDFS(result, root.left, depth + 1);
        levelOrderDFS(result, root.right, depth + 1);
    }
    public static void main(String[] args) {
        OfferUp u = new OfferUp();
        TreeNode root = u.new TreeNode(3);
        root.left = u.new TreeNode(9);
        root.right = u.new TreeNode(20);
        root.right.left = u.new TreeNode(15);
        root.right.right = u.new TreeNode(7);
        List<List<Integer>> levelOrderDFSList = u.levelOrder(root);
        List<List<Integer>> levelOrderBFSList = u.levelOrderBFS(root);
        System.out.println("Level order DFS");
        System.out.println(levelOrderDFSList);
        System.out.println("Level order BFS");
        System.out.println(levelOrderBFSList);
        System.out.println("break".substring(0, 0));
    }

}
