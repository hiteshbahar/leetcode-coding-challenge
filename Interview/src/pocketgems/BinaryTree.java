package pocketgems;

/**
 * Generic Binary Tree class print tree path
 * Created by xwang on 6/25/17.
 */
public class BinaryTree<T extends Comparable<T>> {
    private static class Node<T> {
        private T val;
        private Node<T> left;
        private Node<T> right;
        Node(T v, Node l, Node r) {
            val = v;
            left = l;
            right = r;
        }
        Node(T v) {
            val = v;
            left = null;
            right = null;
        }
    }

    private Node<T> root;

    private void preorder(Node<T> root) {
        if (root == null) {
            System.out.print("null ");
            return;
        }
        System.out.print("(Tree " + root.val + " ");
        preorder(root.left);
        preorder(root.right);
        System.out.print(")");
    }

    public static void main(String[] args) {
        BinaryTree<String> tree = new BinaryTree<String>();
        tree.root = new Node<String>("a", new Node<String>("b"), new Node<String>("c", new Node<String>("d"), null));
        tree.preorder(tree.root);
    }
}
