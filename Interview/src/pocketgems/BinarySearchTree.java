package pocketgems;

/**
 * Created by xwang on 6/25/17.
 */
public class BinarySearchTree<T extends Comparable<T>> {
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

}
