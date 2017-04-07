import java.util.Stack;

public class PureStorage {

    public static class TreeNode {
        int val;
        TreeNode parent;
        TreeNode left;
        TreeNode right;
        boolean visited;
        public TreeNode(int value) {
            val = value;
            parent = null;
            left = null;
            right = null;
            visited = false;               
        }
    }
    public TreeNode dfs(TreeNode node, int target) {
        System.out.println(node.val);
        node.visited = true;
        if (node.val == target) {
            return node;
        }
        TreeNode[] nodes = new TreeNode[] {node.right, node.parent, node.left};
        for (int i = 0; i < 3; i++) {
            if (nodes[i] != null && !nodes[i].visited) {
                TreeNode result = dfs(nodes[i], target);
                if (result != null) {
                    return result;
                }
            }
        }
        return null;
    }
    public int countPalindrome(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        String curr = input.substring(0, 1);
        int count = 0;
        int odd = 0, even = 0;
        for (int i = 0; i < input.length(); i++) {
            odd += findPalindrome(input, i, i);
            
//            if (!odd.isEmpty() && odd.length() > 1) {
//                count++;
//                System.out.format("odd i = %d, %s", i, odd);
//                System.out.println();
//            }
            even += findPalindrome(input, i, i + 1);
           
//            if (!even.isEmpty()) {
//                count++;
//                System.out.format("Even i = %d, %s", i, even);
//                System.out.println();
//            }
        }
        return odd + even;
    }
    public int findPalindrome(String input, int start, int end) {
        int count = 0;
        while (start >= 0 && end < input.length() && input.charAt(start) == input.charAt(end)) {
            start--;
            end++;
            count++;
        }
        return count;
    }
    /**
     * 8. 
     * @param args
     */
    public int checkSequence(String[] events) {
        if (events == null || events.length == 0) {
            return 0;
        }
        int count = 0;
        Stack<String> stack = new Stack<String>();
        for (int i = 0; i < events.length; i++) {
            if (events[i].charAt(0) == 'A') {
                String[] event = events[i].split(" ");
                stack.push(event[1]);
                count++;
            } else {
                count++;
                String[] event = events[i].split(" ");
                if (stack.isEmpty()) {
                    return count;
                }
                String currNum = stack.pop();
                if (!currNum.equals(event[1])) {
                    return count;
                }
            }
        }
        if (!stack.isEmpty()) {
            return count + 1;
        } else {
            return 0;
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        /*
         * 2. dfs
         */
        PureStorage ps = new PureStorage();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(1);
        root.left.parent = root;
        root.right.parent = root;
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(3);
        root.left.left.parent = root.left;
        root.left.right.parent = root.left;
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(1);      
        root.left.left.left.parent = root.left.left;
        root.left.left.right.parent = root.left.left;
        
        root.left.right.right = new TreeNode(9);
        root.left.right.right.parent = root.left.right;
        
        root.left.right.right.left = new TreeNode(2);
        root.left.right.right.left.parent = root.left.right.right;
        root.left.right.right.left.right = new TreeNode(12);
        root.left.right.right.left.right.parent = root.left.right.right.left;
        
        root.right.left = new TreeNode(8);
        root.right.left.parent = root.right;
        root.right.left.right = new TreeNode(5);
        root.right.left.right.parent = root.right.left;
        root.right.left.left = new TreeNode(11);
        TreeNode node = root.right.left.left;
        root.right.left.left.parent = root.right.left;
        root.right.left.left.left = new TreeNode(4);
        root.right.left.left.left.parent = root.right.left.left;
        root.right.left.left.right = new TreeNode(5);
        root.right.left.left.right.parent = root.right.left.left;
        
        ps.dfs(node, 12);
        
        /*
         * 5. test binary search
         */
//        int[] elements = new int[] {1, 2, 3};
//        int target = 2;
//        if (sorted_search(elements, 2)) {
//            System.out.println("CORRECT");
//        } else {
//            System.out.println(elements.length);
//            for (int i = 0; i < elements.length; i++) {
//                System.out.print(elements[i]);
//                if (i < 2) {
//                    System.out.print(" ");
//                } else {
//                    System.out.println();
//                }
//            }
//            System.out.println(target);
//        }
        
        /*
         * 7. countPalindrome
         */
//        String palindrome = "hellolle";
//        String palin2 = "wowpurerocks";
//        
//        System.out.println(ps.countPalindrome(palindrome));
//        System.out.println(ps.countPalindrome(palin2));
        /**
         * 8. 
         */
        String[] events = new String[] {"ACQUIRE 364", "ACQUIRE 84", "RELEASE 84", "RELEASE 364"};
        System.out.println(ps.checkSequence(events));
    }

}
