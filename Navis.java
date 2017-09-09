import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Navis {

    public static void main(String[] args) {
        Navis n = new Navis();
        int[] nums = new int[]{2, 2, 1, 1, 3, 4};
        
        n.freqSort(nums);
    }
    public void freqSort(int[] nums) {

        Queue<Integer>[] bucket = new PriorityQueue[nums.length + 1];
        Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        for (int key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new PriorityQueue<>();
            }
            for (int i = 0; i < frequency; i++) {
                bucket[frequency].offer(key);
            }
        }

        for (int pos = 0; pos < bucket.length; pos++) {
            if (bucket[pos] != null) {
                Queue<Integer> queue = bucket[pos];
                while (!queue.isEmpty()) {
                    System.out.println(queue.poll());
                }
            }
        }
    }

}
