import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Hiya {

    public long[] findMaxMin(String[] operations, int[] nums) {
        Queue<Integer> maxQueue = new PriorityQueue<Integer>(Collections.reverseOrder());
        Queue<Integer> minQueue = new PriorityQueue<Integer>();
        long[] result = new long[nums.length];
        
        for (int i = 0; i < operations.length; i++) {
            if (operations[i].equals("push")) {
                maxQueue.offer(nums[i]);
                minQueue.offer(nums[i]);
            } else if (operations[i].equals("pop")) {
                maxQueue.remove(nums[i]);
                minQueue.remove(nums[i]);
            }
            result[i] = maxQueue.peek() * minQueue.peek();
        }
        return result;
    }
    public static void main(String[] args) {
        Hiya h = new Hiya();
        String[] operations = new String[]{"push", "push", "push", "pop"};
        int[] nums = new int[]{1, 2, 3, 1};
        long[] result = h.findMaxMin(operations, nums);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

}
