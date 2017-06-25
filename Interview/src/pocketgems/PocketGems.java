package pocketgems;

import java.util.*;

/**
 * Created by xwang on 6/18/17.
 */
public class PocketGems {
    /**
     * inner class for findMax
     */
    class Node {
        int val;
        Node left, right;
        Node(int v) {
            val = v;
            left = null;
            right = null;
        }
    }

    /**
     * find the maximum path sum from root to leaf in a binary tree
     * @param root
     * @return
     */
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

    /**
     * inner classes for PRG
     */
    class ItemInfo {
        String name;
        int value;
        int maxStackSize;
        ItemInfo (String n, int val, int size) {
            name = n;
            value = val;
            maxStackSize = size;
        }
    }
    class SlotVal {
        String name;
        int valPerSlot;
        SlotVal(String n, int val) {
            name = n;
            valPerSlot = val;
        }
    }

    /**
     *  RPG game
     * @param n: The number of inventory slots
     * @param items: Array of item types, one for each item in the room
     * @param itemInfos: Array of structs, one for each unique item type
     * @return The maximum total value
     */
    public int PRG(int n, String[] items, ItemInfo[] itemInfos) {
        // 1. first get the counts of every role
        Map<String, Integer> countMap = new HashMap<String, Integer>();
        for (String item : items) {
            countMap.put(item, countMap.getOrDefault(item, 0) + 1);
        }
        // 2. put itemInfos in a map for searching
        Map<String, ItemInfo> itemInfoMap = new HashMap<String, ItemInfo>();
        for (ItemInfo itemInfo : itemInfos) {
            itemInfoMap.put(itemInfo.name, itemInfo);
        }
        // 3. create a PriorityQueue, define its comparator according to the value per slot
        Queue<SlotVal> queue = new PriorityQueue<SlotVal>(new Comparator<SlotVal>() {
            @Override
            public int compare(SlotVal o1, SlotVal o2) {
                return o2.valPerSlot - o1.valPerSlot;
            }
        });
        // 4. get the slot num needed for each role and put them into queue
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            String name = entry.getKey();
            int count = entry.getValue();
            int itemVal = itemInfoMap.get(name).value;
            int maxStackSize = itemInfoMap.get(name).maxStackSize;
            int completeStacks = count / maxStackSize;
            int remainder = count % maxStackSize;

            int valPerSlot = itemVal * maxStackSize;
            SlotVal completeSlotVal = new SlotVal(name, valPerSlot);

            while (completeStacks > 0) {
                queue.offer(completeSlotVal);
                completeStacks--;
            }

            if (remainder > 0) {
                valPerSlot = remainder * itemVal;
                queue.offer(new SlotVal(name, valPerSlot));
            }
        }
        // 5. poll n element from the queue and calculate its total size
        int totalVal = 0;
        int count = n > queue.size() ? queue.size() : n;
        while (count > 0) {
            totalVal += queue.poll().valPerSlot;
            count--;
        }
        return totalVal;
    }

    /**
     * inner class for binary trees questions
     */
    class BSTNodeWithParentPointer {
        BSTNodeWithParentPointer left, right, parent;
        BSTNodeWithParentPointer() {
            left = null;
            right = null;
            parent = null;
        }
    }

    /**
     * find inorder successor of BST, node with parent pointer no value
     * @param root
     * @param node
     * @return
     */
    public BSTNodeWithParentPointer inorderSuccessorWithParentPointer(BSTNodeWithParentPointer root, BSTNodeWithParentPointer node) {
        if (root == null || node == null) {
            return null;
        }
        /**
         * if the right child of the node is not null
         * its inorder successor is the leftmost node of the
         * right subtree
          */
        if (node.right != null) {
            BSTNodeWithParentPointer curr = node.right;
            while (curr.left != null) {
                curr = curr.left;
            }
            return curr;
        }

        /**
         * if the right child of the node is null, its inorder successor is one of its ancestors
         * go up using parent link until find the node which is the left child of its parent
         * its parent is the inorder successor.
         */
        BSTNodeWithParentPointer parent = node.parent;
        while (parent != null && node == parent.right) {
            node = parent;
            parent = parent.parent;
        }
        return parent;
    }

    class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) {
            val = v;
            left = null;
            right = null;
        }
    }

    /**
     * find inorder successor of BST, node with value no parent pointer
     * @param root
     * @param node
     * @return
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode node) {
        if (root == null || node == null) {
            return null;
        }
        /**
         * if node has right child, its inorder successor should be the left most
         * child of the right subtree.
         */
        if (node.right != null) {
            TreeNode curr = node.right;
            while (curr.left != null) {
                curr = curr.left;
            }
            return curr;
        }
        /**
         * if the node doesn't have right child, its successor should be one of its ancestors
         */
        TreeNode curr = root;
        TreeNode successor = null;
        while (curr != null) {
            if (curr.val > node.val) {
                successor = curr;
                curr = curr.left;
            } else if (curr.val < node.val) {
                curr = curr.right;
            } else {
                return successor;
            }
        }
        return successor;
    }

    /**
     * find the inorder successor in a binary tree.
     * @param root
     * @param node
     * @return
     */
    public TreeNode binaryTreeInorderSuccessor(TreeNode root, TreeNode node) {
        if (root == null || node == null) {
            return null;
        }
        return findBTInorderSuccessor(root, node, null);
    }

    /**
     * helper function of the above function, to find the successor of binary tree
     * first find the node, then find its successor
     * if the node has right child, its successor is the left most child of the right subtree
     * otherwise we need to find its parent --> go up to find the node which is the left child of its parent
     * then is parent is the successor
     * @param root
     * @param node
     * @param parent
     * @return
     */

    public TreeNode findBTInorderSuccessor(TreeNode root, TreeNode node, TreeNode parent) {
        // 1. current root is null, then its successor is also null.
        if (root == null) {
            return null;
        }
        // 2. found node
        if (root == node) {
            /**
             * 2.1
             * if root(node) has right child,
             * its inorder successor is the leftmost node of the right subtree
             */
            if (root.right != null) {
                TreeNode curr = node.right;
                while (curr.left != null) {
                    curr = curr.left;
                }
                return curr;
            } else {
                // 2.2 current root doesn't have right child, its parent is successor
                return parent;
            }
        } else {    // 3. current root is not the node we are looking for.

            TreeNode left = findBTInorderSuccessor(root.left, node, root);
            if (left != null) {
                return left;
            }
            return findBTInorderSuccessor(root.right, node, parent);
        }
    }

    public static void main (String[] args) {
        PocketGems p = new PocketGems();
        /**
         * test findMax
         */
//        Node root = p.new Node(10);
//        root.left = p.new Node(-2);
//        root.right = p.new Node(7);
//        root.left.left = p.new Node(8);
//        root.left.right = p.new Node(-4);
//        System.out.println("the maximum is " + p.findMax(root));

        /**
         * test RPG
         */
//        String[] items = {"diamond", "ruby", "armor", "diamond", "diamond", "ruby", "diamond", "diamond", "diamond", "diamond", "diamond", "armor"};
//        ItemInfo[] itemInfos = new ItemInfo[3];
//        itemInfos[0] = p.new ItemInfo("diamond", 10, 5);
//        itemInfos[1] = p.new ItemInfo("ruby", 5, 5);
//        itemInfos[2] = p.new ItemInfo("armor", 25, 1);
//        System.out.println(p.PRG(3, items, itemInfos));

        /**
         * test BST inorder successor
         */
        TreeNode root = p.new TreeNode(15);
        // left subtree
        root.left = p.new TreeNode(10);
        root.left.left = p.new TreeNode(5);
        root.left.left.left = p.new TreeNode(1);
        root.left.left.right = p.new TreeNode(7);
        root.left.left.right.left = p.new TreeNode(6);
        root.left.left.right.right = p.new TreeNode(8);
        // right subtree
        root.right = p.new TreeNode(20);
        root.right.left = p.new TreeNode(17);
        root.right.right = p.new TreeNode(25);
        TreeNode successor = p.inorderSuccessor(root, root);
        System.out.println("bst inorder successor " + successor.val);

        TreeNode btSuccessor = p.binaryTreeInorderSuccessor(root, root);
        System.out.println("binary tree inorder successor " + btSuccessor.val);
    }
}
