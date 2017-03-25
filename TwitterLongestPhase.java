import java.util.LinkedList;
import java.util.Queue;

public class TwitterLongestPhase {

    public int maxLength(int[] a, int k) {
        if (a == null || a.length == 0) {
            return 0;
        }
        
        Queue<Integer> queue = new LinkedList<Integer>();
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            queue.offer(a[i]);
            sum += a[i];
            while (sum > k) {
                sum -= queue.poll(); 
            }
            if (sum == k) {
                max = Math.max(max, queue.size());
            }
        }
        return max;
    }
    public static void main(String[] args) {
        TwitterLongestPhase tlp = new TwitterLongestPhase();
        int[] a1 = {1, 2, 3};
        int k1 = 3;
        int[] a2 = {1, 2, 4, 1, 2, 3};
        int k2 = 6;
        System.out.println(tlp.maxLength(a1, k1));
        System.out.println(tlp.maxLength(a2, k2));

    }

}
