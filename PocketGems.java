<<<<<<< HEAD
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class PocketGems {
    class Pixel {
        int red, green, blue;
        Pixel(int r, int g, int b) {
            red = r;
            green = g;
            blue = b;
        }
    }
    // time: O(nlog(n)) space: O(n)
    public void sortPixels(Pixel[] pixels) {
        Queue<Pixel> queue = new PriorityQueue<Pixel>(new Comparator<Pixel>() {
            public int compare(Pixel p1, Pixel p2) {
                return p1.red - p2.red;
            }
        });

        for (int i = 0; i < pixels.length; i++) {
            queue.offer(pixels[i]);
        }

        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = queue.poll();
        }
    }
    public void bucketSortPixels(Pixel[] pixels) {
        LinkedList<Pixel>[] buckets = new LinkedList[256];
        // if the color value is int
        // in the same bucket, they are already sorted.
        // O(n)
        for (int i = 0; i < pixels.length; i++) {
            int index = pixels[i].red;
            if (buckets[index] == null) {
                buckets[index] = new LinkedList<Pixel>();
            }
            buckets[index].add(pixels[i]);
        }
        int index = 0;
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] != null) {
                for (Pixel pixel : buckets[i]) {
                    pixels[index++] = pixel;
                }
            }
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        PocketGems p = new PocketGems();
        Pixel[] pixels = new Pixel[5];
        pixels[0] = p.new Pixel(1, 0, 3);
        pixels[1] = p.new Pixel(1, 1, 2);
        pixels[2] = p.new Pixel(3, 2, 3);
        pixels[3] = p.new Pixel(4, 0, 1);
        pixels[4] = p.new Pixel(2, 0, 5);

        //p.sortPixels(pixels);
        p.bucketSortPixels(pixels);
        for (int i = 0; i < pixels.length; i++) {
            System.out.println(pixels[i].red + " " + pixels[i].green + " " + pixels[i].blue);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
/**
 * Created by xwang on 6/18/17.
 */
public class PocketGems {
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
        PocketGems p = new PocketGems();
        Node root = p.new Node(10);
        root.left = p.new Node(-2);
        root.right = p.new Node(7);
        root.left.left = p.new Node(8);
        root.left.right = p.new Node(-4);
        System.out.println("the maximum is " + p.findMax(root));
    }
}
||||||| merged common ancestors
=======
/**
 * Created by xwang on 6/18/17.
 */
public class PocketGems {
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
        PocketGems p = new PocketGems();
        Node root = p.new Node(10);
        root.left = p.new Node(-2);
        root.right = p.new Node(7);
        root.left.left = p.new Node(8);
        root.left.right = p.new Node(-4);
        System.out.println("the maximum is " + p.findMax(root));
    }
}
>>>>>>> add pocketgems
